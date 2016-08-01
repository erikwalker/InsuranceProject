package com;
import java.util.ArrayList;

/***************************************************
 * @author 1319252
 * @date July 25th, 2016
 * @version 1.0
 **************************************************/
public class InsuranceLogic 
{
	ValidatedInput validation = new ValidatedInput();
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Policy> policyList = new ArrayList<Policy>();
	int idCounter = 101;
	
	public void registerPolicy()
	{
		int policyNumber;
		String policyName;
		String modeOfPayment;
		double committedAmount;
		boolean canAdd = true;

		System.out.println("Please enter the policy number. The number must be no longer than 6 digits:");
		policyNumber = validation.getIntFromScanner(0, 1000000);
		
		System.out.println("Please enter the name policy name: ");
		policyName = validation.getStringFromScanner();
		
		System.out.println("Please enter the mode of payment. The mode of payments are: monthly, quarterly, half-yearly, and annually");
		modeOfPayment = validation.getStringFromScanner(InsuranceConstants.MODES_OF_PAYMENT);
		
		System.out.println("Please enter the committed amount: ");
		committedAmount = validation.getDoubleFromScanner(0);
		
		for(Policy p: policyList)
		{
			if(p.getPolicyName().equals(policyName))
			{
				canAdd = false;
			}
		}
		
		if(canAdd)
		{
			policyList.add(new Policy(policyNumber, policyName, modeOfPayment, committedAmount));
			System.out.println("The policy has been added successfully.");
		}
		else
		{
			System.out.println("Could not add policy; a policy with that name already exists.");
		}
	}
	
	public void registerCustomer()
	{
		String name;
		String contactNumber;
		String address;
		String id;
		String nominee;
		boolean canAdd = true;
		
		System.out.println("Please enter the customer name: ");
		name = validation.getStringFromScanner(3);
		
		System.out.println("Please enter the customers contact number. The phone number must include the area code and not include any special characters.");
		contactNumber = validation.getPhoneNumberFromScanner();
		
		System.out.println("Please enter the customers contact address: ");
		address = validation.getStringFromScanner();
		
		System.out.println("Please enter the name of the nominee: ");
		nominee = validation.getStringFromScanner();
		
		for(Customer c: customerList)
		{
			if(c.getName().equals(name))
			{
				canAdd = false;
			}
		}
		
		if(canAdd)
		{
			id = generateId(name);
			idCounter++;
			customerList.add(new Customer(name, contactNumber, address, id, nominee));
			System.out.println("The customer has been added successfully.");
		}
		else
		{
			System.out.println("Could not add customer; a customer with that name already exists.");
		}
	}
	
	public String generateId(String name)
	{
		return name.substring(0,3) + idCounter;
	}
	
	public void viewPolicies()
	{
		if(policyList.size() > 0)
		{
			System.out.println("Available policies: ");
			
			for (Policy p: policyList) 
			{
				System.out.println("-----------------------------------------------------------------------------------------------------");
				System.out.printf("%-25s%-25s%-25s%-25s\n", "Policy Number:", "Policy Name:", "Mode of Payment:", "Committed Amount:");
				System.out.printf("%06d%-19s%-25s%-25s%-25s",  p.getPolicyNumber(), " ", p.getPolicyName(), p.getModeOfPayment(), p.getCommittedAmount());
				System.out.println("\n\nTagged Customers:");
				
				for(Customer c: customerList)
				{
					for(Policy pc: c.getPoliciesTagged())
					{
						if(pc.getPolicyName().equals(p.getPolicyName()))
						{
							System.out.printf("%-25s\n", c.getName());
						}
					}
				}
			}
			
			System.out.println("-----------------------------------------------------------------------------------------------------");
		}
		else
		{
			System.out.println("There are currently no policies.");
		}
	}
	
	public void viewCustomers()
	{
		if(customerList.size() > 0)
		{
			System.out.println("Customer List:");
			
			for (Customer c: customerList) 
			{
				System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Customer Name", "Contact Number", "Address", "Id", "Nominee");
				System.out.printf("%-25s%-25s%-25s%-25s%-25s", c.getName(), c.getContactNumber(), c.getAddress(), c.getId(), c.getNominee());
				System.out.println("\n\nPolicies Tagged:");
				
				for(Policy p: c.getPoliciesTagged())
				{
					System.out.printf("%-25s\n", p.getPolicyName());
				}
			}
			
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		}
		else
		{
			System.out.println("There are currently no customers");
		}
	}
	
