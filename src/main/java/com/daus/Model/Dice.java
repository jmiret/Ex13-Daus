package com.daus.Model;

import java.util.List;

/**
 * 
 * @author jordi.miret
 *
 */

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dice") // Unnecessary line if same name
public class Dice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_dice;
	private int side;	
	private int value;
	
	@ManyToOne(targetEntity = Roll.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_roll")	
	private Roll roll;
	
	public Dice() {}
	
}