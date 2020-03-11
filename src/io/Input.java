package io;

import java.util.Scanner;

public class Input {
	
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * Will run a check agaist the inputed number and only return the int if it is an int
	 * @calls Try_Catch
	 * @return the int the user entered
	 */
	public int getUserInt ()
	{
		String 	in = scanner.nextLine();
		while (!validNum(in))
		{
			in = scanner.nextLine();
		}
		return Integer.parseInt(in);
	}
	
	public String getName()
	{
		String in = scanner.nextLine();
		while (!onlyLetters(in))
		{
			in = scanner.nextLine();
		}
		return in;
	}

	private boolean onlyLetters(String s)
	{
		int numLetters = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (Character.isLetter(s.charAt(i)))
				numLetters ++;
		}
		return numLetters == s.length();
	}

	private static boolean validNum(String temp) 
	{
		try {
			Integer.parseInt(temp);
		} catch (NumberFormatException e) {
			System.err.println("invalid input");
			return false;
		}
		return true;
	}

	public void next() 
	{
		scanner.nextLine();
	}

	public void shutdown()
	{
		if ( this.scanner == null )
			return;
		this.scanner.close();
		this.scanner = null;
	}

	public void reset() 
	{
		this.shutdown();
		this.scanner = new Scanner(System.in);
	}
}
