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

import com.daus.Model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	@Query("SELECT p from Player p where p.name = :player_name")
	Player findPlayerByName(@Param("player_name") String name);
	
	//@Query(value = "SELECT * FROM player", nativeQuery = true)
	@Query(value = 	"SELECT player.id, player.name, player.date_reg, AVG(game.is_winner) AS winnerAvg " +
					"FROM player " +
					"INNER JOIN game " +
					"ON player.id = game.player_id " +
					"GROUP BY player.name" +
					"", nativeQuery = true)
	//Wrapper getAvgAllPlayers();
	List<Player> getAvgAllPlayers();
	
}

 