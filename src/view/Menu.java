package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.pay.CreditCard;
import model.pay.Sale;
import model.pay.SalesLineItem;
import model.people.Customer;
import model.people.Manager;
import model.people.SalesStaff;
import model.people.Supplier;
import model.people.User;
import model.system.AccountManager;
import model.system.Product;
import model.system.ProductManager;
import model.system.SalesManager;

public class Menu {

	private AccountManager am;
	private ProductManager pm;
	private SalesManager sm;

	public Menu(AccountManager am, ProductManager pm, SalesManager sm) {
		this.am = am;
		this.pm = pm;
		this.sm = sm;
	}

	public void displayMainMenu() {
		System.out.println("\n\nWelcome to Kostko!");
		System.out.println("------------------");

		System.out.println("Please login to continue or type \"quit\" to quit:");
		System.out.print("\nUsername:");
		Scanner sc = new Scanner(System.in);
		String userName = sc.nextLine();
		if (userName.equalsIgnoreCase("quit")) {
			System.out.println("Good bye!\n");
			return;
		}
		System.out.print("\nPassword:");
		String pin = sc.nextLine();

		User user = am.verify(userName, pin);
		if (user == null || user instanceof SalesStaff || user instanceof Supplier) // as Supplier doesnt have to login!
		{
			System.out.println("Login failed! Please try again.");
			sc.nextLine();
			displayMainMenu();
			return;
		}
		if (user instanceof Manager) {
			System.out.println("\nWelcome Manager " + user.getUserID());
			// MANAGERVIEW (consult jhow customerView works :)
		} else if (user instanceof Customer) {
			System.out.println("\nWelcome Customer " + user.getUserID());
			Sale sale = new Sale((Customer) user);
			customerView((Customer) user, sale);
		}

	}

	private void customerView(Customer user, Sale sale) {
		System.out.println("You have " + sale.getItemsInCart() + " items in your cart.");
		if (sale.getItemsInCart() > 0) {
			displayCart(sale);
			System.out.println("Total Price: $" + sale.getTotalPrice());
		}
		System.out.println("-------------------------------------");
		System.out.println("Select one of the following options (1-5):");
		System.out.println("1. Enter Item ID");
		System.out.println("2. Enter Item Name");
		System.out.println("3. Select Item from List");
		System.out.println("4. Finish and Pay");
		System.out.println("5. Cancel Order");
		System.out.println("6. I Need Assistance");
		Scanner sc = new Scanner(System.in);
		int menuIndex = sc.nextInt();
		sc.nextLine();
		if (menuIndex == 1) {
			addProductByID(sale);
			customerView(user, sale);
			return;
		} else if (menuIndex == 2) {
			addProductByName(sale);
			customerView(user, sale);
			return;
		} else if (menuIndex == 3) {
			selectItemFromList(sale);
			customerView(user, sale);
			return;
		} else if (menuIndex == 4) {
			if (!(sale.getItemsInCart() > 0)) {
				System.out.println("No items in cart! Please add item!");
				customerView(user, sale);
				return;
			}
			boolean success = finishAndPay(sale, (Customer) user);
			if (success == false) {
				customerView(user, sale);
				return;
			} else {
				System.out.println("Thanks for shopping with us! See you soon!");
				displayMainMenu();
				return;
			}
		} else if (menuIndex == 5) {
			System.out.println("Are you sure you would like to cancel the order? (Y/N)");
			String yes = sc.nextLine();
			if (yes.equalsIgnoreCase("n")) {
				customerView(user, sale);
				return;
			} else {
				System.out.println("You've been logged out! See you soon!");
				displayMainMenu();
				return;
			}
		} else if (menuIndex == 6) {
			System.out.println("1. Top Up Credit Card");
			if (sale.getItemsInCart() > 0)
				System.out.println("2. Modify Cart");
			int helpIndex = sc.nextInt();
			sc.nextLine();
			if (helpIndex == 1) {
				topUpCard((Customer) user);
				customerView(user, sale);
				return;
			} else if (helpIndex == 2 && sale.getItemsInCart() > 0) {
				modifyCart(sale);
				customerView(user, sale);
				return;
			} else {
				System.out.println("Invalid Input!");
				customerView(user, sale);
				return;
			}
		} else {

		}
	}

