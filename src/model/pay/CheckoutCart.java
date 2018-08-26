package model.pay;

import java.util.*;

import model.people.Customer;
import model.system.Product;

public class CheckoutCart {
	
	private ArrayList<SalesLineItem> lineItems = new ArrayList<SalesLineItem>();
	private boolean paid = false;
	private long orderID; // get latest ID from array, orderID++ automatically with the constructor?
	private double totalPrice;
	private int loyaltyPtsUsed;
	private int loyaltyPtsEarned;
	private double totalDiscountedPrice;
	
	public CheckoutCart(){
		//TODO orderID
	}
	
	public ArrayList<SalesLineItem> getSalesLineItems() {
		return lineItems; // for view
	}
	
	public double getTotalPrice()
	{
		for(int i = 0; i < lineItems.size(); i++)
		{
			totalPrice += lineItems.get(i).getTotalPrice();
		}
		return totalPrice;
	}
	
	public double getTotalDiscountedPrice(Customer customer)
	{
		int pts = customer.getLoyaltyPts();
		totalDiscountedPrice = getTotalPrice();
		while (pts >= 20)
		{
			totalDiscountedPrice -= 5;
			pts -= 20;
		}
		return totalDiscountedPrice;
	}
	
	
	public int getLoyaltyPtsUsed()
	{
		double tempPrice = getTotalPrice();
		tempPrice -= totalDiscountedPrice;
		int tempPtsUsed = 0;
		while (tempPrice != 0)
		{
			tempPrice -= 5;
			tempPtsUsed += 20;
		}
		return tempPtsUsed;
	}
	
	public int getLoyaltyPtsEarned(Customer customer)
	{
		int tempPts = 0;
		double tempPrice = getTotalDiscountedPrice(customer);
		while (tempPrice >= 10)
		{
			tempPts++;
			tempPrice -= 10;
		}
		return tempPts;
	}
	
	
	public void addLineItem(SalesLineItem lineItem)
	{
		lineItems.add(lineItem);
	}
	
	public void removeLineItem(String productID)
	{
		for(int i = 0; i < lineItems.size(); i++)
		{
			if (lineItems.get(i).getProduct().getProductId().equals(productID))
			{
				lineItems.remove(i);
			}
		}
	}
	
	public SalesLineItem getSalesLineItem(long productID)
	{
		for(int i = 0; i < lineItems.size(); i++)
		{
			if (lineItems.get(i).getProduct().getProductId().equals(productID))
			{
				return lineItems.get(i);
			}
		}
		return null; // if cant find, throws exception?
	}
	
	public int getItemsInCart()
	{
		return lineItems.size();
	}
	
	public long getOrderID()
	{
		return orderID;
	}
	
	public boolean isPaid()
	{
		return paid;
	}
	
	public void pay(Customer customer)
	{
		this.paid = true;
		
		// deduct product stock
		for(int i = 0; i < lineItems.size(); i++)
		{
			Product tempProduct = lineItems.get(i).getProduct();
			int quantity = lineItems.get(i).getProductQuantity();
			tempProduct.reduceStockQty(quantity);
		}
		
		// add loyalty points
		
		customer.deductLoyaltyPts(getLoyaltyPtsUsed());
		customer.addLoyaltyPts(getLoyaltyPtsEarned(customer));

	}
}
