package com.daus.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author jordi.miret
 *
 */

@Entity
@Table(name = "Game") // Unnecessary line if same name
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Long id;
	//protected Long gameNumber;	
	protected Long player_id;
	//protected int roll_number;
	protected boolean isWinner;
	
	public Game() {}
	
	/**
	 * 
	 * @param id
	 * @param player_id
	 * @param roll_number
	 * @param isWinner
	 */
	public Game(Long id, Long player_id, int roll_number, boolean isWinner) {
		super();
		this.id = id;
		this.player_id = player_id;
		//this.roll_number = roll_number;
		this.isWinner = isWinner;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	public Long getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(Long gameNumber) {
		this.gameNumber = gameNumber;
	}
	*/
	
	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	/*
	public int getRoll_number() {
		return roll_number;
	}

	public void setRoll_number(int roll_number) {
		this.roll_number = roll_number;
	}
	*/
	
	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isWinner ? 1231 : 1237);
		result = prime * result + ((player_id == null) ? 0 : player_id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isWinner != other.isWinner)
			return false;
		if (player_id == null) {
			if (other.player_id != null)
				return false;
		} else if (!player_id.equals(other.player_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", player_id=" + player_id + ", isWinner=" + isWinner + "]";
	}
	
}
