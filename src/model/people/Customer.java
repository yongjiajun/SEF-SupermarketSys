package model.people;

public class Customer {

	private String customerID;
	private String customerPIN;
	private String customerFName;
	private String customerLName;
	private String customerPhone;
	private int loyaltyPts;

	public Customer(String customerID, String customerPIN, String customerFName, String customerLName, 
			String customerPhone) {
		this.customerID = customerID;
		this.customerPIN = customerPIN;
		this.customerFName = customerFName;
		this.customerLName = customerLName;
		this.customerPhone = customerPhone;
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

	public String getCustomerPhone() {
		return customerPhone;
	}

	public int getLoyaltyPts() {
		return loyaltyPts;
	}

	public void addLoyaltyPts(int pts)
	{
		this.loyaltyPts += pts;
	}
	
	public void deductLoyaltyPts(int pts)
	{
		this.loyaltyPts -= pts;
	}

}
