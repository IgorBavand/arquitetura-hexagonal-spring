package com.hexagonal.example.example.arq.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExampleArqHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleArqHexagonalApplication.class, args);
	}

}
