package buildings.level;

public class HighLevel extends Level{

    public HighLevel(int max) 
    {
        super(max);
    }

    @Override
    public double getValue() 
    {
        return  7.1 * Math.pow(getCurrent() , 2) - 
                10.9 * getCurrent() + 
                24;
    }

    @Override
    public double getUpgradeCost() 
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Level clone() 
    {
        HighLevel clone = new HighLevel (
            this.getMax()
        );
        return clone;
    }

    @Override
    public String toString() 
    {
        return "High" + "|" +  getCurrent() + "|" + getMax(); 
    }

}