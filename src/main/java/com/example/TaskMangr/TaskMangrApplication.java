package com.example.TaskMangr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.TaskMangr", "com.example.TaskMangr.security"}) // Add your security package here
public class TaskMangrApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskMangrApplication.class, args);
	}
}
