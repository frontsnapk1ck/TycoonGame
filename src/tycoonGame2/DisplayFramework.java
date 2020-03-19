/**
 * 
 */
package tycoonGame2;

import java.util.ArrayList;

import buildings.Building;
import buildings.StoreManager;
import io.Input;
import player.Player;

/**
 * collection of convertions from the players lists to lists of strings that can
 * be passed around without the accompanying data types
 * 
 * @author S38392
 *
 */
public abstract class DisplayFramework {

	protected Input input = new Input();
	protected static Menu menu = new Menu();

	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @return ArrayList"String" of classes only if there is an owned building in
	 *         the class
	 */
	ArrayList<String> getClasses(Player p) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < p.getNumTypes(); i++) {
			if (p.getOwnedBuildings(i) != null && p.getOwnedBuildings(i).size() != 0)
				list.add("" + (i + 1) + "\t" + p.getTypeName(i));
		}
		return list;
	}

	protected ArrayList<String> getOwnedBuilding(Player player) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < player.getNumTypes(); i++) {
			if (player.getOwnedBuildings(i) != null) {
				for (int j = 0; j < player.getOwnedBuildings(i).size(); j++) {
					String building = player.getOwnedBuildings(i).get(j).toString();
					list.add("" + (i + 1) + "\t" + building);
				}
			}
		}
		if (list.size() == 0)
			list.add("empty");
		return list;
	}

	public ArrayList<String> getUpragesWithCosts(Player player, int m) {
		int current = 1;
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < player.getOwnedBuildings(m).size(); i++) {
			if (player.getOwnedBuildings(m).get(i) != null) {
				Building building = player.getOwnedBuildings(m).get(i);
				list.add("" + current + "\t" + building + "\tcosts:\t" + building.getUpgradeCost());
				current++;
			}
		}
		return list;
	}

	protected ArrayList<String> getStockBuilings(Player player) {
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < player.getStockBuildings().size(); i++) {
			list.add(player.getStockBuildings().get(i).displayStats());
		}

		return list;
	}

	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @param m      the index of the class to chech for owned buildings
	 * @return {@link ArrayList} of {@link String}s of all the owned buildings in a
	 *         class of owned buildings
	 */
	protected ArrayList<String> getOwnedBuilding(Player player, int m) {
		int current = 1;
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < player.getOwnedBuildings(m).size(); i++) {
			if (player.getOwnedBuildings(m).get(i) != null) {
				String building = player.getOwnedBuildings(m).get(i).toString();
				list.add("" + (current) + "\t" + building);
				current++;
			}
		}

		return list;
	}

	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @param classNum the index of the {@link buildings.BuildingType} to get the {@link buildings.StoreManager}s from
	 * @return {@link ArrayList} of {@link String}s for all the store managers at a given index
	 */
	protected ArrayList<String> getSMansWithStats(Player player, int classNum) 
	{
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<StoreManager> sMans = player.getSoreManagers(classNum);
		for (int i = 1; i <= sMans.size(); i++)
		{
			StoreManager sManager = sMans.get(i - 1);
			String sManStats = "" + i;
			sManStats += "\t" + sManager + "\tmultiplyer: " + sManager.getMultiplyer();
			sManStats += "\t" + sManager.size() + "/" + sManager.getMaxBuildings();
			sManStats += "\tUpkeep Cost: " + sManager.getUpkeepCost();
			list.add(sManStats);
		}
		if (list.size() == 0)
			list.add("empty");
		return list;
	}

	protected int main (String stats)
	{
		menu.main();
		System.out.println(stats);
		int m = input.getUserInt();
		return m;
	}
	
	protected void waitUntilIn ()
	{
		System.out.print("press enter");
		input.next();
	}
}
