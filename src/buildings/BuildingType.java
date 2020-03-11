package buildings;

public class BuildingType {
	
	public static final BuildingType LEMONADE_STAND = new BuildingType( "Lemonade Stand" );
	public static final BuildingType TWO = 		new BuildingType( "2" );
	public static final BuildingType THREE = 	new BuildingType( "3" );
	public static final BuildingType FOUR = 	new BuildingType( "4" );
	public static final BuildingType FIVE = 	new BuildingType( "5" );
	
	private String id;
	
	private BuildingType (String id)
	{
		this.id = id;
	}
	
	@Override public String toString ()
	{
		return this.id;
	}
	
//	@Override public boolean equals ( Object obj )
//	{
////		System.out.println("\n\t EQUALS ");
//		if ( obj instanceof BuildingType )
//		{
////			System.out.println("\n\t SAME TYPE ");
//			BuildingType that = (BuildingType) obj;
//			return this.id.equals( that.id );
//		}
//		else
//			return false;
//	}

}
