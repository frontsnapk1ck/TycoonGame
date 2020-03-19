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
	private static String message;

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
			Menu.line(10);
			message(message);
			message = null;
			Menu.out(this.getStats());
			mainMenu();
		}
	}

	private void mainMenu() 
	{
		ArrayList<Integer> intList = numbers1ThruX(4);
		intList.add(0);
		intList.add(9);

		Menu.main();
		int in = input.getUserInt("> " , intList);
		operate(in);
	}

	private String getStats() 
	{
		return "$" + fixBal(player.getBalance());
	}

	private void operate(int m) 
	{		
		if (m == 1)
		{
			Menu.out( menu.getOwnedBuilding( this.player ));
		}
		else if (m == 2)
		{
			Menu.out( menu.getStockBuilings( this.player ));
			Menu.line();
			Menu.out( "0\tend");
			Menu.line();

			ArrayList<Integer> intList = numbers1ThruX(this.player.getNumTypes());
			int buildingNum = input.getUserInt( "> " , intList);
			operateBuy(buildingNum);
		}
		else if (m == 3)
		{
			Menu.out( menu.getAllClasses( this.player ));
			Menu.line();
			Menu.out( "0\tback");
			Menu.line();

			ArrayList<Integer> intList = numbers1ThruX(this.player.getNumTypes());
			intList.add(0);
			int classNum = input.getUserInt( "> "  , intList );
			operateStoreManager(classNum);
			return;
		}
		else if (m == 4)
		{
			System.err.println( "Not Implemented" );
		}
		else if (m == 9)
		{
			nextDay();
			return;
		}
		else if (m == 0)
		{
			this.playing = false;
			game.destroy();
			return;
		}
		input.next();
		
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
		ArrayList<Integer> intList = numbers1ThruX(list.size());
		intList.add(0);
		Menu.out(list);
		Menu.out("0\tback");
		Menu.line();

		int in = input.getUserInt("> " , intList);
		if (in == 0)
		{
			operate( 3 );
			return;
		}
		in --;
		viewStoreManager ( classNum , in );
	}

	private void viewStoreManager(int classNum, int in) 
	{
		String sMan = menu.viewStoreManager(this.player, classNum, in);
		if (sMan == null)
		{
			selectStoreManager(classNum);
			return;
		}
		Menu.out(sMan);
		menu.storeManager();
		ArrayList<Integer> intList = numbers1ThruX(2);
		intList.add(9);
		intList.add(0);
		int choice = input.getUserInt("> ", intList);
		operateSingleStoreManager( classNum , in , choice );
	}

	private void operateSingleStoreManager(int classNum, int in, int choice) 
	{
		if ( choice == 1 )
		{
			menu.listStoreManagerUpgrades( classNum , in );
		}
		else if ( choice == 2 )
		{
			menu.getOwnedBuilding(player, m)
		}
		else if (choice == 9)
		{

		}
		else if (choice == 0)
		{
			return;
		}
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
		else if (!player.validWithdraw(player.getCost(in)))
			message = "you could not buy that building because you are broke";
		else if (!player.canAddBuilding(in))
			message = "you could not buy that building becuase there isnt an availble Store Manager";
		else 
			message = "well this is awkward idk why you cant buy that building";
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
		Menu.out(list);
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

	//=============================================
	//				Utility
	//=============================================

	private ArrayList<Integer> numbers1ThruX(int max) 
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i = 1; i <= max; i++)
			intList.add(i);
		return intList;
	}
}
