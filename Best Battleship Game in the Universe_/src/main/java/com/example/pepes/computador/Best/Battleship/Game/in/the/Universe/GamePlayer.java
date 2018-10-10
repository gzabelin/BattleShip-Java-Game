package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private Date gameJoinDate;




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="game_id_lkjfkj")
    private Game game;

    public void setGame(Game aGame){

        this.game = aGame;

    }

    public void setPlayer(Player aPlayer){

        this.player=aPlayer;
    }


    public Game getGame(){
        return game;
    }

    public Player getPlayer(){
        return player;
    }





    GamePlayer(){


    }


    public GamePlayer(Game game, Player player) {

        this.game=game;
        this.player=player;

        Date x = new Date();
        setGameJoinDate(x);

    }











    public Date getGameJoinDate() {
        return gameJoinDate;
    }

    public void setGameJoinDate(Date gameJoinDate) {
        this.gameJoinDate = gameJoinDate;
    }

    public Long getId() {
        return id;
    }


















}
