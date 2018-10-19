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
    private String password;

    private Double totalScore = 0.0;

    private Integer numWins = 0;
    private Integer numLosses = 0;
    private Integer numTies = 0;


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

    public Double getTotalScore() {
        return totalScore;
    }

    @OneToMany(mappedBy="player", fetch= FetchType.EAGER)
    private Set<GamePlayer> gamePlayerSet = new HashSet<>();

    public void addGamePlayer(GamePlayer gameplayer) {
        gameplayer.setPlayer(this);
        gamePlayerSet.add(gameplayer);
    }


    @OneToMany(mappedBy="playerOfScore", fetch= FetchType.EAGER)
    private Set<Score> scoreSet = new HashSet<>();

    public void addScore(Score score) {
        score.setPlayer(this);
        scoreSet.add(score);

        this.totalScore+=score.getScore();

        if (score.getScore()==0.0){this.numLosses++;}
        if (score.getScore()==0.5){this.numTies++;}
        if (score.getScore()==1.0){this.numWins++;}
    }


    public Integer getNumWins() {return numWins;}

    public Integer getNumLosses() {return numLosses;}

    public Integer getNumTies() {return numTies;}

    public Set<Score> getScoreSet() {return scoreSet;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}
