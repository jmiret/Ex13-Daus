USE dice;

## Llistat jugadors amb percentatge MITG d'èxits i jugadors sense tirada
SELECT id_player, name, date_reg, winner_avg 
			FROM (SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg
					FROM player
					LEFT JOIN roll
					ON player.id_player = roll.fk_player
					GROUP BY id_player)
		AS winner_max_avg
		GROUP BY id_player;
       
## Jugador amb MILLOR percentatge d'èxit
SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg
FROM player
	INNER JOIN roll
		ON player.id_player = roll.fk_player
GROUP BY player.id_player
ORDER BY winner_avg DESC LIMIT 1;

## Jugador amb PITJOR percentatge d'èxit
SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg
FROM player
	INNER JOIN roll
		ON player.id_player = roll.fk_player
GROUP BY player.id_player
ORDER BY winner_avg ASC LIMIT 1;

## Llistat jugadors amb percentatge MITG d'èxits
SELECT player.id_player, player.name, player.date_reg, AVG(roll.is_winner) AS winner_avg
FROM player
	INNER JOIN roll
		ON player.id_player = roll.fk_player
GROUP BY player.id_player;

## Queries
SELECT SUM(value) FROM dice WHERE fk_roll = 7;

SELECT * FROM roll WHERE fk_player = 1;

SELECT COUNT(DISTINCT id_player) FROM player;

SELECT player.id_player from player where name = "Arnau Es.";

SELECT * FROM player;

        
        