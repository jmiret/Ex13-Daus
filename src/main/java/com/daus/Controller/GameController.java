package com.daus.Controller;

/**
 * 
 * @author jordi.miret
 *
 */

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daus.Configuration.ApplicationConfig;
import com.daus.Exception.PlayerNotFoundException;
import com.daus.Model.Dice;
import com.daus.Model.Player;
import com.daus.Model.Roll;
import com.daus.Persistence.DiceRepository;
import com.daus.Persistence.PlayerRepository;
import com.daus.Persistence.RollRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GameController {

	private final PlayerRepository playerRepository;
	private final RollRepository rollRepository;
	private final DiceRepository diceRepository;
	
	public GameController(PlayerRepository playerRepository, RollRepository rollRepository, DiceRepository diceRepository) {
		super();		
		this.playerRepository = playerRepository;
		this.rollRepository = rollRepository;
		this.diceRepository = diceRepository;
	}
	
	// http://localhost:8081/players/1/games (CREATE)
	
	@PostMapping("/players/{id}/games")
	List<Dice> rollDice(@PathVariable Long id) {
				
		int numberOfDice = ApplicationConfig.numberOfDice;
		int numberOfSides = ApplicationConfig.numberOfSides;
		List<Integer> winnerNumbers = ApplicationConfig.winnerNumbers;
		
		if(!playerRepository.findById(id).equals(null)) {
			
			Player player;	
			Roll roll;
			Dice dice;
			Long id_roll;
			
			player = playerRepository.getOne(id);
														
			roll = new Roll();			
			roll.setPlayer(player);
			
			rollRepository.save(roll);
			
			id_roll = roll.getId_roll();
			
			for(int i = 1; i <= numberOfDice; i++) {
							
				dice = new Dice();				
				dice.setSide(i);
				dice.setValue(dice.rollDice(numberOfSides));
				dice.setRoll(roll);
				
				diceRepository.save(dice);
				
			}			
			
			if(winnerNumbers.contains((diceRepository.sumRollDice(id_roll))))
				roll.setWinner(true);
			
			rollRepository.save(roll);
			
			return diceRepository.getDiceByRollId(id_roll);
			
		} else {
			throw new PlayerNotFoundException(id);
		}
			
	}
	
	// http://localhost:8081/players/1/games (READ)
	
	@GetMapping("/players/{id}/games")
	List<Roll> getPlayerRoll(@PathVariable Long id) {
		if(!playerRepository.findById(id).equals(null)) {
						
			//return playerRepository.findAll();
			return rollRepository.getRollByPlayerId(id);
		
		} else {
			throw new PlayerNotFoundException(id);
		}	
				
	}
	
	// http://localhost:8081/players/1/games (DELETE)
	
	@DeleteMapping("/players/{id}/games")
	void deletePlayerRoll(@PathVariable Long id) {
		
		List<Long> ids;
		
		ids = rollRepository.getRollIdByPlayerId(id);
		
		diceRepository.deletePlayerRoll(ids);
		
	}
	
	@GetMapping("/players__")
	public List<Player> readAvgAllPlayers() {
		return playerRepository.getAvgAllPlayers();	
	}	
	
}
