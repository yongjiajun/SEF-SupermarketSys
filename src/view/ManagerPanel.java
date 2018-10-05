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
			suppliersPanel, salesPanel, reportPanel, addProductPanel, addSupplierPanel, viewSupplier;
	private JTextField productIdField, productNameField, productPriceField, supplierIDField, supplierPinField,
			supplierFirstNameField, supplierLastNameField, companyNameField, contactNoField, emailField, locationField;

	public static final String DOLLAR_SIGN = "$";
	private AddProductController addProduct = new AddProductController(this);
	private Supplier supplier;
	private JTable table;
	private WelcomeScreen welcomeScreen;
	private DefaultTableModel model;
	private Manager manager;
	private JTextField productNamefield;
	private JTextField productPricefield;
	private JTextField productQuantityField;
	private JTextField productiDfield;
	private JTextField supplierIdField;
	private JTextField supplierCompanyNameField;
	private JTextField suplpierContactNoField;
	private JTextField supplierEmailField;
	private JTextField supplierLocationField;

	public ManagerPanel(Manager manager) {
		this.manager = manager;
		setTitle("SEF Assignment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		parentPanel = new JPanel();
		parentPanel.setBounds(164, 0, 1036, 750);
		contentPane.add(parentPanel);
		parentPanel.setLayout(new CardLayout(0, 0));

		sideBarPanel();
		dashboardPanel();
		productsPanel();
		salesPanel();
		suppliersPanel();
		reportPanel();
		addSupplier();
		viewSupplier();
//		addProductPanel();
	}

	private void sideBarPanel() {
		sideBarPanel = new JPanel();
		sideBarPanel.setBackground(Color.DARK_GRAY);
		sideBarPanel.setBounds(0, 0, 174, 750);
		contentPane.add(sideBarPanel);
		sideBarPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("", SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ManagerPanel.class.getResource("/images/Sef4.png")));
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

		JLabel welcomeLbl = new JLabel("Welcome, " + manager.getUserFName());
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

		productsPanel = new JPanel();
		productsPanel.setBackground(new Color(0, 128, 128));
		parentPanel.add(productsPanel);
		productsPanel.setLayout(null);

		JLabel productsTitle = new JLabel("Products Panel");
		productsTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		productsTitle.setBounds(19, 6, 188, 38);
		productsPanel.add(productsTitle);

		JPanel productPanelSection = new JPanel();
		productPanelSection.setBackground(new Color(128, 128, 128));
		productPanelSection.setBounds(6, 56, 1030, 106);
		productsPanel.add(productPanelSection);
		productPanelSection.setLayout(null);
//		productPanelSection.setVisible(false);

		String[] actionNames = { "Add Item", "Remove Item", "Modify Item" };

		JLabel IDLbl = new JLabel("ID");
		IDLbl.setBounds(22, 6, 99, 16);
		productPanelSection.add(IDLbl);

		JLabel producTNmeLbl = new JLabel("Name");
		producTNmeLbl.setBounds(119, 6, 99, 16);
		productPanelSection.add(producTNmeLbl);

		JLabel productPriceLbl = new JLabel("Price");
		productPriceLbl.setBounds(260, 6, 99, 16);
		productPanelSection.add(productPriceLbl);

		JLabel productQuantityLbl = new JLabel("Quantity");
		productQuantityLbl.setBounds(371, 6, 99, 16);
		productPanelSection.add(productQuantityLbl);

		productNamefield = new JTextField();
		productNamefield.setBounds(108, 40, 130, 26);
		productPanelSection.add(productNamefield);
		productNamefield.setColumns(10);

		productPricefield = new JTextField();
		productPricefield.setColumns(10);
		productPricefield.setBounds(250, 40, 99, 26);
		productPanelSection.add(productPricefield);

		productQuantityField = new JTextField();
		productQuantityField.setColumns(10);
		productQuantityField.setBounds(361, 40, 130, 26);
		productPanelSection.add(productQuantityField);

		productiDfield = new JTextField();
		productiDfield.setColumns(10);
		productiDfield.setBounds(22, 40, 72, 26);
		productPanelSection.add(productiDfield);

		JButton AddButton = new JButton("Add");
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(888, 37, 117, 29);
		productPanelSection.add(updateButton);

		JLabel discountLabel = new JLabel("Discount");
		discountLabel.setBounds(536, 6, 99, 16);
		productPanelSection.add(discountLabel);

		JComboBox<String> discountBox = new JComboBox<String>();
		discountBox.addItem(" ");
		discountBox.addItem("10% for 5 items");
		discountBox.addItem("20% for 1 items");
		discountBox.setSelectedIndex(0);

		discountBox.setBounds(519, 41, 99, 27);
		productPanelSection.add(discountBox);

		Object[] row = new Object[6];

		AddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				row[0] = productiDfield.getText();
				row[1] = productNamefield.getText();
				row[2] = DOLLAR_SIGN + productPricefield.getText();
				row[3] = productQuantityField.getText();
				row[4] = discountBox.getSelectedItem();

				model.addRow(row);

				addProduct.addRemoveModifyProduct(productiDfield.getText(), productNamefield.getText(),
						Double.parseDouble(productPricefield.getText()),
						Integer.parseInt(productQuantityField.getText()), false);

			}
		});


		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int getSelectedRow = table.getSelectedRow();

				if (getSelectedRow >= 0) {
 					model.setValueAt(productiDfield.getText(), getSelectedRow, 0);
					model.setValueAt(productNamefield.getText(), getSelectedRow, 1);
					model.setValueAt(DOLLAR_SIGN + productPricefield.getText(), getSelectedRow, 2);
					model.setValueAt(productQuantityField.getText(), getSelectedRow, 3);

				}
			}
		});

		AddButton.setBounds(888, 1, 117, 29);
		productPanelSection.add(AddButton);



		JButton removeBtn = new JButton("Remove");
		removeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int getSelectedRow = table.getSelectedRow();
				if (getSelectedRow >= 0) {
					model.removeRow(getSelectedRow);

					addProduct.addRemoveModifyProduct(productiDfield.getText(), productNamefield.getText(),
							Double.parseDouble(productPricefield.getText()),
							Integer.parseInt(productQuantityField.getText()), true);
				}
			}
		});
		removeBtn.setBounds(888, 71, 117, 29);
		productPanelSection.add(removeBtn);


		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(19, 208, 1008, 460);

		Object[] columns = { "ID", "Name", "Price", "Quantity", "Discount", "Restock Needed" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		Font font = new Font("", 1, 16);
		table.setFont(font);
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(34, 253, 951, 440);
		productsPanel.add(pane);


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
		panel.setBounds(6, 55, 1030, 98);
		suppliersPanel.add(panel);

		String[] actionNames = { "Add Supplier", "Remove Supplier", "Edit Supplier Details" };

		JLabel supplierIDLbl = new JLabel("Supplier ID");
		supplierIDLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierIDLbl.setBounds(6, 6, 111, 26);
		panel.add(supplierIDLbl);

		JLabel companyName = new JLabel("Company Name");
		companyName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		companyName.setBounds(126, 6, 142, 26);
		panel.add(companyName);

		JLabel supplierContactNo = new JLabel("Contact Number");
		supplierContactNo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierContactNo.setBounds(292, 6, 130, 26);
		panel.add(supplierContactNo);

		JLabel supplierEmail = new JLabel("Email");
		supplierEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierEmail.setBounds(510, 6, 111, 26);
		panel.add(supplierEmail);

		JLabel supplierLocation = new JLabel("Location");
		supplierLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		supplierLocation.setBounds(720, 6, 111, 26);
		panel.add(supplierLocation);

		supplierIdField = new JTextField();
		supplierIdField.setBounds(6, 52, 84, 26);
		panel.add(supplierIdField);
		supplierIdField.setColumns(10);

		supplierCompanyNameField = new JTextField();
		supplierCompanyNameField.setColumns(10);
		supplierCompanyNameField.setBounds(113, 52, 142, 26);
		panel.add(supplierCompanyNameField);

		suplpierContactNoField = new JTextField();
		suplpierContactNoField.setColumns(10);
		suplpierContactNoField.setBounds(280, 52, 130, 26);
		panel.add(suplpierContactNoField);

		supplierEmailField = new JTextField();
		supplierEmailField.setColumns(10);
		supplierEmailField.setBounds(445, 52, 176, 26);
		panel.add(supplierEmailField);

		supplierLocationField = new JTextField();
		supplierLocationField.setColumns(10);
		supplierLocationField.setBounds(656, 52, 204, 26);
		panel.add(supplierLocationField);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(890, 7, 117, 29);
		panel.add(btnAdd);

		JButton removeBtn = new JButton("Remove");
		removeBtn.setBounds(890, 37, 117, 29);
		panel.add(removeBtn);

		JButton modifyBtn = new JButton("Modify");
		modifyBtn.setBounds(890, 63, 117, 29);
		panel.add(modifyBtn);

		JPanel supplierMainPanel = new JPanel();
		supplierMainPanel.setBounds(6, 192, 1012, 496);
		supplierMainPanel.setLayout(null);
		suppliersPanel.add(supplierMainPanel);

		Object[] columns = { "ID", "First Name", "Last Name", "Company Name", "Contact No", "Email", "Location" };
		model.setColumnIdentifiers(columns);


	}

	private void reportPanel() {
		reportPanel = new JPanel();
		reportPanel.setBackground(Color.PINK);
		parentPanel.add(suppliersPanel);
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

		companyNameField = new JTextField();
		companyNameField.setColumns(10);
		companyNameField.setBounds(227, 359, 397, 32);
		addSupplierPanel.add(companyNameField);

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
				String companyName = companyNameField.getText();
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

	public void setWelcomeScreen(WelcomeScreen welcomeScreen) {
		this.welcomeScreen = welcomeScreen;
	}

	public JTextField getSupplierIDField() {
		return supplierIDField;
	}

	public JTextField getSupplierFirstNameField() {
		return supplierFirstNameField;
	}

	public JTextField getSupplierLastNameField() {
		return supplierLastNameField;
	}
}
