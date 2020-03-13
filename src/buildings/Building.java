package buildings;

/**
 * the objects in which the player can own to make money. <br></br>
 * these can be <ul> 
 * 					<li>upgraded</li>
 * 					<li>sold (WIP)</li>
 * 				</ul>
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
	 * the ID of this {@link Building}
	 * <br></br>
	 * used to identify the building though a lookup function
	 */
	
	private String id;
	/**
	 * @note <h1> DO NOT USE THIS CALL</h1>
	 */
	public Building (	BuildingType bT , String id , int maxLevel , 
						double cost , double increace	)
	{
		this.id = id;
		this.cost = cost;
		this.increase = increace;
		this.level = new Level(maxLevel);
	}
	/**
	 * @param BuildingType - Sets the type of building <br></br>
	 * @param maxLevel sets the max level of the building for the level manager <br></br>
	 * @param cost sets the cost of the building to the cost<br></br>
	 * @param increace sets the base increase of the building to the input value<br></br>
	 */
	public Building(	BuildingType bT, int maxLevel, 
						int cost, int increase	) 
	{
		this.bT = bT;
		this.level = new Level(maxLevel);
		this.cost = cost;
		this.increase = increase;
		
		String id = bT.toString();
		this.id = id;
	}
	/**
	 * 
	 * @param id id to set for this instance fo {@link Building}
	 */
	public void setId (String id)
	{
		this.id =id;
	}
	
	/**
	 * 
	 * @return the Id for {@link Building}
	 */
	public String getId ()
	{
		return this.id;
	}

	/**
	 * 
	 * @return the the base cost of this {@link Building} along with the amount of money that
	 *  is incraced through the {@link Level} of this buildings aswell
	 */
	public double getIncrease ()
	{
		double increase = this.increase;
		increase += level.getValue();
		return increase;
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
	 * add a given number of levels to this instance of {@link Building}
	 * @param l number of levels to add to this {@link Building}
	 */
	public void addLevel (int l)
	{
		if (level.isValidAdd(l))
		{
			this.level.addLevel(l);
		}
	}
	
	/**
	 * add a level to this instance of {@link Building}
	 */
	public void addLevel ()
	{
		if (level.isValidAdd(1))
		{
			this.level.addLevel(1);
		}
	}
	
	/**
	 * 
	 * @return the cost of the next upgrade for this {@link Building}
	 */
	public double getUpgradeCost()
	{
		Level tmpLevel = this.level.clone();
		tmpLevel.addLevel(1);
		return tmpLevel.getValue() * 10;
	}
	
	/**
	 *  simmilar to <i>toString</i> but will return a string without showing upgrades
	 * 	@return the  building with its name, cost, and increase
	 * 	
	 */
	public String displayStats ()
	{
		return "" + this.id + "\tcost: " + this.cost + "\t and increases: " + this.increase;
	}
	
	@Override public String toString ()
	{
		return "" + this.id + " w/ Upgrade level " + this.level;
	}
	
	/**
	 *  @return a clone of the building
	 */
	public Building clone ()
	{
		return new Building(this.bT , this.id , this.level.getMaxLevel() , this.cost , this.increase);
	}
	
	/**
	 * @return Building Type of the building
	 */
	public BuildingType getBuildingType() {
		return bT;
	}

}
