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
	private Long dice_id;
	private int side;	
	private int value;
	
	@ManyToOne(targetEntity = Roll.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_roll")	
	private Roll roll;
	
	public Dice() {}
	
	public Dice(Long dice_id, int side, int value, Roll roll) {
		super();
		this.dice_id = dice_id;
		this.side = side;
		this.value = value;
		this.roll = roll;
	}

	public int rollDice(int sides) {
		Random random = new Random();
		return random.nextInt((sides - 1) + 1) + 1;		
	}

	public Long getDice_id() {
		return dice_id;
	}

	public void setDice_id(Long dice_id) {
		this.dice_id = dice_id;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dice_id == null) ? 0 : dice_id.hashCode());
		result = prime * result + ((roll == null) ? 0 : roll.hashCode());
		result = prime * result + side;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dice other = (Dice) obj;
		if (dice_id == null) {
			if (other.dice_id != null)
				return false;
		} else if (!dice_id.equals(other.dice_id))
			return false;
		if (roll == null) {
			if (other.roll != null)
				return false;
		} else if (!roll.equals(other.roll))
			return false;
		if (side != other.side)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dice [dice_id=" + dice_id + ", side=" + side + ", value=" + value + ", roll=" + roll + "]";
	}
	
}