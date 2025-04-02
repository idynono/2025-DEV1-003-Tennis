package com.bnp.assignement.tennis.service.impl;

import com.bnp.assignement.tennis.Game;
import com.bnp.assignement.tennis.Player;
import com.bnp.assignement.tennis.exceptions.GameException;
import com.bnp.assignement.tennis.service.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {


    private Game game;

    public void startGame(String namePlayer1, String namePlayer2) throws GameException {
        if( game == null) {
            game = new Game(new Player(namePlayer1),new Player(namePlayer2));
        } else {
            throw new GameException("Game already started");
        }
    }

    public void player1Scores () throws GameException {
        if( game == null) {
            throw new GameException("Game not started");
        } else {
            game.player1Scores();
        }
    }

    public void player2Scores () throws GameException {
        if( game == null) {
            throw new GameException("Game not started");
        } else {
            game.player2Scores();
        }
    }


}
