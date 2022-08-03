package com.in28minutes.learnspringframework;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.SuperContraGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {

		//ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);

		//MarioGame,GameRunner
		
		//MarioGame game = new MarioGame();
		SuperContraGame game = new SuperContraGame();
		GameRunner runner = new GameRunner(game);
		
		runner.runGame();
		
	}

}
