package test.cases;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.people.*;
import model.system.*;

class SupplierTest {
	/* public Supplier(String supplierID, String supplierPIN, String supplierFName, String supplierLName, 
	String supplierCompanyName, String supplierContactNo, String supplierEmail, String supplierLocation) */
	
	private Supplier supp;
	private Product prod;
	
	@BeforeEach
	public void init() {
		supp = new Supplier("s1234", "1234", "fName", "lName", "cName", "0412345678", "supplier@email.com", "Australia");
		assertTrue(supp != null);
	}
	
	@Test
	void testMethods() {
		assertEquals(supp.getSupplierID(), "s1234");
		assertEquals(supp.getSupplierPIN(), "1234");
		assertEquals(supp.getSupplierFName(), "fName");
		assertEquals(supp.getSupplierLName(), "lName");
		assertEquals(supp.getSupplierCompanyName(), "cName");
		assertEquals(supp.getSupplierContactNo(), "0412345678");
		assertEquals(supp.getSupplierLocation(), "Australia");
	}
	
	@Test 
	void testProductStock() {
		prod = new Product("Product", 500, "PROD", 5.0);
		assertTrue(prod != null);
		
		prod.setReorderQty(100);
		prod.setRestockLvl(250);
		assertEquals(prod.getReorderQty(), 100);
		assertEquals(prod.getRestockLvl(), 250);
	}

}
