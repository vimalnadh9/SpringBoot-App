package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackageClasses=com.example.Entity.Patient.class)
@SpringBootApplication
public class VimalApplication {

	public static void main(String[] args) {
		SpringApplication.run(VimalApplication.class, args);
	}
}