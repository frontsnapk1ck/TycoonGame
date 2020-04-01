package tycoonGame2;

import gui.Manager;
import io.Input;
import player.Player;

abstract class GameFramework{
	/**if the game is currently being played */
	protected boolean playing = true;
	/**the games player */
	protected Player player;
	/**the menu for the game */
	protected static Menu menu;
	/**the method of input the player uses */
	protected Input input;
	/**the conversion from objects to strings */
	protected DisplayFramework dispFrm;
	/**the manager for the displays in the game */
	protected Manager guiManager;


	protected void setupGame() 
	{
		player = new Player();
		input = new Input();
		menu = new Menu();
		dispFrm = new DisplayFramework(); 
		guiManager = new Manager();
		
		player.startGame();
	}

	protected void message(String message) 
	{
		if (message != null)
			System.out.println(message);
	}
}
