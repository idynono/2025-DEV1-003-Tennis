package com.bnp.assignement.tennis;

public class Player {

    public String name;
    public Integer points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void addPoints() {
        this.points = this.points + 1;
    }
}
