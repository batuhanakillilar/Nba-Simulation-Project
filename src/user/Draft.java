package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.Team;
import team.TeamManagement;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Draft extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ArrayList<Team> updated;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Draft frame = new Draft();
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
	public Draft() {
		
		updated = new ArrayList<Team>();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Euphemia UCAS", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Boston Celtics", "Chicago Bulls", "Cleveland Cavaliers", "Miami Heat", "Orlando Magic", "Denver Nuggets", "Utah Jazz", "Golden State Warriors", "Los Angeles Lakers", "Houston Rockets", "San Antonio Spurs", "Dallas Mavericks", "Toronto Raptors", "Brooklyn Nets", "New York Nicks", "Atlanta Hawks"}));
		comboBox.setBounds(93, 81, 271, 65);
		contentPane.add(comboBox);
		
		JButton choose = new JButton("Choose");
		choose.setFont(new Font("Euphemia UCAS", Font.BOLD, 14));
		choose.addActionListener(new ActionListener() {
			
			/**
			 * Let the user choose their team and mark its isSelected field
			 */
			public void actionPerformed(ActionEvent e) {
				
				JLabel team = new JLabel("New label");
				team.setBounds(183, 218, 180, 48);
				contentPane.add(team);
				
				TeamManagement tm = new TeamManagement();
				tm.CreateTeams();
				for(Team t: TeamManagement.teams) {
					
					if(comboBox.getSelectedItem().toString() == t.getName()) {
						
						t.SelectTeam();
						team.setText(t.getName());

					}
					
				}
				setVisible(false);
				PlayerDrafting pf = new PlayerDrafting();
				pf.setVisible(true);
				
			
				
			}
		});
		choose.setBounds(159, 177, 129, 36);
		contentPane.add(choose);
		
		JLabel lblNewLabel = new JLabel("Choose Your Team");
		lblNewLabel.setFont(new Font("Euphemia UCAS", Font.BOLD, 15));
		lblNewLabel.setBounds(143, 44, 189, 36);
		contentPane.add(lblNewLabel);
	}

	public ArrayList<Team> getUpdated() {
		return updated;
	}
}
