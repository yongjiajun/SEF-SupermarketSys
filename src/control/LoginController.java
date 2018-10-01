package control;

import model.people.Customer;
import model.people.Manager;
import model.people.SalesStaff;
import model.people.Supplier;
import model.system.AccountManager;
import view.CustomerCheckoutPanel;
import view.LoginScreen;
import view.ManagerPanel;

public class LoginController {

	private LoginScreen view;
	private AccountManager accountManager;
	private Boolean loginPass = false;

	public void checkCredentials(String id, char[] pass) {
		try {
			id = id.toUpperCase();
			switch (id.charAt(0)) {
			// Manager Login
			case 'M':
				if (accountManager.getManager(id) != null) {
					if (accountManager.getManager(id).getUserPIN().equals(new String(pass))) {
						loginPass = true;
						Manager manager = accountManager.getManager(id);
						ManagerPanel managerPanel = new ManagerPanel(manager);
						managerPanel.setVisible(true);
						view.dispose();
					}
				}
	
				break;
			// SalesStaff Login
			case 'S':
				if (accountManager.getSalesStaff(id) != null) {
					if (accountManager.getSalesStaff(id).getUserPIN().equals(new String(pass))) {
						loginPass = true;
						SalesStaff salesStaff = accountManager.getSalesStaff(id);
					}
				}
				break;
			// Customer Login
			case 'C':
				
				if (accountManager.getCustomer(id) != null) {
					if (accountManager.getCustomer(id).getUserPIN().equals(new String(pass))) {
						loginPass = true;
						Customer customer = accountManager.getCustomer(id);
						CustomerCheckoutPanel customerCheckOutPanel = new CustomerCheckoutPanel(customer);
						customerCheckOutPanel.setVisible(true);
						view.dispose();
					}
				}
				break;
			// Supplier Login
			case 'P':
				if (accountManager.getSupplier(id) != null) {
					if (accountManager.getSupplier(id).getUserPIN().equals(new String(pass))) {
						loginPass = true;
						Supplier supplier = accountManager.getSupplier(id);
					}
				}
	
				break;
			}
		} catch(IndexOutOfBoundsException e) {
			System.err.println("Must fill out the form");
		}
		
		view.setErrorMessageVisible(loginPass);
		
	}
	
	public void setAccountManager(AccountManager am) {
		this.accountManager = am;
	}
	
	public void setView(LoginScreen view) {
		this.view = view;
	}

}
