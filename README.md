# SupermarketSupportSystem - $$$

###### - for Software Engineering Fundamentals Assignment, RMIT 2018

SupermarketSupportSystem is a revolutionary self-checkout system that does what a conventional self-checkout system should do. Please consider buying our system and give us your money.

##### Group Members:

###### Clinton Pham (s3605044), Jia Jun Yong (s3688090), Lawrence Trinh (s3656432), Viviana Ngo (s3671230)



## Current Issues:

- Getting sale to work.
- Actually nothing works yet.

### Issues to-be dealt later:

- In AccountManager, should accounts be serialized instead of writing all their attributes into text files?

```java
private void init() {
		Scanner inputStream = null;
		String filename = null;
		for (int i = 1; i <= 4; i++) {
			if (i == 1) {
				filename = "database/credentials/staff.txt";
			} else if (i == 2) {
				filename = "database/credentials/manager.txt";
			} else if (i == 3) {
				filename = "database/credentials/supplier.txt";
			} else if (i == 4) {
				filename = "database/credentials/customer.txt";
			}
			try {
				inputStream = new Scanner(new File(filename));
				inputStream.useDelimiter("#");
			} catch (FileNotFoundException e) {
				System.out.println("FATAL ERROR: The file \"" + filename + "\" isn't found!");
				e.printStackTrace();
			}
			while (inputStream.hasNextLine()) {
				String readName = inputStream.next();
				String readPassword = null;
				if (i == 1) {
					readPassword = inputStream.next();
					SalesStaff temp = new SalesStaff(readName, readPassword);
					salesStaffs.put(readName, temp);
				} else if (i == 2) {
					readPassword = inputStream.next();
					Manager temp = new Manager(readName, readPassword);
					managers.put(readName, temp);
				} else if (i == 3) {
					readPassword = inputStream.next();
					Supplier temp = new Supplier(readName, readPassword);
					suppliers.put(readName, temp);
				} else if (i == 4) {
					int loyaltyPts = inputStream.nextInt();
					Customer temp = new Customer(readName, loyaltyPts);
					loyalCustomers.put(readName, temp);
				}
			}
		}
	}

	public void terminte() {
		PrintWriter pw = null;
		String filename = null;
		Iterator it = null;
		for (int i = 1; i <= 4; i++) {
			if (i == 1) {
				filename = "database/credentials/staff.txt";
				it = salesStaffs.entrySet().iterator();
			} else if (i == 2) {
				filename = "database/credentials/manager.txt";
				it = managers.entrySet().iterator();
			} else if (i == 3) {
				filename = "database/credentials/supplier.txt";
				it = suppliers.entrySet().iterator();
			} else if (i == 4) {
				filename = "database/credentials/customer.txt";
				it = loyalCustomers.entrySet().iterator();
			}
			try {
				pw = new PrintWriter(new File(filename));
			} catch (FileNotFoundException e) {
				System.out.println("FATAL ERROR: The file \"" + filename + "\" isn't found!");
				e.printStackTrace();
			}
			while (it.hasNext()) {
				String toBePrinted = null;
				Map.Entry mapPair = (Map.Entry) it.next();
				pw.write((String) mapPair.getKey() + "#");
				if (i == 1) {
					SalesStaff temp = (SalesStaff) mapPair.getValue();
					toBePrinted = temp.getPassword();
				} else if (i == 2) {
					Manager temp = (Manager) mapPair.getValue();
					toBePrinted = temp.getPassword();
				} else if (i == 3) {
					Supplier temp = (Supplier) mapPair.getValue();
					toBePrinted = temp.getPassword();
				} else if (i == 4) {
					Customer temp = (Customer) mapPair.getValue();
					toBePrinted = Integer.toString(temp.getLoyaltyPts());
				}
				pw.write(toBePrinted + "#");
				it.remove();
			}
			pw.close();
		}

	}
```



