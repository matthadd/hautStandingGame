package com.hautmointoir.game.server.engine;

import com.hautmointoir.game.shared.Player;
import com.hautmointoir.game.shared.State;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class MoveCommandTest {


    @Test
    void process() throws IOException {
        State state = new State();
        Player player = new Player("fakename");
        Random random = new Random();

        for(int i = 0; i < 100 ; i++) {

            player.setPosition(random.nextInt(state.board.size()));
            state.currentPlayer = player;
            MoveCommand moveCommand = new MoveCommand(state);
            player = moveCommand.process(player);
            assert (player.position <= state.board.size());
        }
    }
}
