package com.bnp.assignement.tennis;

import com.bnp.assignement.tennis.service.GameService;
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

}
