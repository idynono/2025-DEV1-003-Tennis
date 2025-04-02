package com.bnp.assignement.tennis.controllers;

import com.bnp.assignement.tennis.exceptions.GameException;
import com.bnp.assignement.tennis.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    GameService gameService;

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
            gameService.player1Scores();
        } catch (GameException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @GetMapping("/addPointPlayer2")
    public ResponseEntity<String> addPointPlayer2() {
        try {
            gameService.player2Scores();
        } catch (GameException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

}
