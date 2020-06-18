package com.daus.Configuration;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	public final static int numberOfDice = 2;
	public final static int numberOfSides = 6;
	public final static List<Integer> winnerNumbers = Arrays.asList(7);	
		
}
