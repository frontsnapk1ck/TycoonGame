package player;

import java.util.ArrayList;
import java.util.List;

import factory.LoanFactory;
import save.SaveGameManager;
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
	private List<Loan> loans;
	/**list of all stock {@link Loan}s a Player can take out */
	private List<Loan> stockLoans;
	/**the max number of {@link Loan}s a player can have out at once */
	private int maxLoans;
	
	public Account ()
	{
		this.maxLoans = 1;
		this.bal = 0;

		SaveGameManager save = new SaveGameManager();
		LoanFactory factory = new LoanFactory();

		this.loans = save.getOwnedLoans();
		this.stockLoans = factory.getStock();
	}

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
	public List<Loan> getLoans()
	{
		return this.loans;
	}
	public void save() 
	{
		SaveGameManager save = new SaveGameManager();
		List<String> data = getSaveData();
		save.save (data , "res\\assets\\saves\\account\\account.txt");
	}

	private List<String> getSaveData() 
	{
		List<String> data = new ArrayList<String>();
		data.add ("" + this.bal );
		for (Loan loan : this.loans)
			data.add(loan.getSaveData());
		return data;
	}

	public void resetSave() 
	{
		SaveGameManager reset = new SaveGameManager();
		reset.reset("res\\assets\\saves\\account\\account.txt");
	}

	public int getNumAvalibleLoans() 
	{
		return 0;
	}

	public void takeLoan(int in) 
	{
		this.loans.add(this.stockLoans.get(in).clone());
	}

}
