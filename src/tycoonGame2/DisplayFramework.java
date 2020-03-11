/**
 * 
 */
package tycoonGame2;

import java.util.ArrayList;

import buildings.Building;
import io.Input;
import player.Player;

/**
 * @author S38392
 * @param <player>
 *
 */
public abstract class DisplayFramework {
	
	protected Input input = new Input ();
	protected static Menu menu = new Menu ();
	
	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @return ArrayList"String" of classes only if there is an owned building in the class
	 */
	ArrayList<String> getClasses(Player p)
	{
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i<p.getNumTypes(); i++)
		{
			if (p.getOnwedBuildings(i) != null && p.getOnwedBuildings(i).size() !=0)
				list.add("" + (i+1) + "\t" + p.getTypeName(i));
		}
		return list;
	}
	
	protected ArrayList<String> getOwnedBuilding(Player player) 
	{
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < player.getNumTypes(); i ++)
		{
			if (player.getOnwedBuildings(i) != null)
			{
				for (int j = 0; j < player.getOnwedBuildings(i).size(); j++)
				{
					String building = player.getOnwedBuildings(i).get(j).toString();
					list.add("" + (i + 1) + "\t" + building);
				}
			}
		}
		return list;
	}
	
	public ArrayList<String> getUpragesWithCosts(Player player, int m) 
	{
		int current = 1;
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < player.getOnwedBuildings(m).size(); i++)
		{
			if (player.getOnwedBuildings(m).get(i) != null)
			{
				Building building = player.getOnwedBuildings(m).get(i);
				list.add("" + current + "\t" + building + "\tcosts:\t" + building.getUpgradeCost());
				current ++;
			}
		}
		return list;
	}
	
	protected ArrayList<String> getStockBuilings (Player player) 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i<player.getStockBuildings().size(); i++)
		{
			list.add(player.getStockBuildings().get(i).displayStats());
		}
		
		return list;
	}
	
	/**
	 * 
	 * @param 	Player pass a player arround to extract the list of buildings
	 * @param 	m the index of the class to chech for owned buildings
	 * @return	ArrayList"String" of all the owned buildings in a class of owned buildings
	 */
	protected ArrayList<String> getOwnedBuilding(Player player , int m) 
	{
		int current = 1;
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < player.getOnwedBuildings(m).size(); i++)
		{
			if (player.getOnwedBuildings(m).get(i) != null)
			{
				String building = player.getOnwedBuildings(m).get(i).toString();
				list.add("" + (current) + "\t" + building);
				current ++;
			}
		}
		
		return list;
	}
	
	int main (String stats)
	{
		menu.main();
		System.out.println(stats);
		int m = input.getUserInt();
		return m;
	}
	
	void waitUntilIn ()
	{
		System.out.print("press enter");
		input.next();
	}
}
