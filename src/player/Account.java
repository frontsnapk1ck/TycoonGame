package player;

import java.util.ArrayList;

public class Account {
	
	private double bal;
	private ArrayList<Loan> loans = new ArrayList<Loan>();
	private int maxLoans = 1;
	
	public void addBal (double increase)
	{
		this.bal += increase;
	}
	
	public double getBal ()
	{
		return this.bal;
	}
	
	public void subtractBal (double toRemove)
	{
		this.bal -= toRemove;
	}

	public boolean validWithdraw(double toRemove) 
	{
		return this.bal - toRemove >=0;
	}

}
