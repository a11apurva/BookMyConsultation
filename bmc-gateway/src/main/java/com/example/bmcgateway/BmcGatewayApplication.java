package com.example.bmcgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BmcGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmcGatewayApplication.class, args);
	}


}
