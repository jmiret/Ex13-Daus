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

import com.daus.Model.Dice;
import com.daus.Model.Player;
import com.daus.Model.Roll;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	@Query("SELECT p from Player p where p.name = :player_name")
	Player findPlayerByName(@Param("player_name") String name);
		
	@Query(value = 	"SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winnerAvg " +
					"FROM player " +
					"INNER JOIN roll " +
					"ON player.id_player = roll.fk_player " +
					"GROUP BY player.name" +
					"", nativeQuery = true)
	//Wrapper getAvgAllPlayers();
	List<Player> getAvgAllPlayers();
	
	@Query(value = "SELECT * FROM roll WHERE fk_player = :id_player", nativeQuery = true)
	List<Dice> getRollByPlayer(@Param("id_player") Long id_player);
}

 