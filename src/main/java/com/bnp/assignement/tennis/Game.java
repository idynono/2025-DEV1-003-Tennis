package com.bnp.assignement.tennis;

import java.util.Objects;

public class Game {

    private final Player players1;
    private final Player players2;
    private static boolean ongoing;
    private boolean gameOver;

    public Game(Player players1, Player players2) {
        this.players1 = players1;
        this.players2 = players2;
        this.gameOver = false;
        setOngoing(true);
    }

    public void player1Scores(){
        if (isOngoing()){
            this.players1.addPoints();
        }
        getScore();
    }

    public void player2Scores(){
        if (isOngoing()){
            this.players2.addPoints();
        }
        getScore();
    }

    public String getScore(){
        if (players1.getPoints() == 4 && players2.getPoints() < 3) {
            setGameOver(true);
            return "Player " + players1.getName() + " wins";
        } else if (players2.getPoints() == 4 && players1.getPoints() < 3) {
            setGameOver(true);
            return "Player " + players2.getName() + " wins";
        } else if (players1.getPoints() == 3 && players2.getPoints() == 3) {
            return "Deuce";
        } else if (players1.getPoints() == 4 && players2.getPoints() == 3) {
            return "Advantage Player 1";
        } else if (players2.getPoints() == 4 && players1.getPoints() == 3) {
            return "Advantage Player 2";
        } else if (players1.getPoints() > 4 && players2.getPoints() == 3){
            setGameOver(true);
            return "Player " + players1.getName() + " wins";

        }
        else if (players2.getPoints() > 4 && players1.getPoints() == 3){
            setGameOver(true);
            return "Player " + players2.getName() + " wins";

        }
        else if (Objects.equals(players1.getPoints(), players2.getPoints()) && players1.getPoints() >= 3){
            return "Deuce";
        }
        else if (players1.getPoints() == 4 && players2.getPoints() == 4){
            return "Deuce";
        }
        else if (players2.getPoints() == 4 && players1.getPoints() == 4){
            return "Deuce";
        }

        return scoreToString(players1.getPoints()) + "-" + scoreToString(players2.getPoints());
    }

    private String scoreToString(int score) {
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "";
        };
    }

    public static Boolean isOngoing() {
        return ongoing;
    }

    public static void setOngoing(Boolean ongoingParam) {
        ongoing = ongoingParam;
    }

    public Boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }
}
