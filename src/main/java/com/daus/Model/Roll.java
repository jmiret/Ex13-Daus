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
    private List<Dice> dices;
		
	public Roll() {}

	/**
	 * 
	 * @param id_roll
	 * @param game
	 */
	public Roll(Long id_roll, Game game) {
		super();
		this.id_roll = id_roll;
		this.game = game;
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
	
	@Override
	public String toString() {
		return "Roll [id_roll=" + id_roll + ", game=" + game + "]";
	}
			
}
