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
    @JoinColumn(name="player_id") //////////// is this just the name of the column?? Can this be anything? -> yes it can be anything!
    private Player player;      /////////// do i need player1 and player 2???

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="game_id_lkjfkj")
    private Game game;

    public void setGame(Game aGame){        //// check if this is sufficient + see constructor below

        this.game = aGame;

    }

    public void setPlayer(Player aPlayer){

        this.player=aPlayer;
    }


    public Game getGame(){
        return game;
    }

    public Player getPlayer(){
        return player;          /////////// how about player 2?
    }





    GamePlayer(){

        Date x = new Date();
        setGameJoinDate(x);
    }


    public GamePlayer(Game game, Player player) {   ////// also added in the context of JPA tables.

        this.game=game;
        this.player=player;

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
