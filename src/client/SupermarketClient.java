package client;
// Commented these out because it was giving errors

import java.awt.EventQueue;

//<<<<<<< HEAD
//=======
//import static org.junit.Assert.*;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

import view.ManagerPanel;

public class SupermarketClient {
	// TEST CASES GO HERE

	public static void main(String[] arg) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ManagerPanel managerPanel = new ManagerPanel();
					managerPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}