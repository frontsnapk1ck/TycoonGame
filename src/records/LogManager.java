package records;

import java.util.ArrayList;
import java.util.List;

import factory.LogFactory;
import save.SaveGameManager;

public class LogManager {

    private List<Log> logs;

    public LogManager ()
    {
        LogFactory factory = new LogFactory();
        factory.load("res\\assets\\saves\\account\\account.txt");
        this.logs = factory.getLogs();
    }

    public void addLog (double newBalance , double previousBalance , String message)
    {
        Date date = new Date(1);
        Time time = new Time();

        Log log = new Log(date, time, newBalance, previousBalance, message);
        logs.add(log);
        saveLogs();
        
    }


    private void saveLogs() 
    {
        SaveGameManager save = new SaveGameManager();
        List<String> data = new ArrayList<String>();

        for (Log log : logs)
            data.add(log.getSaveData());
        
        save.save(data, "res\\assets\\saves\\account\\account.txt");
    }

    /**
     * @return the logs
     */
    public List<Log> getLogs() {
        return logs;
    }

    public double getLastBal() 
    {
        Log lastLog = this.logs.get(this.logs.size() - 1);
        return lastLog.getNewBalance();
	}

    public void save() 
    {
        saveLogs();
	}

    public int getLastDay() 
    {
        Log lastLog = this.logs.get(this.logs.size() - 1);
        return lastLog.getDay();
	}

}