package tycoonGame2;

import java.util.ArrayList;

/**
 * TODO		throw error for invalid numbers
 * @author	S38392
 *
 */

public class Game extends GameFramework {
	
	private static Game game;

	public static void main(String[] args) 
	{
		game = getInstance(game);
		game.setupGame();
		game.start();
	}
	
	private void start() 
	{
		game.loop();
		
	}

	private void loop() 
	{
		while (playing)
		{
			mainMenu();
		}
	}

	private void mainMenu() 
	{
		operate(menu.main(getStats()));
	}

	private String getStats() 
	{
		String 	stats = "$" + fixBal(player.getBalance());
		return 	stats;
	}

	private void operate(int m) 
	{
		if (m == 1)
		{
			menu.list(	menu.getOwnedBuilding(this.player)	);
		}
		if (m == 2)
		{
			menu.list(	menu.getStockBuilings(this.player)	);
			
			int buildingNum = input.getUserInt();
			operateBuy(buildingNum);
		}
		if (m == 3)
		{
			menu.list(	menu.getClasses(this.player)		);
			menu.out("0\tend");
			menu.line();
			
			int classNum = input.getUserInt();
			operateUp(classNum);
		}
		if (m == 9)
		{
			nextDay();
			return;
		}
		if (m == 0)
		{
			this.playing = false;
			game.destroy();
			return;
		}
		menu.waitUntilIn();
		
	}

	private void operateUp(int in) 
	{
		if (in == 0)
		{
			return;
		}
		in --;
		selectUpgrade(in);
	}

	private void operateBuy(int in) 
	{
		if (in == 0)
		{
			return;
		}
		in --;
		if (player.validWithdraw(player.getCost(in)))
		{
			player.withdraw(player.getCost(in));
			addBuilding (in);
		}
	}

	private void nextDay() 
	{
		this.player.addBalance (this.player.getIncrease());
	}

	private void addBuilding(int buildingNum) 
	{
		player.addBuilding(buildingNum);
	}

	private void selectUpgrade (int m) 
	{
		ArrayList<String> list = menu.getUpragesWithCosts(this.player , m);
		menu.list(list);
		menu.out("0\tend");
		menu.line();
		
		int in = input.getUserInt();
		if (in == 0)
			return;
		purchaceUpgrade(m , in);
	}
	
	private void purchaceUpgrade(int m , int in) 
	{
		in --;
		
		double cost = this.player.getOnwedBuildings(m).get(in).getUpgradeCost();
		if (this.player.validWithdraw(cost))
		{
			this.player.withdraw(cost);
			this.player.getOnwedBuildings(m).get(in).addLevel();
		}
	}

	public static Game getInstance (Game g) 
	{
		if (g == null)
		{
			g = new Game ();
		}
		return g;
	}
	private void destroy ()
	{
		game = null;
	}

	private String fixBal (double bal)
	{
		if ((int) bal == bal 		||
			(int) bal * 10 == bal * 10)
		{
			return "" + bal + "0";
		}
		return "" + ((int) bal * 100)/100;
	}
}
