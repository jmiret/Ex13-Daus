package com.daus.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author jordi.miret
 *
 */

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected Long id_player;
	protected Long id_roll;
	
	public Game() {}

	public Game(Long id, Long id_player, Long id_roll) {
		super();
		this.id = id;
		this.id_player = id_player;
		this.id_roll = id_roll;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_player() {
		return id_player;
	}

	public void setId_player(Long id_player) {
		this.id_player = id_player;
	}

	public Long getId_roll() {
		return id_roll;
	}

	public void setId_roll(Long id_roll) {
		this.id_roll = id_roll;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_player == null) ? 0 : id_player.hashCode());
		result = prime * result + ((id_roll == null) ? 0 : id_roll.hashCode());
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
		if (id_player == null) {
			if (other.id_player != null)
				return false;
		} else if (!id_player.equals(other.id_player))
			return false;
		if (id_roll == null) {
			if (other.id_roll != null)
				return false;
		} else if (!id_roll.equals(other.id_roll))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", id_player=" + id_player + ", id_roll=" + id_roll + "]";
	}	
	
}
