package com.hautmointoir.game.server.engine;

import com.hautmointoir.game.shared.Player;
import com.hautmointoir.game.shared.State;

import java.util.Random;

public abstract class Engine {

    State state;

    public Engine() {

    }

    public boolean canPlay(Player p) {
        return (state.currentPlayer == p);
    }

    public void processCommand() {

    }


    public int rollDices() {
        Random r = new Random();
        return r.nextInt(1,13);
    }

    /* Player can have an advantage at rollDices ?
    * Maybe next evol
    * */
    public int rollDices(Player p) {
        Random r = new Random();
        return r.nextInt(1,13);
    }

    public boolean test() {
        return true;
    }

}
