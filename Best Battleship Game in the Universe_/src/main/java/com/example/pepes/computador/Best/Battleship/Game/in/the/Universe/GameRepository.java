package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GameRepository extends JpaRepository<Game, Long> {

    // It's okay if this interface stays empty
    // it already inherits the most important functions from JPA Repository

}
