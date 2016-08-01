package com;

/***************************************************
 * @author 1319252
 * @date July 25th, 2016
 * @version 1.0
 **************************************************/
public class Policy 
{
	int policyNumber;
	String policyName;
	String modeOfPayment;
	double committedAmount;
	
	public Policy(int policyNumber, String policyName, String modeOfPayment, double committedamount)
	{
		this.policyNumber = policyNumber;
		this.policyName = policyName;
		this.modeOfPayment = modeOfPayment;
		this.committedAmount = committedamount;
	}
	
	public int getPolicyNumber() 
	{
		return policyNumber;
	}
	
	public void setPolicyNumber(int policyNumber) 
	{
		this.policyNumber = policyNumber;
	}
	
	public String getPolicyName() 
	{
		return policyName;
	}
	
	public void setPolicyName(String policyName) 
	{
		this.policyName = policyName;
	}
	
	public String getModeOfPayment() 
	{
		return modeOfPayment;
	}
	
	public void setModeOfPayment(String modeOfPayment) 
	{
		this.modeOfPayment = modeOfPayment;
	}
	
	public double getCommittedAmount() 
	{
		return committedAmount;
	}
	
	public void setCommittedAmount(double committedAmount) 
	{
		this.committedAmount = committedAmount;
	}
}
