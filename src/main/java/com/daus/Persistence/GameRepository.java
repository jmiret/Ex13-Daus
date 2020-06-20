package com.daus.Persistence;

import java.sql.Wrapper;
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
import com.daus.Model.Player;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	@Query(value = "SELECT COUNT(DISTINCT id) from game", nativeQuery = true)
	//@Query(value = "SELECT MAX(DISTINCT id) from game", nativeQuery = true)
	Long getLastGame();
		
	@Query(value = "SELECT id FROM game WHERE player_id = :player_id", nativeQuery = true)
	List<Integer> getPlayerGames(@Param("player_id") int player_id);
	
	@Query(value = "SELECT * FROM player", nativeQuery = true)
	/*@Query(value = "SELECT player.id, player.name, player.date_reg, AVG(game.is_winner) AS winnerAVG " +
			"FROM player " +
			"INNER JOIN game " +
			"ON player.id = game.player_id " +
			"GROUP BY player.name" +
			"", nativeQuery = true)*/	
	//Wrapper getAvgAllPlayers();
	List<Player> getAvgAllPlayers();
	
}
