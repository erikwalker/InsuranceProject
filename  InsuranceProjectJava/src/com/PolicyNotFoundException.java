package com;

/***************************************************
 * @author 1319252
 * @date July 25th, 2016
 * @version 1.0
 **************************************************/
public class PolicyNotFoundException extends Exception
{
	public String getMessage()
	{
		return "The policy does not exist.";
	}
}
