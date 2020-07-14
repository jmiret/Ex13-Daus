package com.daus.Model;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "player") // Unnecessary line if same name
@JsonPropertyOrder({ "id_player", "player_name", "data_reg", "winner_avg"})
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_player")
	private Long id_player;
	
	@JsonProperty("player_name")
	private String name;
	
	@JsonFormat(pattern = "YYYY-MM-dd")
	@JsonProperty("date_reg")
	private Date dateReg;
	
	@Transient
	@JsonProperty("winner_avg")
	private double winner_avg;
	
	@OneToMany(mappedBy = "player")
    @JsonIgnore
	private List<Roll> rolls;
		
	public Player() {}

	/**
	 * 
	 * @param id_player
	 * @param name
	 * @param dateReg
	 * @param winner_avgs
	 */
	public Player(Long id_player, String name, Date dateReg, double winner_avg, List<Roll> rolls) {
		super();
		this.id_player = id_player;
		this.name = name;
		this.dateReg = dateReg;
		this.winner_avg = winner_avg;
		this.rolls = rolls;
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

	public double getWinner_avg() {
		return winner_avg;
	}

	public void setWinner_avg(double winner_avg) {
		this.winner_avg = winner_avg;
	}

	public List<Roll> getRolls() {
		return rolls;
	}

	public void setRolls(List<Roll> rolls) {
		this.rolls = rolls;
	}

	@Override
	public String toString() {
		return "Player [id_player=" + id_player + ", name=" + name + ", dateReg=" + dateReg + ", winner_avg=" + winner_avg
				+ ", rolls=" + rolls + "]";
	}
		
}
