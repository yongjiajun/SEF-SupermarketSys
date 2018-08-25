package model.pay;

import java.util.*;
import model.Product;

public class SalesLineItem {

	private List <Integer, Product> productInformation = new HashMap<Integer,Product>();
	
	public boolean addItem(int quantity, Product product)
	{
		if (productInformation.containsValue(product)) {
			
		}
		return false;
		
	}
	
}
