package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GameMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMenu frame = new GameMenu();
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
	public GameMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("To Change User Info:");
		lblNewLabel.setBounds(6, 234, 146, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start the Game");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * Opens the draft page
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				
				Draft draft = new Draft();
				draft.setVisible(true);
			}
		});
		btnNewButton.setBounds(156, 131, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.addActionListener(new ActionListener() {
			/**
			 * Opens the user info change menu
			 */
			public void actionPerformed(ActionEvent e) {
				
				ChangeUserInfo change = new ChangeUserInfo();
				change.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(144, 232, 105, 22);
		contentPane.add(btnNewButton_1);
	}
}
