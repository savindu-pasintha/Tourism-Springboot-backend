package com.savindupasintha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages={"com"})
public class SpringBootFullCourseApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFullCourseApplication.class, args);
	}	
}
