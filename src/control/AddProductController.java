package control;

import model.system.Product;
import view.ManagerPanel;

public class AddProductController {

	private Product productModel;
	private ManagerPanel view;

	public AddProductController(ManagerPanel view) {
		this.view = view;
	}

	public void addItems(String productID, String productName, double productPrice, int productQuantity) {
		Product[] products = new Product[0];
		Product newProduct = new Product(productID, productName, productPrice, productQuantity);
		products = addProduct(products, newProduct);

		printProduct(newProduct);
	}

	private static Product[] addProduct(Product[] products, Product productToAdd) {
	    Product[] newProducts = new Product[products.length + 1];
	    System.arraycopy(products, 0, newProducts, 0, products.length);
	    newProducts[newProducts.length - 1] = productToAdd;

	    return newProducts;
	}


	private void printProduct(Product product) {
 		System.out.println(product.toString());
	}

	public String getProductName() {
		return productModel.getProductName();
	}

	public String getProductID() {
		return productModel.getProductId();
	}

	public Double getProductPrice() {
		return productModel.getProductPrice();
	}

	public int getProductQuantity() {
		return productModel.getStockQty();
	}

}
