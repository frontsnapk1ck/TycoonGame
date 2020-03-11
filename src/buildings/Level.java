package buildings;

public class Level {
	
	private int level;
	private int maxLevel;
	private double value;
	
	public Level (int max)
	{
		this.maxLevel = max;
		this.level = 0;
		this.value = 0;
	}

	private Level (int max , int level)
	{
		this.maxLevel 	= max;
		this.level 		= level;
		this.findValue();
	}
	
	public void findValue() 
	{
		int value = (int) (Math.pow( 10 , this.level)) / 20;
		if (value <= 5)
			value += 5;
		if (this.level != 0)
			this.value = value;
	}

		
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) 
	{
		this.level = level;
	}
	
	/**
	 *@param l 
	 * @param 	adds the value to the number
	 *@inputs	can take in negative numbers
	 */
	public void addLevel (int l)
	{
		this.level += l;
	}

	/**
	 * @return the value
	 * 
	 * @calls findValue()
	 */
	public double getValue() 
	{
		this.findValue();
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) 
	{
		this.value = value;
	}
	
	/**
	 * @return the max Level
	 */
	public int getMaxLevel ()
	{
		return this.maxLevel;
	}

	public Level clone ()
	{
		return new Level(this.maxLevel , this.level);
	}
	
	@Override public String toString ()
	{
		return "" + this.level + " / " + this.maxLevel;
	}

	public boolean isValidAdd(int l) 
	{
		if (this.level + l >= 0 &&
			this.level + l <= this.maxLevel)
		{
			return true;
		}
		System.err.println("level out of range " + this);
		return false;
	}
}
