package player;

import java.util.ArrayList;
/**
 * part of the {@link Player} <br></br>
 * holds all the informatoin about 
 * <ul>
 * 		<li>balance</li>
 * 		<li>loans</li>
 * 	</ul>
 */
public class Account {
	/**current balance of the {@link Player} */
	private double bal;
	/**list of all the {@link Loan}s the {@link Player} currently has out */
	private ArrayList<Loan> loans = new ArrayList<Loan>();
	/**the max number of {@link Loan}s a player can have out at once */
	private int maxLoans = 1;
	
	/**
	 * adds money to a {@link Player}'s balance
	 * @param increase the amount of money to increase the {@link Player}'s balance by
	 */
	public void addBal (double increase)
	{
		this.bal += increase;
	}
	/**
	 * @return the amount of money the {@link Player} currently has
	 */
	public double getBal ()
	{
		return this.bal;
	}
	/**
	 * takes money away from a {@link Player} <br> </br>
	 * note -- this does not preform a check on if the new balnce will be negitive
	 * @param toRemove the amount of money to remove
	 */
	public void subtractBal (double toRemove)
	{
		this.bal -= toRemove;
	}

	/**
	 * 
	 * @param toRemove the amount of money to check if can be removed
	 * @return if the balance after subtracting the input is greater than or equal to $0.00
	 */
	public boolean validWithdraw(double toRemove) 
	{
		return this.bal - toRemove >=0;
	}

	/**
	 * @return the max number of {@link Loan}s a {@link Player} can take out 
	 */
	public int getMaxLoans() 
	{
		return this.maxLoans;	
	}

	/**
	 * 
	 * @return the current number of {@link Loan}s the player has out
	 */
	public int getLoansSize() 
	{
		return this.loans.size();	
	}

	/**
	 * 
	 * @return {@link ArrayList} of {@link Loan}s that is the current {@link Loan}s the {@link Player} has out
	 */
	public ArrayList<Loan> getLoans()
	{
		return this.loans;
	}

}
