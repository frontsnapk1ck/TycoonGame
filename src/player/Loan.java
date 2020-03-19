package player;

public class Loan {
	
	/**the amount of money withdrawn */
	private double initAmount;
	/**the adjusted amount of the loan that uses the intrest formula */
	private double adjustedAmount;
	/**the number of days the loan lasts */
	private int time;
	/**the intrest rate of the loan */
	private double rate;
	/**the current blance on the loan */
	private double current;
	
	/**
	 * 
	 * @param amount the amount of money withdrawn
	 * @param time the number of days this {@link Loan} lasts
	 * @param rate the intrest rate of the {@link Loan}	expressed as a persentage (1.2 <=> 0.012) where the <code>rate</code> entered is 1.2
	 */
	public Loan (double amount , int time , double rate)
	{
		this.initAmount = amount;
		this.time = time;
		this.adjustedAmount = calcualteCurrent(amount , time , rate);
		this.current = this.adjustedAmount;
	}

	private double calcualteCurrent(double amount, int time, double rate) 
	{
		rate /= 100;
		double power = time;
		double fraction = rate;
		double adjustedAmount = amount * (1 + fraction);
		adjustedAmount = Math.pow(adjustedAmount, power);
		return adjustedAmount;
	}

	public double getInitAmount() {
		return this.initAmount;
	}
	
	public int getTime ()
	{
		return this.time;
	}

	public double getRate ()
	{
		return this.rate;
	}

	public double getCurrent ()
	{
		return this.current;
	}

	public double getAmountPerDay ()
	{
		double amount = this.adjustedAmount / this.time;
		amount = Math.round(amount * 100);
		amount /= 100;
		return amount;
	}

}
