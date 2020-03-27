package save;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import buildings.StoreManager;
import factory.BuildingFactory;
import buildings.Building;
import buildings.BuildingType;

public class SaveGameManager {

    public void save(List<String> data, String filename) {
        String single = condense(data);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(single);
            writer.close();
        } catch (IOException e) {
            System.err.println("SaveGameManager: Saving game to file " + filename + " -FAILED\n\n");
            e.printStackTrace();
        }
    }

    private String condense(List<String> data) {
        String single = "";
        for (String s : data) {
            single += s;
            single += "\n";
        }
        return single;
    }

    public HashMap<BuildingType, List<StoreManager>> getOwnedBuildings() {
        BuildingFactory factory = new BuildingFactory();
        HashMap<BuildingType, List<StoreManager>> ownedBuilding = new HashMap<BuildingType, List<StoreManager>>();

        factory.loadStock("res\\assets\\objects\\stockBuildings.txt");
        List<BuildingType> bTypes = factory.getTypes();

        factory.loadSMans("res\\assets\\saves\\buildings\\storeManagers");
        List<StoreManager> sMans = factory.getSMans();

        factory.loadUserBuildings("res\\assets\\saves\\buildings\\ownedBuildings");
        List<Building> buildings = factory.getUserBuildings();

        for (StoreManager sMan : sMans)
            sMan.add(findMathcing(sMan, buildings));

        for (BuildingType bT : bTypes) 
        {
            ownedBuilding.put(bT, new ArrayList<StoreManager>());
            if (findMatcing(bT, sMans) != null)
                ownedBuilding.get(bT).addAll(findMatcing(bT, sMans));
        }
        return ownedBuilding;
    }

    private List<StoreManager> findMatcing(BuildingType bT, List<StoreManager> sMans) 
    {
        List<StoreManager> matching = null;
        for (StoreManager sMan : sMans)
        {
            if (sMan.getBT().equals(bT))
                matching = new ArrayList<StoreManager>();   
        }
        for (StoreManager sMan : sMans)
        {
            if (sMan.getBT().equals(bT))
                matching.add(sMan);   
        }
        return matching;
    }

    private List<Building> findMathcing(StoreManager sMan, List<Building> buildings) 
    {
        List<Building> mathcingBuildings = new ArrayList<Building>();
        for (Building b : buildings)
        {
            if (b.getSManID().equals(sMan.getID()))
                mathcingBuildings.add(b);
        }
        return mathcingBuildings;
    }

}