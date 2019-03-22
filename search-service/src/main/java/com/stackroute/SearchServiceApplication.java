package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*")
@EnableEurekaClient
@SpringBootApplication
public class SearchServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(SearchServiceApplication.class, args);
	}
//	RestTemplate class to provide overloaded methods for different HTTP methods.
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
