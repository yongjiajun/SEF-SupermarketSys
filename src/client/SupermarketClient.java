package client;
// Commented these out because it was giving errors

import java.awt.EventQueue;

import view.WelcomeScreen;

public class SupermarketClient {
	// TEST CASES GO HERE

	public static void main(String[] arg) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					WelcomeScreen welcomeScreen = new WelcomeScreen();
					welcomeScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}