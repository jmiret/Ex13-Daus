USE dice;

SELECT player.id, player.name, player.date_reg, AVG(game.is_winner) AS winnerAVG
FROM game
	INNER JOIN player
		ON game.player_id = player.id
GROUP BY player.name;