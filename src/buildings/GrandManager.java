package buildings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import factory.BuildingFactory;
import save.SaveGameManager;

public class GrandManager {
	
	/**list of all the {@link Building}s a player can own with their defalut values*/
	private List<Building> allBuildings;
	/**list of all the {@link Building}s the player owns*/
	private HashMap <BuildingType , ArrayList<StoreManager>> ownedBuildings;
	/**list of all the availble {@link BuildingType}s for each of the {@link Building}s*/
	private List<BuildingType> buildingTypes;

	public GrandManager ()
	{
		BuildingFactory factory = new BuildingFactory();
		factory.load ("res\\assets\\objects\\stockBuildings.txt");

		this.allBuildings = factory.getBuildings();
		this.buildingTypes = factory.getTypes();

		this.ownedBuildings = new HashMap<BuildingType, ArrayList<StoreManager>>();

	}
	
	/**
	 * 
	 * @param i index of the {@link BuildingType} to check if you can add a building
	 * @return 	<code>true</code> 	if you can add a {@link Building} <br></b>
	 * 			<code>false</code> 	if you cannot add a {@link Building}
	 */
	public boolean canAddBuilding (int i)
	{
		BuildingType bt = this.buildingTypes.get(i);
		StoreManager sMan = this.getFirstSMan (bt);
		return sMan != null;
	}
	
	/**
	 * adds a {@link Building} at a given tindex to the first open index in a {@link StoreManager}<br></br>
	 * this method calls <code>checkHashArray</code> which will make a new {@link ArrayList} in the {@link HashMap}
	 * @param i index of the building in the list of all {@link Building}s to add to 
	 * 			the list of <i>ownedBuildings</i>
	 */
	public void addBuilding (int i)
	{
		BuildingType bT = this.buildingTypes.get(i);
		Building toAdd = this.allBuildings.get(i).clone();
		checkHashArrray(bT);
		StoreManager sMan = this.getFirstSMan (bT);
		sMan.add(toAdd);
	}

	/**
	 * 
	 * @param bT the {@link BuildingType} of the requested building
	 * @return the first open {@link StoreManager} if there is one, otherwise returns
	 * 					<strong><code>null</code></strong>
	 */
	private StoreManager getFirstSMan(BuildingType bT) 
	{
		if (ownedBuildings.get(bT) == null)
			return null;
		for (int i = 0; i < ownedBuildings.get(bT).size(); i++)
		{
			StoreManager sMan = ownedBuildings.get(bT).get(i);
			if ( !sMan.maxed() )
					return sMan;
		}
		return null;
	}
	
	/**
	 * 
	 * @param bT building type key for the HashMap 
	 * @param i index of the requested {@link StoreManager}
	 * @return {@link StoreManager} at the requested index of <i>ownedBuildings</i>
	 */
	public StoreManager get(BuildingType bT , int i) 
	{
		if (i < getFirstSMan(bT).size())
			return this.ownedBuildings.get(bT).get(i);
		return null;
	}

	/**
	 * 
	 * @return <i>ownedBuildings</i> which is a (HashMap" {@link BuildingType}, {@link ArrayList}"StoreManager"")
	 */
	public HashMap<BuildingType, ArrayList<StoreManager>> get() 
	{
		return this.ownedBuildings;
	}

	/**
	 * 
	 * @param l nubmer of levels to add to the {@link Building}
	 * @param b the {@link Building} to be upgraded
	 */
	public void addUpgrade( Building b ) 
	{
		b.addLevel();
	}

	/**
	 * 
	 * @param bT {@link BuildingType} of the list of store managers to check
	 * @return the number of {@link StoreManager}s in a given {@link BuildingType}
	 */
	public int size(BuildingType bT) 
	{
		return this.ownedBuildings.get(bT).size();
	}
	
	/**
	 * 
	 * @return the number of maped {@link BuildingType}s in the {@link HashMap} <i>ownedBuildings</i>
	 */
	public int size ()
	{
		return this.ownedBuildings.size();
	}
	/**
	 * 
	 * @return the number of different types of buildings that are currently available to the player
	 */
	public int maxSize()
	{
		return this.allBuildings.size();
	}

	/**
	 * will go thorugh an {@link ArrayList} of all the different {@link StoreManager}s and their 
	 * 	subsequent {@link Building}s and return the amount of money they shall give. this number 
	 * 	includes the <i>base price</i> of the {@link Building} along with the <i>upgrade</i> increase 
	 * 	and the mulitplyer from the {@link StoreManager}
	 * 
	 * @param bT {@link BuildingType} of the {@link StoreManager} to get the increase from
	 * @return the amount of money each {@link Building} will provide the player each day
	 */
	public double getIncrease(BuildingType bT) 
	{
		double increase = 0;
		
		List<StoreManager> list = this.ownedBuildings.get(bT);
		
		for (int i = 0; i < list.size(); i++)
			increase += list.get(i).getIncrease();
		
		return increase;
	}
	/**
	 * will go through the {@link HashMap} and for each {@link BuildingType} will get the 
	 * 	individual increase of the building wich will<br></br>
	 * 			go thorugh an {@link ArrayList} of all the different {@link StoreManager}s and 
	 *  		 their subsequent {@link Building}s and return the amount of money they shall give. 
	 *  		 this number includes the <i>base price</i> of the {@link Building} along with the 
	 *  		 <i>upgrade</i> increase and the mulitplyer from the {@link StoreManager 
	 *
	 * 
	 * @return the amount of money each {@link Building} will provide the player each day
	 */
	public double getIncrease() 
	{
		double money = 0;
		for (int i = 0; i < this.ownedBuildings.size(); i ++)
		{
			BuildingType bT = this.buildingTypes.get(i);
			checkHashArrray(bT);
			List<StoreManager> list = this.ownedBuildings.get(bT);
			for (int j = 0; j < list.size(); j++) 
			{
				money += list.get(j).getIncrease();
			}
		}
		return money;
	}

