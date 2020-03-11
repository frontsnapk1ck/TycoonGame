package tycoonGame2;

/**
 * stores the locatoin of the requested actions
 * 
 * @author swalden
 *
 */
public class MenuItem {
	
	private int mainLevel;
	private int subLevel;
	
	/**
	 * 
	 * @param in sets the fisrt level of the menu
	 */
	public MenuItem(int in) 
	{
		this.mainLevel = in;
	}
	/**
	 * @return the mainLevel
	 */
	public int getMainLevel() {
		return mainLevel;
	}
	/**
	 * @param mainLevel the mainLevel to set
	 */
	public void setMainLevel(int mainLevel) {
		this.mainLevel = mainLevel;
	}
	/**
	 * @return the subLevel
	 */
	public int getSubLevel() {
		return subLevel;
	}
	/**
	 * @param subLevel the subLevel to set
	 */
	public void setSubLevel(int subLevel) {
		this.subLevel = subLevel;
	}
	
	
}