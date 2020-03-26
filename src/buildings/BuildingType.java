package buildings;

import java.util.ArrayList;
import java.util.List;

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
		List<BuildingType> list = new ArrayList<BuildingType>();
		list.add(LEMONADE_STAND);
		list.add(TWO);
		list.add(THREE);
		list.add(FOUR);
		list.add(FIVE);
		for (BuildingType type : list)
		{
			if (type.equals(bTCheck))
				return type;
		}
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
