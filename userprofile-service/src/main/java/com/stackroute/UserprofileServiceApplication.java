package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

// main class for running the application
@CrossOrigin("*")
@EnableEurekaClient
@SpringBootApplication
public class UserprofileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserprofileServiceApplication.class, args);
	}

}

