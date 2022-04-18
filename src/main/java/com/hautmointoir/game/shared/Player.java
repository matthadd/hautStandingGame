package com.hautmointoir.game.shared;

public class Player {

    public String name;
    public int x;

    public int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.x = 0;
    }

    public void setPosition(int x, int y) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", score=" + score +
                '}';
    }
}
