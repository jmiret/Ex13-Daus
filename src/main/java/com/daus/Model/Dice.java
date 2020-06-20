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

	/**
	 * 
	 * @param id_dice
	 * @param side
	 * @param value
	 * @param roll
	 */
	public Dice(Long id_dice, int side, int value, Roll roll) {
		super();
		this.id_dice = id_dice;
		this.side = side;
		this.value = value;
		this.roll = roll;
	}

	public Long getId_dice() {
		return id_dice;
	}

	public void setId_dice(Long id_dice) {
		this.id_dice = id_dice;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Roll getRoll() {
		return roll;
	}

	public void setRoll(Roll roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "Dice [id_dice=" + id_dice + ", side=" + side + ", value=" + value + ", roll=" + roll + "]";
	}
	
	
}