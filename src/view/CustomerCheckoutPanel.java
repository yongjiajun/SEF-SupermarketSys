package view;

import java.awt.Color;
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
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class CustomerCheckoutPanel extends JFrame {

	private JPanel contentPane;


	public CustomerCheckoutPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(30, 144, 255));
		mainPanel.setBounds(0, 0, 1200, 750);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		JLabel grocerySystemTitle = new JLabel("Kostco Market");
		grocerySystemTitle.setForeground(new Color(255, 255, 255));
		grocerySystemTitle.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		grocerySystemTitle.setBounds(806, 96, 188, 70);
		mainPanel.add(grocerySystemTitle);

		JButton selectItem = new JButton("Select Item");
		selectItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen login = new LoginScreen();
				login.setVisible(true);
				validate();
				revalidate();

			}
		});
		selectItem.setBounds(751, 390, 298, 43);
		mainPanel.add(selectItem);

		JPanel dateTimePanel = new JPanel();
		dateTimePanel.setBackground(new Color(102, 102, 102));
		dateTimePanel.setForeground(new Color(102, 102, 102));
		dateTimePanel.setBounds(0, 0, 1200, 50);
		mainPanel.add(dateTimePanel);
		dateTimePanel.setLayout(null);

		JLabel welcomeLbl = new JLabel("Welcome, [getID]");
		welcomeLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		welcomeLbl.setForeground(Color.WHITE);
		welcomeLbl.setBounds(18, 8, 234, 30);
		dateTimePanel.add(welcomeLbl);

		// Need to fix so the time changes value overtime. Integrate ClockPanel if you know how
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

		JButton requireAssistanceBtn = new JButton("I NEED ASSISTANCE");
		requireAssistanceBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				INeedAssistanceLogin inaLogin = new INeedAssistanceLogin();
				inaLogin.setVisible(true);
			}
		});
		requireAssistanceBtn.setBackground(new Color(102, 102, 102));
		requireAssistanceBtn.setOpaque(true);
		requireAssistanceBtn.setBounds(970, 7, 219, 38);
		assisstancePanel.add(requireAssistanceBtn);

		JButton cancelOrderBtn = new JButton("Cancel Order");
		cancelOrderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cancelResp = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel your order?", "Cancel Order", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (cancelResp == JOptionPane.YES_OPTION) {
					WelcomeScreen welcomeScreen = new WelcomeScreen();
					welcomeScreen.setVisible(true);
					dispose();
				}
			}
		});
		cancelOrderBtn.setOpaque(true);
		cancelOrderBtn.setBackground(new Color(102, 102, 102));
		cancelOrderBtn.setBounds(720, 7, 187, 38);
		assisstancePanel.add(cancelOrderBtn);

		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(66, 90, 471, 158);
		mainPanel.add(imagePanel);

		JButton enterItemBtn = new JButton("Enter Item");
		enterItemBtn.setBounds(751, 460, 298, 43);
		mainPanel.add(enterItemBtn);

		JButton btnFinishAndPay = new JButton("Finish and Pay");
		btnFinishAndPay.setBounds(751, 539, 298, 43);
		mainPanel.add(btnFinishAndPay);

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
}
