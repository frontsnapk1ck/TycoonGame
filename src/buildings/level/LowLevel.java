package buildings.level;

public class LowLevel extends Level {

    public LowLevel (int max)
    {
        super(max);
        setCurrent(1);
    }

    @Override
    public double getValue() 
    {
        return  3.9 * Math.pow(getCurrent() , 2) - 
                7.1 * getCurrent() +
                13;

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
        LowLevel clone = new LowLevel(
                this.getMax()
            );
        return clone;
    }


}