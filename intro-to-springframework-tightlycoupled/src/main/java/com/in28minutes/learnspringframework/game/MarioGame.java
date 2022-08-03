package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame {
	

	public void up() {
		System.out.println("jump");
	}


	public void down() {
		System.out.println("go into a hole");
	}
	

	public void left() {
		System.out.println("stop");
	}
	

	public void right() {
		System.out.println("go faster");
	}
	
}
