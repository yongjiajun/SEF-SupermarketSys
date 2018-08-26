package model.pay;

import java.util.*;

import model.system.Product;

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
	
}
