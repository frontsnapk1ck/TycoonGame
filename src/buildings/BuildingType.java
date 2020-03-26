package buildings;

/**
 * locks down the avalibe inputs for building types. private class with STATIC FINAL vars.
 * @author S38392
 *
 */
public class BuildingType {
	
	public static final BuildingType LEMONADE_STAND = new BuildingType( "Lemonade Stand" );
	public static final BuildingType TWO = 		new BuildingType( "2" );
	public static final BuildingType THREE = 	new BuildingType( "3" );
	public static final BuildingType FOUR = 	new BuildingType( "4" );
	public static final BuildingType FIVE = 	new BuildingType( "5" );
	
	private String id;
	
	public static BuildingType parseBT(String string) 
	{
		BuildingType bTCheck = new BuildingType (string); 
		if (bTCheck.equals(LEMONADE_STAND))
			return LEMONADE_STAND;
		else if (bTCheck.equals(TWO))
			return TWO;
		else if (bTCheck.equals(THREE))
			return THREE;
		else if (bTCheck.equals(FOUR))
			return FOUR;
		else if (bTCheck.equals(FIVE))
			return FIVE;
		return null;
	}

	private BuildingType (String id)
	{
		this.id = id;
	}

	private String getID() 
	{
		return this.id;
	}
	
	@Override 
	public String toString ()
	{
		return this.id;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (obj instanceof BuildingType)
		{
			BuildingType that = (BuildingType) obj;
			return that.getID().equals(this.id);
		}
		return false;
	}

}
