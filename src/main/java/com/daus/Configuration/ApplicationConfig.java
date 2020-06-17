package com.daus.Configuration;

/**
 * 
 * @author jordi.miret
 * 
 */

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	public final static int numberOfDice = 2;
	public final static int numberOfSides = 6;
	public final static int[] winnerNumbers = {7};	
		
}
