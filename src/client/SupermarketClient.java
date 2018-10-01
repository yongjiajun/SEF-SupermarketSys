package client;
// Commented these out because it was giving errors

import java.awt.EventQueue;

import model.pay.Sale;
import model.system.AccountManager;
import model.system.ProductManager;
import model.system.SalesManager;
import view.WelcomeScreen;

public class SupermarketClient {

	public static void main(String[] arg) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ProductManager pm = new ProductManager();
				AccountManager am = new AccountManager();
				SalesManager sr = new SalesManager();
				try {
					WelcomeScreen welcomeScreen = new WelcomeScreen();
					welcomeScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// run codes on exit
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