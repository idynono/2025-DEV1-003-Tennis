package com.bnp.assignement.tennis.service;

import com.bnp.assignement.tennis.exceptions.GameException;

public interface GameService {


    public void startGame(String namePlayer1, String namePlayer2) throws GameException;

    public void player1Scores () throws GameException;

    public void player2Scores () throws GameException;

    public boolean isGameOver ();

    public boolean isOngoing();

    public String getScore();

}
