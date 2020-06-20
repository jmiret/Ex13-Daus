package com.daus.Model;

/**
 * 
 * @author jordi.miret
 *
 */

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game") // Unnecessary line if same name
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long game_id;
	private boolean isWinner;
	
	@OneToMany(targetEntity = Roll.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "game_id")
	private List<Roll> roll;
		
	public Game() {}
	
	/**
	 * 
	 * @param game_id
	 * @param isWinner
	 * @param roll
	 */	
	public Game(Long game_id, boolean isWinner, List<Roll> roll) {
		super();
		this.game_id = game_id;
		this.isWinner = isWinner;
		this.roll = roll;
	}

	public Long getGame_id() {
		return game_id;
	}

	public void setGame_id(Long game_id) {
		this.game_id = game_id;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public List<Roll> getRoll() {
		return roll;
	}

	public void setRoll(List<Roll> roll) {
		this.roll = roll;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((game_id == null) ? 0 : game_id.hashCode());
		result = prime * result + (isWinner ? 1231 : 1237);
		result = prime * result + ((roll == null) ? 0 : roll.hashCode());
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
		Game other = (Game) obj;
		if (game_id == null) {
			if (other.game_id != null)
				return false;
		} else if (!game_id.equals(other.game_id))
			return false;
		if (isWinner != other.isWinner)
			return false;
		if (roll == null) {
			if (other.roll != null)
				return false;
		} else if (!roll.equals(other.roll))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [game_id=" + game_id + ", isWinner=" + isWinner + ", roll=" + roll + "]";
	}
	
}
