package com.daus.Model;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roll") // Unnecessary line if same name
public class Roll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roll_id;
			
	@OneToMany(targetEntity = Dice.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "roll_id")
	private List<Dice> dice;
	
	public Roll() {}
	
	/**
	 * 
	 * @param roll_id
	 * @param dice
	 */
	public Roll(Long roll_id, List<Dice> dice) {
		super();
		this.roll_id = roll_id;
		this.dice = dice;
	}

	public Long getRoll_id() {
		return roll_id;
	}

	public void setRoll_id(Long roll_id) {
		this.roll_id = roll_id;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dice")
	public List<Dice> getDice() {
		return dice;
	}

	public void setDice(List<Dice> dice) {
		this.dice = dice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dice == null) ? 0 : dice.hashCode());
		result = prime * result + ((roll_id == null) ? 0 : roll_id.hashCode());
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
		if (dice == null) {
			if (other.dice != null)
				return false;
		} else if (!dice.equals(other.dice))
			return false;
		if (roll_id == null) {
			if (other.roll_id != null)
				return false;
		} else if (!roll_id.equals(other.roll_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roll [roll_id=" + roll_id + ", dice=" + dice + "]";
	}
	
}
