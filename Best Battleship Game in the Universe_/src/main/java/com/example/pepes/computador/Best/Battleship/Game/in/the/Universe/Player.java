package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //entity is always declared at class level
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;


    private String userName;


    public Player(){}
    // empty constructor required for CLASSES marked with @Entity;
    // IF you have another non-empty constructor



    // added this one because cmdLineRunner
    public Player(String un){
        setUserName(un);
    }


    // GUI- generated getter
    public String getUserName() {
        return userName;
    }

    // GUI setter
    public void setUserName(String userName) {
        this.userName = userName;
    }





}
