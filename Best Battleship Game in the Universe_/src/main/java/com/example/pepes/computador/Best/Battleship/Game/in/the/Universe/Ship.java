package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Ship {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private Integer length;

    private String shipType;


    @ElementCollection
    @Column(name="location")
    private List <String> location = new LinkedList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gameplayerid")
    private GamePlayer gamePlayer;

    public Ship(){}
    /// why do I need the empty constructor again?? something to do with SpringBoot, no doubt..




    public Ship (String location){

        for (int i=0; i<location.length(); i++){
            if (location.charAt(i) ==','){
                this.location.add(location.substring((i-2),i)); // this doesn't work for A10 !!!!!!!!!!!!!!!!!
            }
        }
        this.location.add(location.substring((location.length()-2), location.length())); // neither does this.

        this.length = this.location.size();

        setShipType();

    }







    public void setGamePlayer(GamePlayer aGameplayer){
        this.gamePlayer = aGameplayer;

    }












    public Long getId() {
        return id;
    }

    public Integer getLength() {
        return length;
    }

    public List<String> getLocation() {
        return location;
    }

    public String getShipType() {
        return shipType;
    }

    public GamePlayer getGamePlayer(){
        return gamePlayer;
    }


    private void setShipType (){
        if (this.length == 1){
            this.shipType = "Attack Dolphin";
        }
        if (this.length == 2){
            this.shipType = "Refugee Boat";
        }
        if (this.length == 3){
            this.shipType = "Fishing Vessel";
        }
        if (this.length == 4){
            this.shipType = "Angery Whale";
        }
    }



}
