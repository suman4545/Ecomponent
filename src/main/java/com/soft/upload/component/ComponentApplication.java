package com.soft.upload.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComponentApplication {
	
	@Value("${uploaddir}")
     private static String appTitle;

	public static void main(String[] args) {
		System.out.println(appTitle);
		SpringApplication.run(ComponentApplication.class, args);
	}
}
