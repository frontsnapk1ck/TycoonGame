package tycoonGame2;

import java.util.ArrayList;

/**
 * @author	S38392
 *
 */

public class Game extends GameFramework {
	
	private static Game game;
	private static String message;
	private static int day;

	public static void main(String[] args) 
	{
		game = getInstance(game);
		game.setupGame();
		game.start();
	}
	
	private void start() 
	{
		day = 1;
		game.loop();
		
	}

	private void loop() 
	{
		while (playing)
		{
			Menu.line(10);
			
			Menu.out("Day: " + day);
			Menu.out(this.getStats());
			message(message);
			
			message = null;

			mainMenu();
		}
	}

	private void mainMenu() 
	{
		ArrayList<Integer> intList = numbersXThruX( 0 , 3 );
		intList.add(9);

		Menu.main();
		int in = input.getUserInt("> " , intList);
		operate(in);
	}

	private String getStats() 
	{
		return "$" + fixBal(player.getBalance());
	}

	private void operate(int in) 
	{
		final int BUY_BUILDING = 1;
		final int SHOW_STORE_MANAGERS = 2;
		final int BUY_STORE_MANAGER = 3;
		
		final int NEW_DAY = 9;
		final int END = 0;

		if (in == BUY_BUILDING)
		{
			Menu.out( menu.getStockBuilings( this.player ));
			Menu.line();
			Menu.out( "0\tback");
			Menu.line();

			ArrayList<Integer> intList = numbers1ThruX(this.player.getNumTypes());
			int buildingNum = input.getUserInt( "> " , intList);

			buyBuilding(buildingNum);
		}
		else if ( in == SHOW_STORE_MANAGERS )
		{
			Menu.out( menu.getAllClasses( this.player ));
			Menu.line();
			Menu.out( "0\tback");
			Menu.line();

			ArrayList<Integer> intList = numbersXThruX( 0 , this.player.getNumTypes() );
			int classNum = input.getUserInt( "> "  , intList );
			
			showStoreManagers( classNum , in );
			return;
		}
		else if ( in == BUY_STORE_MANAGER )
		{
			Menu.out( menu.getAllClasses( this.player ));
			Menu.line();
			Menu.out( "0\tback");
			Menu.line();

			ArrayList<Integer> intList = numbersXThruX( 0 , this.player.getNumTypes() );
			int classNum = input.getUserInt( "> "  , intList );

			buyStoreManager(classNum);
		}
		else if ( in == NEW_DAY)
		{
			nextDay();
			return;
		}
		else if ( in == END )
		{
			this.playing = false;
			game.destroy();
			return;
		}
		input.next();
		
	}

	private void buyStoreManager(int classNum) 
	{
		if (classNum == 0)
			return;
		if (!player.validWithdraw(player.getSManCost()))
		{
			message = "You could not afford to by a new Store Manager";
			return;	
		}
		classNum --;
		player.withdraw(player.getSManCost());
		player.addSMan(classNum);
	}

	private void showStoreManagers(int classNum , int recalValue) 
	{
		final int BACK = 0;

		if (classNum == BACK)
			return;
		classNum--;
		selectStoreManager(classNum , recalValue );
	}

	private void selectStoreManager( int classNum , int recalValue ) 
	{
		final int BACK = 0;

		ArrayList<String> list  = menu.getSMansWithStats( this.player , classNum );
		ArrayList<Integer> intList = numbers1ThruX(list.size());
		intList.add(0);
		Menu.out(list);
		Menu.out("0\tback");
		Menu.line();

		int in = input.getUserInt("> " , intList);
		if (in == BACK)
		{
			operate( recalValue );
			return;
		}
		in --;
		viewStoreManager ( classNum , in , recalValue);
	}

	private void viewStoreManager(int classNum, int in, int recalValue) 
	{
		String sMan = menu.viewStoreManager(this.player, classNum, in);
		if (sMan == null)
		{
			selectStoreManager( classNum , recalValue );
			return;
		}

		Menu.out(sMan);
		menu.storeManager();
		ArrayList<Integer> intList = numbers1ThruX(2);
		intList.add(0);
		int choice = input.getUserInt("> ", intList);
		operateSingleStoreManager( classNum , in , choice );
	}

	private void operateSingleStoreManager(int classNum, int in, int choice) 
	{
		final int BUY = 1;
		final int SHOW_BUILDINGS = 2;
		final int BACK = 0;

		if ( choice == BUY )
		{
			double cost = this.player.getSMan(classNum, in).getUpkeepCost(1);
			menu.storeManagerUpgrades( fixBal(cost) );
			
			ArrayList<Integer> intList = numbersXThruX( 0 , 2 );
			int upgrade = input.getUserInt("> ", intList);
			
			operateStoreManagetUpgrade(classNum , in , upgrade);
		}
		else if ( choice == SHOW_BUILDINGS )
		{
			ArrayList<String> buildingList = menu.getStoreManagerBuildings( player, classNum, in); 
			Menu.out(buildingList);
			Menu.line();
			Menu.out("0\tback");
			
			ArrayList<Integer> intList = numbersXThruX( 0 , buildingList.size() );
			int building = input.getUserInt(">" , intList);
			if (building == BACK)
				return;
			else
			{
				building --;
				viewSingleBuilding (classNum , in , building);
			}
		}
		else if (choice == BACK)
		{
			return;
		}
	}

	private void viewSingleBuilding(int classNum, int in, int building) 
	{
		final int BACK = 0;
		final int UPGRADE = 1;
		final int SELL = 2;
		
		Menu.out ("" + player.getBuilding(classNum , in , building));
		double cost = player.getBuildingUpgradeCost(classNum, in, building);
		menu.building( fixBal( cost ) );
		ArrayList<Integer> intList = numbersXThruX(0, 2);
		int operation = input.getUserInt(">" , intList);
		
		if (operation == BACK)
			return;
		else if (operation == UPGRADE)
			player.upgradeBuilding (classNum , in , building , message);
		else if (operation == SELL)
			player.sellBuilding(classNum , in , building);
	}

	private void operateStoreManagetUpgrade(int classNum, int index, int upgrade) 
	{
		double cost = this.player.getSMan(classNum, index).getUpkeepCost(1);
		if (upgrade == 0)
			return;
		if (!player.validWithdraw(cost))
		{
			message = "You could not afford that upgrade for that Store Manager";
			return;
		}
		if (upgrade == 1)
			this.player.getSMan(classNum, index).increaseMaxBuildings();
		else if (upgrade == 2)
			this.player.getSMan(classNum, index).increaseMultiplier();
		this.player.withdraw(cost);
		

	}

	private void buyBuilding(int in) 
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
		day ++;
		this.player.addBalance (this.player.getIncrease());
	}

	private void addBuilding(int buildingNum) 
	{
		player.addBuilding(buildingNum);
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

	private ArrayList<Integer> numbersXThruX( int min , int max ) 
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i = min; i <= max; i++)
			intList.add(i);
		return intList;
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
