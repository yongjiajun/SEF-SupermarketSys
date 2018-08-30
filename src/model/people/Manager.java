package model.people;

import model.system.Product;

public class Manager extends Employee {

	public Manager(String employeeID, String employeePIN, String employeeFName, String employeeLName) {
		super(employeeID, employeePIN, employeeFName, employeeLName);
	}

	public void setProductQuantity(Product product, int quantity) {
		if (quantity > product.getStockQty()) {
			product.addStockQty(quantity - product.getStockQty());
		} else {
			product.reduceStockQty(product.getStockQty() - quantity);
		}
	}

	public void setProductName(Product product, String name) {
		product.setProductName(name);
	}

	public void setProductPrice(Product product, double price) {
		product.setProductPrice(price);
	}

	public Boolean checkDiscountApplicable(Product product) {
		return product.getDiscountEligible();
	}

	public void setDiscount(Product product, double percentage) {
		product.setDiscountRate(percentage);
	}

	// Make this function void or String? Also should there just be a function in
	// supplier to return details and here we just call that method e.g.
	// supplier.getDetails();
	public String getSupplierDetails(Supplier supplier) {
		String info = String.format("Name: %s %s\nID: %s\nCompany: %s\nPhone: %s\nLocation: %s\nEmail: %s\n",
				supplier.getSupplierFName(), supplier.getSupplierLName(), supplier.getSupplierID(),
				supplier.getSupplierCompanyName(), supplier.getSupplierContactNo(), supplier.getSupplierLocation(),
				supplier.getSupplierEmail());

		return info;
	}
}
