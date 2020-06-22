USE dice;

SELECT id_player, name, date_reg, MIN(winner_avg) 
			FROM (SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg
					FROM player
					INNER JOIN roll
					ON player.id_player = roll.fk_player)
					#Having id_player)
		AS winner_min_avg;

SELECT id_player, name, date_reg, MAX(winner_avg) 
			FROM (SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg
					FROM player
					INNER JOIN roll
					ON player.id_player = roll.fk_player)
					#HAVING winner_avg)
		AS winner_max_avg GROUP BY id_player;

SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg
FROM player
	INNER JOIN roll
		ON player.id_player = roll.fk_player
GROUP BY player.id_player;

SELECT SUM(value) FROM dice WHERE fk_roll = 7;

SELECT * FROM roll WHERE fk_player = 1;

SELECT COUNT(DISTINCT id_player) FROM player;

SELECT player.id_player from player where name = "Arnau Es.";

SELECT * FROM player;

        
        