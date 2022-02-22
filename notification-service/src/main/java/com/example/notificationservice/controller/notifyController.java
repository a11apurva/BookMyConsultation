package com.example.notificationservice.controller;

import com.example.notificationservice.entity.User;
import com.example.notificationservice.service.sesEmailVerificationService;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import java.io.IOException;

@RequiredArgsConstructor
@RestController(value = "/")
public class notifyController {

    private final sesEmailVerificationService verifyEmail;

    @GetMapping("verify")
    public ResponseEntity verifyEmail(@RequestParam("email") String emailId){
        verifyEmail.verifyEmail(emailId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("welcomeemail")
    public ResponseEntity sendEmail(@RequestBody User user) throws TemplateException, MessagingException, IOException {
        verifyEmail.sendVerificationEmail(user);
        return ResponseEntity.ok().build();
    }

}