	private void addProductByID(Sale sale) {
		Scanner sc = new Scanner(System.in);

		boolean quit;
		Product product = null;
		int quantity = 0;
		double weight = 0;
		quit = false;
		while (quit == false) {
			System.out.println("Enter Product ID:");
			String id = sc.nextLine();
			product = pm.getProduct(id);
			if (product == null) {
				System.out.println("Would you like to try again? (Y/N)");
				String yes = sc.nextLine();
				if (yes.equalsIgnoreCase("n")) {
					return;
				} else {
					continue;
				}
			}
			// check if product is in cart
						ArrayList<SalesLineItem> lineItems = sale.getSalesLineItems();
						SalesLineItem lineItem = null;
						for (int i = 0; i < lineItems.size(); i++) {
							if (lineItems.get(i).getProduct().equals(product)) {
								lineItem = lineItems.get(i);
							}
						}

						if (lineItem == null) {
							if (product.getWeightable() == false) {
								System.out.println("Product isn't weightable!");
								boolean quantityOK = false;
								while (quantityOK == false) {
									System.out.println("Enter Quantity:");
									quantity = sc.nextInt();
									sc.nextLine();
									// verfiication?
									if (quantity > 0 && quantity <= product.getStockQty())
									{
										quantityOK = true;
										break;
									}
									else if (quantity > product.getStockQty())
									{
										System.out.println("Quantity inputted exceeded what we have in stock! Would you like to try again? (Y/N)");
									}
									else if (quantity <= 0)
									{
										System.out.println("Quantity error! Would you like to try again? (Y/N)");
									}
									String yes = sc.nextLine();
									if (yes.equalsIgnoreCase("n")) {
										return;
									}
								}
								lineItem = new SalesLineItem(quantity, product);
								sale.addLineItem(lineItem);
								System.out.println(
										"Added " + lineItem.getProductQuantity() + ' ' + product.getProductName() + " to cart!");
								quit = true;
							} else {
								System.out.println("Product weightable!");
								boolean weightOK = false;
								while (weightOK == false) {
									System.out.println(
											"Price per gram for " + product.getProductName() + ":" + product.getPricePerGram());
									System.out.println("Enter Weight (in g):");
									weight = sc.nextDouble();
									sc.nextLine();
									// verfiication?
									if (weight > 0 && weight <= product.getStockWeight())
									{
										weightOK = true;
										break;
									}
									else if (weight > product.getStockWeight())
									{
										System.out.println("Weight inputted exceeded what we have in stock! Would you like to try again? (Y/N)");
									}
									else if (weight <= 0)
									{
										System.out.println("Weight error! Would you like to try again? (Y/N)");
									}
									String yes = sc.nextLine();
									if (yes.equalsIgnoreCase("n")) {
										return;
									}
								}
								quit = true;
								lineItem = new SalesLineItem(weight, product, true);
								System.out.println(
										"Added " + lineItem.getWeight() + "g of " + product.getProductName() + " to cart!");
							}

						} else {
							System.out.println("Product already in cart! Would you like to add more? (Y/N)");
							String yes = sc.nextLine();
							if (yes.equalsIgnoreCase("n")) {
								return;
							}
							if (product.getWeightable() == false) {
								System.out.println("Product isn't weightable!");

								boolean quantityOK = false;
								while (quantityOK == false) {
									System.out.println("Enter Quantity (" + lineItem.getProductQuantity() + " in cart) :");
									quantity = sc.nextInt();
									sc.nextLine();
									// verfiication?
									if (quantity > 0 && quantity <= product.getStockQty())
									{
										quantityOK = true;
										break;
									}
									else if (quantity > product.getStockQty())
									{
										System.out.println("Quantity inputted is greater than what we have in stock! Would you like to try again? (Y/N)");
									}
									else if (quantity <= 0)
									{
										System.out.println("Quantity error! Would you like to try again? (Y/N)");
									}
									yes = sc.nextLine();
									if (yes.equalsIgnoreCase("n")) {
										return;
									}
								}
								int prodQuantity = lineItem.getProductQuantity();
								prodQuantity += quantity;
								lineItem.setProductQuantity(prodQuantity);
								System.out.println("Added " + quantity + "more " + product.getProductName() + " to cart!");
								System.out.println("Total quantity: " + lineItem.getProductQuantity());
								quit = true;
							} else {
								boolean weightOK = false;
								while (weightOK == false) {
									System.out.println(
											"Price per gram for " + product.getProductName() + ":" + product.getPricePerGram());
									System.out.println("Enter Weight (in g, " + lineItem.getWeight() + "g in cart):");
									weight = sc.nextDouble();
									sc.nextLine();
									// verfiication?
									if (weight > 0 && weight <= product.getStockWeight())
									{
										weightOK = true;
										break;
									}
									else if (weight > product.getStockWeight())
									{
										System.out.println("Weight inputted exceeded what we have in stock! Would you like to try again? (Y/N)");
									}
									else if (weight <= 0)
									{
										System.out.println("Weight error! Would you like to try again? (Y/N)");
									}
									yes = sc.nextLine();
									if (yes.equalsIgnoreCase("n")) {
										return;
									}
								}
								double prodWeight = lineItem.getWeight();
								weight += prodWeight;
								lineItem.setWeight(weight);
								System.out.println("Added " + weight + "g of more " + product.getProductName() + " to cart!");
								System.out.println("Total weight: " + lineItem.getWeight() + "g");
								quit = true;
							}
						}
		}

	}

