package control;

import model.system.AccountManager;
import view.LoginScreen;
import view.ManagerPanel;

public class LoginController {

	private LoginScreen view;
	private AccountManager accountManager;
	private Boolean loginPass = false;

	public LoginController(LoginScreen view) {
		this.view = view;
		accountManager = new AccountManager();
	}

	public void checkCredentials(String id, char[] pass) {
		id = id.toUpperCase();
		switch (id.charAt(0)) {
		// Manager Login
		case 'M':
			if (accountManager.getManager(id) != null) {
				if (accountManager.getManager(id).getEmployeePIN().equals(new String(pass))) {
					loginPass = true;
					ManagerPanel managerPanel = new ManagerPanel();
					managerPanel.setVisible(true);
				}
			}

			break;
		// SalesStaff Login
		case 'S':
			if (accountManager.getSalesStaff(id) != null) {
				if (accountManager.getSalesStaff(id).getEmployeePIN().equals(new String(pass))) {
					// Login Successful. Change view
					loginPass = true;
				}
			}
			break;
		// Customer Login
		case 'C':
			if (accountManager.getCustomer(id) != null) {
				if (accountManager.getCustomer(id).getCustomerPIN().equals(new String(pass))) {
					// Login Successful. Change view
					loginPass = true;
				}
			}
			break;
		// Supplier Login
		case 'P':
			if (accountManager.getSupplier(id) != null) {
				if (accountManager.getSupplier(id).getSupplierPIN().equals(new String(pass))) {
					// Login Successful. Change view
					loginPass = true;
				}
			}

			break;
		}
		if (loginPass == false) {
			view.setErrorMessageVisible();
		}
	}

}
