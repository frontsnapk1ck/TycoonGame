package tycoonGame2;

import java.util.ArrayList;

public class Menu extends DisplayFramework {
	
	public static void main ()
	{
		printNewLine(10);
		System.out.println("1\tShow Building");
		System.out.println("2\tBuy Building");
		System.out.println("3\tBuy Upgrade");
		System.out.println("");
		System.out.println("9\tNew day");
		System.out.println("0\tend");
	}
	
	private static void printNewLine(int count) 
	{
		for (count += 0; count >=0; count--)
		{
			System.out.println("");
		}
	}

	public void list (ArrayList<String> list)
	{
		for ( int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}

	public void out(String string) 
	{
		System.out.println(string);
	}

	public void line() 
	{
		System.out.println("");
	}
	
}
