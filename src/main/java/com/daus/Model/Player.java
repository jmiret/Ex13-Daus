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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "player") // Unnecessary line if same name
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long player_id;
	private String name;
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date dateReg;
	@Transient
	private double winnerAvg;
		
	@OneToMany
	@JoinColumn(name = "player_id")
	private List<Game> game;
	
	public Player() {}
	
	/**
	 * 
	 * @param player_id
	 * @param name
	 * @param dateReg
	 * @param winnerAvg
	 * @param game
	 */
	public Player(Long player_id, String name, Date dateReg, double winnerAvg, List<Game> game) {
		super();
		this.player_id = player_id;
		this.name = name;
		this.dateReg = dateReg;
		this.winnerAvg = winnerAvg;
		this.game = game;
	}
	
	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
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

	public List<Game> getGame() {
		return game;
	}

	public void setGame(List<Game> game) {
		this.game = game;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateReg == null) ? 0 : dateReg.hashCode());
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((player_id == null) ? 0 : player_id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(winnerAvg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Player other = (Player) obj;
		if (dateReg == null) {
			if (other.dateReg != null)
				return false;
		} else if (!dateReg.equals(other.dateReg))
			return false;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (player_id == null) {
			if (other.player_id != null)
				return false;
		} else if (!player_id.equals(other.player_id))
			return false;
		if (Double.doubleToLongBits(winnerAvg) != Double.doubleToLongBits(other.winnerAvg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", name=" + name + ", dateReg=" + dateReg + ", winnerAvg=" + winnerAvg
				+ ", game=" + game + "]";
	}
	
}