	private void addProductByName(Sale sale) {
		Scanner sc = new Scanner(System.in);

		boolean quit;
		Product product = null;
		int quantity = 0;
		double weight = 0;
		quit = false;
		while (quit == false) {
			System.out.println("Enter Product Name:");
			String name = sc.nextLine();
			product = pm.getProductByName(name);

			if (product == null) {
				System.out.println("Can't find selected product. Would you like to try again? (Y/N)");
				String yes = sc.nextLine();
				if (yes.equalsIgnoreCase("n")) {
					return;
				} else {
					continue;
				}
			}
			// check if product is in cart
			ArrayList<SalesLineItem> lineItems = sale.getSalesLineItems();
			SalesLineItem lineItem = null;
			for (int i = 0; i < lineItems.size(); i++) {
				if (lineItems.get(i).getProduct().equals(product)) {
					lineItem = lineItems.get(i);
				}
			}

			if (lineItem == null) {
				if (product.getWeightable() == false) {
					System.out.println("Product isn't weightable!");
					boolean quantityOK = false;
					while (quantityOK == false) {
						System.out.println("Enter Quantity:");
						quantity = sc.nextInt();
						sc.nextLine();
						// verfiication?
						if (quantity > 0 && quantity <= product.getStockQty())
						{
							quantityOK = true;
							break;
						}
						else if (quantity > product.getStockQty())
						{
							System.out.println("Quantity inputted is greater than what we have in stock! Would you like to try again? (Y/N)");
						}
						else if (quantity <= 0)
						{
							System.out.println("Quantity error! Would you like to try again? (Y/N)");
						}
						String yes = sc.nextLine();
						if (yes.equalsIgnoreCase("n")) {
							return;
						}
					}
					lineItem = new SalesLineItem(quantity, product);
					sale.addLineItem(lineItem);
					System.out.println(
							"Added " + lineItem.getProductQuantity() + ' ' + product.getProductName() + " to cart!");
					quit = true;
				} else {
					System.out.println("Product weightable!");
					boolean weightOK = false;
					while (weightOK == false) {
						System.out.println(
								"Price per gram for " + product.getProductName() + ":" + product.getPricePerGram());
						System.out.println("Enter Weight (in g):");
						weight = sc.nextDouble();
						sc.nextLine();
						// verfiication?
						if (weight > 0 && weight <= product.getStockWeight())
						{
							weightOK = true;
							break;
						}
						else if (weight > product.getStockWeight())
						{
							System.out.println("Weight inputted exceeded what we have in stock! Would you like to try again? (Y/N)");
						}
						else if (weight <= 0)
						{
							System.out.println("Weight error! Would you like to try again? (Y/N)");
						}
						String yes = sc.nextLine();
						if (yes.equalsIgnoreCase("n")) {
							return;
						}
					}
					quit = true;
					lineItem = new SalesLineItem(weight, product, true);
					System.out.println(
							"Added " + lineItem.getWeight() + "g of " + product.getProductName() + " to cart!");
				}

			} else {
				System.out.println("Product already in cart! Would you like to add more? (Y/N)");
				String yes = sc.nextLine();
				if (yes.equalsIgnoreCase("n")) {
					return;
				}
				if (product.getWeightable() == false) {
					System.out.println("Product isn't weightable!");
					boolean quantityOK = false;
					while (quantityOK == false) {
						System.out.println("Enter Quantity (" + lineItem.getProductQuantity() + " in cart) :");
						quantity = sc.nextInt();
						sc.nextLine();
						// verfiication?
						if (quantity > 0 && quantity <= product.getStockQty())
						{
							quantityOK = true;
							break;
						}
						else if (quantity > product.getStockQty())
						{
							System.out.println("Quantity inputted is greater than what we have in stock! Would you like to try again? (Y/N)");
						}
						else if (quantity <= 0)
						{
							System.out.println("Quantity error! Would you like to try again? (Y/N)");
						}
						yes = sc.nextLine();
						if (yes.equalsIgnoreCase("n")) {
							return;
						}
					}
					int prodQuantity = lineItem.getProductQuantity();
					prodQuantity += quantity;
					lineItem.setProductQuantity(prodQuantity);
					System.out.println("Added " + quantity + "more " + product.getProductName() + " to cart!");
					System.out.println("Total quantity: " + lineItem.getProductQuantity());
					quit = true;
				} else {
					boolean weightOK = false;
					while (weightOK == false) {
						System.out.println(
								"Price per gram for " + product.getProductName() + ":" + product.getPricePerGram());
						System.out.println("Enter Weight (in g, " + lineItem.getWeight() + "g in cart):");
						weight = sc.nextDouble();
						sc.nextLine();
						// verfiication?
						if (weight > 0 && weight <= product.getStockWeight())
						{
							weightOK = true;
							break;
						}
						else if (weight > product.getStockWeight())
						{
							System.out.println("Weight inputted exceeded what we have in stock! Would you like to try again? (Y/N)");
						}
						else if (weight <= 0)
						{
							System.out.println("Weight error! Would you like to try again? (Y/N)");
						}
						yes = sc.nextLine();
						if (yes.equalsIgnoreCase("n")) {
							return;
						}
					}
					double prodWeight = lineItem.getWeight();
					weight += prodWeight;
					lineItem.setWeight(weight);
					System.out.println("Added " + weight + "g of more " + product.getProductName() + " to cart!");
					System.out.println("Total weight: " + lineItem.getWeight() + "g");
					quit = true;
				}
			}
		}
	}

