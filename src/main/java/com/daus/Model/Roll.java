package com.daus.Model;

/**
 * 
 * @author jordi.miret
 * 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.daus.Domain.Dice;

@Entity
public class Roll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Dice dice;
	
	
	
}
