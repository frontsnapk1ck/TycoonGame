package tycoonGame2;

import java.util.List;

public class Menu {
	
	public void main ()
	{
		System.out.println("1\tBuy Building");
		System.out.println("2\tShow Store Managers");
		System.out.println("3\tBuy Store Manager");
		System.out.println("4\tManage Laons");
		System.out.println("");
		System.out.println("9\tNew day");
		System.out.println("0\tpause");
	}
	
	public void storeManager() 
	{
		System.out.println("1\tBuy Upgrade");
		System.out.println("2\tShow Buildings");
		System.out.println("");
		System.out.println("0\texit");
	}

	public void storeManagerUpgrades(String cost)
	{
		System.out.println("1\tincrease number of bduildings\t$" + cost);
		System.out.println("2\tincrease money multiplier\t$" + cost);
		System.out.println("");
		System.out.println("0\tback");
	}

	public void building(String upCost)
	{
		System.out.println("1\tUpgrade Building\t$" + upCost);
		System.out.println("2\tSell Building");
		System.out.println("");
		System.out.println("0\tBack");
	}

	public void manageLoans() 
	{
		System.out.println("1\tTake out Loan");
		System.out.println("2\tView Active Loans");
		System.out.println("");
		System.out.println("0\t");
	}

	public void end() 
	{
		System.out.println("1\tSave Game");
		System.out.println("2\tSave and Exit");
		System.out.println("3\tExit Without Saving");
		System.out.println("4\tReset and Exit");
		System.out.println("");
		System.out.println("0\tBack");

	}

	public void out (List<String> list)
	{
		for ( int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}

	public void out(String out) 
	{
		System.out.println(out);
	}

	public void line() 
	{
		System.out.println("");
	}

	public void line(int count) 
	{
		for (count += 0; count >=0; count--)
		{
			line();
		}
	}

}
