package com;
import java.util.ArrayList;

/***************************************************
 * @author 1319252
 * @date July 25th, 2016
 * @version 1.0
 **************************************************/
public class Customer 
{	
	String name;
	String contactNumber;
	String address;
	String id;
	String nominee;
	ArrayList<Policy> policiesTagged;
	
	public Customer(String name, String contactNumber, String address, String id, String nominee)
	{
		this.name = name;
		this.contactNumber = contactNumber;
		this.address = address;
		this.id = id;
		policiesTagged = new ArrayList<Policy>();
		this.nominee = nominee;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getContactNumber() 
	{
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) 
	{
		this.contactNumber = contactNumber;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public ArrayList<Policy> getPoliciesTagged() 
	{
		return this.policiesTagged;
	}
	
	public void addPolicy(Policy policy)
	{
		this.policiesTagged.add(policy);
	}
	
	public String getNominee() 
	{
		return nominee;
	}
	
	public void setNominee(String nominee) 
	{
		this.nominee = nominee;
	}
	
}
