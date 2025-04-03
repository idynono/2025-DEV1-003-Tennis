package com.bnp.assignement.tennis.controllers;

import com.bnp.assignement.tennis.exceptions.GameException;
import com.bnp.assignement.tennis.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/health-check")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @Operation(summary = "start an game with two players", description = "this call is made to start the game , if the game is already started it will throw an error")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content,  description = "ok as answer if the game was launched"),
            @ApiResponse(responseCode = "400", description = "bad request",
                    content = @Content)

    })
    @PostMapping("/startgame")
    public ResponseEntity<String> start(String playerName1 , String playerName2) {
        try{
            if (playerName1 == null || playerName1.trim().isEmpty() || playerName2 == null || playerName2.trim().isEmpty()) {
                return new ResponseEntity<>("Player name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            gameService.startGame(playerName1,playerName2);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @Operation(summary = "give point to player 1", description = "this call is made to give one point to player 1")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content,  description = "ok if the point was given"),
            @ApiResponse(responseCode = "400", description = "it will throw an error if the game is not launched or finish",
                    content = @Content)

    })
    @GetMapping("/addpointplayer1")
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

    @Operation(summary = "give point to player 2", description = "this call is made to give one point to player 1")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content,  description = "ok if the point was given"),
            @ApiResponse(responseCode = "400", description = "it will throw an error if the game is not launched or finish",
                    content = @Content)

    })
    @GetMapping("/addpointplayer2")
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

    @Operation(summary = "get the score or the winner", description = "the score of the game or the winner is the game is finished")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content)

    })
    @GetMapping("/score")
    public ResponseEntity<String> getScore(){
        if( gameService == null || !gameService.isOngoing()) {
            return new ResponseEntity<>("Game not started", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(gameService.getScore(),HttpStatus.OK);
    }
}