	/**
	 * checks the {@link HashMap} and if the {@link HashMap} at the given {@link BuildingType} 
	 *  is empty will put in a new {@link ArrayList} of {@link StoreManager}s that is empty
	 * @param bT the {@link BuildingType} to check in the {@link HashMap}
	 */
	private void checkHashArrray(BuildingType bT) 
	{
		List<StoreManager> list = this.ownedBuildings.get(bT);
		if (list == null)
			this.ownedBuildings.put(bT , new ArrayList<StoreManager>());
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

	
	private int size(GrandManager manager) 
	{
		return manager.allBuildings.size();
	}

	/**
	 * <h1>test code -- not final</h1>
	 * this code will be replaced by a GUI link that has accsess to the owned building ans can display them properly and return the actual building that has been requested
	 * @param BuildingType is the building type of hte building that is requested
	 * @param i index of the building reqested in the list
	 */
	public StoreManager getSManager(BuildingType bT, int i) 
	{
		return this.ownedBuildings.get(bT).get(i);
	}

	/**
	 * 
	 * @param i index of the {@link HashMap} to get
	 * @return {@link ArrayList} of s
	 */
	public List<StoreManager> getHash(int i) 
	{
		BuildingType bT = this.buildingTypes.get(i);
		return this.ownedBuildings.get(bT);
	}

	/**
	 * 
	 * @param i index of the {@link BuildingType} to get the name of
	 * @return the name of the building type in a string form
	 */
	public String getTypeName(int i) 
	{
		return this.buildingTypes.get(i).toString();
	}

	/**
	 * 
	 * @return list of all the stock buildings
	 */
	public List<Building> getStock() 
	{
		return this.allBuildings;
	}

	/**
	 * 
	 * @param in the index of the {@link Building} to get the cost of 
	 * @return the cost of the {@link Building} at the given Index
	 */
	public double getCost(int in) 
	{
		return this.allBuildings.get(in).getCost();
	}

	/**
	 * creates a new {@link StoreManager} and adds them to the <code>ownedBuildings</code> of the player <br></br>
	 * this method calls <code>checkHashArray</code> which will make a new {@link ArrayList} in the {@link HashMap}
	 * @param classNum the index of the {@link BuildingType} to add the {@link StoreManager} to
	 */
	public void addSMan(int classNum) 
	{
		BuildingType bT = buildingTypes.get(classNum);
		StoreManager sMan = new StoreManager(bT);
		checkHashArrray(bT);
		this.ownedBuildings.get(bT).add(sMan);
	}

	/**
	 * 
	 * @param classNum the undex of the {@link BuildingType} to search for in the {@link HashMap}
	 * @param index the index of the {@link StoreManager} in the {@link HashMap} of {@link StoreManager}s
	 * @param building the index of the {@link Building} in the {@link ArrayList} of {@link Building}s stored in each {@link StoreManager}
	 * @return
	 */
	public Building getBuilding(int classNum, int index, int building) 
	{
		BuildingType bT = buildingTypes.get(classNum);
		StoreManager sMan = this.ownedBuildings.get(bT).get(index);
		return sMan.get(building);
	}

	public double getBuildingUpgradeCost(int classNum, int in, int building) 
	{
		BuildingType bT = buildingTypes.get(classNum);
		return this.ownedBuildings.get(bT).get(in).get(building).getUpgradeCost();
	}

	public void save() 
	{
		saveSMans();
		saveBuildings();
	}

	private void saveBuildings() 
	{
		SaveGameManager save = new SaveGameManager();
		List<String> buildings = this.getAllBuildingsSaveData();
		
		save.save(buildings, "res\\assets\\saves\\ownedBuildings" );
	}


	private List<Building> getAllBuildings() 
	{
		List<StoreManager> sMans = getAllSMans();
		List<Building> buildings = new ArrayList<Building>();
		for (StoreManager sMan : sMans)
			buildings.addAll(sMan.get());
		return buildings;
	}

	private List<String> getAllBuildingsSaveData() 
	{
		List<String> data = new ArrayList<String>();
		List<Building> buildings =  getAllBuildings();
		for (Building building : buildings)
			data.add(building.getSaveData());
		return data;
	}
	private void saveSMans() 
	{
		SaveGameManager save = new SaveGameManager();
		List<String> storeManagers = this.getAllSManSaveData();

		save.save(storeManagers, "res\\assets\\saves\\storeManagers");
	}

	private List<StoreManager> getAllSMans() 
	{
		List<StoreManager> sMans = new ArrayList<StoreManager>();
		for (BuildingType bT : buildingTypes)
		{
			if (this.ownedBuildings.get(bT) != null)
				sMans.addAll(this.ownedBuildings.get(bT));
		}
		return sMans;
	}

	private List<String> getAllSManSaveData ()
	{
		List<StoreManager> sMans = getAllSMans();
		List<String> data = new ArrayList<String>();
		for (StoreManager sMan : sMans)
		{
			data.add(sMan.getSaveData());
		}
		return data;
	}

	public void resetSave() 
	{
		SaveGameManager reset = new SaveGameManager();
		List<String> list = new ArrayList<String>();
		list.add("");
		reset.save( list, "res\\assets\\saves\\storeManagers"  );
		reset.save( list, "res\\assets\\saves\\ownedBuildings" );
	}


}
