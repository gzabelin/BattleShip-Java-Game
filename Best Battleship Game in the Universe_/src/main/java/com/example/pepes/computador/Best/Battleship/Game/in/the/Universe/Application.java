package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository) {
		return (args) -> {
			// save a couple of customers
			Player p1 = playerRepository.save(new Player("JackBauer"));
			System.out.println(p1);
			playerRepository.save(new Player("ChloeO'Brian"));
			playerRepository.save(new Player("KimBauer"));
			playerRepository.save(new Player("DavidPalmer"));
			playerRepository.save(new Player("MichelleDessler"));

			Game game1 = gameRepository.save(new Game());
			System.out.println(game1);
			gameRepository.save(new Game());
			gameRepository.save(new Game());

			GamePlayer gp1 = gamePlayerRepository.save(new GamePlayer(game1, p1));

			System.out.println(gp1);


		};
	}

//	@Bean
//	public CommandLineRunner initData(GameRepository gameRepository) {
//		return (args) -> {
//			// save a couple of customers
//			gameRepository.save(new Game());
//			gameRepository.save(new Game());
//			gameRepository.save(new Game());
//
//
//		};
//	}


}
