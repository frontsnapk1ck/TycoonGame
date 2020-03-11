package tycoonGame2;

import io.Input;
import player.Player;

abstract class GameFramework{
	
	protected boolean playing = true;
	protected Player player;
	protected Menu menu;
	protected Input input;
	
	protected void setupGame() 
	{
		this.player = new Player();
		this.menu = new Menu();
		this.input = new Input();
		
		this.player.startGame();
	}
}
