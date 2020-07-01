package com.condingdojo.demo.com.codingdojo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// 1. Anotación
	@RequestMapping("/")
	// 3. Método que se asigna a la Solicitud anterior.
	public String hello() { // 3
		return "Hello World!";
	}
}
