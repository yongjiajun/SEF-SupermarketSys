package client;
// Commented these out because it was giving errors

import java.awt.EventQueue;

import model.system.AccountManager;
import model.system.ProductManager;
import view.WelcomeScreen;

public class SupermarketClient {
	// TEST CASES GO HERE

	public static void main(String[] arg) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ProductManager pm = new ProductManager();
					AccountManager am = new AccountManager();
					pm.initialiseProducts();
					am.initialiseUsers();
					WelcomeScreen welcomeScreen = new WelcomeScreen();
					welcomeScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}