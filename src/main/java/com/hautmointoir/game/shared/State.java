package com.hautmointoir.game.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class State {
    public Board board;
    public List<Player> players = new ArrayList<>();


    public State() throws IOException {
        this.board = new Board();
    }

    public void addPlayers(Player... players) {
        for (Player p : players) {
            this.players.add(p);
            System.out.println(p);
        }
    }

    public void deletePlayers(Player... players) {
        for (Player p : players) {
                this.players.remove(p);
            System.out.println(p + " deleted");
        }
    }

    public int toTest() {
        return 0;
    }


}
