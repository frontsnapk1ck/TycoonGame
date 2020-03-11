package player;

import java.util.ArrayList;

public class Player {
	
	private Account account = new Account();
	private buildings.Manager bManager = new buildings.Manager();
	
	public void startGame ()
	{
		
		this.account.addBal(1000);
		this.bManager.addBuilding(0);
	}

	public double getIncrease() 
	{
		return this.bManager.getIncrease();
	}

	public void addBalance(double increase) 
	{
		this.account.addBal(increase);
	}

	/**
	 * 
	 * @param i index of the hashMap to return
	 * @return ArrayList"Building" of all the buildings at the index
	 */
	public ArrayList<buildings.Building> getOnwedBuildings (int i)
	{
		return this.bManager.getHash(i);
	}

	public int getNumTypes() 
	{
		return this.bManager.maxSize();
	}

	public String getTypeName(int i) 
	{
		return this.bManager.getTypeName(i);
	}

	public ArrayList<buildings.Building> getStockBuildings() 
	{
		return this.bManager.getStock();
	}

	public void addBuilding(int buildingNum) 
	{
		this.bManager.addBuilding(buildingNum);
	}

	public double getBalance() 
	{
		return this.account.getBal();
	}
	
	public boolean validWithdraw (double withBal)
	{
		return account.validWithdraw(withBal);
	}
	
	public void withdraw (double withBal)
	{
		this.account.subtractBal(withBal);
	}

	/**
	 * 
	 * @param 	in the index of the building to be selected
	 * @return 	the cos of the building
	 */
	public double getCost(int in) 
	{
		return this.bManager.getCost(in);
	}
	
}