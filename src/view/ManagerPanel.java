package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ManagerPanel extends JFrame {

//	STILL NEED TO REFACTOR CODE
//	NEED TO FIX:

//	ACTIONLISTENERS


	private JPanel contentPane;
	private JTable table;
	private JPanel actionPanel = new JPanel();
	private JPanel productsPanel = new JPanel();
	private JLabel dashBoardLbl = new JLabel("DASHBOARD", SwingConstants.CENTER);
	private JPanel dashboardPanel = new JPanel();
	private JPanel parentPanel = new JPanel();
	private JPanel customersPanel = new JPanel();
	private JPanel supplierPanel = new JPanel();
	private JPanel todaySalesPanel = new JPanel();
	private JLabel salesLbl = new JLabel("SALES", SwingConstants.CENTER);
	private JPanel salesPanel = new JPanel();

	public ManagerPanel() {
		setTitle("SEF Assignment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		productsPanel();
		dashboardPanel();
		refactorThisCode();
		customerPanel();
		salesPanel();
		supplierPanel();
		reportPanel();
		employeesPanel();
		systemPanel();
	}

	private void productsPanel() {
		JLabel productsTitle = new JLabel("Products");
		productsTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		productsTitle.setBounds(19, 6, 100, 38);
		productsPanel.add(productsTitle);

		JPanel panel = new JPanel();
		panel.setBounds(6, 78, 1030, 84);
		productsPanel.add(panel);
		panel.setLayout(null);

		JLabel lblProducts = new JLabel("PRODUCTS", SwingConstants.CENTER);
		lblProducts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProducts.setForeground(Color.WHITE);
		lblProducts.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblProducts.setBounds(0, 183, 163, 62);
		actionPanel.add(lblProducts);

		JLabel addProductButton = new JLabel("Add Product", SwingConstants.CENTER);
		addProductButton.setBounds(873, 21, 125, 41);
		panel.add(addProductButton);
		addProductButton.setOpaque(true);
		addProductButton.setForeground(Color.WHITE);
		addProductButton.setBackground(new Color(255, 140, 0));
		addProductButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));

		JComboBox actionBox = new JComboBox();
		actionBox.setBounds(39, 30, 165, 32);
		actionBox.addItem("Add Item");
		actionBox.addItem("Modify Item");
		actionBox.addItem("Remove item");
		panel.add(actionBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 180, 981, 528);
		productsPanel.add(scrollPane);

// Temporary data - shouldn't be here. Need to comply with MVC
		Object[][] data = { { "1", "Apple", "Fruit", "", "$1.00", "100", "Fruit" },
				{ "2", "Apple", "Fruit", "", "$1.00", "100", "Fruit" },
				{ "3", "Apple", "Fruit", "", "$1.00", "100", "Fruit" },
				{ "4", "Apple", "Fruit", "", "$1.00", "100", "Fruit" },
				{ "5", "Apple", "Fruit", "", "$1.00", "100", "Fruit" },
				{ "6", "Apple", "Fruit", "", "$1.00", "100", "Fruit" }, };

		String[] columnHeaders = { "ID", "Name", "Type", "Description", "Price", "Stock", "Category" };

		table = new JTable(data, columnHeaders);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		lblProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(productsPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

	}

	private void dashboardPanel() {

		dashBoardLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dashBoardLbl.setForeground(Color.WHITE);
		dashBoardLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		dashBoardLbl.setBounds(0, 110, 163, 62);
		actionPanel.add(dashBoardLbl);

		todaySalesPanel.setBounds(44, 96, 396, 229);
		dashboardPanel.add(todaySalesPanel);
		todaySalesPanel.setLayout(null);

		JLabel dashboardLbl = new JLabel("Dashboard");
		dashboardLbl.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		dashboardLbl.setBounds(44, 52, 100, 32);
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

		dashBoardLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(dashboardPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
	}

	private void refactorThisCode() {

		actionPanel.setBackground(Color.DARK_GRAY);
		actionPanel.setBounds(0, 0, 174, 750);
		contentPane.add(actionPanel);
		actionPanel.setLayout(null);

		salesLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salesLbl.setForeground(new Color(255, 255, 255));
		salesLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		salesLbl.setBounds(0, 246, 163, 62);
		actionPanel.add(salesLbl);

//		image
		JLabel lblNewLabel = new JLabel("", SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ManagerPanel.class.getResource("/images/Sef4.jpg")));
		lblNewLabel.setBounds(44, 16, 69, 72);
		actionPanel.add(lblNewLabel);

		parentPanel.setBounds(164, 0, 1036, 750);
		contentPane.add(parentPanel);
		parentPanel.setLayout(new CardLayout(0, 0));

		productsPanel.setBackground(Color.WHITE);
		parentPanel.add(productsPanel, "name_282454748275033");
		productsPanel.setLayout(null);

		dashboardPanel.setBackground(new Color(0, 128, 128));
		parentPanel.add(dashboardPanel, "name_282481430111453");
		dashboardPanel.setLayout(null);

		JPanel welcomeDateTimeBorder = new JPanel();
		welcomeDateTimeBorder.setBackground(new Color(128, 128, 128));
		welcomeDateTimeBorder.setBounds(0, 0, 1036, 40);
		dashboardPanel.add(welcomeDateTimeBorder);
		welcomeDateTimeBorder.setLayout(null);

		JLabel welcomeLbl = new JLabel("Welcome [getName/getId]");
		welcomeLbl.setBounds(6, 6, 163, 16);
		welcomeDateTimeBorder.add(welcomeLbl);

		JLabel dateTimeLbl = new JLabel("[DATE][TIME]");
		dateTimeLbl.setBounds(934, 6, 96, 16);
		welcomeDateTimeBorder.add(dateTimeLbl);

		salesPanel.setBackground(Color.BLUE);
		parentPanel.add(salesPanel, "name_282489540810395");

		supplierPanel.setBackground(Color.CYAN);
		parentPanel.add(supplierPanel, "name_282496209162460");

		JPanel systemPanel = new JPanel();
		parentPanel.add(systemPanel, "name_282499597586599");


	}

	private void customerPanel() {
		parentPanel.add(customersPanel, "name_282493106161656");

		JLabel CustomerLbl = new JLabel("CUSTOMERS", SwingConstants.CENTER);
		CustomerLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CustomerLbl.setForeground(Color.WHITE);
		CustomerLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		CustomerLbl.setBounds(0, 329, 163, 62);
		actionPanel.add(CustomerLbl);

		CustomerLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(customersPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
	}

	private void salesPanel() {

		salesLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(salesPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});

	}

	private void supplierPanel() {

		JLabel logisticsLbl = new JLabel("SUPPLIER", SwingConstants.CENTER);
		logisticsLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logisticsLbl.setForeground(Color.WHITE);
		logisticsLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		logisticsLbl.setBounds(0, 420, 163, 62);
		actionPanel.add(logisticsLbl);

		logisticsLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentPanel.removeAll();
				parentPanel.add(supplierPanel);
				parentPanel.repaint();
				parentPanel.revalidate();
			}
		});
	}

	private void reportPanel() {
		JLabel generateReportLbl = new JLabel("REPORT", SwingConstants.CENTER);
		generateReportLbl.setForeground(Color.WHITE);
		generateReportLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		generateReportLbl.setBounds(0, 505, 163, 62);
		actionPanel.add(generateReportLbl);
	}

	private void employeesPanel() {

		JLabel lblEmployeeManagement = new JLabel("EMPLOYEES", SwingConstants.CENTER);
		lblEmployeeManagement.setForeground(Color.WHITE);
		lblEmployeeManagement.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblEmployeeManagement.setBounds(0, 579, 163, 62);
		actionPanel.add(lblEmployeeManagement);
	}

	private void systemPanel() {
		JLabel SystemLbl = new JLabel("SYSTEM", SwingConstants.CENTER);
		SystemLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SystemLbl.setForeground(Color.WHITE);
		SystemLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		SystemLbl.setBounds(0, 669, 163, 62);
		actionPanel.add(SystemLbl);

	}
}
