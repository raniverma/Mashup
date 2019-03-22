package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@EnableEurekaClient
//@Component
@SpringBootApplication
public class ScoreAndBadgeRest {

	public static void main(String[] args) {
		SpringApplication.run(ScoreAndBadgeRest.class, args);
	}
}