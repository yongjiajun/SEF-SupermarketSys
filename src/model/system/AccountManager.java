package model.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import model.people.Customer;
import model.people.Manager;
import model.people.SalesStaff;
import model.people.Supplier;

public class AccountManager {

	/* README FIRST:
	 * 
	 * don't care about this first. will create using TestClient class.
	 * 
	 */
	
	/* INFO:
	 * 
	 * manages arrays of customers, SalesStaffs, manager(s), suppliers can perform add / get /
	 * remove. 
	 * Another account login class may be needed! 
	 * accounts (except customers) can be added using test client or a debug view
	 * 
	 */

	private HashMap<String, Customer> loyalCustomers = new HashMap<String, Customer>();
	private HashMap<String, SalesStaff> salesStaffs = new HashMap<String, SalesStaff>();
	private HashMap<String, Manager> managers = new HashMap<String, Manager>();
	private HashMap<String, Supplier> suppliers = new HashMap<String, Supplier>();

	public AccountManager() {
		// init();
		// will have to call terminate() when closing the program!
	}

	public Customer getCustomer(String id) {
		if (loyalCustomers.containsKey(id)) {
			return loyalCustomers.get(id);
		} else {
			System.out.print("Customer " + id + " not found in database!");
			return null;
		}
	}

	public SalesStaff getSalesStaff(String username) {
		if (salesStaffs.containsKey(username)) {
			return salesStaffs.get(username);
		} else {
			System.out.print("Staff " + username + " not found in database!");
			return null;
		}
	}

	public Manager getManager(String username) {
		if (managers.containsKey(username)) {
			return managers.get(username);
		} else {
			System.out.print("Manager " + username + " not found in database!");
			return null;
		}
	}

	public Supplier getSupplier(String username) {
		if (suppliers.containsKey(username)) {
			return suppliers.get(username);
		} else {
			System.out.print("Supplier " + username + " not found in database!");
			return null;
		}
	}

	public boolean addCustomer(Customer customer) {
		String temp = customer.getCustomerID();
		if (loyalCustomers.containsKey(temp)) {
			System.out.print("Customer exists " + temp + " in database!");
			return false;
		} else {
			loyalCustomers.put(temp, customer);
			return true;
		}
	}

	public boolean addSalesStaff(SalesStaff salesStaff) {
		String temp = salesStaff.getEmployeeID();
		if (salesStaffs.containsKey(temp)) {
			System.out.print("Sales staff " + temp + " exists in database!");
			return false;
		} else {
			salesStaffs.put(temp, salesStaff);
			return true;
		}
	}

	public boolean addManager(Manager manager) {
		String temp = manager.getEmployeeID();
		if (managers.containsKey(temp)) {
			System.out.print("Manager " + temp + " exists in database!");
			return false;
		} else {
			managers.put(temp, manager);
			return true;
		}
	}

	public boolean addSupplier(Supplier supplier) {
		String temp = supplier.getSupplierID();
		if (suppliers.containsKey(temp)) {
			System.out.print("Supplier " + temp + " exists in database!");
			return false;
		} else {
			suppliers.put(temp, supplier);
			return true;
		}
	}

	public boolean removeCustomer(Customer customer) {
		String temp = customer.getCustomerID();
		if (loyalCustomers.containsValue(customer)) {
			loyalCustomers.remove(temp);
			return true;
		} else {
			System.out.print("Customer " + temp + " doesn't exist in database!");
			return false;
		}
	}

	public boolean removeSalesStaff(SalesStaff salesStaff) {
		String temp = salesStaff.getEmployeeID();
		if (salesStaffs.containsValue(salesStaff)) {
			loyalCustomers.remove(temp);
			return true;
		} else {
			System.out.print("Sales staff " + temp + " doesn't exist in database!");
			return false;
		}
	}

