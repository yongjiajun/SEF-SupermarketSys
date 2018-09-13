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
		Product product = new Product(productID, productName, productPrice, productQuantity);
		printProduct(product);
	}

	public void printProduct(Product product) {
		product.toString();
	}
}
