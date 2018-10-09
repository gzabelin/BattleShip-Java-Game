package com.example.pepes.computador.Best.Battleship.Game.in.the.Universe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository) {
		return (args) -> {
			// save a couple of customers
			playerRepository.save(new Player("JackBauer"));
			playerRepository.save(new Player("ChloeO'Brian"));
			playerRepository.save(new Player("KimBauer"));
			playerRepository.save(new Player("DavidPalmer"));
			playerRepository.save(new Player("MichelleDessler"));

		};
	}




}
