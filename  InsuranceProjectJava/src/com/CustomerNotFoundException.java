package com;

/***************************************************
 * @author 1319252
 * @date July 25th, 2016
 * @version 1.0
 **************************************************/
public class CustomerNotFoundException extends Exception
{
	public String getMessage()
	{
		return "The customer does not exist.";
	}
}
