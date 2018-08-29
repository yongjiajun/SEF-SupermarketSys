package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;

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

	public WelcomeScreen() {
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

		JLabel grocerySystemTitle = new JLabel("Welcome to [Market Name]");
		grocerySystemTitle.setForeground(new Color(255, 255, 255));
		grocerySystemTitle.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		grocerySystemTitle.setBounds(731, 98, 373, 65);
		mainPanel.add(grocerySystemTitle);

		JLabel checkoutDescription = new JLabel("(Members Only)");
		checkoutDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkoutDescription.setForeground(new Color(255, 255, 255));
		checkoutDescription.setBounds(843, 257, 161, 43);
		mainPanel.add(checkoutDescription);

		JLabel checkoutDescription1 = new JLabel("Self Service Checkout");
		checkoutDescription1.setForeground(Color.WHITE);
		checkoutDescription1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		checkoutDescription1.setBounds(816, 217, 213, 43);
		mainPanel.add(checkoutDescription1);

		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen login = new LoginScreen();
				login.setVisible(true);
				validate();
				revalidate();

			}
		});
		btnStart.setBounds(803, 465, 225, 81);
		mainPanel.add(btnStart);

		JLabel startDescription = new JLabel("Press \"Start\" to begin self service");
		startDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		startDescription.setForeground(new Color(255, 255, 255));
		startDescription.setBounds(803, 437, 288, 24);
		mainPanel.add(startDescription);

		JPanel dateTimePanel = new JPanel();
		dateTimePanel.setBackground(new Color(128, 128, 128));
		dateTimePanel.setForeground(new Color(128, 128, 128));
		dateTimePanel.setBounds(0, 0, 1200, 43);
		mainPanel.add(dateTimePanel);
		dateTimePanel.setLayout(null);

		JLabel welcomeLbl = new JLabel("Welcome");
		welcomeLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		welcomeLbl.setBounds(519, 6, 112, 31);
		dateTimePanel.add(welcomeLbl);
//Need to fix so the time changes value overtime. Integrate ClockPanel if you know how
		String date = new SimpleDateFormat("[dd/MM/yyyy] [hh:mm:ss]").format(new Date());
        JLabel labelTime = new JLabel(date);
        labelTime.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        labelTime.setBounds(952, 7, 242, 35);
 		dateTimePanel.add(labelTime);


		JPanel assisstancePanel = new JPanel();
		assisstancePanel.setForeground(Color.GRAY);
		assisstancePanel.setBackground(Color.GRAY);
		assisstancePanel.setBounds(0, 678, 1200, 50);
		mainPanel.add(assisstancePanel);
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
		mainPanel.add(imagePanel);
	}

}
