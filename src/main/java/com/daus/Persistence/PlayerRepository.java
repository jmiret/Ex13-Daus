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

import com.daus.Model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	@Query("SELECT p from Player p where p.name = :player_name")
	Player findPlayerByName(@Param("player_name") String name);
	
	@Query(value = 	//"SELECT player.name, AVG(COUNT(game.is_winner)) AS winnerAVG " +
					"SELECT player.id, player.name, player.date_reg, game.is_winner AS winnerAVG " +
					"FROM player " +
					"INNER JOIN game " +
					"ON player.id = game.player_id "+
					"GROUP BY player.name " +
					"", nativeQuery = true)
	List<Player> getAvgAllPlayers();

	/*
	SELECT fabricante.nombre, MAX(producto.precio) AS precioMax, MIN(producto.precio) AS precioMin, AVG(producto.precio) AS precioMedio
	FROM producto 
	INNER JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo
	GROUP BY fabricante.nombre;
	*/
}

 