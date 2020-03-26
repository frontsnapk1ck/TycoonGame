package factory;

import buildings.Building;
import buildings.BuildingType;
import buildings.StoreManager;
import buildings.level.Level;
import buildings.level.LowLevel;
import buildings.level.MidLevel;
import buildings.level.HighLevel;

import java.util.List;
import java.util.ArrayList;

public class BuildingFactory {
	
	
	private List<Building> buildings;
    private List<BuildingType> buildingTypes; 
    private List<StoreManager> sMans;

    public BuildingFactory ()
    {
        this.buildings = new ArrayList<Building>();
        this.buildingTypes = new ArrayList<BuildingType>(); 
        this.sMans = new ArrayList<StoreManager>();
    }

    public List<Building> getBuildings ()
    {
        return this.buildings;
    }

    public List<BuildingType> getTypes()
    {
        return this.buildingTypes;
    }

    public void load ( String filename )
    {
        List<String> buildingData = FileReader.readTextFile(filename);
        this.loadBuildings ( buildingData );
    }

    private void loadBuildings(List<String> buildingData) 
    {
        for (int i = 0; i < buildingData.size(); i++)
            this.loadBuilding(buildingData.get(i));
    }

    private void loadBuilding(String string) 
    {
        String[] slices = string.split("\\|");

        int currentLevel = Integer.parseInt(slices[3]);
        int maxLevel = Integer.parseInt(slices[4]);  
        
        BuildingType bT = BuildingType.parseBT( slices[0] );
        int cost = Integer.parseInt( slices[1] );
        Level level = parseLevel ( slices[2] , currentLevel , maxLevel );

        buildings.add(new buildings.Building(bT, cost, level));
        buildingTypes.add(bT);
    }

    public void loadStoreManagers (List<String> sManData)
    {
        for (String sMan : sManData)
            loadStoreManager(sMan);
    }
 
    private void loadStoreManager(String sMan) 
    {
        String[] slices = sMan.split("\\|");

        BuildingType bT = BuildingType.parseBT(slices[0]);
        String id = slices[0] + "|" + slices[1];
        int baseUpkeepCost = Integer.parseInt(slices[2]);
        int maxBuildings = Integer.parseInt(slices[3]);
        double multiplyer = Double.parseDouble(slices[4]);

        StoreManager storeMan = new StoreManager(bT);
        storeMan.setID( id );
        storeMan.setBaseUpkeepCost( baseUpkeepCost );
        storeMan.setMaxBuildings ( maxBuildings );
        storeMan.setMultiplier ( multiplyer );
        storeMan.getUpkeepCost();

    }

    private static Level parseLevel(String type, int current, int max)
    {
        Level level;
        if (type.equals("Low"))
        {
            level = new LowLevel(max);
            level.setCurrent(current);
        }
        else if (type.equals("Mid"))
        {
            level = new MidLevel(max);
            level.setCurrent(current);
        }
        else if (type.equals("High"))
        {
            level = new HighLevel(max);
            level.setCurrent(current);
        }
        else 
            return null;
        return level;
    }
}