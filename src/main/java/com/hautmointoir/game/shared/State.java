package com.hautmointoir.game.shared;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class State implements Serializable {
    public Board board;
    public List<Player> players = new ArrayList<>();

    public Player currentPlayer;

    int turn = 0;

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

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public Player incrementPlayer() {
        this.turn +=1;

        return  new Player();
    }



    public int toTest() {
        return 0;
    }


}
