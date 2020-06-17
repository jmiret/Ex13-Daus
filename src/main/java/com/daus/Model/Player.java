package com.daus.Model;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Player") // Unnecessary line if same name
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String name;
	protected Date dateReg;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "Game",
			joinColumns = { @JoinColumn(name = "player_id") },
			inverseJoinColumns = { @JoinColumn(name = "roll_id") }
	)
	Set<Roll> rolls = new HashSet<>();
			
	public Player() {}
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Player(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.dateReg = new Date();
	}
	
	/**
	 * 
	 * @param id
	 */
	public Player(Long id) {
		super();
		this.id = id;
		this.name = "Anonymous";
		this.dateReg = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateReg == null) ? 0 : dateReg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", dateReg=" + dateReg + "]";
	}
	
}
