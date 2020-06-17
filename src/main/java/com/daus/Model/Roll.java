package com.daus.Model;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roll") // Unnecessary line if same name
public class Roll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int diceToRoll;
	private int valueOfDice;
	
	@ManyToMany(mappedBy = "rolls")
	private Set<Player> players = new HashSet<>();
	
	public Roll() {}
	
	/**
	 * 
	 * @param id
	 * @param dice
	 */
	public Roll(Long id, int diceToRoll) {
		super();
		this.id = id;
		this.diceToRoll = diceToRoll;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDiceToRoll() {
		return diceToRoll;
	}

	public void setDiceToRoll(int diceToRoll) {
		this.diceToRoll = diceToRoll;
	}

	public int getValueOfDice() {
		return valueOfDice;
	}

	public void setValueOfDice(int valueOfDice) {
		this.valueOfDice = valueOfDice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diceToRoll;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + valueOfDice;
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
		if (diceToRoll != other.diceToRoll)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (valueOfDice != other.valueOfDice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roll [id=" + id + ", diceToRoll=" + diceToRoll + ", valueOfDice=" + valueOfDice + "]";
	}
	
}
