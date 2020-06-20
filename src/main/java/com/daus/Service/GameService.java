package com.daus.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.daus.Configuration.ApplicationConfig;
import com.daus.Domain.Dice;
import com.daus.Exception.PlayerNotFoundException;
import com.daus.Model.Game;
import com.daus.Model.Roll;
import com.daus.Persistence.GameRepository;
import com.daus.Persistence.PlayerRepository;
import com.daus.Persistence.RollRepository;

@Service
public class GameService {
	
	private PlayerRepository playerRepository;
	private RollRepository rollRepository;
	private GameRepository gameRepository;
	
	public GameService() {}
	
	/**
	 * 
	 * @param playerRepository
	 * @param rollRepository
	 * @param gameRepository
	 */
	public GameService(PlayerRepository playerRepository, RollRepository rollRepository,
			GameRepository gameRepository) {
		super();
		this.playerRepository = playerRepository;
		this.rollRepository = rollRepository;
		this.gameRepository = gameRepository;
	}
	
	@Transactional
	public List<Roll> rollDice(Long id) {
		
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
				
				roll.setRollNumber(rollNumber);
				roll.setDiceNumber(i);
				roll.setDiceValue((dice.rollDice(numberOfSides)));
				
				rollRepository.save(roll);
				
			}
			
			game = new Game();
			game.setPlayer_id(id);
			game.setRoll_number(rollNumber);
		
			if(winnerNumbers.contains((rollRepository.valueRollDice(rollNumber))))
				game.setWinner(true);
			
			gameRepository.save(game);
			
			return rollRepository.getRollbyNumber(rollNumber);
			
		} else {
			throw new PlayerNotFoundException(id);
		}
	}

}
