package tycoonGame2;

import java.util.ArrayList;

/**
 * TODO		throw error for invalid numbers
 * TODO		fix the numbering -- you have to go through store manager to upgrade a builgind
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
		return "$" + fixBal(player.getBalance());
	}

	private void operate(int m) 
	{
		if (m == 1)
		{
			Menu.list(	menu.getOwnedBuilding(this.player));
		}
		if (m == 2)
		{
			Menu.list(	menu.getStockBuilings(this.player));
			Menu.out(	"0\tend");
			Menu.line();

			int buildingNum = input.getUserInt();
			operateBuy(buildingNum);
		}
		if (m == 3)
		{
			Menu.list(	menu.getClasses(this.player));
			Menu.out(	"0\tend");
			Menu.line();
			
			int classNum = input.getUserInt();
			operateUp(classNum);
		}
		if (m == 4)
		{
			menu.list(menu.getClasses(this.player));

			int classNum = input.getUserInt("Building Type");
			operateStoreManager(classNum);
		}
		if (m == 5)
		{

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

	private void operateStoreManager(int classNum) 
	{
		if (classNum == 0)
			return;
		classNum--;
		selectStoreManager(classNum);
	}

	private void selectStoreManager(int classNum) 
	{
		ArrayList<String> list  = menu.getSMansWithStats( this.player , classNum );
		Menu.list(list);
		Menu.out("0\tend");
		Menu.line();

		int in = input.getUserInt("Store Manager: ");
		if (in == 0)
			return;
		viewStoreManager ( classNum , in );
	}

	private void viewStoreManager(int classNum, int in) 
	{
		menu.storeManager();
		int choice = input.getUserInt("> ");
		operateSingleStoreManager( classNum , in , choice );
	}

	private void operateSingleStoreManager(int classNum, int in, int choice) 
	{
		//TODO
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
		boolean validBuy = 	player.validWithdraw(player.getCost(in)) && 
							player.canAddBuilding(in);			
		if (validBuy)
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
		Menu.list(list);
		Menu.out("0\tend");
		Menu.line();
		
		int in = input.getUserInt();
		if (in == 0)
			return;
		purchaceUpgrade(m , in);
	}
	
	private void purchaceUpgrade(int m , int in) 
	{
		in --;
		
		double cost = this.player.getOwnedBuildings(m).get(in).getUpgradeCost();
		if (this.player.validWithdraw(cost))
		{
			this.player.withdraw(cost);
			this.player.getOwnedBuildings(m).get(in).addLevel();
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
