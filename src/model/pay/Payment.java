package model.pay;

public class Payment {

	private double amount;
	private long paymentID;
	private long receiptNo;
	private boolean paymentSuccessful;
	
	//TODO When exactly is a Payment object created? After the transaction or before? Please refer to UML.
	
	public Payment(double amountPaid)
	{
		this.amount = amountPaid; // ?
	}
	
	
}
