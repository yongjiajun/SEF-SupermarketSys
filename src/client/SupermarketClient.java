package client;

import model.pay.CreditCard;
import model.people.Customer;
import model.people.Manager;
import model.people.SalesStaff;
import model.people.WarehouseStaff;
import model.system.AccountManager;
import model.system.ProductManager;
import model.system.SalesManager;
import view.Menu;

public class SupermarketClient {

	public static void main(String[] arg) {
		ProductManager pm = new ProductManager();
		AccountManager am = new AccountManager();
		SalesManager sm = new SalesManager();
		
//		Customer cust = new Customer("c123", "1234", "Michael", "Lmao");
//
//		CreditCard card = new CreditCard("creditcardlol", "1234");
//		cust.setCreditCard(card);
//
//		am.addCustomer(cust);
//
//		SalesStaff s1 = new SalesStaff("s123", "1234", "Michelle", "Meme");
//		am.addSalesStaff(s1);
//
//		Manager m1 = new Manager("m123", "1234", "Vicky", "Lol");
//		am.addManager(m1);
//
//		WarehouseStaff ws = new WarehouseStaff("w123", "1234", "Sephora", "Dong");
//		am.addWarehouseStaff(ws);

		am.printSize();
		pm.printSize();

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

}