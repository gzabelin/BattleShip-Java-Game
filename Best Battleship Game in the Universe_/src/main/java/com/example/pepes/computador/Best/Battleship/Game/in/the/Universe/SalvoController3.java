package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api")
public class SalvoController3 {

    @Autowired
    private PlayerRepository playerRepository;


    @RequestMapping("/leaderboard")
    public List<Map> createLeaderBoard () {

        List<Player> allPlayers = playerRepository.findAll();

        List<Map> leaderBoard = new LinkedList<>();

        for(Player p: allPlayers){

            Map<String, Object> info = new TreeMap<>();

            info.put("player", p.getUserName());
            info.put("total_score", p.getTotalScore());
            info.put("wins", p.getNumWins());
            info.put("losses", p.getNumLosses());
            info.put("ties", p.getNumTies());

            leaderBoard.add(info);
        }

        return leaderBoard;
    }

}
