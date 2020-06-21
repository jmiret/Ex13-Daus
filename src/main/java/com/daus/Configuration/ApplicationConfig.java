package com.daus.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

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
	public final static List<Integer> winnerNumbers = Arrays.asList(5, 6); // Arrays.asList(5, 6) // Arrays.asList(7)
		
}
