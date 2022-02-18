package com.example.doctorservice.services;

import com.example.doctorservice.config.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @Override
    public void produceMessage(String topicName, String key, String value) throws IOException {
        kafkaMessageProducer.publish(topicName, key, value);
    }
}
