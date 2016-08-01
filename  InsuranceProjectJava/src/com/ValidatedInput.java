package com;
import java.util.Scanner;

/***************************************************
 * @author 1319252
 * @date July 25th, 2016
 * @version 1.0
 **************************************************/
public class ValidatedInput 
{
	private Scanner sc = new Scanner(System.in);
	
	//gets an integer from the user
	public int getIntFromScanner()
	{
		int userCommand = Integer.MIN_VALUE;
		
		do
		{
			try
			{
				userCommand = sc.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Please enter a valid integer.");
				sc.next();
			}
		}
		while(userCommand <= Integer.MIN_VALUE);
		
		return userCommand;
	}
	
	//gets an integer with a lower bound from the user
	public int getIntFromScanner(int lower)
	{
		int userCommand = Integer.MIN_VALUE;
		
		while(userCommand <= (lower))
			{
				try
				{
					userCommand = sc.nextInt();
					
					if(userCommand < lower)
					{
						System.out.println("Please enter a value higher than " + lower + ".");
						userCommand = Integer.MIN_VALUE;;
					}
				}
				catch(Exception e)
				{
					System.out.println("Please enter a valid integer.");
					sc.next();
				}
			}
		
		return userCommand;
	}
	
	//gets an integer with a lower and upper bound from the user
	public int getIntFromScanner(int lower, int upper)
	{
		int userCommand = Integer.MIN_VALUE;
		
		if(lower <= upper && lower != Integer.MIN_VALUE)
		{
			while(userCommand == Integer.MIN_VALUE)
			{
				try
				{
					userCommand = sc.nextInt();

					if(userCommand < lower || userCommand > upper)
					{
						System.out.println("Please enter a value between " + lower + " and " + (upper) + ".");
						userCommand = Integer.MIN_VALUE;
					}
				
				}
				catch(Exception e)
				{
					System.out.println("Please enter a valid integer.");
					sc.next();
				}
			}
			
		}
		else
		{
			System.out.println("Invalid input. Lower limit must be smaller or equal to upper limit.");
		}
		
		return userCommand;
	}
	
	//gets a double from the user
	public double getDoubleFromScanner()
	{
		double userCommand = -1;
		
		while(userCommand == -1)
		{
			try
			{
				userCommand = sc.nextDouble();
			}
			catch(Exception e)
			{
				System.out.println("Please enter a valid double.");
				sc.next();
			}
		}
		
		return userCommand;
	}
	
	//gets an double with a lower bound from the user
	public double getDoubleFromScanner(double lower)
	{
		double userCommand = Double.MIN_VALUE;
		
		while(userCommand < (lower+1))
		{
			try
			{
				userCommand = sc.nextDouble();
				
				if(userCommand < lower)
				{
					System.out.println("Please enter a value higher than " + lower + ".");
					userCommand = Double.MIN_VALUE;
				}
			}
			catch(Exception e)
			{
				System.out.println("Please enter a valid double.");
				sc.next();
			}
		}
		
		return userCommand;
	}
	
	//gets a string from the user
	public String getStringFromScanner()
	{
		String userCommand = "";
		
		while(userCommand.length() <=0)
		{
			userCommand = sc.nextLine();
		}

		return userCommand;
	}
	
	//gets a string from the user with a minimum length
	public String getStringFromScanner(int length)
	{
		String userCommand = "";
		
		if(length > 0)
		{			
			while(userCommand.length() < length)
			{
				userCommand = sc.nextLine();
				
				if(userCommand.length() < length)
				{
					System.out.println("The length must be greater than or equal to " + length + " characters.");
				}
			}
		}
		else
		{
			System.out.println("Invalid length specified");
		}
		
		return userCommand;
	}
	
	//gets string from the scanner. User can only select from the array of strings
	public String getStringFromScanner(String[] strings)
	{
		String userCommand = "";
		boolean exists = false;
		
		while(userCommand.length() <=0 || !exists)
		{
			userCommand = sc.nextLine();
			
			for(int i = 0; i < strings.length && !exists; i++)
			{
				if(userCommand.equals(strings[i]))
				{
					exists = true;
				}
			}
			
			if(userCommand.length() <=0 || !exists)
			{
				System.out.println("Please enter a valid input.");
			}
		}
		
		return userCommand;
	}
	
	//gets a string from the user that follows the phone number format
	public String getPhoneNumberFromScanner()
	{
		boolean phoneNumber = false;
		String userCommand = "";

		while(!phoneNumber)
		{
			phoneNumber = true;
			userCommand = sc.nextLine();
			if(userCommand.length() == 9)
			{
				for(int i = 0; i < userCommand.length(); i++)
				{
					if(userCommand.charAt(i) < '0' || userCommand.charAt(i) > '9')
					{
						phoneNumber = false;
					}
				}
			}
			else
			{
				phoneNumber = false;
			}
			if(!phoneNumber)
			{
				System.out.println("You have entered an invalid phone number. Enter a 9 digit number.");
			}
		}

		return userCommand;
	}
}
