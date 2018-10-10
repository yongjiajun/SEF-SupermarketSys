package model.people;

public class Supplier {

	private String supplierCompanyName, supplierContactNo, supplierEmail, supplierLocation;
	
	public Supplier(String supplierCompanyName, String supplierContactNo, String supplierEmail, String supplierLocation)
	{
		this.supplierCompanyName = supplierCompanyName;
		this.supplierContactNo = supplierContactNo;
		this.supplierEmail = supplierEmail;
		this.supplierLocation = supplierLocation;
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