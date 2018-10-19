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
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository, SalvoRepository salvoRepository, ScoreRepository scoreRepository) {
		return (args) -> {


			Player p1 = new Player("JackBauer");
			Player p2 = new Player("ChloeO'Brian");
			Player p3 = new Player("KimBauer");
			Player p4 = new Player("DavidPalmer");
			Player p5 = new Player("MichelleDessler");
			Player p6 = new Player("Mr_PoopyButthole");


			Game game1 = new Game();
			Game game2 = new Game();
			Game game3 = new Game();
			Game game4 = new Game();
			Game game5 = new Game();


			Ship ship1 = new Ship("H1, H2, H3");
			Ship ship2 = new Ship("G5, G6, G7, G8");
			Ship ship3 = new Ship("C3, D3, E3");
			Ship ship4 = new Ship("A1, B1");
			Ship ship5 = new Ship("J5");
			Ship ship6 = new Ship("E7, F7");
			Ship ship7 = new Ship("A4, B4, C4");
			Ship ship8 = new Ship("F3");
			Ship ship9 = new Ship("A9, A8, A7, A6");
			Ship ship10 = new Ship("H5, H6, H7");
			Ship ship11 = new Ship("C3, C4");
			Ship ship12 = new Ship("I1, J1");


			Salvo salvo1 = new Salvo("B4, B5, B6");
			Salvo salvo2 = new Salvo("E1, H3, A2");
			Salvo salvo3 = new Salvo("B5, D5, C7");
			Salvo salvo4 = new Salvo("C5, C6");
			Salvo salvo5 = new Salvo("H1, H2, H3");
			Salvo salvo6 = new Salvo("E1, F2, G3");
			Salvo salvo7 = new Salvo("B5, C6, H1");
			Salvo salvo8 = new Salvo("C5, C7, D5");
			Salvo salvo9 = new Salvo("B5, B6, C7");
			Salvo salvo10 = new Salvo("C6, D6, E6");
			Salvo salvo11 = new Salvo("H1, H8");
			Salvo salvo12 = new Salvo("F3, A2, I5");




			GamePlayer gp1 = new GamePlayer(game1, p1);
			GamePlayer gp2 = new GamePlayer(game1, p2);
			GamePlayer gp3 = new GamePlayer(game2, p2);
			GamePlayer gp4 = new GamePlayer(game2, p3);
			GamePlayer gp5 = new GamePlayer(game3, p1);
			GamePlayer gp6 = new GamePlayer(game3, p6);
			GamePlayer gp7 = new GamePlayer(game4, p5);
			GamePlayer gp8 = new GamePlayer(game4, p1);
			GamePlayer gp9 = new GamePlayer(game5, p4);
			GamePlayer gp10 = new GamePlayer(game5, p2);



			Score score1 = new Score (gp1, 0.0);
			Score score2 = new Score (gp2, 1.0);
			Score score3 = new Score (gp3, 1.0);
			Score score4 = new Score (gp4, 0.0);
			Score score5 = new Score (gp5, 0.5);
			Score score6 = new Score (gp6, 0.5);
			Score score7 = new Score (gp7, 0.5);
			Score score8 = new Score (gp8, 0.5);
			Score score9 = new Score (gp9, 1.0);
			Score score10 = new Score (gp10, 0.0);




			p1.setPassword("24");
			p2.setPassword("42");
			p3.setPassword("kb");
			p4.setPassword("mole");
			p5.setPassword("butthol");
			p6.setPassword("kikiki");





			gp1.addShip(ship1);
			gp1.addShip(ship2);
			gp1.addShip(ship3);
			gp2.addShip(ship4);
			gp2.addShip(ship5);
			gp2.addShip(ship6);
			gp3.addShip(ship7);
			gp3.addShip(ship8);
			gp3.addShip(ship9);
			gp4.addShip(ship10);
			gp4.addShip(ship11);
			gp4.addShip(ship12);		/// it seems i cannot reuse the same ships for more tha one GP !!!!!!


			gp1.addSalvo(salvo1);
			gp1.addSalvo(salvo2);
			gp1.addSalvo(salvo3);
			gp2.addSalvo(salvo4);
			gp2.addSalvo(salvo5);
			gp2.addSalvo(salvo6);
			gp3.addSalvo(salvo7);
			gp3.addSalvo(salvo8);
			gp3.addSalvo(salvo9);
			gp4.addSalvo(salvo10);
			gp4.addSalvo(salvo11);
			gp4.addSalvo(salvo12);




			playerRepository.save(p1);
			playerRepository.save(p2);
			playerRepository.save(p3);
			playerRepository.save(p4);
			playerRepository.save(p5);
			playerRepository.save(p6);


			gameRepository.save(game1);
			gameRepository.save(game2);
			gameRepository.save(game3);
			gameRepository.save(game4);
			gameRepository.save(game5);



			gamePlayerRepository.save(gp1);
			gamePlayerRepository.save(gp2);
			gamePlayerRepository.save(gp3);
			gamePlayerRepository.save(gp4);
			gamePlayerRepository.save(gp5);
			gamePlayerRepository.save(gp6);
			gamePlayerRepository.save(gp7);
			gamePlayerRepository.save(gp8);
			gamePlayerRepository.save(gp9);
			gamePlayerRepository.save(gp10);



			shipRepository.save(ship1);
			shipRepository.save(ship2);
			shipRepository.save(ship3);
			shipRepository.save(ship4);
			shipRepository.save(ship5);
			shipRepository.save(ship6);
			shipRepository.save(ship7);
			shipRepository.save(ship8);
			shipRepository.save(ship9);
			shipRepository.save(ship10);
			shipRepository.save(ship11);
			shipRepository.save(ship12);

			salvoRepository.save(salvo1);
			salvoRepository.save(salvo2);
			salvoRepository.save(salvo3);
			salvoRepository.save(salvo4);
			salvoRepository.save(salvo5);
			salvoRepository.save(salvo6);
			salvoRepository.save(salvo7);
			salvoRepository.save(salvo8);
			salvoRepository.save(salvo9);
			salvoRepository.save(salvo10);
			salvoRepository.save(salvo11);
			salvoRepository.save(salvo12);


			scoreRepository.save(score1);
			scoreRepository.save(score2);
			scoreRepository.save(score3);
			scoreRepository.save(score4);
			scoreRepository.save(score5);
			scoreRepository.save(score6);
			scoreRepository.save(score7);
			scoreRepository.save(score8);
			scoreRepository.save(score9);
			scoreRepository.save(score10);



		};
	}




}
