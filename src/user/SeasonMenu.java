package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.Team;
import team.TeamManagement;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class SeasonMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeasonMenu frame = new SeasonMenu();
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
	public SeasonMenu() {
		setTitle("REGULAR SEASON");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 554);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane goster = new JTextPane();
		goster.setFont(new Font("Euphemia UCAS", Font.BOLD, 14));
		goster.setBounds(6, 6, 307, 379);
		contentPane.add(goster);
		
		JTextPane matchs = new JTextPane();
		matchs.setFont(new Font("Euphemia UCAS", Font.BOLD, 15));
		matchs.setBounds(434, 6, 380, 379);
		contentPane.add(matchs);
		
		JLabel lblPressToSimulate = new JLabel("Press to simulate 1st games:");
		lblPressToSimulate.setFont(new Font("Euphemia UCAS", Font.PLAIN, 16));
		lblPressToSimulate.setBounds(25, 446, 288, 32);
		contentPane.add(lblPressToSimulate);
	
		JTextPane Wins = new JTextPane();
		Wins.setFont(new Font("Euphemia UCAS", Font.BOLD, 14));
		Wins.setBounds(312, 6, 49, 379);
		contentPane.add(Wins);
		
		JTextPane Loses = new JTextPane();
		Loses.setFont(new Font("Euphemia UCAS", Font.BOLD, 14));
		Loses.setBounds(360, 6, 47, 379);
		contentPane.add(Loses);
		
		
		
		
		PlayOffs playoff = new PlayOffs();
		
		JButton playoffs = new JButton("Continue to Playoffs");
		playoffs.addActionListener(new ActionListener() {
			/*
			 * Opens the playoff screen
			 */
			public void actionPerformed(ActionEvent e) {
				
				
				
				playoff.setVisible(true);
				
				
				
			}
		});
		playoffs.setBounds(594, 445, 163, 41);
		contentPane.add(playoffs);
		
		playoffs.setVisible(false);
		
		
		
		
		JButton Play = new JButton("Simulate");
		Play.addActionListener(new ActionListener() {
			
			int a = 0;
			/*
			 * Does the matches for every team for 30 times(I have 16 teams) print the results and win/lose counters on the screen. Write the results to a text file.
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				
				int i = 0;
				String matchscores= "             This Weeks Results:" + "\n" + "\n";
				String wins = "W" + "\n";
				String loses = "L" + "\n";
				while (i < 15) {
					
					
					TeamManagement.teams.get(i).doMatch(TeamManagement.teams.get(i+1));
					
					matchscores += TeamManagement.teams.get(i).getName() + " " + TeamManagement.teams.get(i).getInstantscore() + " : " + TeamManagement.teams.get(i+1).getName() + " " + TeamManagement.teams.get(i+1).getInstantscore() + "\n";
					TeamManagement.teams.get(i).setInstantscore(0);
					TeamManagement.teams.get(i+1).setInstantscore(0);
					
					
					i += 2;
					
					
				
				}
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("Normal Season Results.txt",true));
					writer.write(matchscores + "\n");
					writer.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Collections.sort(TeamManagement.teams, Comparator.comparingInt(Team::getWins).reversed());
				matchs.setText(matchscores);
				String puandurumu = "Team Standings: " + "\n";
				
				for (Team t : TeamManagement.teams) {
					puandurumu += t.getName() + "\n";
					wins += t.getWins() + "\n";
					loses += t.getLoses() + "\n";
				}
				goster.setText(puandurumu);
				Wins.setText(wins);
				Loses.setText(loses);
				
				lblPressToSimulate.setText("Press to simulate next week's games:");
				
				a += 1;
				Collections.shuffle(TeamManagement.teams);
				
				if(a == 30) {
					
					
					Play.setVisible(false);
					lblPressToSimulate.setText("Regular season has finished");
					playoffs.setVisible(true);
					

				}
				
				
				
			}
			
			
		});
		Play.setBounds(332, 442, 163, 46);
		contentPane.add(Play);
		
		
		
		
		
		
		
		
		
	}
}
