package com.bnp.assignement.tennis;

import java.util.Objects;

public class Game {

    private final Player players1;
    private final Player players2;
    Boolean ongoing;

    public Game(Player players1, Player players2) {
        this.players1 = players1;
        this.players2 = players2;
        this.ongoing = true;
    }

    public void player1Scores(){
        this.players1.addPoints();
    }

    public void player2Scores(){
        this.players2.addPoints();
    }

    public String getScore(){
        if (players1.getPoints() == 4 && players2.getPoints() < 3) {
            setOngoing(false);
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

    public Boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(Boolean ongoing) {
        this.ongoing = ongoing;
    }
}
