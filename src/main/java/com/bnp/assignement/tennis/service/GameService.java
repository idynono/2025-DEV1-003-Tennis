package com.bnp.assignement.tennis.service;

import com.bnp.assignement.tennis.Game;
import com.bnp.assignement.tennis.Player;
import com.bnp.assignement.tennis.exceptions.GameException;
import org.springframework.stereotype.Service;

@Service
public interface GameService {




    public void startGame(String namePlayer1, String namePlayer2) throws GameException;

    public void player1Scores () throws GameException;

    public void player2Scores () throws GameException;


}
