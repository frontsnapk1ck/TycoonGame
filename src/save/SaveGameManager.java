package save;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import buildings.StoreManager;
import factory.BuildingFactory;
import factory.LoanFactory;
import factory.LogFactory;
import player.Loan;
import records.Date;
import records.Log;
import records.Time;
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

    public void resetLog ()
    {
        String filename = "res\\assets\\saves\\account\\account.txt";
        try {
            FileWriter writer = new  FileWriter(filename);
            Log log = new Log(new Date(1), new Time(), 1000.0, 0.0, "Initial Balance");
            writer.write(log.getSaveData());
            writer.close();
        } catch (IOException e) {
            System.err.println("SaveGameManager: Resteting save at file " + filename + " -FAILED\n\n");
            e.printStackTrace();        
        }
    }

    public void reset(String filename) 
    {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            System.err.println("SaveGameManager: Resteting save at file " + filename + " -FAILED\n\n");
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

    public HashMap<BuildingType, List<StoreManager>> getOwnedBuildings() 
    {
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
            System.err.println(b.getSManID());
            System.err.println(sMan.getID());
            if (b.getSManID().equals(sMan.getID()))
            {
                mathcingBuildings.add(b);
                System.out.println("Match");
            }
        }
        return mathcingBuildings;
    }

    public List<Loan> getOwnedLoans() 
    {
        LoanFactory factory = new LoanFactory();
        List<Loan> loans= new ArrayList<Loan>();

        factory.loadOwned ("res\\assets\\saves\\account\\ownedLoans.txt");
        if (factory.getLoans() != null && factory.getLoans().size() != 0)
            loans.addAll(factory.getLoans());
        return loans;
	}

    public List<Log> getLogs() 
    {
        LogFactory factory = new LogFactory();
        List<Log> logs = new ArrayList<Log>();

        factory.load("res\\assets\\saves\\account\\account.txt");
        if (factory.getLogs() != null && factory.getLogs().size() != 0)
            logs.addAll(factory.getLogs());
        return logs;
	}

}