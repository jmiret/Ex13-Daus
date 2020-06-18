package com.daus.Persistence;

import java.util.List;

/**
 * 
 * @author jordi.miret
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daus.Model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	@Query(value = "SELECT COUNT(DISTINCT id) from game", nativeQuery = true)
	//@Query(value = "SELECT MAX(DISTINCT id) from game", nativeQuery = true)
	int getLastGame();
		
	@Query(value = "SELECT id FROM game WHERE player_id = :player_id", nativeQuery = true)
	List<Integer> getPlayerGames(@Param("player_id") int player_id);
		
}
