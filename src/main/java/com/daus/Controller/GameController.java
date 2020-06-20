package com.daus.Controller;
import java.sql.Wrapper;
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
import com.daus.Exception.PlayerNotFoundException;
import com.daus.Model.Dice;
import com.daus.Model.Game;
import com.daus.Model.Player;
import com.daus.Model.Roll;
import com.daus.Persistence.GameRepository;
import com.daus.Persistence.PlayerRepository;
import com.daus.Persistence.RollRepository;
import com.daus.Service.GameService;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GameController {
	
	private final GameRepository gameRepository;
	private final PlayerRepository playerRepository;
	private final RollRepository rollRepository;
	
	private GameService gameService;

	public GameController(GameRepository gameRepository, PlayerRepository playerRepository, RollRepository rollRepository, GameService gameService) {
		super();
		this.gameRepository = gameRepository;
		this.playerRepository = playerRepository;
		this.rollRepository = rollRepository;
		this.gameService = gameService;
	}
	
	/*
	private String toJson(Object object) {

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
	}
	*/
	
	@PostMapping("/players/{id}/games")
	List<Roll> rollDice(@PathVariable Long id) {
				
		int numberOfDice = ApplicationConfig.numberOfDice;
		int numberOfSides = ApplicationConfig.numberOfSides;
		List<Integer> winnerNumbers = ApplicationConfig.winnerNumbers;
		
		if(!playerRepository.findById(id).equals(null)) {
			Game game;
			Dice dice;
			Roll roll;
			int rollNumber;
			
			//rollNumber = rollRepository.getLastRoll() + 1;
			rollNumber = gameRepository.getLastGame() + 1;
			
			for(int i = 1; i <= numberOfDice; i++) {
				
				roll = new Roll();
				dice = new Dice();
				
				/*
				roll.setRollNumber(rollNumber);
				roll.setDiceNumber(i);
				roll.setDiceValue((dice.rollDice(numberOfSides)));
				*/
				
				rollRepository.save(roll);
				
			}
			
			game = new Game();
			/*
			game.setPlayer_id(id);
			game.setRoll_number(rollNumber);
			*/
			
			if(winnerNumbers.contains((rollRepository.valueRollDice(rollNumber))))
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
	void deletePlayerRoll(@PathVariable int id) {
		List<Integer> ids;
		ids = gameRepository.getPlayerGames(id);
		rollRepository.deletePlayerRoll(ids);
		System.out.println(ids.toString());
	}
	
	@GetMapping("/players__")
	public List<Player> readAvgAllPlayers() {
		//return playerRepository.findAll();
		return gameRepository.getAvgAllPlayers();	
	}	
	
	
}
