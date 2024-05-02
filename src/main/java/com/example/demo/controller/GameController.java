package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Player;
import com.example.demo.respository.PlaceRepository;
import com.example.demo.respository.PlayerRepository;
import com.example.demo.service.GameService;

@RestController
@RequestMapping("/")
public class GameController {
	
	 @Autowired
	    private GameService gameService;

	    @PostMapping("/create-game")
	    public ResponseEntity<String> createGame(@RequestParam String hostName) {
	        return gameService.createGame(hostName);
	    }

	    @PostMapping("/join-game")
	    public ResponseEntity<String> joinGame(@RequestParam String playerName) {
	        return gameService.joinGame(playerName);
	    }

	    @GetMapping("/roll-die/{playerId}")
	    public ResponseEntity<String> rollDie(@PathVariable Long playerId) {
	        return gameService.rollDie(playerId);
	    }
	    
	    @DeleteMapping("/delete-player/{playerId}")
	    public ResponseEntity<String> deletePlayer(@PathVariable Long playerId) {
	        return gameService.deletePlayer(playerId);
	    }
}