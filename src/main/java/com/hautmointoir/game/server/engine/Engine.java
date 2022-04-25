package com.hautmointoir.game.server.engine;

import com.hautmointoir.game.shared.Player;
import com.hautmointoir.game.shared.State;

import java.util.Random;

public abstract class Engine {

    State currentState;
    public Engine() {
    }

    // work do to on it...
    public boolean processCommand() {
        return true;
    }

    public boolean canPlay(Player p) {
        return (currentState.currentPlayer.id == p.id);
    }

    /* basic roll dice, 1 to 12 */
    public int rollDices() {
        Random r = new Random();
        return r.nextInt(1,13);
    }

    /* Player can have an advantage at rollDices ?
    * Maybe in next feature
    */
    public int rollDices(Player p) {
        Random r = new Random();
        return r.nextInt(1,13);
    }
}
