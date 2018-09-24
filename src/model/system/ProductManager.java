package model.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class ProductManager {

	private HashMap<String, Product> products = new HashMap<String, Product>();

	public void initialiseProducts()
	{
		try {
	         FileInputStream fileIn = new FileInputStream("database/products.ser");
	         ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	         products = (HashMap<String, Product>) objectIn.readObject();
	         System.out.println("Products are loaded from database!");
	         objectIn.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Product class not found");
	         c.printStackTrace();
	         return;
	      }
	}
	
	// always call this function after adding/modifying products / before shutdown
	public void saveProducts()
	{
		try {
	         FileOutputStream fileOut = new FileOutputStream("database/products.ser");
	         ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	         objectOut.writeObject(products);
	         objectOut.close();
	         fileOut.close();
	         System.out.println("Products are saved to database!");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public boolean addProduct(Product product)
	{
		if (products.containsKey(product.getProductId()))
		{
			System.out.println("Product " + product.getProductId() + " already exists in database!");
			return false;
		}
		else
		{
			products.put(product.getProductId(), product);
			System.out.println("Product " + product.getProductId() + " added into database!");
			return true;
		}
	}
	
	public boolean removeProduct(String productID)
	{
		if (products.containsKey(productID))
		{
			products.remove(productID);
			return true;
		}
		else
		{
			System.out.println("Product " + productID + " doesn't exist in database!");
			return false;
		}
	}
	
	public Product getProduct(String productID) {
		if (products.containsKey(productID))
		{
			return products.get(productID);
		}
		else
		{
			System.out.println("Product " + productID + " doesn't exist in database!");
			return null; // UI Verification!
		}
	}
	
}
