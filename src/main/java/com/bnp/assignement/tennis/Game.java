package com.bnp.assignement.tennis;

import java.util.Objects;

public class Game {

    public Player players1;
    public Player players2;

    public Game(Player players1, Player players2) {
        this.players1 = players1;
        this.players2 = players2;
    }

    public void player1Scores(){
        this.players1.addPoints();
    }

    public void player2Scores(){
        this.players2.addPoints();
    }

    public String getScore(){
        if (players1.getPoints() == 4 && players2.getPoints() < 3) {
            return "Player 1 wins";
        } else if (players2.getPoints() == 4 && players1.getPoints() < 3) {
            return "Player 2 wins";
        } else if (players1.getPoints() == 3 && players2.getPoints() == 3) {
            return "Deuce";
        } else if (players1.getPoints() == 4 && players2.getPoints() == 3) {
            return "Advantage Player 1";
        } else if (players2.getPoints() == 4 && players1.getPoints() == 3) {
            return "Advantage Player 2";
        } else if (players1.getPoints() > 4 && players2.getPoints() == 3){
            return "Player 1 wins";
        }
        else if (players2.getPoints() > 4 && players1.getPoints() == 3){
            return "Player 2 wins";
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
}
