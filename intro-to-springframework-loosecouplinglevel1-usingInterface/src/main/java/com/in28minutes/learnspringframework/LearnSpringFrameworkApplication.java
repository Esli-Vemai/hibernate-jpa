package com.in28minutes.learnspringframework;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {

		
		MarioGame game = new MarioGame();
		//SuperContraGame game = new SuperContraGame();
		GameRunner runner = new GameRunner(game);
		
		runner.runGame();
		
	}

}
