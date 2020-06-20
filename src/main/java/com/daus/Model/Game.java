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
import javax.persistence.Transient;

@Entity
@Table(name = "game") // Unnecessary line if same name
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_game;
	private boolean isWinner;
	
	@ManyToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_player")	
	private Player player;
			
	@OneToMany(mappedBy = "game")
    private List<Roll> rolls;
	
	public Game() {}

	/**
	 * 
	 * @param id_game
	 * @param isWinner
	 * @param player
	 */
	public Game(Long id_game, boolean isWinner, Player player) {
		super();
		this.id_game = id_game;
		this.isWinner = isWinner;
		this.player = player;
	}

	public Long getId_game() {
		return id_game;
	}

	public void setId_game(Long id_game) {
		this.id_game = id_game;
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

	@Override
	public String toString() {
		return "Game [id_game=" + id_game + ", isWinner=" + isWinner + ", player=" + player + "]";
	}
	
}
