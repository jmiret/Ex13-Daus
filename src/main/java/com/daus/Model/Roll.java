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
		
	public Roll() {}
			
}
