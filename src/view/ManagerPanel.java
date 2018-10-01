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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.AddProductController;
import model.people.Manager;
import model.people.Supplier;

public class ManagerPanel extends JFrame {

	private JPanel contentPane, parentPanel, sideBarPanel, dashboardPanel, todaySalesPanel, productsPanel,
			suppliersPanel, salesPanel, reportPanel, systemPanel, addProductPanel, addSupplierPanel, viewSupplier;
	private JTextField productIdField;
	private JTextField productNameField;
	private JTextField productPriceField;

	private AddProductController addProduct = new AddProductController(this);
	private Supplier supplier;

	private JFrame frame;
	private JTable table;
	private JTextField supplierIDField;
	private JTextField supplierPinField;
	private JTextField supplierFirstNameField;
	private JTextField supplierLastNameField;
	private JTextField companyNameFiel;
	private JTextField contactNoField;
	private JTextField emailField;
	private JTextField locationField;

	private DefaultTableModel model;

	public ManagerPanel(Manager manager) {
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
//		customersPanel();
		salesPanel();
		suppliersPanel();
		reportPanel();
//		employeesPanel();
//		systemPanel();
		addSupplier();
		viewSupplier();

		addProductPanel();
//		removeProductPanel();
//		modifyProductPanel();

	}

//
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
		dashboardLabel.setBounds(0, 163, 164, 37);
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
		productsLabel.setBounds(0, 263, 164, 37);
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
		salesLabel.setBounds(0, 363, 164, 37);
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

		JLabel supplierLabel = new JLabel("SUPPLIER", SwingConstants.CENTER);
		supplierLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supplierLabel.setForeground(Color.WHITE);
		supplierLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		supplierLabel.setBounds(0, 463, 164, 37);
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
		reportLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reportLabel.setForeground(Color.WHITE);
		reportLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		reportLabel.setBounds(0, 563, 164, 37);
		sideBarPanel.add(reportLabel);

