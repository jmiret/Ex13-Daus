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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roll") // Unnecessary line if same name
public class Roll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_roll;
			
	@ManyToOne(targetEntity = Game.class, fetch = FetchType.LAZY)	
	@JoinColumn(name = "fk_game")
	private Game game;
		
	@OneToMany(mappedBy = "roll")
	private List<Dice> dice;
		
	public Roll() {}
	
	/**
	 * 
	 * @param id_roll
	 * @param game
	 * @param dice
	 */
	public Roll(Long id_roll, Game game, List<Dice> dice) {
		super();
		this.id_roll = id_roll;
		this.game = game;
		this.dice = dice;
	}

	public Long getId_roll() {
		return id_roll;
	}

	public void setId_roll(Long id_roll) {
		this.id_roll = id_roll;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	
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
		result = prime * result + ((game == null) ? 0 : game.hashCode());
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
		Roll other = (Roll) obj;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
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
		return "Roll [id_roll=" + id_roll + ", game=" + game + "]";
	}
	
}
