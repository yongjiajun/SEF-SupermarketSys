package client;
// Commented these out because it was giving errors

import java.awt.EventQueue;

import model.system.AccountManager;
import model.system.ProductManager;
import view.WelcomeScreen;

public class SupermarketClient {

	public static void main(String[] arg) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ProductManager pm = new ProductManager();
				AccountManager am = new AccountManager();
				try {
					pm.initialiseProducts();
					am.initialiseUsers();
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
				        }
				    }, "Shutdown-thread"));
				
			}
		});

	}

}