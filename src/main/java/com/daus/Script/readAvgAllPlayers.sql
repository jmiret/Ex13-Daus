USE dice;

SELECT player.id, player.name, player.date_reg, AVG(game.is_winner) AS winnerAVG
FROM game
	INNER JOIN player
		ON game.player_id = player.id
GROUP BY player.name;

SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winnerAvg
				FROM roll 
					INNER JOIN player 
						ON roll.fk_player = player.id_player 
				GROUP BY player.name;

SELECT * FROM player;

SELECT SUM(value) FROM dice WHERE fk_roll = 7;

SELECT * FROM roll WHERE fk_player = 1;