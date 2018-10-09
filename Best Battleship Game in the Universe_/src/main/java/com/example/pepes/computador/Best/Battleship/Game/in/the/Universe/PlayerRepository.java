package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByUserName(String userName);

}

// plan of attack tells me to create a CLASS
// e-book tells me to make an INTERFACE