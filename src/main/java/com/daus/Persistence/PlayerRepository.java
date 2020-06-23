package com.daus.Persistence;

/**
 * 
 * @author jordi.miret
 */

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daus.Model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query(value = "SELECT player.id_player from player where name = ?1", nativeQuery = true)
	Long findPlayerByName(@Param("name") String name);
	
	@Query(value = "SELECT COUNT(DISTINCT id_player) FROM player", nativeQuery = true)
	Long getLastId();
	
	@Query(value = 	"SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg " + 
			"		 FROM player " + 
			"		 INNER JOIN roll " + 
			"		 ON player.id_player = roll.fk_player " + 
			"		 GROUP BY player.id_player " + 
			" 		 ORDER BY winner_avg ASC LIMIT 1", nativeQuery = true)
	Map<String, Object> getLoser();
	
	@Query(value = 	"SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg " + 
			"		 FROM player " + 
			"		 INNER JOIN roll " + 
			"		 ON player.id_player = roll.fk_player " + 
			"		 GROUP BY player.id_player " + 
			" 		 ORDER BY winner_avg DESC LIMIT 1", nativeQuery = true)
	Map<String, Object> getWinner();
	
	@Query(value = "SELECT AVG(roll.is_winner) AS winner_avg " + 
			"		FROM player " + 
			"		INNER JOIN roll " + 
			"		ON player.id_player = roll.fk_player " + 
			"", nativeQuery = true)
	Map<String, Object> getAvg();
	
	@Query(value = 	"SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg " +
			"FROM player " +
			"INNER JOIN roll " +
			"ON player.id_player = roll.fk_player " +
			"GROUP BY player.name" +
			"", nativeQuery = true)
	List<Map<String, Object>> getAvgAllPlayers();
	
}

 