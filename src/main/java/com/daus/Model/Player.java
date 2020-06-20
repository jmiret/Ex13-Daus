package com.daus.Model;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "player") // Unnecessary line if same name
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_player;
	private String name;
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date dateReg;
	@Transient
	private double winnerAvg;
		
	public Player() {}
	
}
