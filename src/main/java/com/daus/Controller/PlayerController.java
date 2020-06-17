package com.daus.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
}