	public boolean removeManager(Manager manager) {
		String temp = manager.getEmployeeID();
		if (managers.containsValue(manager)) {
			managers.remove(temp);
			return true;
		} else {
			System.out.print("Manager " + temp + " doesn't exist in database!");
			return false;
		}
	}

	public boolean removeSupplier(Supplier supplier) {
		String temp = supplier.getSupplierID();
		if (suppliers.containsValue(supplier)) {
			suppliers.remove(temp);
			return true;
		} else {
			System.out.print("Supplier " + temp + " doesn't exist in database!");
			return false;
		}
	}

//	private void init() {
//		Scanner inputStream = null;
//		String filename = null;
//		for (int i = 1; i <= 4; i++) {
//			if (i == 1) {
//				filename = "database/credentials/staff.txt";
//			} else if (i == 2) {
//				filename = "database/credentials/manager.txt";
//			} else if (i == 3) {
//				filename = "database/credentials/supplier.txt";
//			} else if (i == 4) {
//				filename = "database/credentials/customer.txt";
//			}
//			try {
//				inputStream = new Scanner(new File(filename));
//				inputStream.useDelimiter("#");
//			} catch (FileNotFoundException e) {
//				System.out.println("FATAL ERROR: The file \"" + filename + "\" isn't found!");
//				e.printStackTrace();
//			}
//			while (inputStream.hasNextLine()) {
//				String readName = inputStream.next();
//				String readPassword = null;
//				if (i == 1) {
//					readPassword = inputStream.next();
//					SalesStaff temp = new SalesStaff(readName, readPassword);
//					salesStaffs.put(readName, temp);
//				} else if (i == 2) {
//					readPassword = inputStream.next();
//					Manager temp = new Manager(readName, readPassword);
//					managers.put(readName, temp);
//				} else if (i == 3) {
//					readPassword = inputStream.next();
//					Supplier temp = new Supplier(readName, readPassword);
//					suppliers.put(readName, temp);
//				} else if (i == 4) {
//					int loyaltyPts = inputStream.nextInt();
//					Customer temp = new Customer(readName, loyaltyPts);
//					loyalCustomers.put(readName, temp);
//				}
//			}
//		}
//	}
//
//	public void terminte() {
//		PrintWriter pw = null;
//		String filename = null;
//		Iterator it = null;
//		for (int i = 1; i <= 4; i++) {
//			if (i == 1) {
//				filename = "database/credentials/staff.txt";
//				it = salesStaffs.entrySet().iterator();
//			} else if (i == 2) {
//				filename = "database/credentials/manager.txt";
//				it = managers.entrySet().iterator();
//			} else if (i == 3) {
//				filename = "database/credentials/supplier.txt";
//				it = suppliers.entrySet().iterator();
//			} else if (i == 4) {
//				filename = "database/credentials/customer.txt";
//				it = loyalCustomers.entrySet().iterator();
//			}
//			try {
//				pw = new PrintWriter(new File(filename));
//			} catch (FileNotFoundException e) {
//				System.out.println("FATAL ERROR: The file \"" + filename + "\" isn't found!");
//				e.printStackTrace();
//			}
//			while (it.hasNext()) {
//				String toBePrinted = null;
//				Map.Entry mapPair = (Map.Entry) it.next();
//				pw.write((String) mapPair.getKey() + "#");
//				if (i == 1) {
//					SalesStaff temp = (SalesStaff) mapPair.getValue();
//					toBePrinted = temp.getPassword();
//				} else if (i == 2) {
//					Manager temp = (Manager) mapPair.getValue();
//					toBePrinted = temp.getPassword();
//				} else if (i == 3) {
//					Supplier temp = (Supplier) mapPair.getValue();
//					toBePrinted = temp.getPassword();
//				} else if (i == 4) {
//					Customer temp = (Customer) mapPair.getValue();
//					toBePrinted = Integer.toString(temp.getLoyaltyPts());
//				}
//				pw.write(toBePrinted + "#");
//				it.remove();
//			}
//			pw.close();
//		}
//
//	}

}
