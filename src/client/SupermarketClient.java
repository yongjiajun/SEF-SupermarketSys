package client;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.pay.CheckoutCart;
import model.pay.SalesLineItem;
import model.people.Customer;
import model.system.Product;
import view.MainMenu;

public class SupermarketClient {
	// TEST CASES GO HERE
	
	private Product kleenex, bignut, tv;
	private Customer john;
	private CheckoutCart cartA, cartB;
	private SalesLineItem item;
	
	@Before
	public void init()
	{
		john = new Customer("john123", "1234", "Lil", "John");
		kleenex = new Product("Kleenex", 183, "KLEEN123" , 2.99);
		bignut = new Product("Big Nut", 12, "BIGNUT12", 5.00);
		tv = new Product("Sony 8K FULL XD TV", 2, "XDTV1233", 29999);
		tv.setDiscountRate(0.2);
		kleenex.setBulkSales(0.2, 20);
	}
	
	@Test
	public void test()
	{
		cartA = new CheckoutCart();
		item = new SalesLineItem(2, tv);
		cartA.addLineItem(item);
		assertEquals(cartA.getLoyaltyPtsEarned(john), 4799);
		assertEquals(cartA.getLoyaltyPtsUsed(john), 0);
		cartA.pay(john);
		cartB = new CheckoutCart();
		item = new SalesLineItem(12, bignut);
		cartB.addLineItem(item);
		item = new SalesLineItem(21, kleenex);
		cartB.addLineItem(item);
		System.out.println(cartB.getLoyaltyPtsUsed(john));
		System.out.println(cartB.getTotalDiscountedPrice(john));
		assertEquals(cartB.getLoyaltyPtsEarned(john), 11);
		System.out.println(cartB.getLoyaltyPtsUsed(john));
		cartB.pay(john);
	}
	
	@After
	public void term()
	{
		assertEquals(john.getLoyaltyPts(), 11);
		assertEquals(kleenex.getStockQty(), 162);
		assertEquals(bignut.getStockQty(), 0);
	}
}
