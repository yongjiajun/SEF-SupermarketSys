package control;

import model.system.AccountManager;
import view.INeedAssistanceLogin;

public class EmployeeLoginController {

	private INeedAssistanceLogin view;
	private AccountManager accountManager;
	private boolean loginPass = false;

	public EmployeeLoginController(INeedAssistanceLogin view) {
		this.view = view;
		accountManager = new AccountManager();
	}

	public void checkCredentials(String id, char[] pass) {
		try {
			id = id.toUpperCase();
			switch (id.charAt(0)) {
			// Manager Login
			case 'M':
				if (accountManager.getManager(id) != null) {
					if (accountManager.getManager(id).getEmployeePIN().equals(new String(pass))) {
						// Login Successful. Change view
						loginPass = true;
						view.dispose();
					}
				}
	
				break;
			// SalesStaff Login
			case 'S':
				if (accountManager.getSalesStaff(id) != null) {
					if (accountManager.getSalesStaff(id).getEmployeePIN().equals(new String(pass))) {
						// Login Successful. Change view
						loginPass = true;
						view.dispose();
					}
				}
				break;
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Must fill out the form");
		}

		view.setErrorMessageVisible(loginPass);
		
	}

}
