package test.cases;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import model.system.Product;
class ProductTest {

	HashMap<String, Product> products = new HashMap<String, Product>();
	Product apple = new Product("Apple", 100, "1", 1.99);

	@Test
	public void addProductTest() {
//	(String productName, int stockQty, String productID, double productPrice)

   		products.put("1", apple);

  		assertEquals(apple.getProductName(), "Apple");
  		assertEquals(apple.getStockQty(), 100);
  		assertEquals(apple.getProductId(), "1");
  		assertEquals(apple.getProductPrice(), 1.99);

	}
	@Test
	public void changeProductPrice() {
		apple.setProductPrice(0.99);
 		assertEquals(apple.getProductPrice(), 0.99);
	}

	@Test
	public void checkDiscountRate() {
		apple.setProductPrice(1000);
		apple.setDiscountedPrice(10);
		assertEquals(apple.getDiscountedPrice(), 900);
 	}

}
