package model.pay;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;

import model.Product;
=======
import java.util.*;
>>>>>>> 2e34ca331e4475a47e7f94657279b4fa7f2c4dd4

import model.system.Product;

<<<<<<< HEAD
//	private List <Integer, Product> productInformation = new HashMap<Integer,Product>();
//	
//	public boolean addItem(int quantity, Product product)
//	{
//		if (productInformation.containsValue(product)) {
//			
//		}
//		return false;
//		
//	}
=======
public class SalesLineItem {
	
	private int quantity;
	private Product product;
	
	public SalesLineItem(int quantity, Product product)
	{
		this.quantity = quantity;
		this.product = product;
	}
	
	public int getProductQuantity()
	{
		return quantity;
	}
	
	public Product getProduct()
	{
		return product;
	}
	
	public void setProductQuantity (int quantity)
	{
		this.quantity = quantity;
	}
	
	public double getItemPrice()
	{
		return product.getProductPrice();
	}
	
	public double getTotalPrice()
	{
		if (product.getBulkSalesEligible() == true && quantity >= product.getBulkSalesQty())
		{
			return (product.getProductPrice()*quantity)*(1-product.getBulkSalesRate());
		}
		else if (product.getDiscountEligible() == true)
		{
			return (product.getProductPrice() * quantity) * (1- product.getDiscountRate());
		}
		else
			return product.getProductPrice()*quantity;
	}
>>>>>>> 2e34ca331e4475a47e7f94657279b4fa7f2c4dd4
	
}
