package com.hautmointoir.game.server.engine;

import com.hautmointoir.game.shared.Player;
import com.hautmointoir.game.shared.State;

import java.util.Random;

public class MoveCommand extends Engine {

    State currentState;

    public MoveCommand(State state) {
        this.currentState = state;
    }

    public Player process(Player player) {
        if(this.currentState.currentPlayer.id != player.id) return null;

        int expectedPosition = player.getPosition() + this.rollDices();

        if (expectedPosition > this.currentState.board.size()){
            int diff = expectedPosition - this.currentState.board.size();
            player.setPosition( player.getPosition() - diff);
            return player;
        }

        player.setPosition(expectedPosition);
        return player;
    }



}
