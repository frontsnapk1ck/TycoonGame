package factory;

import java.util.ArrayList;
import java.util.List;

import records.Date;
import records.Log;
import records.Time;

public class LogFactory {

    private List<Log> logs = new ArrayList<Log>();

    public void load(String filename) 
    {
        List<String> logData = FileReader.readTextFile(filename);
        loadLogs(logData);
	}

    private void loadLogs(List<String> logData) 
    {
        for (String log : logData)
            loadLog(log);
    }

    private void loadLog(String log) 
    {
        String [] slices = log.split("\\|");

        int day = Integer.parseInt(slices[0]);
        int hours = Integer.parseInt(slices[1]);
        int mins = Integer.parseInt(slices[2]);
        int secs = Integer.parseInt(slices[3]);

        Date date = new Date(day);
        Time time = new Time(hours, mins, secs);

        double newBalance = Double.parseDouble(slices[4]);
        double previousBalance = Double.parseDouble(slices[5]);
        String message = slices[6];

        Log l = new Log(date, time, newBalance, previousBalance, message);
        this.logs.add(l);
    }

    public List<Log> getLogs() 
    {
		return this.logs;
	}

}