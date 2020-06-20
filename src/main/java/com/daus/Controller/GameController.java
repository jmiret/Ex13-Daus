package com.daus.Controller;

/**
 * 
 * @author jordi.miret
 *
 */

import java.sql.Wrapper;
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
import com.daus.Model.Game;
import com.daus.Model.Player;
import com.daus.Model.Roll;
import com.daus.Persistence.DiceRepository;
import com.daus.Persistence.GameRepository;
import com.daus.Persistence.PlayerRepository;
import com.daus.Persistence.RollRepository;
import com.daus.Service.GameService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GameController {
	
	private final GameRepository gameRepository;
	private final PlayerRepository playerRepository;
	private final RollRepository rollRepository;
	private final DiceRepository diceRepository;
	
	public GameController(GameRepository gameRepository, PlayerRepository playerRepository, RollRepository rollRepository, DiceRepository diceRepository) {
		super();
		this.gameRepository = gameRepository;
		this.playerRepository = playerRepository;
		this.rollRepository = rollRepository;
		this.diceRepository = diceRepository;
	}
	
	@PostMapping("/players/{id}/games")
	List<Roll> rollDice(@PathVariable Long id) {
				
		int numberOfDice = ApplicationConfig.numberOfDice;
		int numberOfSides = ApplicationConfig.numberOfSides;
		List<Long> winnerNumbers = ApplicationConfig.winnerNumbers;
		
		if(!playerRepository.findById(id).equals(null)) {
			Player player;
			Game game;			
			Roll roll;
			Dice dice;
			Long id_roll;
			
			player = new Player();
			player.setId_player(id);
						
			game = new Game();
			game.getId_game();
			game.setPlayer(player);
												
			roll = new Roll();
			id_roll = roll.getId_roll();
			//roll.setGame(game);
			
			rollRepository.save(roll);
			
			for(int i = 1; i <= numberOfDice; i++) {
							
				dice = new Dice();				
				dice.setSide(i);
				dice.setValue(dice.rollDice(numberOfSides));
				dice.setRoll(roll);
				
				diceRepository.save(dice);
				
			}			
			
			if(winnerNumbers.contains((diceRepository.sumRollDice(id_roll))))
				game.setWinner(true);
			
			gameRepository.save(game);
			
			//return rollRepository.getRollByID(id_roll);
			return null;
			
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
