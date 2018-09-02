package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	private JPanel contentPane, parentPanel, sideBarPanel, dashboardPanel, todaySalesPanel, productsPanel,
			customersPanel, suppliersPanel, salesPanel, reportPanel, employeesPanel, systemPanel;
	private JTable table;

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

		JComboBox actionBox = new JComboBox();
		actionBox.setBounds(833, 23, 166, 40);
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

	}

	private void customersPanel() {
		customersPanel = new JPanel();
		customersPanel.setBackground(Color.BLACK);
		parentPanel.add(customersPanel);

	}

	private void salesPanel() {
		salesPanel = new JPanel();
		salesPanel.setBackground(Color.BLUE);
		parentPanel.add(salesPanel);

	}

	private void suppliersPanel() {
		suppliersPanel = new JPanel();
		suppliersPanel.setBackground(Color.RED);
		parentPanel.add(suppliersPanel);
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
		parentPanel.add(systemPanel);
	}
}
