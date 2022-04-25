package com.hautmointoir.game.server.engine;

import com.hautmointoir.game.shared.Player;
import com.hautmointoir.game.shared.State;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoveCommandTest {


    @Test
    void processForOnePlayer() throws IOException {
        State state = new State();
        Player player1 = new Player("P1");
        Player player2 = new Player("P2");

        state.addPlayers(player1, player2);
        List<Player> players = state.players;

        Random random = new Random();

        player1.setPosition(random.nextInt(state.board.size() - 1));
        MoveCommand moveCommand = new MoveCommand(state);
        state = moveCommand.process(players.get(0).id);
        assert (state.getPlayerById(players.get(0).id).position <= state.board.size());
    }

    @Test
    void processForTwoPlayers() throws IOException {
        State state = new State();
        Player player1 = new Player("P1");
        Player player2 = new Player("P2");

        state.addPlayers(player1, player2);
        List<Player> players = state.players;

        Random random = new Random();

        player1.setPosition(random.nextInt(state.board.size() - 1));
        MoveCommand moveCommand = new MoveCommand(state);
        state = moveCommand.process(players.get(0).id);

        // the player cant get out of the board (duh...)
        assert (state.getPlayerById(players.get(0).id).position <= state.board.size());

        // player cant move twice
        assert (moveCommand.process(players.get(0).id) == null);

        // second player can play
        assert (moveCommand.process(players.get(1).id) != null);

    }
}