	private void selectItemFromList(Sale sale) {
		Scanner sc = new Scanner(System.in);
		boolean quit;
		Product product = null;
		int quantity = 0;
		double weight = 0;
		quit = false;
		while (quit == false) {
			System.out.println("Please select one of the following items:");
			HashMap<String, Product> products = pm.getProductsMap();
			int counter = 1;
			System.out.println("#\tID\tName\tWeightable\tPrice");
			for (Product tempProduct : products.values()) {
				if (tempProduct.getWeightable() == true)
					System.out.println(counter + "\t" + tempProduct.getProductId() + '\t' + tempProduct.getProductName()
							+ "\t \t" + tempProduct.getWeightable() + "\t$" + tempProduct.getPricePerGram() + " /g");
				else
					System.out.println(counter + "\t" + tempProduct.getProductId() + '\t' + tempProduct.getProductName()
							+ "\t \t$" + tempProduct.getProductPrice());
				counter++;
			}
			System.out.println("Please enter the product #:");
			int prodNum = sc.nextInt();
			sc.nextLine();

			if (!(prodNum > 0 && prodNum <= counter)) {
				System.out.println("Invalid input! Would you like to try again? (Y/N)");
				String yes = sc.nextLine();
				if (yes.equalsIgnoreCase("n")) {
					return;
				} else {
					continue;
				}
			}

			counter = 1;

			for (Product tempProduct : products.values()) {
				if (prodNum == counter) {
					product = tempProduct;
				}
				counter++;
			}
			ArrayList<SalesLineItem> lineItems = sale.getSalesLineItems();
			SalesLineItem lineItem = null;
			for (int i = 0; i < lineItems.size(); i++) {
				if (lineItems.get(i).getProduct().equals(product)) {
					lineItem = lineItems.get(i);
				}
			}

			if (lineItem == null) {
				if (product.getWeightable() == false) {
					System.out.println("Product isn't weightable!");
					boolean quantityOK = false;
					while (quantityOK == false) {
						System.out.println("Enter Quantity:");
						quantity = sc.nextInt();
						sc.nextLine();
						// verfiication?
						if (quantity > 0 && quantity <= product.getStockQty())
						{
							quantityOK = true;
							break;
						}
						else if (quantity > product.getStockQty())
						{
							System.out.println("Quantity inputted is greater than what we have in stock! Would you like to try again? (Y/N)");
						}
						else if (quantity <= 0)
						{
							System.out.println("Quantity error! Would you like to try again? (Y/N)");
						}
						String yes = sc.nextLine();
						if (yes.equalsIgnoreCase("n")) {
							return;
						}
					}
					lineItem = new SalesLineItem(quantity, product);
					sale.addLineItem(lineItem);
					System.out.println(
							"Added " + lineItem.getProductQuantity() + ' ' + product.getProductName() + " to cart!");
					quit = true;
				} else {
					System.out.println("Product weightable!");
					boolean weightOK = false;
					while (weightOK == false) {
						System.out.println(
								"Price per gram for " + product.getProductName() + ":" + product.getPricePerGram());
						System.out.println("Enter Weight (in g):");
						weight = sc.nextDouble();
						sc.nextLine();
						// verfiication?
						if (weight > 0 && weight <= product.getStockWeight())
						{
							weightOK = true;
							break;
						}
						else if (weight > product.getStockWeight())
						{
							System.out.println("Weight inputted exceeded what we have in stock! Would you like to try again? (Y/N)");
						}
						else if (weight <= 0)
						{
							System.out.println("Weight error! Would you like to try again? (Y/N)");
						}
						String yes = sc.nextLine();
						if (yes.equalsIgnoreCase("n")) {
							return;
						}
					}
					quit = true;
					lineItem = new SalesLineItem(weight, product, true);
					System.out.println(
							"Added " + lineItem.getWeight() + "g of " + product.getProductName() + " to cart!");
				}

			} else {
				System.out.println("Product already in cart! Would you like to add more? (Y/N)");
				String yes = sc.nextLine();
				if (yes.equalsIgnoreCase("n")) {
					return;
				}
				if (product.getWeightable() == false) {
					System.out.println("Product isn't weightable!");
					boolean quantityOK = false;
					while (quantityOK == false) {
						System.out.println("Enter Quantity (" + lineItem.getProductQuantity() + " in cart) :");
						quantity = sc.nextInt();
						sc.nextLine();
						// verfiication?
						if (quantity > 0 && quantity <= product.getStockQty())
						{
							quantityOK = true;
							break;
						}
						else if (quantity > product.getStockQty())
						{
							System.out.println("Quantity inputted is greater than what we have in stock! Would you like to try again? (Y/N)");
						}
						else if (quantity <= 0)
						{
							System.out.println("Quantity error! Would you like to try again? (Y/N)");
						}
						yes = sc.nextLine();
						if (yes.equalsIgnoreCase("n")) {
							return;
						}
					}
					int prodQuantity = lineItem.getProductQuantity();
					prodQuantity += quantity;
					lineItem.setProductQuantity(prodQuantity);
					System.out.println("Added " + quantity + "more " + product.getProductName() + " to cart!");
					System.out.println("Total quantity: " + lineItem.getProductQuantity());
					quit = true;
				} else {
					boolean weightOK = false;
					while (weightOK == false) {
						System.out.println(
								"Price per gram for " + product.getProductName() + ":" + product.getPricePerGram());
						System.out.println("Enter Weight (in g, " + lineItem.getWeight() + "g in cart):");
						weight = sc.nextDouble();
						sc.nextLine();
						// verfiication?
						if (weight > 0 && weight <= product.getStockWeight())
						{
							weightOK = true;
							break;
						}
						else if (weight > product.getStockWeight())
						{
							System.out.println("Weight inputted exceeded what we have in stock! Would you like to try again? (Y/N)");
						}
						else if (weight <= 0)
						{
							System.out.println("Weight error! Would you like to try again? (Y/N)");
						}
						yes = sc.nextLine();
						if (yes.equalsIgnoreCase("n")) {
							return;
						}
					}
					double prodWeight = lineItem.getWeight();
					weight += prodWeight;
					lineItem.setWeight(weight);
					System.out.println("Added " + weight + "g of more " + product.getProductName() + " to cart!");
					System.out.println("Total weight: " + lineItem.getWeight() + "g");
					quit = true;
				}
			}
		}
	}

