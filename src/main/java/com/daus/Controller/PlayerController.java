package com.daus.Controller;

/**
 * 
 * @author jordi.miret
 * 
 */

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daus.Exception.CustomException;
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
	
	// http://localhost:8081/players (CREATE)	
	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player) {
		
		if (playerRepository.findPlayerByName(player.getName()) != null)
			throw new CustomException("Player exists in database.");
		
		player.setDateReg(new Date());

		return playerRepository.save(player);			
	}
	
	// http://localhost:8081/players (READER)	
	@GetMapping("/players")
	@ResponseBody	
	public List<Map<String, Object>> getAvgAllPlayers(Model model) {
		
		List<Map<String, Object>> results = (List<Map<String, Object>>) playerRepository.getAvgAllPlayers();
		model.addAttribute("results", results);
		return results;	
	}	
	
	// http://localhost:8081/players{id} (UPDATE)	
	@PutMapping("/players/{id}")
	public Player updatePlayer(@RequestBody Player p, @PathVariable Long id) {
		//return playerRepository.findById(id).map(player -> {
		return playerRepository.findById(id).map(player -> {
			player.setName(p.getName());
			return playerRepository.save(player);
		}).orElseThrow(() -> {
			return new PlayerNotFoundException(id);		
		});
	}
	
	// http://localhost:8081/ranking (READER)
	@GetMapping("/players/ranking")
	public Map<String, Object> getAvg(Model model) {
		Map<String, Object> results = (Map<String, Object>) playerRepository.getAvg();
		model.addAttribute("results", results);
		return results;
	}
	
	/*
	// http://localhost:8081/ranking/loser (READER)
	@GetMapping("/players/ranking/loser")
	public String getLoser() throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.readTree(playerRepository.getLoser());
		
		String resultsJSON = mapper.writeValueAsString(mapper);
		
		return resultsJSON;
	}
	*/
	
	// http://localhost:8081/ranking/loser (READER)
		@GetMapping("/players/ranking/loser")
		public Map<String, Object> getLoser() {
			Map<String, Object> results = (Map<String, Object>) playerRepository.getLoser();
			return results;
		}
		
	// http://localhost:8081/ranking/winner (READER)
		@GetMapping("/players/ranking/winner")
		public Map<String, Object> getWinner() {
			Map<String, Object> results = (Map<String, Object>) playerRepository.getWinner();
			return results;
		}
	
	// http://localhost:8081/ranking/winner_1 (READER)
	@GetMapping("/players/ranking/winner_1")
	public Map<String, Object> getWinner_1(Model model) {
		Map<String, Object> results = (Map<String, Object>) playerRepository.getWinner();
		model.addAttribute("results", results);
		return results;
	}
		
}
