package buildings.level;

public abstract class Level {
	
	private int current;
	private int maxLevel;
	
	public Level (int max)
	{
		this.maxLevel = max;
		this.current = 1;
	}

	public abstract double getValue();
	public abstract double getUpgradeCost();
	public abstract Level clone();
	public abstract String toString();

	public int getCurrent()
	{
		return this.current;
	}

	public int getMax()
	{
		return this.maxLevel;
	}

	public void setCurrent(int i)
	{
		this.current = i;
	}

	public void addLevel()
	{
		this.current++;
	}

	public boolean canAddLevel ()
	{
		return this.current + 1 <= maxLevel;
	}

}
