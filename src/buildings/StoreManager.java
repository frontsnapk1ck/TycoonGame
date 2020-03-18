package buildings;

import java.util.ArrayList;

/**
 * a store manager handles a set amount of stores at a time. the defalut is 10, but that can be upgraded down the line
 * <br></br>
 * a store manager also handles getting the daily revenue of the stores which a multiplyer can be aplied to with leveling up
 * <br></br>
 * a store manager cost a certian amount per day, and that figure is increaced with each upgrade that is aplied to the Store Manager
 *
 * @author S38392
 *
 */
public class StoreManager {
	/**the multiplyer on the income this building owns*/
	private double 	multiplyer;
	/**the max number of buildings this maanger can hold*/
	private int 	maxBuildings;
	/**the cost to maintain this Store manager every day*/
	private double	upkeepCost;
	/**the base cost to maintain this Store manager every day*/
	private double	baseUpkeepCost;
	/**the number of upgrades currently on this Store manager<br></br>
	 * used to calcualte <i>upkeepCost</i>*/
	private int 	upgradeCount;
	
	/**a list of all the building this manager is managing <br></br> 
	 * these buildigns must be of the same type to be in the same manager*/
	private ArrayList<Building> buildings;
	/**the building type that the Store Manager must hold*/
	private BuildingType bT;
	
	public StoreManager (BuildingType bT)
	{
		this.bT = bT;
		this.multiplyer = 	1;
		this.maxBuildings = 10;
		this.baseUpkeepCost=5;
		this.upgradeCount =	0;
		this.buildings = 	new ArrayList<Building>();
		
		this.upkeepCost = baseUpkeepCost;
	}
	
	public void add(Building b)
	{
		if (b.getBuildingType() == this.bT)
			this.buildings.add(b);
	}
	
	/**
	 * increases the max number of {@link Building}s this instance of {@link StoreManager} can hold
	 */
	public void increaseMaxBuildings()
	{
		this.upgradeCount++;
		this.maxBuildings++;
	}
	
	/**
	 * increases the mulitplyer of this instance of {@link StoreManager} by 0.1
	 */
	public void increaseMultiplier()
	{
		this.upgradeCount++;
		this.multiplyer += .1;
	}
	/**
	 * takes number of upgrades and calculates the upkeep cost for this instance of {@link StoreManager}
	 */
	private void calculateUpkeep() 
	{
		double upgradeCost = Math.pow(2, this.upgradeCount);
		if (upgradeCost == 1)
			upgradeCost = 0;
		else if (upgradeCost < 10)
			upgradeCost = 10;
		this.upkeepCost = this.baseUpkeepCost + upgradeCost;
	}	

	/**
	 * @return the multiplyer upon the {@link Building}s in this instance of {@link StoreManager}
	 */
	public double getMultiplyer() 
	{
		return multiplyer;
	}

	/**
	 * @return the max number of {@link Building}s this this instance of {@link StoreManager} can have
	 */
	public int getMaxBuildings() 
	{
		return maxBuildings;
	}

	/**
	 * @return the upkeep cost daily of this instance of {@link StoreManager}
	 */
	public double getUpkeepCost() 
	{
		calculateUpkeep();
		return upkeepCost;
	}

	/**
	 * @return the number of upgrades on this instance of {@link StoreManager}
	 */
	public int getUpgradeCount() 
	{
		return upgradeCount;
	}

	/**
	 * @return the {@link Building}s in this instance of {@link StoreManager}
	 */
	public ArrayList<Building> get() 
	{
		return buildings;
	}
	
	/**
	 * 
	 * @return the {@link BuildingType} of this {@link StoreManager}
	 */
	public BuildingType getBT ()
	{
		return this.bT;
	}

	/**
	 * @return if this {@link StoreManager} has the max number of buildigns is can handle
	 */
	public boolean maxed() 
	{
		return this.buildings.size() < this.maxBuildings;
	}

	/**
	 * 
	 * @return the size of the {@link ArrayList} of {@link Building} this instance of 
	 * 	{@link StoreManager} has
	 */
	public int size() 
	{
		return this.buildings.size();
	}
	/**
	 * 
	 * @return the increase the {@link Building}s in this instance of {@link StoreManager} 
	 * 	has to include the base cost of each {@link Building} and the level increase of 
	 * 	each {@link Building} all multipled by this instance of {@link StoreManager}'s 
	 * 	multiplyer 
	 */
	public double getIncrease() 
	{
		double increase = 0;
		for (int i = 0; i < this.size(); i++)
		{
			increase += this.buildings.get(i).getIncrease();
		}
		return increase;
	}

}