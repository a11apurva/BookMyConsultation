package com.example.notificationservice;

import com.example.notificationservice.entity.User;
import com.example.notificationservice.service.emailService;
import com.example.notificationservice.service.sesEmailVerificationService;
import freemarker.template.TemplateException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext =  SpringApplication.run(NotificationServiceApplication.class, args);

		Properties properties = new Properties();
		KafkaHost kafkaHost = applicationContext.getBean(KafkaHost.class);

		properties.put("bootstrap.servers", kafkaHost.getKafkaHost()+":9092");
		properties.put("group.id", "test");
		properties.put("enable.auto.commit", "true");
		properties.put("auto.commit.interval.ms", "1000");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


		KafkaConsumer<String, String> consumer=  new KafkaConsumer<String, String>(properties);
		consumer.subscribe(Arrays.asList("new_doc", "doc_approval", "doc_rejection", "app_confirm", "prescription"));

		Set<String> subscribedTopics = consumer.subscription();
		subscribedTopics.stream().forEach(System.out::println);

		try{
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
				for(ConsumerRecord<String, String> record: records)
				{
					System.out.println(record.value());

					String topic = record.topic();
					JSONObject obj = new JSONObject(record.value());

					if(topic.equals("new_doc"))
					{
						String name = obj.getString("firstName");
						String emailId = obj.getString("emailId");
						User usr = new User(name, emailId);
						sesEmailVerificationService emailService = 	applicationContext.getBean(sesEmailVerificationService.class);
						emailService.sendVerificationEmail(usr);
					}
				}

			}
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			consumer.close();
		}
	}

	@Component
	class KafkaHost {

		@Value("${KAFKA_HOST:54.146.152.189}")
		private String kafkaHost;

		public String getKafkaHost() {
			return kafkaHost;
		}
	}
}
