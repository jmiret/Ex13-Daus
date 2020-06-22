package com.daus.Domain;

/**
 * 
 * @author jordi.miret
 *
 */

import java.util.List;

import com.daus.Model.Player;
import com.daus.Model.Roll;

public class Game {
		
	private Long id_game;
	private boolean isWinner;
	private Player player;
	private List<Roll> rolls;
	
	public Game() {}

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

	public List<Roll> getRolls() {
		return rolls;
	}

	public void setRolls(List<Roll> rolls) {
		this.rolls = rolls;
	}
	
}
