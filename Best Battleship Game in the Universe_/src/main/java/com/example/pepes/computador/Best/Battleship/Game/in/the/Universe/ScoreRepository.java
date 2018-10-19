package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ScoreRepository  extends JpaRepository<Score, Long> {

}
