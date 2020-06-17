package com.daus.Domain;

import java.util.Random;

/**
 * 
 * @author jordi.miret
 *
 */

public class Dice {

	private Long id;
	private int sides;	
	private int value;
	
	public Dice() {}

	public Dice(Long id, int sides, int value) {
		super();
		this.id = id;
		this.sides = sides;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int rollDice(int sides) {
		Random random = new Random();
		return random.nextInt((sides - 1) + 1) + 1;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + sides;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sides != other.sides)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dice [id=" + id + ", sides=" + sides + ", value=" + value + "]";
	}
	
}

