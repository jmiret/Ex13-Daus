package com.daus;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Collections;

/**
 * 
 * @author jordi.miret
 * 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daus.DausApplication;

@SpringBootApplication
public class DausApplication {
	
	public static void main(String[] args) {
		
		// Customize Tomcat server port 
				SpringApplication app = new SpringApplication(DausApplication.class);
		        app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8081"));
		        app.run(args);	
	}

}
