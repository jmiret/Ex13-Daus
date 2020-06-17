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

@Entity
public class Roll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numOfDice;
	private int valOfDice;
	
	public Roll() {}
	
	/**
	 * 
	 * @param id
	 * @param dice
	 */
	public Roll(Long id, int numOfDice) {
		super();
		this.id = id;
		this.numOfDice = numOfDice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumOfDice() {
		return numOfDice;
	}

	public void setNumOfDice(int numOfDice) {
		this.numOfDice = numOfDice;
	}
	
	public int getValOfDice() {
		return valOfDice;
	}

	public void setValOfDice(int valOfDice) {
		this.valOfDice = valOfDice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numOfDice;
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
		Roll other = (Roll) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numOfDice != other.numOfDice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roll [id=" + id + ", numOfDice=" + numOfDice + "]";
	}
	
}
