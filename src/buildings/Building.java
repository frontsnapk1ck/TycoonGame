package buildings;

public class Building {
	
	private Level level;
	private double cost;
	private double increase;
	private BuildingType bT;
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
	 * @param BuildingType - Sets the type of building
	 * @param _
	 * @param maxLevel sets the max level of the building for the level manager
	 * @param _ 
	 * @param cost sets the cost of the building to the cost
	 * @param _ 
	 * @param increace sets the base increase of the building to the input value
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
	
	public void setId (String id)
	{
		this.id =id;
	}
	
	public String getId ()
	{
		return this.id;
	}

	public double getIncrease ()
	{
		double increase = this.increase;
		increase += level.getValue();
		return increase;
	}
	
	public double getCost ()
	{
		return this.cost;
	}
	
	public void addLevel (int l)
	{
		if (level.isValidAdd(l))
		{
			this.level.addLevel(l);
		}
	}
	
	public void addLevel ()
	{
		if (level.isValidAdd(1))
		{
			this.level.addLevel(1);
		}
	}
	
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
