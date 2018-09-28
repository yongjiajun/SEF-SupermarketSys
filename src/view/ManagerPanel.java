package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.AddProductController;

public class ManagerPanel extends JFrame {

	private JPanel contentPane, parentPanel, sideBarPanel, dashboardPanel, todaySalesPanel, productsPanel,
			customersPanel, suppliersPanel, salesPanel, reportPanel, employeesPanel, systemPanel, addProductPanel, addSupplierPanel;
 	private JTextField productIdField;
	private JTextField productNameField;
	private JTextField productPriceField;


	private AddProductController addProduct = new AddProductController(this);
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField supplierIDField;
	private JTextField supplierPinField;
	private JTextField supplierFirstNameField;
	private JTextField supplierLastNameField;
	private JTextField companyNameFiel;
	private JTextField contactNoField;
	private JTextField emailField;
	private JTextField locationField;
	public ManagerPanel() {
		setTitle("SEF Assignment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		parentPanel = new JPanel();
		parentPanel.setBounds(164, 0, 1036, 750);
		contentPane.add(parentPanel);
		parentPanel.setLayout(new CardLayout(0, 0));

		sideBarPanel();
		dashboardPanel();
		productsPanel();
		customersPanel();
		salesPanel();
		suppliersPanel();
		reportPanel();
		employeesPanel();
		systemPanel();
		addSupplier();

//		addProductPanel();
//		removeProductPanel();
//		modifyProductPanel();



	}

	private void sideBarPanel() {
		sideBarPanel = new JPanel();
		sideBarPanel.setBackground(Color.DARK_GRAY);
		sideBarPanel.setBounds(0, 0, 174, 750);
		contentPane.add(sideBarPanel);
		sideBarPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("", SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ManagerPanel.class.getResource("/images/Sef4.jpg")));
		lblNewLabel.setBounds(50, 28, 74, 72);
		sideBarPanel.add(lblNewLabel);

		JLabel dashboardLabel = new JLabel("DASHBOARD", SwingConstants.CENTER);
		dashboardLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dashboardLabel.setForeground(Color.WHITE);
		dashboardLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		dashboardLabel.setBounds(0, 140, 174, 37);
		sideBarPanel.add(dashboardLabel);
		dashboardLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(dashboardPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

		JLabel productsLabel = new JLabel("PRODUCTS", SwingConstants.CENTER);
		productsLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productsLabel.setForeground(Color.WHITE);
		productsLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		productsLabel.setBounds(0, 217, 174, 37);
		sideBarPanel.add(productsLabel);
		productsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				parentPanel.removeAll();
				parentPanel.add(productsPanel);
				parentPanel.repaint();
				parentPanel.revalidate();

			}
		});

		JLabel salesLabel = new JLabel("SALES", SwingConstants.CENTER);
		salesLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salesLabel.setForeground(new Color(255, 255, 255));
		salesLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		salesLabel.setBounds(0, 290, 174, 37);
		sideBarPanel.add(salesLabel);
		salesLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(salesPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

		JLabel customersLabel = new JLabel("CUSTOMERS", SwingConstants.CENTER);
		customersLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		customersLabel.setForeground(Color.WHITE);
		customersLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		customersLabel.setBounds(0, 371, 174, 37);
		sideBarPanel.add(customersLabel);
		customersLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(customersPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

		JLabel supplierLabel = new JLabel("SUPPLIER", SwingConstants.CENTER);
		supplierLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supplierLabel.setForeground(Color.WHITE);
		supplierLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		supplierLabel.setBounds(0, 448, 174, 37);
		sideBarPanel.add(supplierLabel);
		supplierLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(suppliersPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

		JLabel reportLabel = new JLabel("REPORT", SwingConstants.CENTER);
		reportLabel.setForeground(Color.WHITE);
		reportLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		reportLabel.setBounds(0, 525, 174, 37);
		sideBarPanel.add(reportLabel);
		reportLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(reportPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

		JLabel employeesLabel = new JLabel("EMPLOYEES", SwingConstants.CENTER);
		employeesLabel.setForeground(Color.WHITE);
		employeesLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		employeesLabel.setBounds(0, 602, 174, 37);
		sideBarPanel.add(employeesLabel);
		employeesLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(employeesPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

		JLabel systemLabel = new JLabel("SYSTEM", SwingConstants.CENTER);
		systemLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		systemLabel.setForeground(Color.WHITE);
		systemLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		systemLabel.setBounds(0, 679, 174, 37);
		sideBarPanel.add(systemLabel);
		systemLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(systemPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

	}

	private void dashboardPanel() {
		dashboardPanel = new JPanel();
		dashboardPanel.setBackground(new Color(0, 128, 128));
		parentPanel.add(dashboardPanel);
		dashboardPanel.setLayout(null);

		JPanel welcomeDateTimePanel = new JPanel();
		welcomeDateTimePanel.setBackground(new Color(102, 102, 102));
		welcomeDateTimePanel.setBounds(0, 0, 1036, 50);
		dashboardPanel.add(welcomeDateTimePanel);
		welcomeDateTimePanel.setLayout(null);

		JLabel welcomeLbl = new JLabel("Welcome, [ManagerName]");
		welcomeLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		welcomeLbl.setForeground(Color.WHITE);
		welcomeLbl.setBounds(18, 8, 400, 30);
		welcomeDateTimePanel.add(welcomeLbl);

		// Need to fix so the time changes value overtime. Integrate ClockPanel if you
		// know how
		String date = new SimpleDateFormat("[dd/MM/yyyy] [hh:mm:ss]").format(new Date());
		JLabel labelTime = new JLabel(date);
		labelTime.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		labelTime.setForeground(Color.WHITE);
		labelTime.setBounds(811, 9, 220, 30);
		welcomeDateTimePanel.add(labelTime);

		todaySalesPanel = new JPanel();
		todaySalesPanel.setBounds(44, 96, 396, 229);
		dashboardPanel.add(todaySalesPanel);
		todaySalesPanel.setLayout(null);

		JLabel dashboardLbl = new JLabel("Dashboard");
		dashboardLbl.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		dashboardLbl.setBounds(44, 52, 174, 32);
		dashboardPanel.add(dashboardLbl);

		JPanel todaySalesBox = new JPanel();
		todaySalesBox.setBackground(new Color(0, 128, 0));
		todaySalesBox.setBounds(30, 55, 326, 42);
		todaySalesPanel.add(todaySalesBox);
		todaySalesBox.setLayout(null);

		JLabel temporaySalesLbl = new JLabel("$43244");
		temporaySalesLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		temporaySalesLbl.setForeground(new Color(255, 255, 255));
		temporaySalesLbl.setBounds(132, 5, 123, 31);
		todaySalesBox.add(temporaySalesLbl);

		JLabel lblTodaysSales = new JLabel("Todays Sales");
		lblTodaysSales.setBounds(142, 24, 95, 19);
		todaySalesPanel.add(lblTodaysSales);

		JPanel grossProfitBox = new JPanel();
		grossProfitBox.setBackground(new Color(0, 128, 0));
		grossProfitBox.setBounds(30, 157, 147, 30);
		todaySalesPanel.add(grossProfitBox);

		JLabel label_1 = new JLabel("$43244");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		grossProfitBox.add(label_1);

		JPanel grossProfit1Box = new JPanel();
		grossProfit1Box.setBackground(new Color(0, 128, 0));
		grossProfit1Box.setBounds(209, 157, 147, 30);
		todaySalesPanel.add(grossProfit1Box);

		JLabel label_2 = new JLabel("$43244");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		grossProfit1Box.add(label_2);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(72, 130, 61, 16);
		todaySalesPanel.add(lblNewLabel_1);

		JLabel label = new JLabel("New label");
		label.setBounds(249, 130, 61, 16);
		todaySalesPanel.add(label);

		JPanel topSellingProductBox = new JPanel();
		topSellingProductBox.setBounds(44, 356, 396, 351);
		dashboardPanel.add(topSellingProductBox);

		JPanel dashboardDisplaySomething = new JPanel();
		dashboardDisplaySomething.setBounds(603, 96, 363, 335);
		dashboardPanel.add(dashboardDisplaySomething);

		JPanel dashBoardDisplaySomething2 = new JPanel();
		dashBoardDisplaySomething2.setBounds(603, 515, 363, 192);
		dashboardPanel.add(dashBoardDisplaySomething2);
	}

	private void productsPanel() {
//		salesPanel = new JPanel();
//		salesPanel.setBackground(Color.BLUE);
//		parentPanel.add(salesPanel);

		productsPanel = new JPanel();
		productsPanel.setBackground(new Color(0, 128, 128));
		parentPanel.add(productsPanel);
		productsPanel.setLayout(null);

		JLabel productsTitle = new JLabel("Products Panel");
		productsTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		productsTitle.setBounds(19, 6, 188, 38);
		productsPanel.add(productsTitle);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(6, 78, 1030, 84);
		productsPanel.add(panel);
		panel.setLayout(null);

		String[] actionNames = { "Add Item", "Remove Item", "Modify Item" };
		JComboBox actionBox = new JComboBox(actionNames);
		actionBox.setBounds(833, 23, 166, 40);
		panel.add(actionBox);

		table_3 = new JTable();
		table_3.setBounds(6, 222, 1008, 460);
		productsPanel.add(table_3);


		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
//		    	  Add Item
				int selectedActiom = actionBox.getSelectedIndex();

				switch (selectedActiom) {
				case 0:
					productsPanel.removeAll();
					addProductPanel();
					addProductPanel.setVisible(true);
					productsPanel.add(addProductPanel);
 					productsPanel.repaint();
					productsPanel.revalidate();
					break;

				case 1:
					removeProductPanel();
					break;

				case 2:

					break;
				}
			}

		};

		actionBox.addActionListener(actionListener);
//
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(36, 180, 981, 528);
//		productsPanel.add(scrollPane);

// Temporary data - shouldn't be here. Need to comply with MVC
//		Object[][] data = {
//				{ "1", "Apple", "Fruit", "", "$1.00", "100", "Fruit", "True" },
//				{ "2", "Apple", "Fruit", "", "$1.00", "100", "Fruit", "True" },
//				{ "3", "Apple", "Fruit", "", "$1.00", "100", "Fruit", "True" },
//				{ "4", "Apple", "Fruit", "", "$1.00", "100", "Fruit", "True" },
//				{ "5", "Apple", "Fruit", "", "$1.00", "100", "Fruit", "True" },
//				{ "6", "Apple", "Fruit", "", "$1.00", "100", "Fruit", "True" },
//				};


//		Object[][] data = {
//{addProduct.getProductID(), addProduct.getProductName(), addProduct.getProductPrice(), addProduct.getProductQuantity()},


//		};
//		Object[] row = new Object[4];
//
//		String[] columnHeaders = { "Product ID", "Product Name", "Product Price", "Quantity" };
//
//		table = new JTable(row, columnHeaders);
//		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
//		scrollPane.setViewportView(table);


	}

	private void customersPanel() {
		customersPanel = new JPanel();
		customersPanel.setBackground(Color.BLACK);
		parentPanel.add(customersPanel);

	}

	private void salesPanel() {

	}

	private void suppliersPanel() {
		suppliersPanel = new JPanel();
		suppliersPanel.setBackground(new Color(0, 128, 128));
		parentPanel.add(suppliersPanel);
		suppliersPanel.setLayout(null);

		JLabel supplierLabel = new JLabel("Supplier Details");
		supplierLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		supplierLabel.setBounds(6, 21, 156, 36);
		suppliersPanel.add(supplierLabel);

		DefaultTableModel model = new DefaultTableModel();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(6, 69, 1030, 84);
		suppliersPanel.add(panel);

		String[] actionNames = {"Add Supplier", "Remove Supplier", "Edit Supplier Details", "Refresh"};
		JComboBox comboBox = new JComboBox(actionNames);
		comboBox.setBounds(833, 23, 166, 40);
		panel.add(comboBox);



//		public Supplier(String supplierID, String supplierPIN, String supplierFName, String supplierLName,
//				String supplierCompanyName, String supplierContactNo, String supplierEmail, String supplierLocation) {
		Object[] columns = {"ID", "First Name", "Last Name", "Company Name", "Contact No", "Email", "Location"};
		model.setColumnIdentifiers(columns);

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				int selectedAction = comboBox.getSelectedIndex();

				switch(selectedAction) {
				case 0:

//					suppliersPanel.removeAll();
					addSupplier();
					addSupplierPanel.setVisible(true);
					suppliersPanel.add(addSupplierPanel);
					suppliersPanel.repaint();
					suppliersPanel.revalidate();
					break;
				}
			}
		};

		comboBox.addActionListener(actionListener);



	}

	private void reportPanel() {
		reportPanel = new JPanel();
		reportPanel.setBackground(Color.PINK);
		parentPanel.add(suppliersPanel);
	}

	private void employeesPanel() {
		employeesPanel = new JPanel();
		employeesPanel.setBackground(Color.ORANGE);
		parentPanel.add(employeesPanel);

	}

	private void systemPanel() {
		systemPanel = new JPanel();
		systemPanel.setBackground(Color.YELLOW);

	}

	private void addProductPanel() {
//		productsPanel();

		addProductPanel = new JPanel();
 		parentPanel.add(addProductPanel, "name_379884347646550");
		addProductPanel.setVisible(true);
		addProductPanel.setBackground(new Color(0, 128, 128));
		addProductPanel.setLayout(null);

		JLabel lblProductDetail = new JLabel("Product Detail");
		lblProductDetail.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblProductDetail.setBounds(16, 6, 188, 38);
		addProductPanel.add(lblProductDetail);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(6, 67, 1030, 84);
		addProductPanel.add(panel);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(682, 28, 117, 29);
		panel.add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addProductPanel.setVisible(false);
				parentPanel.removeAll();
				productsPanel();
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
		btnCancel.setBounds(826, 28, 117, 29);
		panel.add(btnCancel);

		JLabel productIdLabel = new JLabel("ID *");
		productIdLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		productIdLabel.setBounds(120, 216, 84, 31);
		addProductPanel.add(productIdLabel);

		JLabel lblName = new JLabel("Name *");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblName.setBounds(120, 270, 84, 31);
		addProductPanel.add(lblName);

		JLabel lblPrice = new JLabel("Price *");
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPrice.setBounds(120, 324, 84, 31);
		addProductPanel.add(lblPrice);

//		JLabel lblCategory = new JLabel("Category *");
//		lblCategory.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
//		lblCategory.setBounds(120, 377, 101, 31);
//		addProductPanel.add(lblCategory);

		JLabel lblQuantity = new JLabel("Quantity *");
		lblQuantity.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblQuantity.setBounds(120, 388, 101, 31);
		addProductPanel.add(lblQuantity);

//		JLabel lblStatus = new JLabel("Status *");
//		lblStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
//		lblStatus.setBounds(120, 504, 101, 31);
//		addProductPanel.add(lblStatus);

		productIdField = new JTextField();
		productIdField.setBounds(265, 216, 256, 31);
		addProductPanel.add(productIdField);
		productIdField.setColumns(10);


		productNameField = new JTextField();
		productNameField.setColumns(10);
		productNameField.setBounds(265, 275, 256, 31);
		addProductPanel.add(productNameField);

		productPriceField = new JTextField();
		productPriceField.setColumns(10);
		productPriceField.setBounds(265, 329, 93, 31);
		addProductPanel.add(productPriceField);



		JComboBox productQuantityBox = new JComboBox();
				for (int i=0; i<=99; i++) {
					productQuantityBox.addItem(new Integer(i));
			}

		productQuantityBox.setBounds(265, 394, 93, 27);
		addProductPanel.add(productQuantityBox);

//		JComboBox productEnabledBox = new JComboBox();
//		productEnabledBox.setBounds(265, 510, 93, 27);
//		addProductPanel.add(productEnabledBox);

		JButton btnSubmit = new JButton("Submit");


		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//					 (Product productID, Product productName, Product productPrice,
//				Product productCategory, Product productQuantity)
				String productID = productIdField.getText();
				String productName = productNameField.getText();
				double productPrice = Double.parseDouble(productPriceField.getText());
//				String productCategory = (String) productCategoryBox.getSelectedItem();
				int productQuantity = (int)productQuantityBox.getSelectedItem();

				addProduct.addItems(productID, productName, productPrice, productQuantity);
				parentPanel.removeAll();
				productsPanel();
				parentPanel.repaint();
				parentPanel.revalidate();
 			}
		});



		btnSubmit.setBounds(120, 582, 131, 44);
		addProductPanel.add(btnSubmit);
		addProductPanel.setVisible(false);
	}
	private void modifyProductPanel() {


	}
	private void removeProductPanel() {

//		Retrieve items - temporary variable
		String[] items = {"Apple", "Banana", "Kiwi"};
		JComboBox combo = new JComboBox(items);
		String[] options = {"Cancel", "Remove"};
		String title = "Remove Item";
		int selection = JOptionPane.showOptionDialog(null, combo, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);


	}

	private void addSupplier() {

		addSupplierPanel = new JPanel();
 		parentPanel.add(addSupplierPanel, "name_379884347646550");
 		addSupplierPanel.setVisible(true);
 		addSupplierPanel.setBackground(new Color(0, 128, 128));
 		addSupplierPanel.setLayout(null);

		JLabel supplierID = new JLabel("Supplier ID");
		supplierID.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierID.setBounds(31, 219, 112, 36);
		addSupplierPanel.add(supplierID);

		JLabel supplierPin = new JLabel("Pin");
		supplierPin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierPin.setBounds(31, 269, 112, 36);
		addSupplierPanel.add(supplierPin);

		JLabel supplierFirstName = new JLabel("First Name");
		supplierFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierFirstName.setBounds(31, 320, 112, 36);
		addSupplierPanel.add(supplierFirstName);

		JLabel supplierLastName = new JLabel("Last Name");
		supplierLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierLastName.setBounds(31, 374, 112, 36);
		addSupplierPanel.add(supplierLastName);

		JLabel companyName = new JLabel("Company Name");
		companyName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		companyName.setBounds(31, 422, 147, 36);
		addSupplierPanel.add(companyName);

		JLabel supplierContactNo = new JLabel("Contact Number");
		supplierContactNo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierContactNo.setBounds(31, 478, 147, 36);
		addSupplierPanel.add(supplierContactNo);

		JLabel supplierEmail = new JLabel("Email");
		supplierEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierEmail.setBounds(31, 530, 112, 36);
		addSupplierPanel.add(supplierEmail);

		JLabel supplierLocation = new JLabel("Location");
		supplierLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierLocation.setBounds(31, 582, 112, 36);
		addSupplierPanel.add(supplierLocation);

		supplierIDField = new JTextField();
		supplierIDField.setBounds(200, 222, 397, 32);
		addSupplierPanel.add(supplierIDField);
		supplierIDField.setColumns(10);

		supplierPinField = new JTextField();
		supplierPinField.setColumns(10);
		supplierPinField.setBounds(200, 275, 397, 32);
		addSupplierPanel.add(supplierPinField);

		supplierFirstNameField = new JTextField();
		supplierFirstNameField.setColumns(10);
		supplierFirstNameField.setBounds(200, 326, 397, 32);
		addSupplierPanel.add(supplierFirstNameField);

		supplierLastNameField = new JTextField();
		supplierLastNameField.setColumns(10);
		supplierLastNameField.setBounds(200, 380, 397, 32);
		addSupplierPanel.add(supplierLastNameField);

		companyNameFiel = new JTextField();
		companyNameFiel.setColumns(10);
		companyNameFiel.setBounds(200, 428, 397, 32);
		addSupplierPanel.add(companyNameFiel);

		contactNoField = new JTextField();
		contactNoField.setColumns(10);
		contactNoField.setBounds(200, 478, 397, 32);
		addSupplierPanel.add(contactNoField);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(200, 536, 397, 32);
		addSupplierPanel.add(emailField);

		locationField = new JTextField();
		locationField.setColumns(10);
		locationField.setBounds(200, 588, 397, 32);
		addSupplierPanel.add(locationField);

		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		submitBtn.setBounds(31, 667, 117, 29);
		addSupplierPanel.add(submitBtn);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(200, 667, 117, 29);
		addSupplierPanel.add(cancelBtn);
		addSupplierPanel.setVisible(false);
	}
}
