package model.pay;

import java.util.*;

public class Sale {
	
	private ArrayList<SalesLineItem> lineItems = new ArrayList<SalesLineItem>();
	private boolean paid;
	private double totalPrice;
	
	public Sale(){
		
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
}
