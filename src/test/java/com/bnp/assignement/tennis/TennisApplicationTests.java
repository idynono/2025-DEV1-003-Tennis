package com.bnp.assignement.tennis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TennisApplicationTests {

    @Test
    void contextLoads() {
    }

    @BeforeEach
    void setUp() {
        game = new Game();
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
