package com.daus.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Wrapper;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;  
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daus.Exception.PlayerNotFoundException;
import com.daus.Model.Player;
import com.daus.Persistence.PlayerRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PlayerController {
	
	private JdbcTemplate jdbcTemplate;
	private final PlayerRepository playerRepository;

	public PlayerController(PlayerRepository playerRepository) {
		super();
		// TODO Auto-generated constructor stub
		this.playerRepository = playerRepository;
	}
	
	@PostMapping("/players")
	Player createPlayer(@RequestBody Player player) {
		player.setDateReg(new Date());
		return playerRepository.save(player);
	}
	
	@PutMapping("/players/{id}")
	Player updatePlayer(@RequestBody Player p, @PathVariable Long id) {
		return playerRepository.findById(id).map(player -> {
			player.setName(p.getName());
			return playerRepository.save(player);
		}).orElseThrow(() -> {
			return new PlayerNotFoundException(id);		
		});
	}
		
	@GetMapping("/players")
	@ResponseBody
	public List<Player> readAvgAllPlayers() {		
		return playerRepository.getAvgAllPlayers();	
	}	
	
	@GetMapping("/players_1")
	@ResponseBody // The returned value will be converted to JSON	
	public List<Map<String, Object>> readAvgAllPlayers_1() {
				
		String query = "SELECT player.id, player.name, player.date_reg, AVG(game.is_winner) AS winnerAVG " + 
				"FROM game " + 
				"	INNER JOIN player " + 
				"		ON game.player_id = player.id " + 
				"GROUP BY player.name";
		
		return jdbcTemplate.queryForList(query);
	}
		
	@GetMapping("/players_2")
	@ResponseBody // The returned value will be converted to JSON
	//@RequestMapping(value="/players", method = RequestMethod.GET)
	public List<Player> readAvgAllPlayers_2() {
				
		List<Player> results = jdbcTemplate.query("SELECT p.name FROM Player p", new RowMapper<Player>() {

			@Override
			public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Player player = new Player();
				player.setName(rs.getString("name"));
				
				return player;
			}
			
		});
		
		return results;
	}
	
}
