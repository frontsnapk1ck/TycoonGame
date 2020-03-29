package records;

public class Time{

    private final int TIMEZONE_OFFSET = -5;

    private long time;
    private int hours;
    private int mins;
    private int secs;

    public Time ()
    {
        this(System.currentTimeMillis());
    }

    public Time(long timeMillis) 
    {
        this.time = timeMillis;
        formatTime();
        fixTime(TIMEZONE_OFFSET);
    }

    private void fixTime(int i) 
    {
        this.hours += i;
        if (this.hours < 0)
            this.hours += 24;
    }

    public Time(int h, int m, int s)
    {
        this.hours = h;
        this.mins = m;
        this.secs = s;
    }

    private void formatTime() 
    {
        final int MILLS_IN_DAY = 86400000;
        final int MILLS_IN_HOUR = 3600000;
        final int MILLS_IN_MIN = 60000;
        final int MILLS_IN_SECS = 1000;

        long time1Day = this.time % MILLS_IN_DAY;
        int h = (int) (time1Day / MILLS_IN_HOUR);
        
        long minLong = (time1Day - h * MILLS_IN_HOUR);
        int m = (int) (minLong / MILLS_IN_MIN);
        
        long secLong = (minLong - m * MILLS_IN_MIN);
        int s = (int) (secLong / MILLS_IN_SECS);

        this.hours = h;
        this.mins = m;
        this.secs = s;
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @return the mins
     */
    public int getMins() {
        return mins;
    }

    /**
     * @return the sec
     */
    public int getSec() {
        return secs;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * @param mins the mins to set
     */
    public void setMins(int mins) {
        this.mins = mins;
    }

    /**
     * @param sec the sec to set
     */
    public void setSec(int secs) {
        this.secs = secs;
    }

    public String format(int t)
    {
        String out = "";
        if (t < 10 )
            out += 0;
        out += t;
        return out;
    }

    @Override
    public String toString() 
    {
        String out = "" +   this.hours + ":" + 
                            format(this.mins) + ":" + 
                            format(this.secs);
        return out;
    }

    public String getSaveData ()
    {
        String out = "" +   this.hours + "|" + 
                            format(this.mins) + "|" + 
                            format(this.secs);
        return out;
    }

}