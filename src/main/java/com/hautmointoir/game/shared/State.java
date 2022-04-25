package com.hautmointoir.game.shared;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class State implements Serializable {
    public Board board;
    public List<Player> players = new ArrayList<>();

    public Player currentPlayer;

    public int playerIdPointer = 0;
    

    public State() throws IOException {
        this.board = new Board();
    }

    public void addPlayers(Player... players) {
        for (Player p : players) {

            // give player new id
            p.setId(this.players.size());

            // add it to the state list
            this.players.add(p);
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

    public void incrementPlayer() {
        this.playerIdPointer = (this.playerIdPointer + 1) % players.size();
        this.currentPlayer = this.players.get(playerIdPointer);
    }

    public void replacePlayerById(Player player) {
        this.players.set(player.id, player);
    }

    public Player getPlayerById(int id) {
        if (this.players.size() < id) return null;
        return this.players.get(id);
    }

    public boolean canPlayer(Player p) {
        return (p.id == this.getCurrentPlayer().id);
    }

}
