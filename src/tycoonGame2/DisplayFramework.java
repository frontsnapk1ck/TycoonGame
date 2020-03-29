package tycoonGame2;

import java.util.ArrayList;
import java.util.List;

import buildings.Building;
import buildings.StoreManager;
import player.Loan;
import player.Player;

/**
 * collection of convertions from the players lists to lists of strings that can
 * be passed around without the accompanying data types
 * 
 * @author S38392
 *
 */
public class DisplayFramework {

	//============================================
	//			Classes of Building Types
	//============================================

	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @return {@link ArrayList} of {@link String}s of {@link buildings.BuildingType}s a {@link Player} owns only if there is an owned {@link Building} in
	 *         the {@link java.util.HashMap} of all the {@link buildings.BuildingType}s
	 */
	public ArrayList<String> getClasses(Player p) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < p.getNumTypes(); i++) {
			if (p.getOwnedBuildings(i) != null && p.getOwnedBuildings(i).size() != 0)
				list.add("" + (i + 1) + "\t" + p.getTypeName(i));
		}
		return list;
	}

	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @return {@link ArrayList} of {@link String}s of all the {@link buildings.BuildingType}s a {@link Player} has reguardless of if the {@link Player} owns any {@link Building}s of that {@link buildings.BuildingType}
	 */
	public ArrayList<String> getAllClasses(Player p) 
	{
		ArrayList<String> list = new ArrayList<String>();
		for (int i =1; i <= p.getNumTypes(); i++)
			list.add("" + i + "\t" + p.getTypeName(i-1));
		return list;
	}

	//============================================
	//			Upgrade
	//============================================

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

	//============================================
	//			Buildings			
	//============================================

	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @return {@link ArrayList} of {@link String}s for all the Stock {@link Building}s a {@link Player} can buy
	 */
	public ArrayList<String> getStockBuilings(Player player) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= player.getStockBuildings().size(); i++)
			list.add("" + i + "\t" + player.getStockBuildings().get(i-1).displayStats());
		return list;
	}

	public ArrayList<String> getStoreManagerBuildings ( Player player , int classNum , int index )
	{
		ArrayList<String> list = new ArrayList<String>();
		StoreManager sMan = player.getSMan( classNum , index );
		for (int i = 1; i <= sMan.size(); i++)
			list.add(i + "\t" + sMan.get(i-1)); 
		return list;
	}

	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @param m      the index of the class to chech for owned buildings
	 * @return {@link ArrayList} of {@link String}s of all the owned buildings in a
	 *         class of owned buildings
	 */
	public ArrayList<String> getOwnedBuilding(Player player, int m) 
	{
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
	 * @return {@link ArrayList} of {@link String}s for all the {@link Building}s the {@link Player} owns thorout all the {@link buildings.BuildingType}s the {@link Player} owns {@link Building}s in
	 */
	public ArrayList<String> getOwnedBuilding(Player player) 
	{
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

	//============================================
	//			Store Managers
	//============================================

	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @param classNum the index of the {@link buildings.BuildingType} to get the {@link buildings.StoreManager}s from
	 * @return {@link ArrayList} of {@link String}s for all the store managers at a given index
	 */
	public List<String> getSMansWithStats(Player player, int classNum) 
	{
		List<String> list = new ArrayList<String>();
		List<StoreManager> sMans = player.getSMans(classNum);
		if ( sMans == null || sMans.size() == 0 )
		{
			list.add("empty");
			return list;
		}
		for (int i = 1; i <= sMans.size(); i++)
		{
			StoreManager sManager = sMans.get(i - 1);
			String sManStats = "" + i + "\t" + sManager.stats();
			list.add(sManStats);
		}
		return list;
	}

	/**
	 * 
	 * @param Player pass a player arround to extract the list of buildings
	 * @param classNum the index of the {@link buildings.BuildingType} to get the {@link buildings.StoreManager}s from
	 * @param in the index of the {@link StoreManager} requested in the {@link ArrayList}s of {@link StoreManager}s at the given <code>ClassNum </code> index
	 * @return detailed information about the {@link StoreManager} requested in the form of a displayable {@link String}
	 */
	public String viewStoreManager( Player p , int classNum, int in ) 
	{
		return p.getSMan(classNum , in).toString();
	}

	public List<String> getLoans(Player player) 
	{
		List<Loan> loans = player.getLoans();
		List<String> list = new ArrayList<String>();
		
		if (loans == null || loans.size() == 0)
		{
			list.add( "empty" );
			return list;
		} 

		for (Loan loan : loans)
			list.add(loan.toString());
		return list;
	}

	public List<String> getAvailbleLoans(Player player) {
		return null;
	}

}
