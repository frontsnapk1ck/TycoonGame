package io;

import java.util.ArrayList;
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

	/**
	 * runs a program that gets an {@link Integer} input by the user and dosen't return untill the user inputs a {@link Integer} <br></br>
	 * runs default prompts and erros upon entry request and entry failure to satisfy requirements <br></br>
	 * accepts all {@link Integer}s <br></br>
	 * runs a TRY_CATCH	
	 * @return the {@link Integer} the user inputed
	 */
	public int getUserInt()
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		return this.handleGettingUserInt("", "Invalid Number" , intList);
	}
	/**
	 * runs a program that gets an {@link Integer} input by the user and dosen't return untill the user inputs a {@link Integer} <br></br>
	 * runs default prompts and erros upon entry request and entry failure to satisfy requirements <br></br>
	 * runs a TRY_CATCH	
	 * @param acceptable the desired {@link Integer}
	 * @return the {@link Integer} the user inputed
	 */
	public int getUserInt(int acceptable)
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(acceptable);
		return this.handleGettingUserInt("", "Invalid Number", intList);
	}
	/**
	 * runs a program that gets an {@link Integer} input by the user and dosen't return untill the user inputs a {@link Integer} <br></br>
	 * runs default prompts and erros upon entry request and entry failure to satisfy requirements <br></br>
	 * runs a TRY_CATCH	
	 * @param intList the desired {@link Integer}s -- returns <code>true</code> if any one of the numbers is met
	 * @return the {@link Integer} the user inputed
	 */
	public int getUserInt (ArrayList<Integer> intList)
	{
		return this.handleGettingUserInt( "" , "Invalid Number", intList);
	}

	//=======================================================
	//			Int -- prompt
	//======================================================

	/**
	 * runs a program that gets an {@link Integer} input by the user and dosen't return untill the user inputs a {@link Integer} <br></br>
	 * runs default error upon entry failure to satisfy requirements <br></br>
	 * Accepts all {@link Integer}s
	 * runs a TRY_CATCH	
	 * @param prompt the messgage to be displayed to the user upon every attempt to input an integer
	 * @return the {@link Integer} the user inputed
	 */
	public int getUserInt(String prompt) 
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		return this.handleGettingUserInt(prompt, "Invalid Number" , intList);
	}

	/**
	 * runs a program that gets an {@link Integer} input by the user and dosen't return untill the user inputs a {@link Integer} <br></br>
	 * runs default error upon entry failure to satisfy requirements <br></br>
	 * runs a TRY_CATCH
	 * @param prompt the messgage to be displayed to the user upon every attempt to input an integer
	 * @param acceptable the desired {@link Integer}
	 * @return the {@link Integer} the user inputed
	 */
	public int getUserInt( String prompt , int acceptable)
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(acceptable);
		return this.handleGettingUserInt( prompt , "Invalid Number" , intList );
	}

	/**
	 * runs a program that gets an {@link Integer} input by the user and dosen't return untill the user inputs a {@link Integer} <br></br>
	 * runs default error upon entry failure to satisfy requirements <br></br>
	 * runs a TRY_CATCH
	 * @param prompt the messgage to be displayed to the user upon every attempt to input an integer
	 * @param intList the desired {@link Integer}s -- returns <code>true</code> if any one of the numbers is met
	 * @return the {@link Integer} the user inputed
	 */
	public int getUserInt ( String prompt , ArrayList<Integer> intList)
	{
		return this.handleGettingUserInt( prompt , "Invalid Number" , intList );
	}

	//=======================================================
	//			Int -- prompt && error
	//======================================================

	/**
	 * runs a program that gets an {@link Integer} input by the user and dosen't return untill the user inputs a {@link Integer} <br></br>
	 * Accepts all {@link Integer}s
	 * runs a TRY_CATCH	
	 * @param prompt the messgage to be displayed to the user upon every attempt to input an integer
	 * @param error the message to be shown to the user upon every failed input attempt
	 * @return the {@link Integer} the user inputed
	 */
	public int getUserInt(String prompt , String error)
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		return this.handleGettingUserInt( prompt , error , intList );
	}

	/**
	 * runs a program that gets an {@link Integer} input by the user and dosen't return untill the user inputs a {@link Integer} <br></br>
	 * runs a TRY_CATCH
	 * @param prompt the messgage to be displayed to the user upon every attempt to input an integer
	 * @param error the message to be shown to the user upon every failed input attempt
	 * @param acceptable the desired {@link Integer}
	 * @return the {@link Integer} the user inputed
	 */
	public int getUserInt( String prompt , String error , int acceptable)
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(acceptable);
		return this.handleGettingUserInt(prompt, error, intList);
	}

	/**
	 * runs a program that gets an {@link Integer} input by the user and dosen't return untill the user inputs a {@link Integer} <br></br>
	 * runs a TRY_CATCH
	 * @param prompt the messgage to be displayed to the user upon every attempt to input an integer
	 * @param error the message to be shown to the user upon every failed input attempt
	 * @param intList the desired {@link Integer}s -- returns <code>true</code> if any one of the numbers is met
	 * @return the {@link Integer} the user inputed
	 */
	public int getUserInt( String prompt , String error , ArrayList<Integer> intList)
	{
		return this.handleGettingUserInt(prompt, error, intList);
	}

	//=======================================================
	//			Int -- handler
	//======================================================

	/**
	 * @param prompt the messgage to be displayed to the user upon every attempt to input an integer
	 * @param error the message to be shown to the user upon every failed input attempt
	 * @param intList the list of integers acceptable to use
	 * @return the {@link Integer} the user inputed
	 */
	private int handleGettingUserInt(String prompt , String error , ArrayList<Integer> intList)
	{
		System.out.print(prompt);
		String 	in = scanner.nextLine();
		while (!validNum(in) || !inListInt(intList , in))
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
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided <br></br>
	 * runs default prompts and erros upon entry request and entry failure to satisfy requirements <br></br>
	 * accepts all {@link Character}s
	 * @return single uppercase {@link Character} input by the User
	 */
	public char getUserChar()
	{
		ArrayList<Character> charList = new ArrayList<Character>();
		return this.handleGettingUserChar( "", "Invalid Char" , charList );
	}

	/**
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided <br></br>
	 * runs default prompts and erros upon entry request and entry failure to satisfy requirements <br></br>
	 * @param acceptable the desired {@link Character}
	 * @return single uppercase {@link Character} input by the User
	 */
	public char getUserChar(char acceptable)
	{
		ArrayList<Character> charList = new ArrayList<Character>();
		charList.add(acceptable);
		return this.handleGettingUserChar( "" , "Invalid Char" , charList);
	}

	/**
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided <br></br>
	 * runs default prompts and erros upon entry request and entry failure to satisfy requirements <br></br>
	 * @param charList the desired {@link Character}s -- returns <code>true</code> if one of the {@link Character}s are met
	 * @return single uppercase {@link Character} input by the User
	 */
	public char getUserChar (ArrayList<Character> charList)
	{
		return this.handleGettingUserChar( "" , "Invalid Char" , charList);
	}

	//=======================================================
	//			CHAR -- prompt
	//======================================================

	/**
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided <br></br>
	 * runs default erros upon entry failure to satisfy requirements <br></br>
	 * accepts all {@link Character}s
	 * @param prompt the prompt to be used upon request for user entry
	 * @return single uppercase {@link Character} input by the User
	 */
	public char getUserChar(String prompt)
	{
		ArrayList<Character> charList = new ArrayList<Character>();
		return this.handleGettingUserChar( prompt , "Invalid Char" , charList );
	}

	/**
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided <br></br>
	 * runs default erros upon entry failure to satisfy requirements
	 * @param acceptable the desired {@link Character}
	 * @param prompt the prompt to be used upon request for user entry
	 * @return single uppercase {@link Character} input by the User
	 */
	public char getUserChar ( String prompt , char acceptable)
	{
		ArrayList<Character> charList = new ArrayList<Character>();
		charList.add(acceptable);
		return this.handleGettingUserChar(prompt, "Invalid Char", charList);
	}

	/**
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided <br></br>
	 * runs default erros upon entry failure to satisfy requirements
	 * @param charList the desired {@link Character}s -- returns <code>true</code> if one of the {@link Character}s are met
	 * @param prompt the prompt to be used upon request for user entry
	 * @return single uppercase {@link Character} input by the User
	 */
	public char getUserChar ( String prompt , ArrayList<Character> charList)
	{
		return this.handleGettingUserChar(prompt, "Invalid Char", charList);
	}

	//=======================================================
	//			CHAR -- prompt && error
	//======================================================
	
	/**
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided <br></br>
	 * accepts all {@link Character}s
	 * @param prompt the prompt to be used upon request for user entry
	 * @param error the error to display to the user upon the entrry not meeting requirements
	 * @return single uppercase {@link Character} input by the User
	 */
	public char getUserChar( String prompt , String error )
	{		
		ArrayList<Character> charList = new ArrayList<Character>();
		return this.handleGettingUserChar( prompt, error , charList);
	}

	/** 
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided <br></br>
	 * @param prompt the prompt to be used upon request for user entry
	 * @param error the error to display to the user upon the entrry not meeting requirements
	 * @param acceptable the desired {@link Character}
	 * @return single uppercase {@link Character} input by the User
	 */
	public char getUserChar( String prompt , String error , char acceptable)
	{
		ArrayList<Character> charList = new ArrayList<Character>();
		charList.add(acceptable);
		return this.handleGettingUserChar(prompt, error, charList);
	}

	/** 
	 * runs a program that gets a letter and doesnt do so untill a valid charecter is provided <br></br>
	 * @param prompt the prompt to be used upon request for user entry
	 * @param error the error to display to the user upon the entrry not meeting requirements
	 * @param charList the desired {@link Character}s -- returns <code>true</code> if one of the {@link Character}s are met
	 * @return single uppercase {@link Character} input by the User
	 */
	public char getUserChar ( String prompt , String error , ArrayList<Character> charList )
	{
		return this.handleGettingUserChar(prompt, error, charList);
	}

	//=======================================================
	//			CHAR -- handler
	//======================================================
	
	/**
	 * 
	 * @param prompt the message to be shown to the user on every attempt
	 * @param error the message to be shown to the user upon every failed input attempt
	 * @return single uppercase {@link Character} input by the User
	 */
	private char handleGettingUserChar( String prompt , String error , ArrayList<Character> charList )
	{
		System.out.print(prompt);
		String in = scanner.nextLine();
		in = in.toUpperCase();

		boolean valid = onlyLetters(in) && in.length() <=1 && in.length() != 0;
		while (!valid && !inListChar(charList, in))
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
	//			Wait
	//====================================================

	/**
	 * waits for the user to hit enter before continueing the program <br>
	 * </br>
	 * displays default prompt of "hit enter"
	 */
	public void next()
	{
		handleNext("hit enter ");
	}

	/**
	 * waits for the user to hit enter before continueing the program
	 * @param out the prompt to be displayed to the user
	 */
	public void next (String out)
	{
		handleNext(out);
	}

	/**
	 * waits for the user to hit enter before continueing the program
	 * @param out the prompt to be displayed to the user
	 */
	private void handleNext(String out) 
	{
		System.out.println(out);
		scanner.nextLine();
	}
	//====================================================
	//			Utility
	//====================================================

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

	//===========================================
	//		Checkers -- In List
	//===========================================

	private boolean inListInt(ArrayList<Integer> intList, String in) 
	{
		int intIn = Integer.parseInt(in);
		if (intList == null || intList.size() == 0)
		{
			return true;
		}
		for (int i = 0; i < intList.size(); i++)
		{
			if (intIn == intList.get(i))
			{
				return true;
			}
		}
		return false;
	}

	private boolean inListChar(ArrayList<Character> charList, String in) 
	{
		if (charList == null || charList.size() == 0)
			return true;
		for (int i = 0; i < charList.size(); i ++)
		{
			if (in.toUpperCase().charAt(0) == charList.get(i))
				return true;
		}
		return false;
	}

}
