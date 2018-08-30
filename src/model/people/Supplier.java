package model.people;

public class Supplier {
	
	private String supplierID, supplierPIN, supplierFName, supplierLName, supplierCompanyName, supplierContactNo, supplierEmail, supplierLocation;

	public Supplier(String supplierID, String supplierPIN, String supplierFName, String supplierLName,
			String supplierCompanyName, String supplierContactNo, String supplierEmail, String supplierLocation) {
		this.supplierID = supplierID;
		this.supplierPIN = supplierPIN;
		this.supplierFName = supplierFName;
		this.supplierLName = supplierLName;
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

	public String getSupplierCompanyName() {
		return supplierCompanyName;
	}

	public String getSupplierContactNo() {
		return supplierContactNo;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public String getSupplierLocation() {
		return supplierLocation;
	}
}