package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy="gamePlayer", fetch= FetchType.EAGER)
    private Set<Ship> shipSet = new HashSet<>();

    @OneToMany(mappedBy="gamePlayerOfSalvo", fetch= FetchType.EAGER)
    private Set<Salvo> salvoSet = new HashSet<>();

    private int turnCount = 0;




    GamePlayer(){}

    public GamePlayer(Game game, Player player) {

        this.game=game;
        this.player=player;


        Date x = new Date();
        setGameJoinDate(x);
    }





    public void addShip(Ship ship) {
        ship.setGamePlayer(this);
        shipSet.add(ship);
    }

    public void addSalvo(Salvo salvo){
        turnCount+=1;
        salvo.setGamePlayer(this);
        salvoSet.add(salvo);
    }












    public void setGameJoinDate(Date gameJoinDate) {
        this.gameJoinDate = gameJoinDate;
    }

    public Game getGame(){
        return game;
    }

    public Player getPlayer(){
        return player;
    }

    public Date getGameJoinDate() {
        return gameJoinDate;
    }

    public Long getId() {
        return id;
    }

    public Set<Ship> getShipSet() {return shipSet;}

    public Set<Salvo> getSalvoSet() {return salvoSet;}


    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getTurnCount() {return turnCount;}


}