	public boolean finishAndPay(Sale sale, Customer customer) {

		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		System.out.println("This is your cart:");
		displayCart(sale);
		System.out.println("Total Price: $" + sale.getTotalPrice());
		System.out.println("Total Loyalty Points Earned: " + sale.getLoyaltyPtsEarned());
		System.out.println("Total Loyalty Points Used: " + sale.getLoyaltyPtsUsed());
		System.out.println("Total Discounted Price: $" + sale.getTotalDiscountedPrice());
		System.out.println("Would you like to finish and pay? (Y/N)");
		String yes = sc.nextLine();
		if (yes.equalsIgnoreCase("n")) {
			return false;
		}
		while (quit == false) {
			System.out.println("Amount Payable: $" + sale.getTotalDiscountedPrice());
			System.out.println("Please enter credit card ID:");
			String credID = sc.nextLine();
			System.out.println("Please enter credit card PIN:");
			String pin = sc.nextLine();
			if (credID.equals(customer.getCreditCard().getCreditCardID()) == false
					|| pin.equals(customer.getCreditCard().getPin()) == false) {
				System.out.println("Credit Card ID / PIN Error! Would you like to try again? (Y/N)");
				yes = sc.nextLine();
				if (yes.equalsIgnoreCase("n")) {
					return false;
				} else
					continue;
			}
			System.out.println("Credit card balance: $" + customer.getCreditCard().getBalance());
			if (customer.getCreditCard().getBalance() < sale.getTotalDiscountedPrice()) {
				System.out.println(
						"Insufficient balance! Would you like one of our friendly staffs to top up for you? (Y/N)");
				yes = sc.nextLine();
				if (yes.equalsIgnoreCase("n")) {
					return false;
				} else {
					boolean topUpSuccessful = topUpCard(customer);
					if (topUpSuccessful == false) {
						System.out.println("Top up failed! Please try again later.");
						return false;
					} else {
						System.out.println("New balance: $" + customer.getCreditCard().getBalance());
					}
				}
			}
			sale.pay(sm);
			customer.getCreditCard().deductBalance(sale.getTotalDiscountedPrice());
			System.out.println("Payment successful! Amount paid: $" + sale.getTotalDiscountedPrice());
			System.out.println("New Credit card balance: $" + customer.getCreditCard().getBalance());
			System.out.println("Loyalty points: " + customer.getLoyaltyPts());
			quit = true;
		}
		return true;
	}

