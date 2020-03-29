 package records;

 public class Date{

    private int month;
    private int day;
    private int year;

    public Date ( int day )
    {
        this.day = day;
        this.month = -1;
        this.year = -1;
    }

    public Date ( int m , int d, int y)
    {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() 
    {
        String out = "";
        if (month > 0)
            out += month;
        if (day > 0)
        {
            if (!out.equals(""))
            {
                out += "/";
                out += day;
            }
            else 
                out += day;
        }
        if (year >= 0)
        {
            if (!out.equals(""))
            {
                out += "/";
                out += year;
            }
            else 
                out += year;
        }
        return out;
    }

    public String getSaveData ()
    {
        String out = "";
        if (month > 0)
            out += month;
        if (day > 0)
        {
            if (!out.equals(""))
            {
                out += "|";
                out += day;
            }
            else 
                out += day;
        }
        if (year >= 0)
        {
            if (!out.equals(""))
            {
                out += "|";
                out += year;
            }
            else 
                out += year;
        }
        return out;
    }
}