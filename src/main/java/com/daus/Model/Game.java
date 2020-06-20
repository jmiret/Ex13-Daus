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
	@JoinColumn(name = "fk_Player")	
	private Player player;
			
	public Game() {}
	
}
