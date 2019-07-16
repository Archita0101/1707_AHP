package com.example.demomicroservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories("com.example.demomicroservice2.dao")
@EnableScheduling
public class DemoMicroservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoMicroservice2Application.class, args);
	}

}
