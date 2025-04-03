package com.bnp.assignement.tennis;

import com.bnp.assignement.tennis.exceptions.GameException;
import com.bnp.assignement.tennis.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TennisApplicationTestService {

    Player player1;
    Player player2;
    @Autowired
    GameService game;


    void setUp() throws GameException {
        if (!game.isOngoing()){
            player1 = new Player("player1");
            player2 = new Player("player2");
            game.startGame(player1.getName(),player2.getName());
        }
    }

    @Test
    void gameHastarted() throws GameException {
        setUp();
        assertEquals(true, game.isOngoing());
    }

    @Test
    void gameFinish() throws GameException {
        setUp();
        GameException thrown = Assertions.assertThrowsExactly(GameException.class, () -> {
            game.player1Scores();
            game.player1Scores();
            game.player1Scores();
            game.player1Scores();
            game.player1Scores();
            throw new GameException("Game is over");
        });
        assertEquals("Game is over", thrown.getMessage());
    }



}
