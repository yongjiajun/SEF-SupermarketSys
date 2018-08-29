package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 1200, 750);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel grocerySystemTitle = new JLabel("Welcome to [Market Name]");
		grocerySystemTitle.setForeground(new Color(255, 255, 255));
		grocerySystemTitle.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		grocerySystemTitle.setBounds(731, 98, 373, 65);
		panel.add(grocerySystemTitle);

		JLabel checkoutDescription = new JLabel("(Members Only)");
		checkoutDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkoutDescription.setForeground(new Color(255, 255, 255));
		checkoutDescription.setBounds(843, 257, 161, 43);
		panel.add(checkoutDescription);

		JLabel checkoutDescription1 = new JLabel("Self Service Checkout");
		checkoutDescription1.setForeground(Color.WHITE);
		checkoutDescription1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkoutDescription1.setBounds(816, 217, 213, 43);
		panel.add(checkoutDescription1);

		JButton btnStart = new JButton("START");
		btnStart.setBounds(803, 465, 225, 81);
		panel.add(btnStart);

		JLabel lblNewLabel = new JLabel("Press \"Start\" to begin self service");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(803, 437, 288, 16);
		panel.add(lblNewLabel);

		JPanel dateTimePanel = new JPanel();
		dateTimePanel.setBackground(new Color(128, 128, 128));
		dateTimePanel.setForeground(new Color(128, 128, 128));
		dateTimePanel.setBounds(0, 0, 1200, 43);
		panel.add(dateTimePanel);
		dateTimePanel.setLayout(null);

		JLabel welcomeLbl = new JLabel("Welcome");
		welcomeLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		welcomeLbl.setBounds(519, 6, 112, 31);
		dateTimePanel.add(welcomeLbl);

		JLabel dateTimeLbl = new JLabel("[DATE][TIME]");
		dateTimeLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		dateTimeLbl.setBounds(1005, 6, 189, 31);
		dateTimePanel.add(dateTimeLbl);

		JPanel assisstancePanel = new JPanel();
		assisstancePanel.setForeground(Color.GRAY);
		assisstancePanel.setBackground(Color.GRAY);
		assisstancePanel.setBounds(0, 678, 1200, 50);
		panel.add(assisstancePanel);
		assisstancePanel.setLayout(null);

		JButton requireAssistanceBtn = new JButton("I NEED ASSISTANCE");
//		requireAssistanceBtn.setBackground(new Color(255, 0, 0));
		requireAssistanceBtn.setBackground(new Color(128, 128, 128));
//		requireAssistanceBtn.setForeground(new Color(255, 0, 0));
		requireAssistanceBtn.setOpaque(true);
		requireAssistanceBtn.setBounds(926, 6, 219, 38);
		assisstancePanel.add(requireAssistanceBtn);

		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(66, 83, 455, 514);
		panel.add(imagePanel);
	}
}
