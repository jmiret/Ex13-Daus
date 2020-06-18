package com.daus.Model;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	protected Long id;
	protected int rollNumber;
	protected int diceNumber;
	protected int diceValue;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "rolls")
	protected Set<Player> players = new HashSet<>();
	
	public Roll() {}
	
	/**
	 * @param rollNumber
	 * @param diceNumber
	 * @param diceValue
	 */
	public Roll(int rollNumber, int diceNumber, int diceValue) {
		this.rollNumber = rollNumber;
		this.diceNumber = diceNumber;
		this.diceValue = diceValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getDiceNumber() {
		return diceNumber;
	}

	public void setDiceNumber(int diceNumber) {
		this.diceNumber = diceNumber;
	}

	public int getDiceValue() {
		return diceValue;
	}

	public void setDiceValue(int diceValue) {
		this.diceValue = diceValue;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diceNumber;
		result = prime * result + diceValue;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + rollNumber;
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
		if (diceNumber != other.diceNumber)
			return false;
		if (diceValue != other.diceValue)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (rollNumber != other.rollNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roll [id=" + id + ", rollNumber=" + rollNumber + ", diceNumber=" + diceNumber + ", diceValue="
				+ diceValue + ", players=" + players + "]";
	}
	
}
