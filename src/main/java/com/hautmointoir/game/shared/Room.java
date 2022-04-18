package com.hautmointoir.game.shared;

import java.io.IOException;

public class Room {
    public int id;
    public State roomState;
    public int playerID;

    public Room() throws IOException {
        this.roomState = new State();
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomState=" + roomState +
                ", playerID=" + playerID +
                '}';
    }
}