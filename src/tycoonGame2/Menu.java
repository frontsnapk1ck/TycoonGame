package tycoonGame2;

import java.util.ArrayList;

import player.Player;

public class Menu extends DisplayFramework {
	
	public static void main ()
	{
		line(10);
		System.out.println("1\tShow Building");
		System.out.println("2\tBuy Building");
		System.out.println("3\tBuy Upgrade");
		System.out.println("4\tShow Store Managers");
		System.out.println("5\tBuy Store Manager");
		System.out.println("");
		System.out.println("9\tNew day");
		System.out.println("0\tend");
	}
	
	public void storeManager() 
	{
		System.out.println("1\tBuy Upgrade");
		System.out.println("2\tShow Buildings");
		System.out.println("9\tsell");
		System.out.println("0\texit");
	}
	
	public static void list (ArrayList<String> list)
	{
		for ( int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}

	public static void out(String string) 
	{
		System.out.println(string);
	}

	public static void line() 
	{
		System.out.println("");
	}

	private static void line(int count) 
	{
		for (count += 0; count >=0; count--)
		{
			line();
		}
	}

	
}
