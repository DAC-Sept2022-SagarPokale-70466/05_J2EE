package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Day16SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day16SecurityApplication.class, args);
	}

	// configure Password encoder bean
	@Bean // to tell SC follow method ret a java obj to be managed as spring bean
	public PasswordEncoder encoder() {
		System.out.println("in pwd enc bean");
		return new BCryptPasswordEncoder();
	}

}
