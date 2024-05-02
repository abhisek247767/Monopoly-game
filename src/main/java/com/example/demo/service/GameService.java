package com.example.demo.service;

import org.springframework.http.ResponseEntity;

public interface GameService {
    ResponseEntity<String> createGame(String hostName);
    ResponseEntity<String> joinGame(String playerName);
    ResponseEntity<String> rollDie(Long playerId);
    ResponseEntity<String> deletePlayer(Long playerId);

}
