package com.daus.Model;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.List;

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
	private boolean isWinner;
	
	@ManyToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_player")	
	private Player player;
	
	@OneToMany(mappedBy = "roll")
	@JsonIgnore
    private List<Dice> dices;
		
	public Roll() {}

	/**
	 * 
	 * @param id_roll
	 * @param isWinner
	 * @param player
	 * @param dices
	 */	
	public Roll(Long id_roll, boolean isWinner, Player player, List<Dice> dices) {
		super();
		this.id_roll = id_roll;
		this.isWinner = isWinner;
		this.player = player;
		this.dices = dices;
	}

	public Long getId_roll() {
		return id_roll;
	}

	public void setId_roll(Long id_roll) {
		this.id_roll = id_roll;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Dice> getDices() {
		return dices;
	}

	public void setDices(List<Dice> dices) {
		this.dices = dices;
	}

	@Override
	public String toString() {
		return "Roll [id_roll=" + id_roll + ", isWinner=" + isWinner + ", player=" + player + ", dices=" + dices + "]";
	}
			
}
