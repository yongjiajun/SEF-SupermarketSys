package test.cases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.pay.CheckoutCart;
import model.pay.SalesLineItem;
import model.people.Customer;
import model.people.Manager;
import model.people.SalesStaff;
import model.people.Supplier;
import model.system.Product;

class ManagerTest {
	
	private Customer c1, c2, c3;
	private Manager m1;
	private SalesStaff s1;
	private Supplier p1;
	
	private Product apple, orange, iceCream;
	
	private CheckoutCart cart;
	private SalesLineItem item;

	@BeforeEach
	public void setUp() {
		c1 = new Customer("C000", "0000", "Casey", "Customer");
		c2 = new Customer("C111", "1111", "Clein", "Customer");
		c3 = new Customer("C222", "2222", "Catherine", "Customer");
		c3.addLoyaltyPts(100);
		
		m1 = new Manager("M111", "1111", "Matthew", "Manager");
		s1 = new SalesStaff("S222", "2222", "Stephanie", "SalesStaff");
		p1 = new Supplier("P333", "3333", "Peter", "Supplier", "CompName", "CompLoc", "CompEmail", "CompPhone");
		
		apple = new Product("Apple", "APPLE", 0.8, 1000);
		apple.setBulkSales(0.1, 10);
		
		orange = new Product("Orange", "ORANGE", 1, 500);
		
		iceCream = new Product("IceCream", "ICECREAM", 8, 50);
		iceCream.setDiscountRate(.2);
	}

	// Suggested Test Cases For Milestone 1
	@Test
	public void milestoneTest() {
		// 1. Confirms that the product quantity will reduce when a sale is made
		cart = new CheckoutCart();
		item = new SalesLineItem(20, apple);
		cart.addLineItem(item);
		cart.pay(c1);
		assertEquals(apple.getStockQty(), 980);
		
		// 2. Confirms that stock increases when replenished
		apple.addStockQty(1020);
		assertEquals(apple.getStockQty(), 2000);
		
		// 3. Confirms that sale price is computed correctly
		cart = new CheckoutCart();
		item = new SalesLineItem(10, orange);
		cart.addLineItem(item);
		item = new SalesLineItem(2, iceCream);
		cart.addLineItem(item);
		item = new SalesLineItem(20, apple);
		cart.addLineItem(item);
		assertEquals(cart.getTotalPrice(), 37.2);
		
		// 4. Confirms that sale price is computed correctly for discounted items
		cart = new CheckoutCart();
		item = new SalesLineItem(2, iceCream);
		cart.addLineItem(item);
		assertEquals(cart.getTotalPrice(), 12.8);
		
		// 5. Confirms that sale price is computed correctly for bulk sale items
		cart = new CheckoutCart();
		item = new SalesLineItem(20, apple);
		cart.addLineItem(item);
		assertEquals(cart.getTotalPrice(), 14.4);
		
		// 6. Confirms that sale price is computed correctly for normal priced item
		cart = new CheckoutCart();
		item = new SalesLineItem(10, orange);
		cart.addLineItem(item);
		assertEquals(cart.getTotalPrice(), 10);
		
		// 7. Confirms that customer receives the right amount of loyalty points
		cart = new CheckoutCart();
		item = new SalesLineItem(30, orange);
		cart.addLineItem(item);
		item = new SalesLineItem(6, iceCream);
		cart.addLineItem(item);
		item = new SalesLineItem(42, apple);
		cart.addLineItem(item);
		cart.pay(c2);
		assertEquals(c2.getLoyaltyPts(), 9);
		
		// 8. Confirms that discounts are computed correctly when loyalty points are combined with normal priced items
		cart = new CheckoutCart();
		item = new SalesLineItem(10, orange);
		cart.addLineItem(item);
		assertEquals(c3.getLoyaltyPts(), 100);
		assertEquals(cart.getTotalDiscountedPrice(c3), 0);
		cart.pay(c3);
		assertEquals(c3.getLoyaltyPts(), 60);
		
		// 9. Confirms that discounts are computed correctly when loyalty points are combined with bulk sale items
		cart = new CheckoutCart();
		item = new SalesLineItem(100, apple);
		cart.addLineItem(item);
		c3.addLoyaltyPts(40);
		assertEquals(c3.getLoyaltyPts(), 100);
		assertEquals(cart.getTotalDiscountedPrice(c3), 47);
		cart.pay(c3);
		assertEquals(c3.getLoyaltyPts(), 4);
		
		// 10. Confirms that discounts are computed correctly when loyalty points are combined with discounted items
		cart = new CheckoutCart();
		item = new SalesLineItem(10, iceCream);
		cart.addLineItem(item);
		c3.addLoyaltyPts(96);
		assertEquals(c3.getLoyaltyPts(), 100);
		assertEquals(cart.getTotalDiscountedPrice(c3), 39);
		cart.pay(c3);
		assertEquals(c3.getLoyaltyPts(), 3);
	}
	
	// My Obligations
	@Test
	public void myTest() {
		// Confirms that manager can change product name
		assertEquals(apple.getProductName(), "Apple");
		m1.setProductName(apple, "Green Apple");
		assertEquals(apple.getProductName(), "Green Apple");

		// Confirms that manager can change product quantity
		assertEquals(apple.getStockQty(), 1000);
		m1.setProductQuantity(apple, 500);
		assertEquals(apple.getStockQty(), 500);

		// Confirms that manager can change product price
		assertEquals(apple.getProductPrice(), 0.8);
		m1.setProductPrice(apple, 0.5);
		assertEquals(apple.getProductPrice(), 0.5);

		// Confirms that manager can check if product is on a discount
		assertFalse(apple.getDiscountEligible());
		
		// Confirms that manager can change product discount
		assertFalse(apple.getDiscountEligible());
		m1.setProductDiscount(apple, 0.1);
		assertEquals(apple.getDiscountRate(), 0.1);
	}
	
	@AfterEach
	public void tearDown() {
		
	}

}
