package buildings.level;

public class MidLevel extends Level {

    public MidLevel (int max)
    {
        super(max);
    }

    @Override
	public double getValue() 
    {
       return   2.9 * Math.pow(getCurrent(), 2) + 
                4.9 * getCurrent() + 
                6;
    }

    @Override
    public double getUpgradeCost() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Level clone() {
        MidLevel clone = new MidLevel(
            this.getMax()
        );
        return clone;
    }

}