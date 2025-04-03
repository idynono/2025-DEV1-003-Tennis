package com.bnp.assignement.tennis.controllers;

import com.bnp.assignement.tennis.exceptions.GameException;
import com.bnp.assignement.tennis.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/startgame")
    public ResponseEntity<String> start(String playerName1 , String playerName2) {
        try{
            gameService.startGame(playerName1,playerName2);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @GetMapping("/addPointPlayer1")
    public ResponseEntity<String> addPointPlayer1() {
        try {
            if( gameService == null || !gameService.isOngoing()) {
                throw new GameException("Game not started");
            }
            if(gameService.isGameOver()) {
                return new ResponseEntity<>("the game is finish", HttpStatus.BAD_REQUEST);
            }
            gameService.player1Scores();
        } catch (GameException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @GetMapping("/addPointPlayer2")
    public ResponseEntity<String> addPointPlayer2() {
        try {
            if( gameService == null || !gameService.isOngoing()) {
                return new ResponseEntity<>("Game not started", HttpStatus.BAD_REQUEST);
            }
            if(gameService.isGameOver()) {
                return new ResponseEntity<>("the game is finish", HttpStatus.BAD_REQUEST);
            }
            gameService.player2Scores();
        } catch (GameException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @GetMapping("/score")
    public ResponseEntity<String> getScore(){
        if( gameService == null || !gameService.isOngoing()) {
            return new ResponseEntity<>("Game not started", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gameService.getScore(),HttpStatus.OK);
    }
}
