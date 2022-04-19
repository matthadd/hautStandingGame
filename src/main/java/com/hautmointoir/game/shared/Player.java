package com.hautmointoir.game.shared;

public class Player {
    public int id;

    public String name;
    public int x = 0;
    public int score = 0;
    public boolean isFcked = false;
    public Player() {}

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
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
