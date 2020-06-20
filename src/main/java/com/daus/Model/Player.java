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

	/**
	 * 
	 * @param id_player
	 * @param name
	 * @param dateReg
	 * @param winnerAvg
	 */
	public Player(Long id_player, String name, Date dateReg, double winnerAvg) {
		super();
		this.id_player = id_player;
		this.name = name;
		this.dateReg = dateReg;
		this.winnerAvg = winnerAvg;
	}

	public Long getId_player() {
		return id_player;
	}

	public void setId_player(Long id_player) {
		this.id_player = id_player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateReg() {
		return dateReg;
	}

	public void setDateReg(Date dateReg) {
		this.dateReg = dateReg;
	}

	public double getWinnerAvg() {
		return winnerAvg;
	}

	public void setWinnerAvg(double winnerAvg) {
		this.winnerAvg = winnerAvg;
	}

	@Override
	public String toString() {
		return "Player [id_player=" + id_player + ", name=" + name + ", dateReg=" + dateReg + ", winnerAvg=" + winnerAvg
				+ "]";
	}
	
}
