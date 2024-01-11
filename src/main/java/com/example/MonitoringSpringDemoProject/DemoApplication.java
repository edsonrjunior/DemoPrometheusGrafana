package com.example.MonitoringSpringDemoProject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Projeto teste de observability",
				version = "1.0.0",
				description = "Projeto para fins de estudo",
				termsOfService = "edsonrjk",
				contact = @Contact(
						name = "Edson Jr",
						email = "edsonkjk@gmail.com"
				),
				license = @License(
						name = "licence",
						url = "edsonkjk"
				)
		)
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
