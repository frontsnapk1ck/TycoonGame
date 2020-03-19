package io;

import java.util.Scanner;

public class Input {
	
	private Scanner scanner = new Scanner(System.in);
	
	//=================================================
	//				String
	//=================================================

	public String getLetters ()
	{
		return this.hanndleGettingUserLetters( "" , "Invalid String");
	}

	public String getLetters ( String prompt )
	{
		return this.hanndleGettingUserLetters(prompt, "Invalid String");
	}

	public String getLetters (String prompt , String error)
	{
		return this.hanndleGettingUserLetters(prompt, error);
	}

	/**
	 * 
	 * @param prompt the messgage to be displayed to the user upon every attempt to input an integer
	 * @param error the message to be shown to the user upon every failed input attempt
	 * @return the string the user input if it is only letters
	 */
	private String hanndleGettingUserLetters( String prompt , String error )
	{
		System.out.print(prompt);
		String in = scanner.nextLine();
		while (!onlyLetters(in))
		{
			System.err.println( error );
			System.out.print( prompt );
			in = scanner.nextLine();
		}
		return in;
	}

	//=======================================================
	//			Int
	//======================================================

	public int getUserInt()
	{
		return this.handleGettingUserInt("", "Invalid Number");
	}

	public int getUserInt(String prompt) 
	{
		return this.handleGettingUserInt(prompt, "Invalid Number");
	}

	public int getUserInt(String prompt , String error)
	{
		return this.handleGettingUserInt(prompt, error);
	}

	/**
	 * @param prompt the messgage to be displayed to the user upon every attempt to input an integer
	 * @param error the message to be shown to the user upon every failed input attempt
	 * @return the {@link Integer} the user inputed
	 */
	private int handleGettingUserInt(String prompt , String error)
	{
		System.out.print(prompt);
		String 	in = scanner.nextLine();
		while (!validNum(in))
		{
			System.err.println( error );
			System.out.print( prompt);
			in = scanner.nextLine();
		}
		return Integer.parseInt(in);
	}

	//=======================================================
	//			CHAR
	//======================================================

	/**
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided
	 * @return single uppercase letter
	 */
	public char getUserChar()
	{
		return this.handleGettingUserChar( "", "Invalid Char" );
	}
	
	public char getUserChar(String prompt)
	{
		return this.handleGettingUserChar( prompt, "Invalid Char" );
	}
	
	public char getUserChar(String prompt, String error)
	{
		return this.handleGettingUserChar( prompt, error );
	}
	
	/**
	 * 
	 * @param prompt the message to be shown to the user on every attempt
	 * @param error the message to be shown to the user upon every failed input attempt
	 * @return the {@link Char} the user inputed 
	 */
	private char handleGettingUserChar(String prompt, String error)
	{
		System.out.print(prompt);
		String in = scanner.nextLine();
		in = in.toUpperCase();

		boolean valid = onlyLetters(in) && in.length() <=1 && in.length() != 0;
		while (!valid)
		{
			System.err.println( error );
			System.out.print(prompt);
			in = scanner.nextLine();
			in = in.toUpperCase();
			valid =	onlyLetters(in) 	&& in.length() <=1 && in.length() != 0;
		}
		return in.charAt(0);
	}

	//====================================================
	//			Utility
	//====================================================

	/** 
	 * waits until the user presses the Enter key
	 */
	public void next() 
	{
		scanner.nextLine();
	}

	/**
	 * shutsdown this calss by closing the {@link Scanner} then setting it to <code> Null </code>
	 */
	public void shutdown()
	{
		if ( this.scanner == null )
			return;
		this.scanner.close();
		this.scanner = null;
	}

	/**
	 * resets this class by preforming a <code>shutdown</code> the {@link Scanner} and then recreating it
	 */
	public void reset() 
	{
		this.shutdown();
		this.scanner = new Scanner(System.in);
	}

	//===========================================
	//		Checkers
	//===========================================

	/**
	 * 
	 * @param temp the string to be cheked agaist
	 * @return if the string passed can be parsed to an {@link Integer}
	 */
	private static boolean validNum(String temp) 
	{
		try {
			Integer.parseInt(temp);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param s {@link String} to be checked
	 * @return if the {@link String} is onlt letters
	 */
	private boolean onlyLetters(String s)
	{
		int numLetters = -1;
		for (int i = 0; i < s.length(); i++)
		{
			if (Character.isLetter(s.charAt(i)))
				numLetters ++;
		}
		return numLetters == s.length() -1;
	}
}
