package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.pay.Sale;
import model.pay.SalesLineItem;
import model.people.Customer;
import model.people.Manager;
import model.people.SalesStaff;
import model.people.Supplier;
import model.people.User;
import model.system.AccountManager;
import model.system.Product;
import model.system.ProductManager;
import model.system.SalesManager;

public class Menu {

	
	private AccountManager am;
	private  ProductManager pm;
	private SalesManager sm;
	
	public Menu (AccountManager am, ProductManager pm, SalesManager sm)
	{
		this.am = am;
		this.pm = pm;
		this.sm = sm;
	}
	
	public void displayMainMenu()
	{
		System.out.println("Welcome to Kostko!");
		System.out.println("------------------\n");
		
		System.out.println("Please login to continue:");
		System.out.print("\nUsername:");
		Scanner sc = new Scanner(System.in);
		String userName = sc.nextLine(); 
		System.out.print("\nPassword:");
		String pin = sc.nextLine(); 
		
		User user = am.verify(userName, pin);
		if (user == null)
		{
			System.out.println("Login failed! Please try again.");
			sc.nextLine();
			displayMainMenu();
			return;
		}
		if (user instanceof Manager)
		{
			System.out.println("Welcome Manager " + user.getUserID());
		}
		else if (user instanceof SalesStaff)
		{
			System.out.println("Welcome Staff " + user.getUserID());
		}
		else if (user instanceof Supplier)
		{
			System.out.println("Welcome Supplier " + user.getUserID());
		}
		else if (user instanceof Customer)
		{
			System.out.println("Welcome Customer " + user.getUserID());
			Sale sale = new Sale((Customer) user);
			customerView((Customer) user, sale);
		}		
		
	}
	
	private void customerView(Customer user, Sale sale)
	{
		System.out.println("You have " + sale.getItemsInCart() + "items in your cart.");
		if (sale.getItemsInCart() > 0)
		{
			ArrayList<SalesLineItem> lineItems = sale.getSalesLineItems();
			System.out.println("ID\tName\tQuantity\tPrice");
			for (int i = 0; i < sale.getItemsInCart(); i++)
			{
				Product tempProduct = lineItems.get(i).getProduct();
				SalesLineItem lineItem = lineItems.get(i);
				System.out.println(tempProduct.getProductId() + '\t' + tempProduct.getProductName() + '\t' + .;
			}
		}
		System.out.println("-------------------------------------");
		System.out.println("Select one of the following options:");
		System.out.println("1. Enter ID and Quantity");
		System.out.println("2. Enter Item Name and Weight");
		System.out.println("3. Select Item from List");
		System.out.println("4. Cancel Order");
	}
}
