package com.hautmointoir.game.server.engine;

import com.hautmointoir.game.shared.Player;
import com.hautmointoir.game.shared.State;

import java.util.Random;

public class MoveCommand extends Engine {

    public  MoveCommand() {}

    public void process(State state) {
        Player p = state.getCurrentPlayer();
    }



}
