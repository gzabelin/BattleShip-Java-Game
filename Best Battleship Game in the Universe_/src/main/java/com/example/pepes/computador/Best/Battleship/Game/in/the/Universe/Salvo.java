package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Salvo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gameplayerid")
    private GamePlayer gamePlayerOfSalvo;

    @ElementCollection
    @Column(name="location")
    private List<String> location = new LinkedList<>();

    private Integer turnNo;




    public Salvo(){}    // empty constructor


    public Salvo(String location){

        for (int i=0; i<location.length(); i++){
            if (location.charAt(i) ==','){
                this.location.add(location.substring((i-2),i)); // this doesn't work for A10 !!!!!!!!!!!!!!!!!
            }
        }
        this.location.add(location.substring((location.length()-2), location.length())); // neither does this.

    }






    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayerOfSalvo = gamePlayer;
        this.turnNo = gamePlayer.getTurnCount();
    }


    public Long getId() {return id;}

    public List<String> getLocation() {return location;}

    public Integer getTurnNo() {return turnNo;}

    public GamePlayer getGamePlayer() {return gamePlayerOfSalvo;}





}
