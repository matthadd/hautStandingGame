package com.hautmointoir.game.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hautmointoir.game.server.engine.DrawCardCommand;
import com.hautmointoir.game.server.engine.MoveCommand;
import com.hautmointoir.game.shared.Player;
import com.hautmointoir.game.shared.Room;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*")
public class GameController {

    final String PATH_TO_ROOMS = "src/main/resources/game/rooms/";

    @GetMapping("")
    public String index() throws IOException {
        Room room = new Room();
        System.out.println(room.roomState.board.size());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(room);
        WriteObjectToFile(room);
        Room r = (Room) ReadObjectFromFile(PATH_TO_ROOMS + "/1");
        return mapper.writeValueAsString(r);

    }

    @GetMapping("/test")
    public int test() throws IOException {
        MoveCommand moveCommand = new MoveCommand();

        return moveCommand.rollDices();

    }

    @PostMapping("/addPlayer")
    @ResponseBody
    public String addPlayer(@RequestBody Player player) {
        // check if player exist
        // if yes return No,ne

        // else
        // add Player to list
        // return Player id ?

        return "Player: " + player.toString();
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
        return "ID: ";
    }

    @PostMapping("/draw")
    @ResponseBody
    public String action(@RequestBody DrawCardCommand actionCommand) {
        // check if room doesnt exist
        // if not send packet room closed

        // else
        // then need player id ?
        // return current state of the room
        return "ID: ";
    }

    public void WriteObjectToFile(Object serObj) {
        try {

            FileOutputStream fileOut = new FileOutputStream(PATH_TO_ROOMS + "/1");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was successfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Object ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}