	public void tagCustomer()
	{
		Customer customer = null;
		Policy policy = null;
		
		if(customerList.size() > 0 && policyList.size() > 0)
		{
			System.out.println("Please choose from the list of customers you would like to add a policy: ");
			viewCustomers();
			
			try
			{
				customer = getCustomer();
				System.out.println("Please choose from the list of policies you would like to tag the customer: ");
				viewPolicies();
				
				try
				{
					policy = getPolicy();
				
					if(customer.getPoliciesTagged().contains(policy))
					{
						System.out.println("Customer already has that policy.");
					}
					else
					{
						customer.addPolicy(policy);
						System.out.println("Policy successfully added to customer");
					}
				}
				catch(PolicyNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
			}
			catch(CustomerNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("Unable to tag policy. At least one customer and one policy must exist.");
		}
		
	}
	
	public void searchCustomerByName()
	{
		Customer c;
		System.out.println("Please enter the customer name: ");
		
		try
		{
			c = getCustomer();
			
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.printf("%-25s%-25s%-25s%-25s\n", "Customer Name", "Contact Number", "Address", "Id");
			System.out.printf("%-25s%-25s%-25s%-25s\n", c.getName(), c.getContactNumber(), c.getAddress(), c.getId());
			System.out.println("Policies Tagged:");
			
			for(Policy p: c.getPoliciesTagged())
			{
				System.out.printf("%-25s\n", p.getPolicyName());
			}
			System.out.println("-----------------------------------------------------------------------------------------------------");
		}
		catch(CustomerNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void searchCustomerByPolicy()
	{
		Policy p;
		System.out.println("Please enter the policy name: ");
		try
		{
			p = getPolicy();
			if(customerList.size() > 0)
			{
				for(Customer c: customerList)
				{
					if(c.getPoliciesTagged().contains(p))
					{
						System.out.println("-----------------------------------------------------------------------------------------------------");
						System.out.printf("%-25s%-25s%-25s%-25s\n", "Customer Name", "Contact Number", "Address", "Id");
						System.out.printf("%-25s%-25s%-25s%-25s\n", c.getName(), c.getContactNumber(), c.getAddress(), c.getId());
						System.out.println("-----------------------------------------------------------------------------------------------------");
					}
				}
			}
		}
		catch(PolicyNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteCustomer()
	{
		if(customerList.size() > 0)
		{
			Customer c;
			System.out.println("Please enter the name of the customer you would like to delete from the list below. ");
			viewCustomers();
			
			try
			{
				c = getCustomer();

				if(c.getPoliciesTagged().size() == 0)
				{
					customerList.remove(c);
					System.out.println("Customer has been removed.");
				}
				else
				{
					System.out.println("There is a policy tagged to this customer. Remove policy before deleting customer.");
				}
			}
			catch(CustomerNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("There are no customers to delete.");
		}
	}
	
	public void deletePolicy()
	{		
		if(policyList.size() > 0)
		{
			Policy p;
			System.out.println("Please enter the name of the policy you would like to delete from the list below. ");
			viewPolicies();
			
			try
			{
				p = getPolicy();

				for(Customer c: customerList)
				{
					c.getPoliciesTagged().remove(p);
				}
				
				policyList.remove(p);
				System.out.println("Policy has been removed.");
				
			}
			catch(PolicyNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("There are no policies to delete.");
		}
	}
	
	public void updateCustomer()
	{
		String name;
		String contactNumber;
		String address;
		String nominee;
		
		if(customerList.size() > 0)
		{
			Customer c;
			System.out.println("Please enter the name of the customer you would like to update from the list below. ");
			viewCustomers();
			
			try
			{
				c = getCustomer();
				
				System.out.println("Please enter the customer name: ");
				name = validation.getStringFromScanner(3);
				
				System.out.println("Please enter the customers contact number. The phone number must include the area code and not include any special characters.");
				contactNumber = validation.getPhoneNumberFromScanner();
				
				System.out.println("Please enter the customers contact address: ");
				address = validation.getStringFromScanner();
				
				System.out.println("Please enter the name of the nominee: ");
				nominee = validation.getStringFromScanner();
				
				c.setName(name);
				c.setContactNumber(contactNumber);
				c.setAddress(address);
				c.setNominee(nominee);
				
				System.out.println("Customer has been updated.");
			}
			catch(CustomerNotFoundException e)
			{
				System.out.print(e.getMessage());
			}
		}
		else
		{
			System.out.println("There are no customers to update.");
		}
	}
	
	private Customer getCustomer() throws CustomerNotFoundException
	{
		String customerName;
		Customer customer = null;
		
		customerName = validation.getStringFromScanner();
		for(Customer c: customerList)
		{
			if(c.getName().equals(customerName))
			{
				customer = c;
			}
		}
		
		if(customer == null)
		{
			throw new CustomerNotFoundException();
		}
		
		return customer;
	}
	
	private Policy getPolicy() throws PolicyNotFoundException
	{
		String policyName;
		Policy policy = null;

		policyName = validation.getStringFromScanner();
			
		for(Policy p: policyList)
		{
			if(p.getPolicyName().equals(policyName))
			{
				policy = p;
			}
		}
		
		if(policy == null)
		{
			throw new PolicyNotFoundException();
		}
		return policy;
	}
}
