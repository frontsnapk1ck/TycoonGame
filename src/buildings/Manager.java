package buildings;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
	
	private ArrayList<Building> allBuildings = new ArrayList<Building>();
	private HashMap<BuildingType, ArrayList<Building>> ownedBuildings = new HashMap<BuildingType, ArrayList<Building>>();
	private ArrayList<BuildingType> buildingTypes = new ArrayList<BuildingType>();
	
	public Manager ()
	{
		this.setAllBuildingTypes();
		this.setAllBuildings ();
	}
	
	private void setAllBuildingTypes() 
	{
		this.buildingTypes.add(BuildingType.LEMONADE_STAND);
		this.buildingTypes.add(BuildingType.TWO);
		this.buildingTypes.add(BuildingType.THREE);
		this.buildingTypes.add(BuildingType.FOUR);
		this.buildingTypes.add(BuildingType.FIVE);
	}

	private void setAllBuildings ()
	{
		this.allBuildings.add(new Building(buildingTypes.get(0) , 5 , 1 , 10));
		this.allBuildings.add(new Building(buildingTypes.get(1) , 5 , 2 , 10));
		this.allBuildings.add(new Building(buildingTypes.get(2) , 5 , 3 , 10));
		this.allBuildings.add(new Building(buildingTypes.get(3) , 5 , 4 , 10));
		this.allBuildings.add(new Building(buildingTypes.get(4) , 5 , 5 , 10));
/*		6
 * 		7
 * 		...
 */
	}
	
	public void addBuilding (int i)
	{
		BuildingType bt = this.buildingTypes.get(i);
		Building toAdd = this.allBuildings.get(i).clone();
		this.checkHashArrray (bt);
		toAdd.setId("" + bt + this.ownedBuildings.get(bt).size());
		
		this.ownedBuildings.get(bt).add(toAdd);
	}
	
	private void checkHashArrray(BuildingType bt) 
	{
		if (!this.ownedBuildings.containsKey(bt))
			this.ownedBuildings.put(bt, new ArrayList<Building>());
	}

	public HashMap<BuildingType, ArrayList<Building>> get() 
	{
		return this.ownedBuildings;
	}

	public void addUpgrade(int l , Building b) 
	{
		b.addLevel(l);
	}

	public ArrayList<Building> get(BuildingType bT) 
	{
		return this.ownedBuildings.get(bT);
	}

	public int size(BuildingType bT) 
	{
		return this.ownedBuildings.get(bT).size();
	}
	
	public int size ()
	{
		return this.ownedBuildings.size();
	}
	
	public int maxSize()
	{
		return this.allBuildings.size();
	}

	public double getIncrease(BuildingType bT) 
	{
		double increase = 0;
		
		ArrayList<Building> list = this.ownedBuildings.get(bT);
		
		for (int i = 0; i < list.size(); i++)
			increase += list.get(i).getIncrease();
		
		return increase;
	}

	public double getIncrease() 
	{
		double money = 0;
		for (int i = 0; i < this.ownedBuildings.size(); i ++)
		{
			BuildingType bT = this.buildingTypes.get(i);
			checkHashArrray(bT);
			ArrayList<Building> list = this.ownedBuildings.get(bT);
			for (int j = 0; j < list.size(); j++) 
			{
				money += list.get(j).getIncrease();
			}
		}
		return money;
	}

	@Override public String toString ()
	{
		String out = "";
		for (int i = 0; i < this.size(this); i ++)
		{
			out += this.ownedBuildings.get(this.buildingTypes.get(i));
			out += "\n";
		}
		return out;
	}

	
	private int size(Manager manager) 
	{
		return manager.allBuildings.size();
	}

	/**
	 * <h1>test code -- not final</h1>
	 * this code will be replaced by a GUI link that has accsess to the owned building ans can display them properly and return the actual building that has been requested
	 * @param BuildingType is the building type of hte building that is requested
	 * @param i index of the building reqested in the list
	 */
	public Building getBuilding(BuildingType bT, int i) 
	{
		return this.ownedBuildings.get(bT).get(i);
	}

	public ArrayList<Building> getHash(int i) 
	{
		BuildingType bT = this.buildingTypes.get(i);
		return this.ownedBuildings.get(bT);
	}

	public String getTypeName(int i) 
	{
		return this.buildingTypes.get(i).toString();
	}

	public ArrayList<Building> getStock() 
	{
		return this.allBuildings;
	}

	public double getCost(int in) 
	{
		return this.allBuildings.get(in).getCost();
	}

}
