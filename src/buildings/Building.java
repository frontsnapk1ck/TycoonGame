package buildings;

import buildings.level.Level;
/**
 * the objects in which the player can own to make money. <br>
 * </br>
 * these can be
 * <ul>
 * <li>upgraded</li>
 * <li>sold (WIP)</li>
 * </ul>
 * 
 * @author S38392
 *
 */
public class Building {
	
	/**the {@link Level} of this building*/
	private Level level;
	/**the base cost of this {@link Building}*/
	private double cost;
	/**the base increase of this {@link Building}*/
	private double increase;
	/**the {@link BuildingType} of this {@link Building}*/
	private BuildingType bT;

	/**
	 * @param BuildingType - Sets the type of building <br></br>
	 * @param maxLevel sets the max level of the building for the level manager <br></br>
	 * @param cost sets the cost of the building to the cost<br></br>
	 * @param increace sets the base increase of the building to the input value<br></br>
	 */
	public Building(	BuildingType bT, double cost, Level level	) 
	{
		this.bT = bT;
		this.cost = cost;
		this.level = level;
	}

	/**
	 * 
	 * @return the the base cost of this {@link Building} along with the amount of money that
	 *  is incraced through the {@link Level} of this buildings aswell
	 */
	public double getIncrease ()
	{
		return level.getValue();
	}
	
	/**
	 * 
	 * @return the base cost of this building
	 */
	public double getCost ()
	{
		return this.cost;
	}
	
	/**
	 * add a level to this instance of {@link Building}
	 */
	public void addLevel ()
	{
		if (level.canAddLevel())
		{
			this.level.addLevel();
		}
	}
	
	/**
	 * 
	 * @return the cost of the next upgrade for this {@link Building}
	 */
	public double getUpgradeCost()
	{
		return this.level.getUpgradeCost();
	}
	
	/**
	 *  simmilar to <i>toString</i> but will return a string without showing upgrades
	 * 	@return the  building with its name, cost, and increase
	 * 	
	 */
	public String displayStats ()
	{
		return "" + this.bT + "\tcost: " + this.cost + "\t and increases: " + this.increase;
	}
	
	@Override public String toString ()
	{
		return "" + this.bT + " w/ Upgrade level " + this.level;
	}

	/**
	 *  @return a clone of the building
	 */
	@Override
	public Building clone ()
	{
		Building clone = new Building(
			this.getBuildingType() , 
			this.getCost() , 
			this.getLevel().clone()
		);
		return clone;
	}
	
	private Level getLevel() 
	{
		return this.level;
	}

	/**
	 * @return Building Type of the building
	 */
	public BuildingType getBuildingType() {
		return bT;
	}

}
