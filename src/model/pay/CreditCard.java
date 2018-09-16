package model.pay;

import model.people.Customer;

public class CreditCard {

	private String creditCardID;
	private String cardHolderID; // for verification
	private String pin;
	private double balance;
	private int loyaltyPoints;

	public CreditCard(String creditCardID, Customer cardHolder, String pin) {
		this.creditCardID = creditCardID;
		this.cardHolderID = cardHolder.getUserID();
		this.pin = pin;
		this.balance = 0;
	}

	public String getCreditCardID() {
		return creditCardID;
	}

	public String getCardHolderID() {
		return cardHolderID;
	}

	public String getPin() {
		return pin;
	}

	public double getBalance() {
		return balance;
	}

	public double getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public void addBalance(double topup) {
		this.balance += topup;
	}

	public void deductBalance(double deductAmount) {
		this.balance += deductAmount;
	}
}
