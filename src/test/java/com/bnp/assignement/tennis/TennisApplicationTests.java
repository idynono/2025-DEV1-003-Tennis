package com.bnp.assignement.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TennisApplicationTests {

    Player player1;
    Player player2;
    Game game;

    @BeforeEach
    void setUp() {
         player1 = new Player("player1");
         player2 = new Player("player2");
         game = new Game(player1,player2);
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
    void player1ScoresOnce() {
        game.player1Scores();
        assertEquals("15-0", game.getScore());
    }

    @Test
    void player2ScoresOnce() {
        game.player2Scores();
        assertEquals("0-15", game.getScore());
    }

    @Test
    void player1ScoresTwice() {
        game.player1Scores();
        game.player1Scores();
        assertEquals("30-0", game.getScore());
    }

    @Test
    void player2ScoresTwice() {
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
    void player2ScoresThreeTimes() {
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        assertEquals("0-40", game.getScore());
    }

    @Test
    void player1Wins() {
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        assertEquals("Player 1 wins", game.getScore());
    }

    @Test
    void player2Wins() {
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        assertEquals("Player 2 wins", game.getScore());
    }


    @Test
    void deuce() {
        game.player1Scores();
        game.player1Scores();
        game.player1Scores();
        game.player2Scores();
        game.player2Scores();
        game.player2Scores();
        assertEquals("Deuce", game.getScore());
    }

    @Test
    void player1Advantage() {
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
    void player2Advantage() {
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
    void player1WinsFromAdvantage() {
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
    void player2WinsFromAdvantage() {
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
    void deuceAfterAdvantage() {
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
    void deuceAfterAdvantage2() {
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