	private boolean topUpCard(Customer customer) {
		boolean quit = false;
		Scanner sc = new Scanner(System.in);
		while (quit == false) {
			System.out.println("Please login to continue or type \"quit\" to quit:");
			System.out.print("\nStaff Username:");
			String userName = sc.nextLine();
			if (userName.equalsIgnoreCase("quit")) {
				return false;
			}
			System.out.print("\nPassword:");
			String pin = sc.nextLine();

			User user = am.verify(userName, pin);
			if (user == null || !(user instanceof SalesStaff)) {
				System.out.println("Login failed! Would you like to try again? (Y/N)");
				String yes = sc.nextLine();
				if (yes.equalsIgnoreCase("n")) {
					return false;
				} else
					continue;
			} else {
				System.out.println("Enter amount to be topped up:");
				double topupAmt = sc.nextDouble();
				sc.nextLine();
				if (topupAmt <= 0) {
					System.out.println("Input error! You've been logged out, please try again!");
					continue;
				}
				customer.getCreditCard().addBalance(topupAmt);
				System.out.println(
						"Amount topped up: " + topupAmt + " for Customer" + customer.getUserID() + "\'s credit card");
				return true;
			}
		}
		return false;
	}

	private void modifyCart(Sale sale) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean innerQuit = false;
		while (quit == false) {
			System.out.println("Please login to continue or type \"quit\" to quit:");
			System.out.print("\nStaff Username:");
			String userName = sc.nextLine();
			if (userName.equalsIgnoreCase("quit")) {
				return;
			}
			System.out.print("\nPassword:");
			String pin = sc.nextLine();

			User user = am.verify(userName, pin);
			if (user == null || !(user instanceof SalesStaff)) {
				System.out.println("Login failed! Would you like to try again? (Y/N)");
				String yes = sc.nextLine();
				if (yes.equalsIgnoreCase("n")) {
					return;
				} else
					continue;
			} else {
				while (innerQuit == false) {
					displayCart(sale);
					System.out.println("Remove an item by its #:");
					int itemNum = sc.nextInt();
					sc.nextLine();
					if (!(itemNum >= 0 && itemNum <= sale.getItemsInCart())) {
						System.out.println("Invalid input! Would you like to try again? (Y/N)");
						String yes = sc.nextLine();
						if (yes.equalsIgnoreCase("n")) {
							return;
						} else {
							continue;
						}
					} else {
						sale.getSalesLineItems().remove(itemNum);
						System.out.println("Item removed!!");
					}
					innerQuit = true;
				}
			}
			quit = true;
		}
	}

	private void displayCart(Sale sale) {
		ArrayList<SalesLineItem> lineItems = sale.getSalesLineItems();
		System.out.println("#\tID\tName\tQuantity\tWeight\tPrice");
		for (int i = 0; i < sale.getItemsInCart(); i++) {
			Product tempProduct = lineItems.get(i).getProduct();
			SalesLineItem lineItem = lineItems.get(i);
			if (lineItem.getWeightable() == true)
				System.out.println(i + "\t" + tempProduct.getProductId() + '\t' + tempProduct.getProductName() + "\t \t"
						+ lineItem.getWeight() + "g\t$" + lineItem.getTotalPrice());
			else
				System.out.println(i + "\t" + tempProduct.getProductId() + '\t' + tempProduct.getProductName() + '\t'
						+ lineItem.getProductQuantity() + "\t \t$" + lineItem.getTotalPrice());
		}
	}

}
