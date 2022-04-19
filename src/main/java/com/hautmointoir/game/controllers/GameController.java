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

    final String PATH_TO_ROOMS = "src/main/resources/gameStorage/rooms/";

    @GetMapping("")
    public String index() throws IOException {
        Room room = new Room();
        System.out.println(room.roomState.board.size());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(room);
        WriteObjectToFile(room, PATH_TO_ROOMS + "/1");
        Room r = (Room) ReadObjectFromFile(PATH_TO_ROOMS + "/1");
        return mapper.writeValueAsString(r);
    }

    @GetMapping("/test")
    public int test() throws IOException {
        MoveCommand moveCommand = new MoveCommand();

        return moveCommand.rollDices();

    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody Player player) {
        // check if player exist

        // if false
        // add Player to list

        // return Player id

        return "Player: " + player.toString();
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody int id) {
        // check if player exist

        // if false
        // add Player to list

        // return Player id

        return true;
    }

    @GetMapping("/join")
    @ResponseBody
    public String join(@RequestParam int id) {
        // check if room exist

        // if false
        // create room
        // save it to .json file

        // if true
        // then NEED player id (note the RequestParam is not mandatory)
        // add Player to room

        // return state of room
        return "ID: " + id;
    }

    @GetMapping("/update")
    @ResponseBody
    public String update(@RequestParam int roomID) {

        // check if room exist

        // if true
        // return current state of the room

        // if false
        // return room close msg (ex : {room : closed}, or 404 Error, ...)

        return "ID: " + roomID;
    }

    @PostMapping("/roll")
    @ResponseBody
    public String roll(@RequestBody MoveCommand moveCommand) {
        // check if room doesnt exist
        // if not send packet room closed

        // else
        // then need player id ?
        // return current state of the room
        return "ID: ";
    }

    @PostMapping("/draw")
    @ResponseBody
    public String draw(@RequestBody DrawCardCommand actionCommand) {
        // check if room doesnt exist
        // if not send packet room closed

        // else
        // then need player id ?
        // return current state of the room
        return "ID: ";
    }

    public void WriteObjectToFile(Object serObj, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("[WriteObjectToFile] SUCCESS");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Object ReadObjectFromFile(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            System.out.println("[ReadObjectFromFile] SUCCESS");
            objectIn.close();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}