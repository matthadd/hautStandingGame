package com.hautmointoir.game.server.engine;

import com.hautmointoir.game.shared.Player;
import com.hautmointoir.game.shared.State;

public class MoveCommand extends Engine {

    State currentState;

    public MoveCommand(State state) {
        this.currentState = state;
    }

    // process make modification and send the new state to load
    public State process(int playerID) {
        // if the player is not supposed to play : do nothing
        if (this.currentState.playerIdPointer != playerID) return null;

        Player player = this.currentState.getPlayerById(playerID);

        int expectedPosition = player.getPosition() + this.rollDices();

        this.currentState.board.size(); // debug

        // if expected position is outside board walk backward
        if (expectedPosition > this.currentState.board.size()) {
            int diff = expectedPosition - this.currentState.board.size();
            player.setPosition(player.getPosition() - diff);
            this.currentState.replacePlayerById(player);
        } else {
            // else replace position with expected position
            player.setPosition(expectedPosition);
            // replace the old player object with the new in the state
            this.currentState.replacePlayerById(player);

        }


        // finally increment player position and return the new state
        this.currentState.incrementPlayer();
        return this.currentState;
    }


}
