package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@Component
@CrossOrigin("*")
@EnableEurekaClient
@SpringBootApplication
public class QuestionsRest {

	public static void main(String[] args) {
		SpringApplication.run(QuestionsRest.class, args);
	}
}