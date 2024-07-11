package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField age;
	private JTextField email;
	private JTextField nickname;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("REGISTER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Euphemia UCAS", Font.PLAIN, 14));
		lblNewLabel.setBounds(62, 17, 78, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setFont(new Font("Euphemia UCAS", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(62, 45, 78, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Euphemia UCAS", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(62, 157, 78, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setFont(new Font("Euphemia UCAS", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(62, 101, 78, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nickname:");
		lblNewLabel_4.setFont(new Font("Euphemia UCAS", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(62, 129, 78, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Age:");
		lblNewLabel_5.setFont(new Font("Euphemia UCAS", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(62, 73, 78, 22);
		contentPane.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(152, 12, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		surname = new JTextField();
		surname.setBounds(152, 41, 130, 26);
		contentPane.add(surname);
		surname.setColumns(10);
		
		age = new JTextField();
		age.setBounds(152, 69, 130, 26);
		contentPane.add(age);
		age.setColumns(10);
		
		email = new JTextField();
		email.setBounds(152, 97, 130, 26);
		contentPane.add(email);
		email.setColumns(10);
		
		nickname = new JTextField();
		nickname.setBounds(152, 125, 130, 26);
		contentPane.add(nickname);
		nickname.setColumns(10);
		
		password = new JTextField();
		password.setBounds(152, 153, 130, 26);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton register = new JButton("Register");
		register.setFont(new Font("Euphemia UCAS", Font.BOLD, 15));
		register.addActionListener(new ActionListener() {
			/*
			 * Read file checks if username exist. Then checks if the validations are true or not. Write it into users.txt if it is all true
			 */
			public void actionPerformed(ActionEvent e) {
				
				
				
				String Name = name.getText();
				String Surname = surname.getText();
				int Age = Integer.parseInt(age.getText());
				String Email = email.getText();
				String Nickname = nickname.getText();
				String Password = password.getText();
				String warning =  " ";
				boolean isSameNick = false;
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
					String line;
					while((line = reader.readLine()) != null) {
						
						String[] list = line.split(",");
							
						if(list[4].equals(Nickname) ) {
								
							warning += "This username is taken";
							isSameNick = true;
							
								
						}
					}
					
					reader.close();
					
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				
				
				if(UserValidity.nameValidity(Name) == true && UserValidity.nameValidity(Surname) == true && UserValidity.ageValidity(Age) == true
						&& UserValidity.emailValidity(Email) == true && UserValidity.usernameValidity(Nickname) && UserValidity.passwordValidity(Password) == true && isSameNick == false) {
					
					
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt",true));
						writer.write(Name + "," + Surname + "," + Age + "," + Email + "," + Nickname + "," + Password + "\n");
						writer.close();
						warning += "Your registration is succesful";
						setVisible(false);
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
								
					
					
				}
				if(UserValidity.nameValidity(Name) == false && UserValidity.nameValidity(Surname) == true && UserValidity.ageValidity(Age) == true
						&& UserValidity.emailValidity(Email) == true && UserValidity.usernameValidity(Nickname)== true && UserValidity.passwordValidity(Password) == true) {
					
					warning += "The name you entered is not valid, It should be at least 3 characters and consist of alphabetic characters only";
					
					
				}
				if(UserValidity.nameValidity(Name) == true && UserValidity.nameValidity(Surname) == true && UserValidity.ageValidity(Age) == false
						&& UserValidity.emailValidity(Email) == true && UserValidity.usernameValidity(Nickname) == true && UserValidity.passwordValidity(Password) == true) {
					
					warning += "The age you entered is not valid, You should at least be 12";
					
					
				}
				if(UserValidity.nameValidity(Name) == true && UserValidity.nameValidity(Surname) == true && UserValidity.ageValidity(Age) == true
						&& UserValidity.emailValidity(Email) == false && UserValidity.usernameValidity(Nickname)== true && UserValidity.passwordValidity(Password) == true) {
					
					warning += "The e-mail you entered is not valid, please check the format";
					
					
				}
				if(UserValidity.nameValidity(Name) == true && UserValidity.nameValidity(Surname) == true && UserValidity.ageValidity(Age) == true
						&& UserValidity.emailValidity(Email) == true && UserValidity.usernameValidity(Nickname) == false && UserValidity.passwordValidity(Password) == true) {
					
					
					warning += "The nickname you entered is not valid, it should be consist of alphabetic characters or digits";
					
					
				}
				if(UserValidity.nameValidity(Name) == true && UserValidity.nameValidity(Surname) == true && UserValidity.ageValidity(Age) == true
						&& UserValidity.emailValidity(Email) == true && UserValidity.usernameValidity(Nickname) == true && UserValidity.passwordValidity(Password) == false) {
					
					warning += "The password you entered is not valid,It should consist at least one alphabetic character, one digit, one special character and it should at least have 8 characters ";
					
					
				}
				if(UserValidity.nameValidity(Name) == true && UserValidity.nameValidity(Surname) == false && UserValidity.ageValidity(Age) == true
						&& UserValidity.emailValidity(Email) == true && UserValidity.usernameValidity(Nickname) == true && UserValidity.passwordValidity(Password) == true) {
					
					warning += "The surname you entered is not valid, It should be at least 3 characters and consist of alphabetic characters only";
					
					
				}
				
				
				
				JOptionPane.showMessageDialog(register, warning);
				
				AnaEkran ak = new AnaEkran();
				ak.setVisible(true);
			
				
				
				
				
				
			}
		});
		register.setBounds(152, 207, 150, 42);
		contentPane.add(register);
	}

}
