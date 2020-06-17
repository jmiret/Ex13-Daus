package com.daus.Controller;

import java.util.List;

/**
 * 
 * @author jordi.miret
 *
 */

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daus.Configuration.ApplicationConfig;
import com.daus.Domain.Dice;
import com.daus.Exception.PlayerNotFoundException;
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
				
			return rollRepository.getRollbyNumber(rollNumber);
			
		} else {
			throw new PlayerNotFoundException(id);
		}
				
	}

}
