package com.example.doctorservice.services;

import java.io.IOException;

public interface NotificationService {

    public void produceMessage(String topicName, String key, String value) throws IOException;

}
