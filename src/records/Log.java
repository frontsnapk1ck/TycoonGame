package records;

public class Log {

    private Date date;
    private Time time;
    private double newBalance;
    private double previousBalance;
    private String message;
    
    public Log (Date date , Time time , double newBalance , 
                            double previousBalance , String message)
    {
        this.date = date;
        this.time = time;
        this.newBalance = newBalance;
        this.previousBalance = previousBalance;
        this.message = message;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param newBalance the newBalance to set
     */
    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    /**
     * @param previousBalance the previousBalance to set
     */
    public void setPreviousBalance(double previousBalance) {
        this.previousBalance = previousBalance;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString()
    {
        String out = "Date: " +   this.date + "\tTime: " + 
                            this.time + "\tNew Balance: $" + 
                            this.newBalance + "\tPrevious Balance: $" + 
                            this.previousBalance + "\tMessage: " +
                            this.message;
        return out;
    }

    public String getSaveData()
    {
        String d = "" + this.date.getSaveData() + "|" +
                        this.time.getSaveData() + "|" + 
                        this.newBalance + "|" + 
                        this.previousBalance + "|" +
                        this.message;
        return d;
    }

	/**
     * @return the newBalance
     */
    public double getNewBalance() {
        return newBalance;
    }

    public int getDay() 
    {
		return this.date.getDay();
	}
}