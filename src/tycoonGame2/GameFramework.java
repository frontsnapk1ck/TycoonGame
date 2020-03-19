package tycoonGame2;

import io.Input;
import player.Player;

abstract class GameFramework{
	/**if the game is currently being played */
	protected boolean playing = true;
	/**the games player */
	protected Player player;
	/**
	 * the menu for the game <br></br>
	 * used to display items for the game 
	 */
	protected static Menu menu;
	/**the method of input the player uses */
	protected Input input;
	
	protected void setupGame() 
	{
		this.player = new Player();
		menu = new Menu();
		this.input = new Input();
		
		this.player.startGame();
	}

	protected void message(String message) 
	{
		if (message != null)
			System.out.println(message);
	}
}