		JLabel logoutLbl = new JLabel("LOGOUT", SwingConstants.CENTER);
		logoutLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutLbl.setForeground(Color.WHITE);
		logoutLbl.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		logoutLbl.setBounds(0, 663, 164, 37);
		logoutLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cancelResp = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (cancelResp == JOptionPane.YES_OPTION) {
					WelcomeScreen welcomeScreen = new WelcomeScreen();
					welcomeScreen.setVisible(true);
					dispose();
					validate();
					revalidate();
				}
			}
		});
		
		
		sideBarPanel.add(logoutLbl);
		salesPanel = new JPanel();
		salesPanel.setBounds(0, 0, 1036, 750);
		contentPane.add(salesPanel);
		salesPanel.setBackground(Color.GREEN);
		reportLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(reportPanel);
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

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(19, 208, 1008, 460);
		// addProduct.addItems(productID, productName, productPrice, productQuantity);

		Object[] columns = { "ID", "Name", "Price", "Quantity" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("", 1, 22);
		table.setFont(font);
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(34,253,951,440);
		productsPanel.add(pane);
//		productsPanel.add(table);

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

		String[] actionNames = { "Add Supplier", "Remove Supplier", "Edit Supplier Details" };
		JComboBox comboBox = new JComboBox(actionNames);
		comboBox.setBounds(833, 23, 166, 40);
		panel.add(comboBox);

		JPanel supplierMainPanel = new JPanel();
		supplierMainPanel.setBounds(6, 192, 1012, 496);
		supplierMainPanel.setLayout(null);
		suppliersPanel.add(supplierMainPanel);

//		public Supplier(String supplierID, String supplierPIN, String supplierFName, String supplierLName,
//				String supplierCompanyName, String supplierContactNo, String supplierEmail, String supplierLocation) {
		Object[] columns = { "ID", "First Name", "Last Name", "Company Name", "Contact No", "Email", "Location" };
		model.setColumnIdentifiers(columns);

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				int selectedAction = comboBox.getSelectedIndex();

				switch (selectedAction) {
				case 0:

					suppliersPanel.removeAll();
					addSupplier();
					addSupplierPanel.setVisible(true);
					suppliersPanel.add(addSupplierPanel);
					suppliersPanel.repaint();
					suppliersPanel.revalidate();
					break;
//				case 3:
//					viewSupplier();
//					addSupplierPanel.setVisible(true);
//					suppliersPanel.add(addSupplierPanel);
//					suppliersPanel.repaint();
//					suppliersPanel.revalidate();
//					break;

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

//	private void employeesPanel() {
//
//	}

//	private void systemPanel() {
//		systemPanel = new JPanel();
//		systemPanel.setBackground(Color.YELLOW);
//
//	}

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
		for (int i = 0; i <= 99; i++) {
			productQuantityBox.addItem(new Integer(i));
		}

		productQuantityBox.setBounds(265, 394, 93, 27);
		addProductPanel.add(productQuantityBox);

//		JComboBox productEnabledBox = new JComboBox();
//		productEnabledBox.setBounds(265, 510, 93, 27);
//		addProductPanel.add(productEnabledBox);

		JButton btnSubmit = new JButton("Submit");

		Object[] row = new Object[4];
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

//					 (Product productID, Product productName, Product productPrice,
//				Product productCategory, Product productQuantity)
//				System.out.println();
//				String productID = productIdField.getText();
//				String productName = productNameField.getText();
//				double productPrice = Double.parseDouble(productPriceField.getText());
////				String productCategory = (String) productCategoryBox.getSelectedItem();
//				int productQuantity = (int)productQuantityBox.getSelectedItem();

//				addProduct.addItems(productIdField.getText(), productNameField.getText(), productPriceField.getText(), productQuantityBox.getSelectedIndex());


				parentPanel.removeAll();
				productsPanel();
				row[0] = productIdField.getText();
				row[1] = productNameField.getText();
				row[2] = productPriceField.getText();
				row[3] = productQuantityBox.getSelectedItem();
				model.addRow(row);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

		btnSubmit.setBounds(140, 579, 131, 44);
		addProductPanel.add(btnSubmit);
		addProductPanel.setVisible(false);
	}

	private void modifyProductPanel() {

	}

	private void removeProductPanel() {

//		Retrieve items - temporary variable
		String[] items = { "Apple", "Banana", "Kiwi" };
		JComboBox combo = new JComboBox(items);
		String[] options = { "Cancel", "Remove" };
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
		supplierID.setBounds(58, 150, 112, 36);
		addSupplierPanel.add(supplierID);

		JLabel supplierPin = new JLabel("Pin");
		supplierPin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierPin.setBounds(58, 200, 112, 36);
		addSupplierPanel.add(supplierPin);

		JLabel supplierFirstName = new JLabel("First Name");
		supplierFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierFirstName.setBounds(58, 251, 112, 36);
		addSupplierPanel.add(supplierFirstName);

		JLabel supplierLastName = new JLabel("Last Name");
		supplierLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierLastName.setBounds(58, 305, 112, 36);
		addSupplierPanel.add(supplierLastName);

		JLabel companyName = new JLabel("Company Name");
		companyName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		companyName.setBounds(58, 353, 147, 36);
		addSupplierPanel.add(companyName);

		JLabel supplierContactNo = new JLabel("Contact Number");
		supplierContactNo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierContactNo.setBounds(58, 409, 147, 36);
		addSupplierPanel.add(supplierContactNo);

		JLabel supplierEmail = new JLabel("Email");
		supplierEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierEmail.setBounds(58, 461, 112, 36);
		addSupplierPanel.add(supplierEmail);

		JLabel supplierLocation = new JLabel("Location");
		supplierLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierLocation.setBounds(58, 513, 112, 36);
		addSupplierPanel.add(supplierLocation);

		supplierIDField = new JTextField();
		supplierIDField.setBounds(227, 153, 397, 32);
		addSupplierPanel.add(supplierIDField);
		supplierIDField.setColumns(10);

		supplierPinField = new JTextField();
		supplierPinField.setColumns(10);
		supplierPinField.setBounds(227, 206, 397, 32);
		addSupplierPanel.add(supplierPinField);

		supplierFirstNameField = new JTextField();
		supplierFirstNameField.setColumns(10);
		supplierFirstNameField.setBounds(227, 257, 397, 32);
		addSupplierPanel.add(supplierFirstNameField);

		supplierLastNameField = new JTextField();
		supplierLastNameField.setColumns(10);
		supplierLastNameField.setBounds(227, 311, 397, 32);
		addSupplierPanel.add(supplierLastNameField);

		companyNameFiel = new JTextField();
		companyNameFiel.setColumns(10);
		companyNameFiel.setBounds(227, 359, 397, 32);
		addSupplierPanel.add(companyNameFiel);

		contactNoField = new JTextField();
		contactNoField.setColumns(10);
		contactNoField.setBounds(227, 409, 397, 32);
		addSupplierPanel.add(contactNoField);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(227, 467, 397, 32);
		addSupplierPanel.add(emailField);

		locationField = new JTextField();
		locationField.setColumns(10);
		locationField.setBounds(227, 519, 397, 32);
		addSupplierPanel.add(locationField);

		JButton submitBtn = new JButton("Submit");


		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String supplierId = supplierIDField.getText();
				String supplierPin = supplierPinField.getText();
				String supplierFirstName = supplierFirstNameField.getText();
				String supplierLastName = supplierLastNameField.getText();
				String companyName = companyNameFiel.getText();
				String contactNo = contactNoField.getText();
				String email = emailField.getText();
				String loc = locationField.getText();

				supplier = new Supplier(supplierId, supplierPin, supplierFirstName, supplierLastName, companyName,
						contactNo, email, loc);

				addSupplierPanel.setVisible(false);
				parentPanel.removeAll();
				suppliersPanel();
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
		submitBtn.setBounds(67, 620, 117, 29);
		addSupplierPanel.add(submitBtn);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(236, 620, 117, 29);
		addSupplierPanel.add(cancelBtn);

		JLabel lblAddSupplierDetails = new JLabel("Add Supplier Details");
		lblAddSupplierDetails.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblAddSupplierDetails.setBounds(31, 32, 211, 55);
		addSupplierPanel.add(lblAddSupplierDetails);
		addSupplierPanel.setVisible(false);

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addSupplierPanel.setVisible(false);
				parentPanel.removeAll();
				suppliersPanel();
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
	}

	private void viewSupplier() {
		viewSupplier = new JPanel();
		viewSupplier.setVisible(true);
	}
}
