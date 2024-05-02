package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Player;
import com.example.demo.respository.PlaceRepository;
import com.example.demo.respository.PlayerRepository;
import com.example.demo.service.GameService;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public ResponseEntity<String> createGame(String hostName) {
        // Implementation to create a new game
        Player host = new Player();
        host.setName(hostName);
        playerRepository.save(host);
        return ResponseEntity.status(HttpStatus.CREATED).body("Game Created Successfully");
    }

    @Override
    public ResponseEntity<String> joinGame(String playerName) {
        // Implementation to join the game
        List<Player> players = playerRepository.findAll();
        if (players.size() >= 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Game already has 2 players.");
        }

        Player player = new Player();
        player.setName(playerName);
        playerRepository.save(player);
        return ResponseEntity.status(HttpStatus.OK).body(playerName + " has joined the game.");
    }

    @Override
    public ResponseEntity<String> rollDie(Long playerId) {
        // Implementation to roll the die and handle game logic
        Player player = playerRepository.findById(playerId).orElse(null);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found.");
        }

        // Simulate rolling two dice
        int die1 = (int)(Math.random() * 6) + 1;
        int die2 = (int)(Math.random() * 6) + 1;
        int total = die1 + die2;

        // Logic to handle player actions based on the place landed
        // This logic includes buying a place, paying rent, gaining $200 when passing start, etc.

        String result = "Die rolled: " + total + ". Landed on Place XYZ."; // Placeholder message
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @Override
    public ResponseEntity<String> deletePlayer(Long playerId) {
        Player player = playerRepository.findById(playerId).orElse(null);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found.");
        }

        playerRepository.delete(player);
        return ResponseEntity.status(HttpStatus.OK).body("Player deleted successfully.");
    }
}