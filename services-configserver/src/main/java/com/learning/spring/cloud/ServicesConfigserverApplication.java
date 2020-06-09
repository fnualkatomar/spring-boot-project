package com.learning.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
//http://localhost:8888/limits-service/default
@SpringBootApplication
@EnableConfigServer
public class ServicesConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesConfigserverApplication.class, args);
	}

}
