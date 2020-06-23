package com.daus.Service;

import java.util.List;

/** 
 * @author jordi.miret 
 */

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.daus.Persistence.PlayerRepository;

public class PlayerServiceImp implements PlayerService {
	
	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImp(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@Override
	public Map<String, Object> getAvg() {
		// TODO Auto-generated method stub
		
		Map<String, Object> result = (Map<String, Object>) playerRepository.getAvg();
		return result;
	}
	
	@Override
	public Map<String, Object> getLoser() {
		// TODO Auto-generated method stub
		
		Map<String, Object> result = (Map<String, Object>) playerRepository.getLoser();
		return result;
	}
	
	@Override
	public Map<String, Object> getWinner() {
		// TODO Auto-generated method stub
		
		Map<String, Object> result = (Map<String, Object>) playerRepository.getWinner();
		return result;
	}

	@Override
	public List<Map<String, Object>> getAvgAllPlayers() {
		// TODO Auto-generated method stub

		List<Map<String, Object>> result = (List<Map<String, Object>>) playerRepository.getAvgAllPlayers();
		return result;
		
	}

}
