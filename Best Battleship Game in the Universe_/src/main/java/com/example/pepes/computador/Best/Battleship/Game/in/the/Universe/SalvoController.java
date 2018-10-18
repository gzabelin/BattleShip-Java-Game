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

//    @Autowired
//    private PlayerRepository playerRepository;
//
    @Autowired
    private GamePlayerRepository gamePlayerRepository;

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


// This code is OK, but Vasil's solution is better :)

//        for (int i=0; i<allGames.size(); i++){
//
//            Map<String, Object> gameInfo = new HashMap<>();
//
//            gameInfo.put("id", allGames.get(i).getId());
//            gameInfo.put("created", allGames.get(i).getGameCreationDate());
//
//            gameJSON.add(gameInfo);
//        }


        // return gameJSON;

        return allGames.stream()
                       // .sorted((game1, game2) -> game2.getId()-game1.getId())
                        .map(game -> createGameDto(game))
                        .collect(toList());

    }

    private Map<String, Object> createGameDto(Game game){
        Map<String, Object> gameInfo = new HashMap<>();
        gameInfo.put("id", game.getId());
        gameInfo.put("created", game.getGameCreationDate());

        return  gameInfo;
    }


    @RequestMapping("/games/gameInfo")
    public List<Object> getAllGameInfo() {

        List<Game> allGameInfo = new LinkedList<>();

        allGameInfo = getAll();


        return allGameInfo.stream()
                    .map(game -> gameDTO(game))
                    .collect(toList());



    }

    private Map<String, Object> playerDTO (Player pl){

        Map<String, Object> playerInfo = new HashMap<>();

        playerInfo.put("id", pl.getId());
        playerInfo.put("User Name", pl.getUserName());

        return playerInfo;

    }

    private Map<String, Object> gamePlayerDTO (GamePlayer gp){

        Map<String, Object> gamePlayerXY = new HashMap<>();

        gamePlayerXY.put("GP id", gp.getId());
        gamePlayerXY.put("player", playerDTO(gp.getPlayer()));


        return gamePlayerXY;

    }

    private List<Map<String, Object>> gamePlayerList (Game game){
        List<GamePlayer> gamePlayerList = new LinkedList<>();

        gamePlayerList = gamePlayerRepository.findAll();

        return gamePlayerList.stream()
                            .filter(gamePlayer -> gamePlayer.getGame()== game)
                            .map(gameplayer-> gamePlayerDTO(gameplayer) )
                            .collect(toList());
    }


    private Map<String, Object> gameDTO (Game game){

        Map<String, Object> gameDTO = new TreeMap<>();

        gameDTO.put("Game ID", game.getId());
        gameDTO.put("Game created", game.getGameCreationDate());
        gameDTO.put("Gameplayers", gamePlayerList(game));



        return gameDTO;
    }





}
