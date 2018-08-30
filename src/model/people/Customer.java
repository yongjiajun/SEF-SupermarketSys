package model.people;

public class Customer {

	private String customerID, customerPIN, customerFName, customerLName;
	private int loyaltyPts;

	public Customer(String customerID, String customerPIN, String customerFName, String customerLName) {
		this.customerID = customerID;
		this.customerPIN = customerPIN;
		this.customerFName = customerFName;
		this.customerLName = customerLName;
		this.loyaltyPts = 0;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerPIN() {
		return customerPIN;
	}

	public String getCustomerFName() {
		return customerFName;
	}

	public String getCustomerLName() {
		return customerLName;
	}

	public int getLoyaltyPts() {
		return loyaltyPts;
	}

	public void addLoyaltyPts(int pts) {
		this.loyaltyPts += pts;
	}

	public void deductLoyaltyPts(int pts) {
		this.loyaltyPts -= pts;
	}

}
