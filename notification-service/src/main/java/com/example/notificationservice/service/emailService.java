package com.example.notificationservice.service;

import com.example.notificationservice.entity.User;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
public class emailService {

    public emailService() {}



    @Autowired
    private sesEmailVerificationService verifyEmail;

    public void sendWelcomeEmail(String user, String emailId) throws TemplateException, MessagingException, IOException {
        verifyEmail.sendVerificationEmail(user, emailId);
    }

}
