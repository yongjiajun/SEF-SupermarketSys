package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.LoginController;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel errorMessage;
	private LoginController loginController = new LoginController(this);

	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(30, 144, 255));
		mainPanel.setBounds(0, 0, 1200, 750);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		JLabel grocerySystemTitle = new JLabel("Welcome to Kostco");
		grocerySystemTitle.setForeground(new Color(255, 255, 255));
		grocerySystemTitle.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		grocerySystemTitle.setBounds(423, 88, 373, 65);
		mainPanel.add(grocerySystemTitle);

		JLabel pinLabel = new JLabel("PIN");
		pinLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		pinLabel.setForeground(new Color(255, 255, 255));
		pinLabel.setBounds(374, 277, 53, 43);
		mainPanel.add(pinLabel);

		JLabel idLabel = new JLabel("ID");
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		idLabel.setBounds(379, 222, 35, 43);
		mainPanel.add(idLabel);

		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				char[] pw = passwordField.getPassword();
				loginController.checkCredentials(id, pw);

			}
		});
		loginBtn.setBounds(479, 350, 141, 56);
		mainPanel.add(loginBtn);

		errorMessage = new JLabel("Login Failed. Please try again.");
		errorMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(479, 400, 600, 200);
		errorMessage.setVisible(false);
		mainPanel.add(errorMessage);

		JPanel dateTimePanel = new JPanel();
		dateTimePanel.setBackground(new Color(128, 128, 128));
		dateTimePanel.setForeground(new Color(128, 128, 128));
		dateTimePanel.setBounds(0, 0, 1200, 43);
		mainPanel.add(dateTimePanel);
		dateTimePanel.setLayout(null);

		JLabel loginTitle = new JLabel("Login");
		loginTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		loginTitle.setBounds(519, 6, 112, 31);
		dateTimePanel.add(loginTitle);

		JLabel dateTimeLbl = new JLabel();
//		dateTimeLbl.add(new ClockPanel());

		dateTimeLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		dateTimeLbl.setBounds(1005, 6, 189, 31);
		dateTimePanel.add(dateTimeLbl);

		JPanel assisstancePanel = new JPanel();
		assisstancePanel.setForeground(Color.GRAY);
		assisstancePanel.setBackground(Color.GRAY);
		assisstancePanel.setBounds(0, 678, 1200, 50);
		mainPanel.add(assisstancePanel);
		assisstancePanel.setLayout(null);

		JButton requireAssistanceBtn = new JButton("I NEED ASSISTANCE");
		requireAssistanceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				INeedAssistanceLogin inaLogin = new INeedAssistanceLogin();
				inaLogin.setVisible(true);
			}
		});
		requireAssistanceBtn.setBackground(new Color(128, 128, 128));
		requireAssistanceBtn.setOpaque(true);
		requireAssistanceBtn.setBounds(926, 6, 219, 38);
		assisstancePanel.add(requireAssistanceBtn);

		JButton backBtn = new JButton("BACK");
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				dispose();
				WelcomeScreen welcomeScreen = new WelcomeScreen();
				welcomeScreen.setVisible(true);
				validate();
				revalidate();
			}
		});
		backBtn.setOpaque(true);
		backBtn.setBackground(Color.GRAY);
		backBtn.setBounds(20, 6, 142, 38);
		assisstancePanel.add(backBtn);

		textField = new JTextField();
		textField.setBounds(426, 222, 257, 37);
		mainPanel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(427, 283, 256, 37);
		mainPanel.add(passwordField);
	}

	public void setErrorMessageVisible(Boolean value) {
		errorMessage.setVisible(!value);
	}
}
