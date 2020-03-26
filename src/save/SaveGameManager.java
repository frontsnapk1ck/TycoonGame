package save;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveGameManager {

    public void save (List<String> data , String filename)
    {
        String single = condense(data);
        try{
            FileWriter writer = new FileWriter(filename);
            writer.write(single);
            writer.close();
        }catch (IOException e)
        {
            System.err.println("SaveGameManager: Saving game to file " + filename + " -FAILED\n\n");
            e.printStackTrace();
        }
    }

    private String condense(List<String> data) 
    {
        String single = "";
        for (String s : data)
        {
            single += s;
            single += "\n";
        }
        return single;
    }

    public void checkOwnedBuildings ()
    {
        
    }

}