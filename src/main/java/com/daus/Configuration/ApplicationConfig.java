package com.daus.Configuration;

import java.util.ArrayList;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	public final static int numberOfDice = 2;
	public final static int numberOfSides = 6;
	public final static List<Long> winnerNumbers = new ArrayList<Long>(7);	
		
}
