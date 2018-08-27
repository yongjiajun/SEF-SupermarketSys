package model.people;

public class Supplier {

	private String supplierCompanyName;
	private String supplierContactNo;
	private String supplierEmail;
	private String supplierLocation;
	private String supplierFName;
	private String supplierLName;
	private String supplierID;
	private String supplierPIN;
	
	public Supplier(String supplierFName, String supplierLName, String supplierID, String supplierPIN,
			String supplierCompanyName, String supplierContactNo, String supplierEmail,
			String supplierLocation) {
		this.supplierFName = supplierFName;
		this.supplierLName = supplierLName;
		this.supplierID = supplierID;
		this.supplierPIN = supplierPIN;
		this.supplierCompanyName = supplierCompanyName;
		this.supplierContactNo = supplierContactNo;
		this.supplierEmail = supplierEmail;
		this.supplierLocation = supplierLocation;
	}
	
	public String getSupplierFName() {
		return supplierFName;
	}

	public String getSupplierLName() {
		return supplierLName;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public String getSupplierPIN() {
		return supplierPIN;
	}

	public String getSupplierCompanyName()
	{
		return supplierCompanyName;
	}
	
	public String getSupplierContactNo()
	{
		return supplierContactNo;
	}
	
	public String getSupplierEmail() {
		return supplierEmail;
	}
	
	public String getSupplierLocation() {
		return supplierLocation;
	}
}