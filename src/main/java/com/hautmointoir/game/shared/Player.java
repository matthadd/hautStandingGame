package com.hautmointoir.game.shared;

public class Player {
    public int id = 0;

    public String name;
    public int position = 0;
    public boolean isFcked = false;

    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}

    public int getPosition() {return this.position;}
    public void setPosition(int x) {this.position = x;}


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
