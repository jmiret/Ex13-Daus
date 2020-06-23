package com.daus.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface PlayerService {
	
	Map<String, Object> getAvg();
	
	Map<String, Object> getLoser();
	
	Map<String, Object> getWinner();
	
	List<Map<String, Object>> getAvgAllPlayers();

}
