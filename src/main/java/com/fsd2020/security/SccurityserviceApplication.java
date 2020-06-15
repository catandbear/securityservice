package com.fsd2020.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SccurityserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SccurityserviceApplication.class, args);
	}

}
