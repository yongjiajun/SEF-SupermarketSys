package model.pay;

import model.Customer;

public class CreditCard {

	private String creditCardID;
	private double balance;
	private int loyaltyPoints;
	private Customer belongsTo;
	
	public creditCardID(String creditCardID, double balance, int loyaltyPoints, Customer belongsTo)
	{
		this.creditCardID = creditCardId;
		this.balance = balance;
		this.loyaltyPoints = loyaltyPoints;
	}
	
	public double getLoyaltyPoints() {
		return loyaltyPoints;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public String getID()
	{
		
	}
	//TODO
}
