package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;



    private Date gameEndDate;



    private Double score;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player playerOfScore;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game gameOfScore;



    public Score (){}


    public Score (GamePlayer gp, Double score){

        this.score = score;
        gp.distributeScore(this);

        Date x = new Date();
        this.gameEndDate = x;
    }




    public void setPlayer(Player player) {
        this.playerOfScore = player;
    }


    public void setGame(Game game) {
        this.gameOfScore = game;
    }

    public Long getId() {
        return id;
    }

    public Date getGameEndDate() {
        return gameEndDate;
    }

    public Double getScore() {
        return score;
    }

    public Player getPlayer() {
        return playerOfScore;
    }

    public Game getGame() {
        return gameOfScore;
    }
}
