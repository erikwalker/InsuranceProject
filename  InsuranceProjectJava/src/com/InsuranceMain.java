package com;

/***************************************************
 * @author 1319252
 * @date July 25th, 2016
 * @version 1.0
 **************************************************/
public class InsuranceMain
{
	public static void main(String[] args)
	{
		int command = -1;
		ValidatedInput validation = new ValidatedInput();
		InsuranceLogic insuranceLogic = new InsuranceLogic();
		
		//checks the user input for a number corresponding to the available actions
		while(command != 11 || command != -1)
		{
			//List of commands user can perform
			System.out.println("\nWelcome to the insurance policy management system.\n ");
			System.out.println("1 - Register policy " +
								"\n2 - Register customer " +
								"\n3 - View policies " +
								"\n4 - View customers " + 
								"\n5 - Tag customer to policy" +
								"\n6 - Search customer by name " + 
								"\n7 - Search customer by policy  " +
								"\n8 - Delete customer " +
								"\n9 - Delete policy " +	
								"\n10 - Update Customer" +
								"\n11 - Exit\n" );
			
			System.out.println("Please enter a value between 1 and 11.");
			
			command = validation.getIntFromScanner(1, 11);
			
			switch(command)
			{
			case 1: 
				insuranceLogic.registerPolicy();
				break;
			case 2:
				insuranceLogic.registerCustomer();
				break;
			case 3:
				insuranceLogic.viewPolicies();
				break;
			case 4:
				insuranceLogic.viewCustomers();
				break;
			case 5:
				insuranceLogic.tagCustomer();
				break;
			case 6:
				insuranceLogic.searchCustomerByName();
				break;
			case 7:
				insuranceLogic.searchCustomerByPolicy();
				break;
			case 8:
				insuranceLogic.deleteCustomer();
				break;
			case 9:
				insuranceLogic.deletePolicy();
				break;
			case 10:
				insuranceLogic.updateCustomer();
				break;
			case 11:
				System.out.println("System is now exiting.");
				System.exit(0);
				break;
			}
		}
	}
}

