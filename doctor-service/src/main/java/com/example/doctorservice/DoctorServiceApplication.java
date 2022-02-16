package com.example.doctorservice;

import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoctorServiceApplication {

	public static void main(String[] args) {

		System.out.println("*********Started********");
		SpringApplication.run(DoctorServiceApplication.class, args);
	}

	@Bean
	ObjectMetadata objectMetadata(){
		return new ObjectMetadata();
	}

}
