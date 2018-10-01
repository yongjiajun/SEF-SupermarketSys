package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.EmployeeLoginController;
import model.people.Customer;

public class CustomerCheckoutPanel extends JFrame {

	private JPanel contentPane, mainPanel, enterItemPanel, selectItemPanel;
	private JButton logoutBtn, finishAndPayBtn, removeItemBtn, requireAssistanceBtn, selectItemBtn, enterItemBtn;
	private Customer customer;
	private WelcomeScreen welcomeScreen;

	public CustomerCheckoutPanel(Customer customer) {
		this.customer = customer;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(30, 144, 255));
		mainPanel.setBounds(0, 0, 1200, 750);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		topBotPanel();
		leftSection();
		rightSection();
		selectItemPanel();
		enterItemPanel();

	}
	
	public void topBotPanel() {
		JPanel dateTimePanel = new JPanel();
		dateTimePanel.setBackground(new Color(102, 102, 102));
		dateTimePanel.setForeground(new Color(102, 102, 102));
		dateTimePanel.setBounds(0, 0, 1200, 50);
		mainPanel.add(dateTimePanel);
		dateTimePanel.setLayout(null);

		JLabel welcomeLbl = new JLabel("Welcome, " + customer.getUserFName());
		welcomeLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		welcomeLbl.setForeground(Color.WHITE);
		welcomeLbl.setBounds(18, 8, 234, 30);
		dateTimePanel.add(welcomeLbl);

		// Need to fix so the time changes value overtime. Integrate ClockPanel if you
		// know how
		String date = new SimpleDateFormat("[dd/MM/yyyy] [hh:mm:ss]").format(new Date());
		JLabel labelTime = new JLabel(date);
		labelTime.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		labelTime.setForeground(Color.WHITE);
		labelTime.setBounds(975, 9, 220, 30);
		dateTimePanel.add(labelTime);

		JPanel assisstancePanel = new JPanel();
		assisstancePanel.setForeground(new Color(102, 102, 102));
		assisstancePanel.setBackground(new Color(102, 102, 102));
		assisstancePanel.setBounds(0, 678, 1200, 50);
		mainPanel.add(assisstancePanel);
		assisstancePanel.setLayout(null);

		requireAssistanceBtn = new JButton("I NEED ASSISTANCE");
		requireAssistanceBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				INeedAssistanceLogin inaLogin = new INeedAssistanceLogin();
//				inaLogin.setVisible(true);

				EmployeeLoginController employeeLoginController = new EmployeeLoginController();

				JLabel idLabel = new JLabel("Username:");
				JTextField id = new JTextField();

				JLabel pwLabel = new JLabel("Password:");
				JPasswordField pw = new JPasswordField();

				Object[] array = { idLabel, id, pwLabel, pw };

				int response;

				do {
					response = JOptionPane.showConfirmDialog(null, array, "Login", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {
						if (employeeLoginController.checkCredentials(id.getText(), pw.getPassword())) {
							employeeLogin();
							break;
						}

						else {
							JOptionPane.showMessageDialog(null, "Login Failed. Please try again.");
							id.setText("");
							pw.setText("");
						}
					}

				} while (response != JOptionPane.CANCEL_OPTION && response != JOptionPane.CLOSED_OPTION);
			}
		});

		requireAssistanceBtn.setBackground(new Color(102, 102, 102));
		requireAssistanceBtn.setOpaque(true);
		requireAssistanceBtn.setBounds(970, 7, 219, 38);
		assisstancePanel.add(requireAssistanceBtn);

		JButton cancelOrderBtn = new JButton("CANCEL ORDER");
		cancelOrderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cancelResp = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel your order?",
						"Cancel Order", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (cancelResp == JOptionPane.YES_OPTION) {
					employeeLogout();
					welcomeScreen.setVisible(true);
					dispose();
					validate();
					revalidate();
				}
			}
		});
		cancelOrderBtn.setOpaque(true);
		cancelOrderBtn.setBackground(new Color(102, 102, 102));
		cancelOrderBtn.setBounds(720, 7, 187, 38);
		assisstancePanel.add(cancelOrderBtn);

		logoutBtn = new JButton("LOGOUT");
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cancelResp = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (cancelResp == JOptionPane.YES_OPTION) {
					employeeLogout();
				}
			}
		});
		logoutBtn.setOpaque(true);
		logoutBtn.setBackground(new Color(102, 102, 102));
		logoutBtn.setBounds(18, 7, 187, 38);
		logoutBtn.setVisible(false);
		assisstancePanel.add(logoutBtn);
	}

	public void leftSection() {
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(66, 90, 471, 158);
		mainPanel.add(imagePanel);
		
		JPanel itemListPanel = new JPanel();
		itemListPanel.setBounds(66, 283, 471, 357);
		mainPanel.add(itemListPanel);
		itemListPanel.setLayout(null);

		JLabel totalLabel = new JLabel("Total");
		totalLabel.setBounds(10, 330, 61, 16);
		itemListPanel.add(totalLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 311, 471, 12);
		itemListPanel.add(separator);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
	}
	
	public void rightSection() {
		JLabel grocerySystemTitle = new JLabel("Kostco Market");
		grocerySystemTitle.setForeground(new Color(255, 255, 255));
		grocerySystemTitle.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		grocerySystemTitle.setBounds(806, 96, 188, 70);
		mainPanel.add(grocerySystemTitle);
		
		selectItemBtn = new JButton("Select Item");
		selectItemBtn.setBounds(751, 390, 298, 43);
		selectItemBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectItemPanel.setVisible(true);
				displayButtons(false);
			}
		});
		mainPanel.add(selectItemBtn);
		
		enterItemBtn = new JButton("Enter Item");
		enterItemBtn.setBounds(751, 460, 298, 43);
		enterItemBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterItemPanel.setVisible(true);
				displayButtons(false);
			}
		});
		mainPanel.add(enterItemBtn);

		finishAndPayBtn = new JButton("Finish and Pay");
		finishAndPayBtn.setBounds(751, 530, 298, 43);
		mainPanel.add(finishAndPayBtn);

		removeItemBtn = new JButton("Remove Item");
		removeItemBtn.setBounds(751, 530, 298, 43);
		removeItemBtn.setVisible(false);
		mainPanel.add(removeItemBtn);
	}
	
	public void enterItemPanel() {
		enterItemPanel = new JPanel();
		enterItemPanel.setBounds(701, 200, 398, 400);
		enterItemPanel.setBackground(Color.WHITE);
		enterItemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		enterItemPanel.setLayout(null);
		enterItemPanel.setVisible(false);
		mainPanel.add(enterItemPanel);

		JLabel enterItemLbl = new JLabel("Enter Item Info");
		enterItemLbl.setBounds(115, 10, 170, 20);
		enterItemLbl.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		enterItemPanel.add(enterItemLbl);

		JLabel idLbl = new JLabel("ID", SwingConstants.CENTER);
		idLbl.setBounds(48, 70, 76, 22);
		idLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		enterItemPanel.add(idLbl);

		JTextField idTextField = new JTextField();
		idTextField.setBounds(149, 65, 163, 32);
		enterItemPanel.add(idTextField);

		JLabel nameLbl = new JLabel("Name", SwingConstants.CENTER);
		nameLbl.setBounds(48, 130, 76, 22);
		nameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		enterItemPanel.add(nameLbl);

		JTextField nameTextField = new JTextField();
		nameTextField.setBounds(149, 125, 163, 32);
		enterItemPanel.add(nameTextField);

		JLabel weightLbl = new JLabel("Weight", SwingConstants.CENTER);
		weightLbl.setBounds(48, 200, 76, 22);
		weightLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		enterItemPanel.add(weightLbl);

		JTextField weightTextField = new JTextField();
		weightTextField.setBounds(149, 195, 163, 32);
		enterItemPanel.add(weightTextField);

		JLabel quantityLbl = new JLabel("Quantity", SwingConstants.CENTER);
		quantityLbl.setBounds(48, 270, 76, 22);
		quantityLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		enterItemPanel.add(quantityLbl);

		JTextField quantityTextField = new JTextField();
		quantityTextField.setBounds(149, 265, 163, 32);
		enterItemPanel.add(quantityTextField);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterItemPanel.setVisible(false);
				displayButtons(true);
			}
		});
		cancelBtn.setBounds(25, 339, 122, 38);
		enterItemPanel.add(cancelBtn);

		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Add item to item list
			}
		});
		addBtn.setBounds(251, 339, 122, 38);
		enterItemPanel.add(addBtn);
	}

	public void selectItemPanel() {
		selectItemPanel = new JPanel();
		selectItemPanel.setBounds(701, 200, 398, 442);
		selectItemPanel.setBackground(Color.WHITE);
		selectItemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		selectItemPanel.setLayout(null);
		selectItemPanel.setVisible(false);
		mainPanel.add(selectItemPanel);
		
		JTextArea itemTextArea = new JTextArea();
		itemTextArea.setEditable(false);
		
		JScrollPane itemScrollPane = new JScrollPane(itemTextArea);
		itemScrollPane.setPreferredSize(new Dimension(264, 200));
		itemScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		itemScrollPane.setBackground(Color.RED);
		itemScrollPane.setVisible(true);
		itemScrollPane.setBounds(25, 25, 348, 300);
		selectItemPanel.add(itemScrollPane);
		
		JLabel quantityLbl = new JLabel("Quantity");
		quantityLbl.setBounds(30, 341, 76, 22);
		quantityLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		selectItemPanel.add(quantityLbl);
		
		JTextField quantityTextField = new JTextField();
		quantityTextField.setBounds(125, 336, 60, 32);
		quantityTextField.setText("1");
		quantityTextField.setHorizontalAlignment(JTextField.CENTER);
		selectItemPanel.add(quantityTextField);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectItemPanel.setVisible(false);
				displayButtons(true);
			}
		});
		cancelBtn.setBounds(25, 381, 122, 38);
		selectItemPanel.add(cancelBtn);

		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Add item to item list
			}
		});
		addBtn.setBounds(251, 381, 122, 38);
		selectItemPanel.add(addBtn);
	}
	
	public void employeeLogin() {
		logoutBtn.setVisible(true);
		finishAndPayBtn.setVisible(false);
		removeItemBtn.setVisible(true);
		requireAssistanceBtn.setVisible(false);
		mainPanel.setBackground(new Color(25, 150, 125));
	}
	

	public void employeeLogout() {
		logoutBtn.setVisible(false);
		removeItemBtn.setVisible(false);
		finishAndPayBtn.setVisible(true);
		requireAssistanceBtn.setVisible(true);
		mainPanel.setBackground(new Color(30, 144, 255));
	}

	public void displayButtons(Boolean display) {
		enterItemBtn.setVisible(display);
		selectItemBtn.setVisible(display);
		finishAndPayBtn.setVisible(display);
		if (logoutBtn.isVisible()) {
			removeItemBtn.setVisible(display);
			finishAndPayBtn.setVisible(false);
		}
	}
	
	public void setWelcomeScreen(WelcomeScreen welcomeScreen) {
		this.welcomeScreen = welcomeScreen;
	}

	
}
