package client;
// Commented these out because it was giving errors

import java.awt.EventQueue;

import model.pay.CreditCard;
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
				SalesManager sr = new SalesManager();
				
				
				
				Product kleenex = new Product ("KLEEN123", "Kleenex", 2.49, 500);
				pm.addProduct(kleenex);
				
				Menu menu = new Menu(am, pm, sr);
				menu.displayMainMenu();
				
				
				
				
				// Run Code On Exit
				Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			        public void run() {
			        	pm.saveProducts();
						am.saveUsers();	
						sr.saveSales();
			        }
			    }, "Shutdown-thread"));
				
			}
		});

	}

}