package model.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	private HashMap<String, Customer> customers = new HashMap<String, Customer>();
	private HashMap<String, SalesStaff> salesStaffs = new HashMap<String, SalesStaff>();
	private HashMap<String, Manager> managers = new HashMap<String, Manager>();
	private HashMap<String, Supplier> suppliers = new HashMap<String, Supplier>();

	public AccountManager() {
		// TODO remove these and have dummy users in the database
//		Customer c1 = new Customer("C123", "1234", "Alpha", "Bravo");
//		addCustomer(c1);
//
//		Manager m1 = new Manager("M123", "1234", "Charlie", "Delta");
//		addManager(m1);
//
//		SalesStaff s1 = new SalesStaff("S123", "1234", "Echo", "Foxtrot");
//		addSalesStaff(s1);
//
//		Supplier p1 = new Supplier("P123", "1234", "Golf", "Hotel", "CompName", "CompPhone", "CompEmail",
//				"CompLocation");
//		addSupplier(p1);
		initialiseUsers();
	}

	public Customer getCustomer(String id) {
		if (customers.containsKey(id)) {
			return customers.get(id);
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
		String temp = customer.getUserID();
		if (customers.containsKey(temp)) {
			System.out.print("Customer exists " + temp + " in database!");
			return false;
		} else {
			customers.put(temp, customer);
			return true;
		}
	}

	public boolean addSalesStaff(SalesStaff salesStaff) {
		String temp = salesStaff.getUserID();
		if (salesStaffs.containsKey(temp)) {
			System.out.print("Sales staff " + temp + " exists in database!");
			return false;
		} else {
			salesStaffs.put(temp, salesStaff);
			return true;
		}
	}

	public boolean addManager(Manager manager) {
		String temp = manager.getUserID();
		if (managers.containsKey(temp)) {
			System.out.print("Manager " + temp + " exists in database!");
			return false;
		} else {
			managers.put(temp, manager);
			return true;
		}
	}

	public boolean addSupplier(Supplier supplier) {
		String temp = supplier.getUserID();
		if (suppliers.containsKey(temp)) {
			System.out.print("Supplier " + temp + " exists in database!");
			return false;
		} else {
			suppliers.put(temp, supplier);
			return true;
		}
	}

	public boolean removeCustomer(Customer customer) {
		String temp = customer.getUserID();
		if (customers.containsValue(customer)) {
			customers.remove(temp);
			return true;
		} else {
			System.out.print("Customer " + temp + " doesn't exist in database!");
			return false;
		}
	}

	public boolean removeSalesStaff(SalesStaff salesStaff) {
		String temp = salesStaff.getUserID();
		if (salesStaffs.containsValue(salesStaff)) {
			customers.remove(temp);
			return true;
		} else {
			System.out.print("Sales staff " + temp + " doesn't exist in database!");
			return false;
		}
	}

	public boolean removeManager(Manager manager) {
		String temp = manager.getUserID();
		if (managers.containsValue(manager)) {
			managers.remove(temp);
			return true;
		} else {
			System.out.print("Manager " + temp + " doesn't exist in database!");
			return false;
		}
	}

	public boolean removeSupplier(Supplier supplier) {
		String temp = supplier.getUserID();
		if (suppliers.containsValue(supplier)) {
			suppliers.remove(temp);
			return true;
		} else {
			System.out.print("Supplier " + temp + " doesn't exist in database!");
			return false;
		}
	}

	private void initialiseUsers()
	{
		try {
	         FileInputStream fileInCustomer = new FileInputStream("database/customers.ser");
	         FileInputStream fileInSupplier = new FileInputStream("database/suppliers.ser");
	         FileInputStream fileInManager = new FileInputStream("database/managers.ser");
	         FileInputStream fileInSalesStaff = new FileInputStream("database/salesstaffs.ser");
	         ObjectInputStream objectInCustomer = new ObjectInputStream(fileInCustomer);
	         ObjectInputStream objectInSupplier = new ObjectInputStream(fileInSupplier);
	         ObjectInputStream objectInManager = new ObjectInputStream(fileInManager);
	         ObjectInputStream objectInSalesStaff = new ObjectInputStream(fileInSalesStaff);
	         customers = (HashMap<String, Customer>) objectInCustomer.readObject();
	         suppliers = (HashMap<String, Supplier>) objectInSupplier.readObject();
	         managers = (HashMap<String, Manager>) objectInManager.readObject();
	         salesStaffs = (HashMap<String, SalesStaff>) objectInSalesStaff.readObject();
	         System.out.println("Users are loaded from database!");
	         objectInCustomer.close();
	         objectInSupplier.close();
	         objectInManager.close();
	         objectInSalesStaff.close();
	         fileInCustomer.close();
	         fileInSupplier.close();
	         fileInManager.close();
	         fileInSalesStaff.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         c.printStackTrace();
	         return;
	      }
	}
	
	// always call this function before shutdown
	public void saveUsers()
	{
		try {
			FileOutputStream fileOutCustomer = new FileOutputStream("database/customers.ser");
			FileOutputStream fileOutSupplier = new FileOutputStream("database/suppliers.ser");
			FileOutputStream fileOutManager = new FileOutputStream("database/managers.ser");
			FileOutputStream fileOutSalesStaff = new FileOutputStream("database/salesstaffs.ser");
	         ObjectOutputStream objectOutCustomer = new ObjectOutputStream(fileOutCustomer);
	         ObjectOutputStream objectOutSupplier = new ObjectOutputStream(fileOutSupplier);
	         ObjectOutputStream objectOutManager = new ObjectOutputStream(fileOutManager);
	         ObjectOutputStream objectOutSalesStaff = new ObjectOutputStream(fileOutSalesStaff);
	         objectOutCustomer.writeObject(customers);
	         objectOutSupplier.writeObject(suppliers);
	         objectOutManager.writeObject(managers);
	         objectOutSalesStaff.writeObject(salesStaffs);
	         objectOutCustomer.close();
	         objectOutSupplier.close();
	         objectOutManager.close();
	         objectOutSalesStaff.close();
	         fileOutCustomer.close();
	         fileOutSupplier.close();
	         fileOutManager.close();
	         fileOutSalesStaff.close();
	         System.out.println("Users are saved to database!");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}

}
