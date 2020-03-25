package factory;

import buildings.Building;
import java.util.List;
import java.util.ArrayList;

public class BuildingFactory {
	
	
	private List<Building> buildings = new ArrayList<Building>();
	
	public BuildingFactory()
	{
		
	}
	
    public void load( String filename )
    {
        List<String> buildingData = FileReader.readTextFile(filename);
        this.loadBuildings ( buildingData );
    }

    private void loadBuildings(List<String> buildingData) 
    {
        System.err.println(buildingData);
        for (int i = 0; i < buildingData.size(); i++)
            this.loadBuilding(buildingData.get(i));
    }

    private void loadBuilding(String string) 
    {
        String[] slices = string.split("-");
        
        int cost = Integer.parseInt(slices[1]);
        int currentLevel = Integer.parseInt(slices[3]);
        int maxLevel = Integer.parseInt(slices[4]);

        for (int i = 0; i < slices.length; i++)
            System.err.println(slices[i]);
    }
    
}