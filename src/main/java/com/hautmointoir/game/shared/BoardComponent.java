package com.hautmointoir.game.shared;

public class BoardComponent implements BoardComponentInterface {
    public String name;
    public String description;
    public int movePoints;
    public int weight;

    public BoardComponent() {}

    public BoardComponent(String name, String description, int movePoints, int weight) {
        this.name = name;
        this.description = description;
        this.movePoints = movePoints;
        this.weight = weight;
    }

    @Override
    public void before() {

    }

    @Override
    public void now() {

    }

    @Override
    public void after() {

    }

    @Override
    public String toString() {
        return "BoardComponent{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", movePoints=" + movePoints +
                '}';
    }
}
