package com.example.doctorservice.config;

import java.io.IOException;


/**
 * Contract for publishing message to Kafka
 */
public interface KafkaMessageProducer {

    void publish(String topic, String key, String value) throws IOException;
}
