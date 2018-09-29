package control;

import model.system.AccountManager;
import view.INeedAssistanceLogin;

public class EmployeeLoginController {

	private AccountManager accountManager;

	public EmployeeLoginController() {
		accountManager = new AccountManager();
	}

	public boolean checkCredentials(String id, char[] pass) {
		try {
			id = id.toUpperCase();
			switch (id.charAt(0)) {
			// Manager Login
			case 'M':
				if (accountManager.getManager(id) != null) {
					if (accountManager.getManager(id).getUserPIN().equals(new String(pass))) {
						// Login Successful. Change view
						return true;
					}
				}
	
				break;
			// SalesStaff Login
			case 'S':
				if (accountManager.getSalesStaff(id) != null) {
					if (accountManager.getSalesStaff(id).getUserPIN().equals(new String(pass))) {
						// Login Successful. Change view
						return true;
					}
				}
				break;
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Must fill out the form");
		}
		return false;
	}

}
