package com.daus.Controller;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daus.Exception.PlayerNotFoundException;
import com.daus.Model.Player;
import com.daus.Persistence.PlayerRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PlayerController {
	
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
	
	
	@GetMapping("/players_1")
	List<Player> readAvgAllPlayers() {
		//return playerRepository.findAll();
		return playerRepository.getAvgAllPlayers();
	}
		
}
