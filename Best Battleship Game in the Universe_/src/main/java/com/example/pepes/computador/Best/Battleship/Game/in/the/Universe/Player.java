package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;


    private String userName;


    public Player(){}




    public Player(String un){
        setUserName(un);
    }



    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }




    @OneToMany(mappedBy="player", fetch= FetchType.EAGER)
    private Set<GamePlayer> gamePlayerSet = new HashSet<>();

    public void addGamePlayer(GamePlayer gameplayer) {
        gameplayer.setPlayer(this);
        gamePlayerSet.add(gameplayer);
    }









}
