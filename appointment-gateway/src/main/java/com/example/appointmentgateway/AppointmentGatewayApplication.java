package com.example.appointmentgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class AppointmentGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentGatewayApplication.class, args);
	}

}
