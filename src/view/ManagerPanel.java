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


	private JPanel contentPane;
	private JTable table;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					AdminPanel frame = new AdminPanel();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	public ManagerPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		productsPanel();
	}


	private void productsPanel() {


		JPanel Panel = new JPanel();
		Panel.setBackground(Color.DARK_GRAY);
		Panel.setBounds(0, 0, 167, 750);
		contentPane.add(Panel);
		Panel.setLayout(null);


		JLabel salesLbl = new JLabel("SALES", SwingConstants.CENTER);

		salesLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salesLbl.setForeground(new Color(255, 255, 255));
		salesLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		salesLbl.setBounds(0, 194, 163, 62);
		Panel.add(salesLbl);

		JLabel dashBoardLbl = new JLabel("DASHBOARD", SwingConstants.CENTER);

		dashBoardLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dashBoardLbl.setForeground(Color.WHITE);
		dashBoardLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		dashBoardLbl.setBounds(0, 120, 163, 62);
		Panel.add(dashBoardLbl);

		JLabel CustomerLbl = new JLabel("CUSTOMERS", SwingConstants.CENTER);
		CustomerLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CustomerLbl.setForeground(Color.WHITE);
		CustomerLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		CustomerLbl.setBounds(0, 285, 163, 62);
		Panel.add(CustomerLbl);

		JLabel SystemLbl = new JLabel("SYSTEM", SwingConstants.CENTER);
		SystemLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SystemLbl.setForeground(Color.WHITE);
		SystemLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		SystemLbl.setBounds(0, 610, 163, 62);
		Panel.add(SystemLbl);

		JLabel lblNewLabel = new JLabel("", SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ManagerPanel.class.getResource("/images/Sef4.jpg")));
		lblNewLabel.setBounds(44, 16, 69, 72);
		Panel.add(lblNewLabel);

		JLabel lblProducts = new JLabel("PRODUCTS", SwingConstants.CENTER);
		lblProducts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProducts.setForeground(Color.WHITE);
		lblProducts.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblProducts.setBounds(0, 381, 163, 62);
		Panel.add(lblProducts);

		JLabel supplierLbl = new JLabel("SUPPLIER", SwingConstants.CENTER);
		supplierLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supplierLbl.setForeground(Color.WHITE);
		supplierLbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		supplierLbl.setBounds(0, 491, 163, 62);
		Panel.add(supplierLbl);

		JPanel parentPanel = new JPanel();
		parentPanel.setBounds(164, 0, 1036, 750);
		contentPane.add(parentPanel);
		parentPanel.setLayout(new CardLayout(0, 0));

		JPanel productsPanel = new JPanel();
		productsPanel.setBackground(Color.WHITE);
		parentPanel.add(productsPanel, "name_282454748275033");
		productsPanel.setLayout(null);

		JLabel productsTitle = new JLabel("Products");
		productsTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		productsTitle.setBounds(6, 6, 100, 38);
		productsPanel.add(productsTitle);

		JPanel panel = new JPanel();
		panel.setBounds(0, 78, 1036, 84);
		productsPanel.add(panel);
		panel.setLayout(null);

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
		Object[][] data = {
				{"1","Apple","Fruit","","$1.00","100","Fruit"},
				{"2","Apple","Fruit","","$1.00","100","Fruit"},
				{"3","Apple","Fruit","","$1.00","100","Fruit"},
				{"4","Apple","Fruit","","$1.00","100","Fruit"},
				{"5","Apple","Fruit","","$1.00","100","Fruit"},
				{"6","Apple","Fruit","","$1.00","100","Fruit"},
		};

		String[] columnHeaders = {"ID", "Name", "Type", "Description", "Price", "Stock", "Category"};

		table = new JTable(data, columnHeaders);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setBackground(Color.BLUE);
		parentPanel.add(dashboardPanel, "name_282481430111453");

		JPanel salesPanel = new JPanel();
		salesPanel.setBackground(Color.BLUE);
		parentPanel.add(salesPanel, "name_282489540810395");

		JPanel customersPanel = new JPanel();
		parentPanel.add(customersPanel, "name_282493106161656");

		JPanel supplierPanel = new JPanel();
		supplierPanel.setBackground(Color.CYAN);
		parentPanel.add(supplierPanel, "name_282496209162460");

		JPanel systemPanel = new JPanel();
		parentPanel.add(systemPanel, "name_282499597586599");

//		Temporary action listeners
		lblProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  parentPanel.removeAll();
				  parentPanel.add(productsPanel);
				  parentPanel.repaint();
				  parentPanel.revalidate();
			}
		});

		dashBoardLbl.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked (MouseEvent e) {
				parentPanel.removeAll();
				  parentPanel.add(dashboardPanel);
				  parentPanel.repaint();
				  parentPanel.revalidate();
			}
		});

		CustomerLbl.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked (MouseEvent e) {
				parentPanel.removeAll();
				  parentPanel.add(customersPanel);
				  parentPanel.repaint();
				  parentPanel.revalidate();
			}
		});
		salesLbl.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked (MouseEvent e) {
				parentPanel.removeAll();
				  parentPanel.add(salesPanel);
				  parentPanel.repaint();
				  parentPanel.revalidate();
			}
		});

		supplierLbl.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked (MouseEvent e) {
				  parentPanel.removeAll();
				  parentPanel.add(supplierPanel);
				  parentPanel.repaint();
				  parentPanel.revalidate();
			}
		});
	}
}
