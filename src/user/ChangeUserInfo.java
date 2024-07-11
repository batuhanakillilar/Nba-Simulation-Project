package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ChangeUserInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input;
	private JTextField Username;
	private JTextField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeUserInfo frame = new ChangeUserInfo();
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
	public ChangeUserInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel info = new JLabel("Select the info that you want to change:");
		info.setBounds(21, 125, 299, 35);
		contentPane.add(info);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Age", "Password", "E-Mail"}));
		comboBox.setBounds(282, 130, 117, 27);
		contentPane.add(comboBox);
		
		input = new JTextField();
		input.setBounds(227, 233, 185, 26);
		contentPane.add(input);
		input.setColumns(10);
		
		JLabel Enter = new JLabel("Please enter the new info:");
		Enter.setBounds(21, 236, 185, 21);
		contentPane.add(Enter);
		
		JLabel labelss = new JLabel("Please enter your username:");
		labelss.setBounds(21, 40, 212, 26);
		contentPane.add(labelss);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter your password:");
		lblNewLabel_1.setBounds(21, 78, 264, 27);
		contentPane.add(lblNewLabel_1);
		
		Username = new JTextField();
		Username.setBounds(247, 40, 165, 26);
		contentPane.add(Username);
		Username.setColumns(10);
		
		Password = new JTextField();
		Password.setBounds(247, 78, 165, 27);
		contentPane.add(Password);
		Password.setColumns(10);
		
		// I read the users file here and turn it to a string to check later
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
			String line;
			
			while((line = reader.readLine()) != null) {
				
				lines.add(line);
				
			}
			
			reader.close();
				
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Save ");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * Checks the inputs and validates them, if they are true change the users.txt file and update it.
			 */
			public void actionPerformed(ActionEvent e) {
				String message = "Update is succesfull";
				String age_war = "Invalid age";
				String password_war = "Invalid password";
				String email_war = "Invalid e-mail";
					
					for(int i = 0; i < lines.size(); i ++) {
						String list[] = lines.get(i).split(",");
						if(list[4].equals(Username.getText()) && list[5].equals(Password.getText())) {
								
							try {
								BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"));
								if(comboBox.getSelectedItem().toString() == "Age") {
									if(UserValidity.ageValidity(Integer.parseInt(input.getText())) == true) {
										
										JOptionPane.showMessageDialog(btnNewButton, message);
										writer.write(list[0] + "," +list[1] + "," + input.getText() + "," +list[3] + "," +list[4] + "," +list[5] + "\n");
										setVisible(false);
									}
									else {
										
										JOptionPane.showMessageDialog(btnNewButton, age_war);
									}
									
									
								}
								if(comboBox.getSelectedItem().toString() == "Password") {
									if(UserValidity.passwordValidity(input.getText()) == true) {
										writer.write(list[0] + "," +list[1] + "," + list[2] + "," +list[3] + "," +list[4] + "," + input.getText() + "\n");
										JOptionPane.showMessageDialog(btnNewButton, message);
										setVisible(false);
									}
									else {
										
										JOptionPane.showMessageDialog(btnNewButton, password_war);
									}
									
								}
								if(comboBox.getSelectedItem().toString() == "E-Mail") {
									if(UserValidity.emailValidity(input.getText()) == true) {
										
										writer.write(list[0] + "," +list[1] + "," + list[2] + "," + input.getText() + "," +list[4] + "," +list[5] + "\n");
										JOptionPane.showMessageDialog(btnNewButton, message);
										setVisible(false);
									}
									else {
										JOptionPane.showMessageDialog(btnNewButton, email_war);
										
									}
									
									
								}
								writer.close();
								lines.remove(i);
									
									
							} catch (IOException e1) {
									// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}			
								
								
							}
						for(int i = 0; i < lines.size(); i ++) {
							String list[] = lines.get(i).split(",");
							try {
								BufferedWriter writer2 = new BufferedWriter(new FileWriter("users.txt",true));
								writer2.write(list[0] + "," +list[1] + "," + list[2] + "," +list[3] + "," +list[4] + "," +list[5] + "\n");
								writer2.close();
								
								
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
							
							
						}
					
					
					
				}
				
				
			
		});
		btnNewButton.setBounds(216, 320, 212, 29);
		contentPane.add(btnNewButton);
	}
}
