package model.pay;

import java.util.*;

public class CheckoutCart {
	
	private ArrayList<SalesLineItem> lineItems = new ArrayList<SalesLineItem>();
	private boolean paid = false;
	private long orderID; // get latest ID from array, orderID++ automatically with the constructor?
	private double totalPrice;
	
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
	
	public void addLineItem(SalesLineItem lineItem)
	{
		lineItems.add(lineItem);
	}
	
	public void removeLineItem(long productID)
	{
		for(int i = 0; i < lineItems.size(); i++)
		{
			if (lineItems.get(i).getProduct().getProductId() == productID)
			{
				lineItems.remove(i);
			}
		}
	}
	
	public SalesLineItem getSalesLineItem(long productID)
	{
		for(int i = 0; i < lineItems.size(); i++)
		{
			if (lineItems.get(i).getProduct().getProductId() == productID)
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
	
	public void pay(boolean paid)
	{
		this.paid = paid;
	}
}
