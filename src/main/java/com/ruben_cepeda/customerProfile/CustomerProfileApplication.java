package com.ruben_cepeda.customerProfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CustomerProfileApplication {
	@RequestMapping("/")
	public String index() {
		return "Greetings from the Consumer Reports Customer Profile Application";
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerProfileApplication.class, args);
	}
}