package com.daus.Persistence;

/**
 * 
 * @author jordi.miret
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daus.Model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query(value = "SELECT player.id_player from player where name = ?1", nativeQuery = true)
	Long findPlayerByName(@Param("name") String name);
		
	@Query(value = 	"SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg " +
					"FROM player " +
					"INNER JOIN roll " +
					"ON player.id_player = roll.fk_player " +
					"GROUP BY player.name" +
					"", nativeQuery = true)
	List<Player> getAvgAllPlayers();
	
	@Query(value = "SELECT COUNT(DISTINCT id_player) FROM player", nativeQuery = true)
	Long getLastId();
	
	@Query(value = "SELECT id_player, name, date_reg, MIN(winner_avg) " +
			"		FROM (SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg " + 
			"			FROM player " + 
			"			INNER JOIN roll " + 
			"			ON player.id_player = roll.fk_player " + 
			"			GROUP BY player.name) " +
			"			AS winner_min_avg", nativeQuery = true)
	Player getLoser();
	
	@Query(value = "SELECT id_player, name, date_reg, MAX(winner_avg) " +
			"		FROM (SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg " + 
			"			FROM player " + 
			"			INNER JOIN roll " + 
			"			ON player.id_player = roll.fk_player " + 
			"			GROUP BY player.name) " +
			"			AS winner_max_avg", nativeQuery = true)
	Player getWinner();
	
}

 