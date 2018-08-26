package model.pay;

import model.Customer;

public class CreditCard {

	private String creditCardID;
	private double balance;
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
	
	public double getBalance() {
		return balance;
	}

	public double getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	
	// TODO
}
