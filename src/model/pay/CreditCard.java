package model.pay;

import model.people.Customer;

public class CreditCard {

	private String creditCardID;
	private String cardHolderID; // for verification
	private String pin;
	private double balance;
<<<<<<< HEAD
	private int loyaltyPoints;
	private Customer belongsTo;

	public CreditCard(String creditCardID, double balance, int loyaltyPoints, Customer belongsTo) {
		this.creditCardID = creditCardID;
		this.balance = balance;
		this.loyaltyPoints = loyaltyPoints;
	}
	
	public String getCreditCardID() {
		return creditCardID;
	}
	
=======
	
	public CreditCard(String creditCardID, Customer cardHolder, String pin)
	{
		this.creditCardID = creditCardID;
		this.cardHolderID = cardHolder.getCustomerID();
		this.pin = pin;
	}
	
	public String getCreditCardID()
	{
		return creditCardID;
	}
	
	public String getCardHolder()
	{
		return cardHolderID;
	}
	
	public String getPin() {
		return pin;
	}
	
>>>>>>> 2e34ca331e4475a47e7f94657279b4fa7f2c4dd4
	public double getBalance() {
		return balance;
	}

	public double getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
<<<<<<< HEAD
	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	
	// TODO
=======
	public void addBalance(double topup)
	{
		this.balance += topup;
	}
	
	public void deductBalance(double deductAmount)
	{
		this.balance += deductAmount;
	}
	
>>>>>>> 2e34ca331e4475a47e7f94657279b4fa7f2c4dd4
}
