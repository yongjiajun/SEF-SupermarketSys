package client;
// Commented these out because it was giving errors

import java.awt.EventQueue;

import model.pay.CreditCard;
import model.people.Customer;
import model.people.Manager;
import model.people.SalesStaff;
import model.system.AccountManager;
import model.system.Product;
import model.system.ProductManager;
import model.system.SalesManager;
import view.Menu;

public class SupermarketClient {	

	public static void main(String[] arg) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ProductManager pm = new ProductManager();
				AccountManager am = new AccountManager();
				SalesManager sm = new SalesManager();
				
				
				//public Customer(String customerID, String customerPIN, String customerFName, String customerLName)
//				Customer cust = new Customer("C123", "1234", "lol", "lol");
//				
//				CreditCard card = new CreditCard("creditcardlol", "1234");
//				cust.setCreditCard(card);
//				
//				am.addCustomer(cust);
//				
//				SalesStaff s1 = new SalesStaff("S123", "1234", "cunt", "mike");
//				am.addSalesStaff(s1);
//				
//				Manager m1 = new Manager("m123", "1234", "cunt", "xd");
//				am.addManager(m1);
				
				// PLEASE DO A RESET OF THE DATABASE AND READD USERS.
				// customers and staffs requirements should be working, further testing needed!
				
				// Product kleenex = new Product ("KLEEN123", "Kleenex", 2.49, 500);
				// pm.addProduct(kleenex);
				
				Menu menu = new Menu(am, pm, sm);
				menu.displayMainMenu();
				
				
				
				
				// Run Code On Exit
				Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			        public void run() {
			        	pm.saveProducts();
						am.saveUsers();	
						sm.saveSales();
			        }
			    }, "Shutdown-thread"));
				
			}
		});

	}

}