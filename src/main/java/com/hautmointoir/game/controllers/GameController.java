package com.hautmointoir.game.controllers;

import com.hautmointoir.game.server.engine.ActionCommand;
import com.hautmointoir.game.server.engine.MoveCommand;
import com.hautmointoir.game.shared.Player;
import com.hautmointoir.game.shared.Room;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class GameController {

    @GetMapping("/")
    public String index() throws IOException {
        Room room = new Room();
        System.out.println(room.roomState.board.size());
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/addPlayer")
    @ResponseBody
    public String addPlayer(@RequestBody Player player) {
        // check if player exist
        // if yes return No,ne

        // else
        // add Player to list
        // return Player id ?

        return "Player: " + player.toString() ;
    }

    @GetMapping("/join")
    @ResponseBody
    public String join(@RequestParam int id) {
        // check if room doesnt exist
        // create room
        // save it to .json file
        // return State to client as Json

        // else
        // then NEED player id (Param non mandatory)
        // add Player to room
        // send state of room
        return "ID: " + id;
    }

    @GetMapping("/update")
    @ResponseBody
    public String update(@RequestParam int roomID) {
        // check if room doesnt exist
        // if not send packet room closed

        // else
        // then need player id ?
        // return current state of the room

        // send story ?
        return "ID: " + roomID;
    }

    @PostMapping("/move")
    @ResponseBody
    public String update(@RequestBody MoveCommand moveCommand) {
        // check if room doesnt exist
        // if not send packet room closed

        // else
        // then need player id ?
        // return current state of the room
        return "ID: " ;
    }

    @PostMapping("/action")
    @ResponseBody
    public String action(@RequestBody ActionCommand actionCommand) {
        // check if room doesnt exist
        // if not send packet room closed

        // else
        // then need player id ?
        // return current state of the room
        return "ID: " ;
    }

}