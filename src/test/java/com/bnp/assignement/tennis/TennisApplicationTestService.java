package com.bnp.assignement.tennis;

import com.bnp.assignement.tennis.exceptions.GameException;
import com.bnp.assignement.tennis.service.GameService;
import com.bnp.assignement.tennis.service.impl.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TennisApplicationTestService {

    Player player1;
    Player player2;
    @Autowired
    GameService game;

    @BeforeEach
    void setUp() throws GameException {
        player1 = new Player("player1");
        player2 = new Player("player2");
        game.startGame(player1.getName(),player2.getName());
    }

    @Test
    void gameHastarted() {
        assertEquals(true, game.isOngoing());
    }

    @Test
    void initialScoreIsZeroZero() {
        assertEquals("0-0", game.getScore());
    }

    @Test
    void player1ScoresOnce() throws GameException {
        game.player1Scores();
        assertEquals("15-0", game.getScore());
    }

    @Test
    void player2ScoresOnce() throws GameException {
        game.player2Scores();
        assertEquals("0-15", game.getScore());
    }

    @Test
    void player1ScoresTwice() throws GameException {
        game.player1Scores();
        game.player1Scores();
        assertEquals("30-0", game.getScore());
    }

    @Test
    void player2ScoresTwice() throws GameException {
        game.player2Scores();
        game.player2Scores();
        assertEquals("0-30", game.getScore());
    }

    @Test
    void player1ScoresThreeTimes() {
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        assertEquals("40-0", game.getScore());
    }

    @Test
    void player2ScoresThreeTimes() throws GameException {
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        assertEquals("0-40", game.getScore());
    }

    @Test
    void player1Wins() throws GameException {
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        assertEquals("Player 1 wins", game.getScore());
    }

    @Test
    void player2Wins() throws GameException {
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        assertEquals("Player 2 wins", game.getScore());
    }


    @Test
    void deuce() throws GameException {
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        assertEquals("Deuce", game.getScore());
    }

    @Test
    void player1Advantage() throws GameException {
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        game.player1Scores();
        assertEquals("Advantage Player 1", game.getScore());
    }

    @Test
    void player2Advantage() throws GameException {
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        assertEquals("Advantage Player 2", game.getScore());
    }

    @Test
    void player1WinsFromAdvantage() throws GameException{
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        game.player1Scores();
        game.player1Scores();
        assertEquals("Player 1 wins", game.getScore());
    }

    @Test
    void player2WinsFromAdvantage() throws GameException{
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        assertEquals("Player 2 wins", game.getScore());
    }

    @Test
    void deuceAfterAdvantage() throws GameException {
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        assertEquals("Deuce", game.getScore());
    }

    @Test
    void deuceAfterAdvantage2() throws GameException {
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        game.player2Scores();
        game.player1Scores();
        assertEquals("Advantage Player 1", game.getScore());
    }
}
