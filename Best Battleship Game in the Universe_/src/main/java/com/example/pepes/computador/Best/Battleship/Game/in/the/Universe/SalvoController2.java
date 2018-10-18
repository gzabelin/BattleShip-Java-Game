package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class SalvoController2 {

    @Autowired
    private GamePlayerRepository gamePlayerRepository;



    @RequestMapping("/game_view/gp{gameplayerId}")
    public Map<String, Object> createGameView (@PathVariable Long gameplayerId) {

        GamePlayer gp = gamePlayerRepository.findOne(gameplayerId);
        GamePlayer opponent = new GamePlayer(); // not assigned yet.

        Game thisGame = gp.getGame();
        Player thisPlayer = gp.getPlayer();




        Map<String, Object> gpView = new TreeMap<>();


        gpView.put("gameID", thisGame.getId());
        gpView.put("gameCreated", thisGame.getGameCreationDate());

        gpView.put("player1", thisPlayer.getUserName());

        for (GamePlayer gp2: thisGame.getGamePlayerSet()){

            if(gp2.getPlayer().getUserName() != thisPlayer.getUserName()){
                gpView.put("player2", gp2.getPlayer().getUserName());
                opponent = gp2;                                           // the opponent gets assigned here!
            }
        }



        List<Map<String, Object>> ships = new LinkedList<>();

        for (Ship s: gp.getShipSet()){

            Map<String, Object> ship = new TreeMap<>();
            ship.put("type", s.getShipType());
            ship.put("location", s.getLocation());

            ships.add(ship);
        }

        gpView.put("ships", ships);







        List<Map<String, Object>> player1_shots = new LinkedList<>();

        for (Salvo s: gp.getSalvoSet()){            /// this gets me the shots that P1 has fired

            Map<String, Object> shot = new TreeMap<>();
            shot.put("location", s.getLocation());
            shot.put("turn", s.getTurnNo());

            player1_shots.add(shot);
        }



        List<Map<String, Object>> player2_shots = new LinkedList<>();

        for (Salvo s: opponent.getSalvoSet()){            /// this gets me the shots that P2 has fired

            Map<String, Object> shot = new TreeMap<>();
            shot.put("location", s.getLocation());
            shot.put("turn", s.getTurnNo());

            player2_shots.add(shot);
        }


        Map<String, Object> salvoes = new TreeMap<>();

        salvoes.put("player1", player1_shots);
        salvoes.put("player2", player2_shots);


        gpView.put("salvoes", salvoes);















        return gpView;


    }






}
