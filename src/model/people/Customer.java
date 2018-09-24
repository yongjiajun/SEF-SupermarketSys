package model.people;

public class Customer extends User{

	private int loyaltyPts;

	public Customer(String customerID, String customerPIN, String customerFName, String customerLName) {
		super(customerID, customerPIN, customerFName, customerLName);
		this.loyaltyPts = 0;
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
