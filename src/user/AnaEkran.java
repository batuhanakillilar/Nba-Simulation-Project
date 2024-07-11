package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AnaEkran extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
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
	public AnaEkran() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Welcome to NBA Simulation Game");
		lblNewLabel.setFont(new Font("Euphemia UCAS", Font.BOLD, 16));
		lblNewLabel.setBounds(80, 24, 315, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Register if you do not have an account");
		lblNewLabel_1.setBounds(16, 254, 269, 48);
		lblNewLabel_1.setFont(new Font("Euphemia UCAS", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1);
		
		JButton sign_in = new JButton("Log In");
		sign_in.setBounds(151, 191, 117, 29);
	
		sign_in.addActionListener(new ActionListener() {
			/**
			 * This button reads users file check if inputs are true or not.
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) { 
				
				String warning = "";
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
					String line;
					while((line = reader.readLine()) != null) {
						
						String[] list = line.split(",");
							
						if(list[4].equals(username.getText()) && list[5].equals(password.getText())) {
								
							warning = "Log in succesful";
							GameMenu menu = new GameMenu();
							menu.setVisible(true);
								
						}
						
						if(list[4].equals(username.getText()) == true && list[5].equals(password.getText()) == false) {
							
							warning = "Wrong password!";
						}
						
						if(list[4].equals(username.getText()) == false && list[5].equals(password.getText()) == true) {
							
							warning = "Wrong username!";
						}
						
						if(list[4].equals(username.getText()) == false && list[5].equals(password.getText()) == false) {
							
							warning = "Wrong username and password!";
						}
						
						
					}
					
					reader.close();
					
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(sign_in, warning);
				setVisible(false);
				
			}
		});
		contentPane.add(sign_in);
		
		JButton register = new JButton("Register");
		register.setBounds(278, 266, 117, 29);
		register.addActionListener(new ActionListener() {
			/**
			 * button to open register page
			 */
			public void actionPerformed(ActionEvent e) {
				
				Register reg = new Register();
				reg.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(register);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Euphemia UCAS", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(80, 110, 78, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Euphemia UCAS", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(80, 146, 78, 16);
		contentPane.add(lblNewLabel_3);
		
		username = new JTextField();
		username.setBounds(170, 106, 160, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(170, 142, 160, 26);
		contentPane.add(password);
		password.setColumns(10);
	}
}
