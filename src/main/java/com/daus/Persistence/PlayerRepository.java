package com.daus.Persistence;

/**
 * 
 * @author jordi.miret
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daus.Model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	@Query("SELECT p from Player p where p.name = :player_name")
	Player findPlayerByName(@Param("player_name") String name);
	
}
 