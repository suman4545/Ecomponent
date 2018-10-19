package com.soft.upload.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*This Application Will get data from as  rest Service.
 * Kafka server need to send the data 
 * And FTP server Need to Store A File
 * 
 * 
 * 
 */
@SpringBootApplication
public class ComponentApplication {
	
	@Value("${uploaddir}")
     private static String appTitle;

	public static void main(String[] args) {
		System.out.println(appTitle);
		SpringApplication.run(ComponentApplication.class, args);
	}
}
