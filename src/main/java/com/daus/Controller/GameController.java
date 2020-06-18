package com.daus.Controller;

import java.util.List;

/**
 * 
 * @author jordi.miret
 *
 */

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daus.Configuration.ApplicationConfig;
import com.daus.Domain.Dice;
import com.daus.Exception.PlayerNotFoundException;
import com.daus.Model.Game;
import com.daus.Model.Roll;
import com.daus.Persistence.GameRepository;
import com.daus.Persistence.PlayerRepository;
import com.daus.Persistence.RollRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GameController {
	
	private final GameRepository gameRepository;
	private final PlayerRepository playerRepository;
	private final RollRepository rollRepository;

	public GameController(GameRepository gameRepository, PlayerRepository playerRepository, RollRepository rollRepository) {
		super();
		this.gameRepository = gameRepository;
		this.playerRepository = playerRepository;
		this.rollRepository = rollRepository;
	}
	
	@PostMapping("/players/{id}/games")
	List<Roll> rollDice(@PathVariable Long id) {
		
		if(!playerRepository.findById(id).equals(null)) {
			Game game;
			Dice dice;
			Roll roll;
			int rollNumber;
			
			rollNumber = rollRepository.getLastRoll() + 1;
			
			for(int i = 1; i <= ApplicationConfig.numberOfDice; i++) {
				roll = new Roll();
				dice = new Dice();
				roll.setRollNumber(rollNumber);
				roll.setDiceNumber(i);
				roll.setDiceValue((dice.rollDice(ApplicationConfig.numberOfSides)));
				rollRepository.save(roll);
			}
			
			game = new Game();
			game.setPlayer_id(id);
			//game.setRoll_number(rollNumber);
			
			if(rollRepository.valueRollDice(rollNumber) == 7)
				game.setWinner(true);
			
			gameRepository.save(game);
			
			return rollRepository.getRollbyNumber(rollNumber);
			
		} else {
			throw new PlayerNotFoundException(id);
		}
				
	}
	
	@GetMapping("/players/{id}/games")
	List<Game> getPlayerRoll(@PathVariable Long id) {
		return gameRepository.findAll();				
	}
	
	@DeleteMapping("/players/{id}/games")
	void deletePlayerRoll(@PathVariable Long id) {
		gameRepository.deleteById(id);
	}

}
