package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private Date gameCreationDate;







    @OneToMany(mappedBy="game", fetch= FetchType.EAGER)
    private Set<GamePlayer> gamePlayerSet = new HashSet<>();


    public void addGamePlayer(GamePlayer gameplayer) {
        gameplayer.setGame(this);
        gamePlayerSet.add(gameplayer);
    }


    @OneToMany(mappedBy="gameOfScore", fetch= FetchType.EAGER)
    private Set<Score> scoreSet = new HashSet<>();

    public void addScore(Score score) {
        score.setGame(this);
        scoreSet.add(score);
    }






    public Game(){

        Date x = new Date();

        setGameCreationDate(x);
    }


    public Set<Score> getScoreSet() {return scoreSet;}

    public Date getGameCreationDate() {
        return this.gameCreationDate;
    }

    public void setGameCreationDate(Date gameCreationDate) {
        this.gameCreationDate = gameCreationDate;
    }

    public Long getId() {
        return id;
    }

    public Set<GamePlayer> getGamePlayerSet() {
        return gamePlayerSet;
    }
}
