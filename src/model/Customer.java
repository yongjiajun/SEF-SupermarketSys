package model;

public class Customer {

	private String id;
	private int loyaltyPts;

	public Customer(String id, int loyaltyPts) {
		this.id = id;
		this.loyaltyPts = loyaltyPts; // defaults to 0 for new customers
	}

	public String getId() {
		return id;
	}

	public int getLoyaltyPts() {
		return loyaltyPts;
	}

	public void setLoyaltyPts(int loyaltyPts) {
		this.loyaltyPts = loyaltyPts;
	}

}
