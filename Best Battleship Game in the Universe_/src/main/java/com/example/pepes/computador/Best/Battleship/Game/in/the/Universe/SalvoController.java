package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.util.stream.Collectors.toList;


@RestController                 /// this guy is my REST controller for the games.
@RequestMapping("/api")       /// ("/api")  tells to start every URL with /api.
public class SalvoController {


    @Autowired
    private GameRepository gameRepository;

    @RequestMapping("/games")
    public List<Game> getAll() {
        return gameRepository.findAll();            /// findAll() is a standard method from JPA Repository Interface
    }

    @RequestMapping("/games/IDs")
    public List<Long> getGameIDs() {

        List<Game> allGames = new LinkedList<>();
        allGames = getAll();

        //Map<String, Object> justGameIDs = new HashMap<>();
        List<Long> justIDs = new LinkedList<>();

        for (int i=0; i<allGames.size(); i++){

        //   justGameIDs.put("id", allGames.get(i).getId());
            justIDs.add(allGames.get(i).getId());
        }


        // return justIDs;


        return allGames.stream()
                        .map(game -> game.getId())
                        .collect(toList());

    }

    @RequestMapping("/games/gameJSON")
    public List<Map<String, Object>> getGameJSON() {

        List<Game> allGames = new LinkedList<>();
        allGames = getAll();

        List<Map<String, Object>> gameJSON = new LinkedList<>();



        for (int i=0; i<allGames.size(); i++){

            Map<String, Object> gameInfo = new HashMap<>();

            gameInfo.put("id", allGames.get(i).getId());
            gameInfo.put("created", allGames.get(i).getGameCreationDate());

            gameJSON.add(gameInfo);
        }


         return gameJSON;



    }







}
