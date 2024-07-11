package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.Team;
import team.TeamManagement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class PlayOffs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayOffs frame = new PlayOffs();
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
	public PlayOffs() {
		setTitle("PLAY OFFS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel team_1 = new JLabel("1st Team");
		team_1.setBounds(30, 28, 142, 23);
		contentPane.add(team_1);
		
		JLabel team_8 = new JLabel("8th Team");
		team_8.setBackground(Color.GRAY);
		team_8.setBounds(30, 63, 142, 23);
		contentPane.add(team_8);
		
		JLabel team_2 = new JLabel("2nd Team");
		team_2.setBounds(30, 138, 142, 23);
		contentPane.add(team_2);
		
		JLabel team_7 = new JLabel("7th Team");
		team_7.setBounds(30, 173, 113, 28);
		contentPane.add(team_7);
		
		JLabel team_3 = new JLabel("3rd Team");
		team_3.setBounds(30, 243, 142, 28);
		contentPane.add(team_3);
		
		JLabel team_6 = new JLabel("6th Team");
		team_6.setBounds(30, 281, 142, 28);
		contentPane.add(team_6);
		
		JLabel team_4 = new JLabel("4th Team");
		team_4.setBounds(30, 350, 113, 29);
		contentPane.add(team_4);
		
		JLabel team_5 = new JLabel("5th Team");
		team_5.setBounds(30, 391, 113, 28);
		contentPane.add(team_5);
		
		JLabel semi_1 = new JLabel("1st Semi-Finalist");
		semi_1.setBounds(184, 42, 164, 23);
		contentPane.add(semi_1);
		
		JLabel semi_2 = new JLabel("2nd Semi-Finalist");
		semi_2.setBounds(184, 148, 164, 28);
		contentPane.add(semi_2);
		
		JLabel semi_3 = new JLabel("3rd Semi-Finalist");
		semi_3.setBounds(184, 268, 164, 23);
		contentPane.add(semi_3);
		
		JLabel semi_4 = new JLabel("4th Semi-Finalist");
		semi_4.setBounds(184, 373, 164, 23);
		contentPane.add(semi_4);
		
		JLabel final_1 = new JLabel("1st Finalist");
		final_1.setBounds(362, 96, 122, 16);
		contentPane.add(final_1);
		
		JLabel final_2 = new JLabel("2nd Finalist");
		final_2.setBounds(362, 318, 122, 16);
		contentPane.add(final_2);
		
		JLabel winner = new JLabel("Winner");
		winner.setBounds(441, 203, 164, 34);
		contentPane.add(winner);
		
		JTextPane results = new JTextPane();
		results.setBounds(605, 51, 291, 356);
		contentPane.add(results);
		
		JLabel lblNewLabel_1 = new JLabel("Match Results");
		lblNewLabel_1.setBounds(714, 31, 107, 16);
		contentPane.add(lblNewLabel_1);
		
		
		JButton Play_semi = new JButton("Simulate");
		Play_semi.setBounds(319, 464, 133, 46);
		Play_semi.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		Play_semi.setVisible(false);
		Play_semi.setEnabled(false);
		contentPane.add(Play_semi);
		
		JButton play_final = new JButton("Simulate");
		play_final.setBounds(319, 464, 133, 46);
		play_final.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		play_final.setVisible(false);
		play_final.setEnabled(false);
		contentPane.add(play_final);
		
		
		
		ArrayList<Team> playoff_teams = new ArrayList<Team>();
		ArrayList<Team> semi_finalists = new ArrayList<Team>();
		ArrayList<Team> finalists = new ArrayList<Team>();
				
		
		JButton Play = new JButton("Simulate");
		Play.setBounds(319, 464, 133, 46);
		Play.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		Play.addActionListener(new ActionListener() {
			/**
			 * Get the first 8 team regarding their win counts and make them play with each other for the quarter finals. Print the results of the matches on the screen
			 */
			public void actionPerformed(ActionEvent e) {
				
				String matchscores = "";
				Collections.sort(TeamManagement.teams, Comparator.comparingInt(Team::getWins).reversed());
				for(int i = 0; i < 8; i ++) {
					
					playoff_teams.add(TeamManagement.teams.get(i));
				}
				
				team_1.setText(playoff_teams.get(0).getName());
				team_2.setText(playoff_teams.get(1).getName());
				team_3.setText(playoff_teams.get(2).getName());
				team_4.setText(playoff_teams.get(3).getName());
				team_5.setText(playoff_teams.get(4).getName());
				team_6.setText(playoff_teams.get(5).getName());
				team_7.setText(playoff_teams.get(6).getName());
				team_8.setText(playoff_teams.get(7).getName());
				
				
				playoff_teams.get(0).doMatch(playoff_teams.get(7));
				playoff_teams.get(1).doMatch(playoff_teams.get(6));
				playoff_teams.get(2).doMatch(playoff_teams.get(5));
				playoff_teams.get(3).doMatch(playoff_teams.get(4));
				
				matchscores += playoff_teams.get(0).getName() + " " +  playoff_teams.get(0).getInstantscore() + " : " + playoff_teams.get(7).getName() +  " " + playoff_teams.get(7).getInstantscore() + "\n";
				matchscores += playoff_teams.get(1).getName() + " " + playoff_teams.get(1).getInstantscore() + " : " + playoff_teams.get(6).getName() +  " " + playoff_teams.get(6).getInstantscore() + "\n";
				matchscores += playoff_teams.get(2).getName() + " " + playoff_teams.get(2).getInstantscore() + " : " + playoff_teams.get(5).getName() +  " " + playoff_teams.get(5).getInstantscore() + "\n";
				matchscores +=playoff_teams.get(3).getName() + " " + playoff_teams.get(3).getInstantscore() + " : " + playoff_teams.get(4).getName() +  " " + playoff_teams.get(4).getInstantscore() + "\n";
				
				results.setText(matchscores);
				
				
				if(playoff_teams.get(0).getInstantscore() > playoff_teams.get(7).getInstantscore()) {
					
					semi_finalists.add(playoff_teams.get(0));
					semi_1.setText(playoff_teams.get(0).getName());
					
					
				}
				if(playoff_teams.get(7).getInstantscore() > playoff_teams.get(0).getInstantscore()) {
					
					semi_finalists.add(playoff_teams.get(7));
					semi_1.setText(playoff_teams.get(7).getName());
					
					
				}
				
				
				if(playoff_teams.get(1).getInstantscore() > playoff_teams.get(6).getInstantscore()) {
					
					semi_finalists.add(playoff_teams.get(1));
					semi_2.setText(playoff_teams.get(1).getName());
					
					
				}
				if(playoff_teams.get(6).getInstantscore() > playoff_teams.get(1).getInstantscore()) {
					
					semi_finalists.add(playoff_teams.get(6));
					semi_2.setText(playoff_teams.get(6).getName());
					
					
				}
				
				
				if(playoff_teams.get(2).getInstantscore() > playoff_teams.get(5).getInstantscore()) {
					
					semi_finalists.add(playoff_teams.get(2));
					semi_3.setText(playoff_teams.get(2).getName());
					
					
				}
				if(playoff_teams.get(5).getInstantscore() > playoff_teams.get(2).getInstantscore()) {
					
					semi_finalists.add(playoff_teams.get(5));
					semi_3.setText(playoff_teams.get(5).getName());
					
					
				}
				
				
				if(playoff_teams.get(3).getInstantscore() > playoff_teams.get(4).getInstantscore()) {
					
					semi_finalists.add(playoff_teams.get(3));
					semi_4.setText(playoff_teams.get(3).getName());
					
					
				}
				if(playoff_teams.get(4).getInstantscore() > playoff_teams.get(3).getInstantscore()) {
					
					semi_finalists.add(playoff_teams.get(4));
					semi_4.setText(playoff_teams.get(4).getName());
					
					
				}
				
				semi_finalists.get(0).setInstantscore(0);
				semi_finalists.get(1).setInstantscore(0);
				semi_finalists.get(2).setInstantscore(0);
				semi_finalists.get(3).setInstantscore(0);
				
				Play.setVisible(false);
				Play.setEnabled(false);
				
				Play_semi.setVisible(true);
				Play_semi.setEnabled(true);
				
				
			}
		});
		contentPane.add(Play);
		
		

		Play_semi.addActionListener(new ActionListener() {
			/**
			 * Let the semi finalists do their matches and print the results on the screen
			 */
			public void actionPerformed(ActionEvent e) {
				
				String semi_scores = "";
				
				semi_finalists.get(0).doMatch(semi_finalists.get(1));
				semi_finalists.get(2).doMatch(semi_finalists.get(3));
				
				semi_scores += semi_finalists.get(0).getName() + semi_finalists.get(0).getInstantscore() + " : " + semi_finalists.get(1).getName() + semi_finalists.get(1).getInstantscore() + "\n";
				semi_scores += semi_finalists.get(2).getName() + semi_finalists.get(2).getInstantscore() + " : " + semi_finalists.get(3).getName() + semi_finalists.get(3).getInstantscore() + "\n";
				
				
				results.setText(semi_scores);
				
				
				
				if(semi_finalists.get(0).getInstantscore() > semi_finalists.get(1).getInstantscore()) {
					
					finalists.add(semi_finalists.get(0));
					final_1.setText(semi_finalists.get(0).getName());
				}
				if(semi_finalists.get(1).getInstantscore() > semi_finalists.get(0).getInstantscore()) {
					
					finalists.add(semi_finalists.get(1));
					final_1.setText(semi_finalists.get(1).getName());
				}
				
				
				if(semi_finalists.get(2).getInstantscore() > semi_finalists.get(3).getInstantscore()) {
					
					finalists.add(semi_finalists.get(2));
					final_2.setText(semi_finalists.get(2).getName());
				}
				if(semi_finalists.get(3).getInstantscore() > semi_finalists.get(2).getInstantscore()) {
					
					finalists.add(semi_finalists.get(3));
					final_2.setText(semi_finalists.get(3).getName());
				}
				
				finalists.get(0).setInstantscore(0);
				finalists.get(1).setInstantscore(0);
				
				Play_semi.setVisible(false);
				Play_semi.setEnabled(false);
				play_final.setVisible(true);
				play_final.setEnabled(true);
				
				
				
				
				
			}
		});
		
		
		
		play_final.addActionListener(new ActionListener() {
			/*
			 * Does the final match and announce the champion
			 */
			public void actionPerformed(ActionEvent e) {
				
				String matchscores = playoff_teams.get(0).getName() + " " +  playoff_teams.get(0).getInstantscore() + " : " + playoff_teams.get(7).getName() +  " " + playoff_teams.get(7).getInstantscore() + "\n";
				matchscores += playoff_teams.get(1).getName() + " " + playoff_teams.get(1).getInstantscore() + " : " + playoff_teams.get(6).getName() +  " " + playoff_teams.get(6).getInstantscore() + "\n";
				matchscores += playoff_teams.get(2).getName() + " " + playoff_teams.get(2).getInstantscore() + " : " + playoff_teams.get(5).getName() +  " " + playoff_teams.get(5).getInstantscore() + "\n";
				matchscores +=playoff_teams.get(3).getName() + " " + playoff_teams.get(3).getInstantscore() + " : " + playoff_teams.get(4).getName() +  " " + playoff_teams.get(4).getInstantscore() + "\n";
				
				String semi_scores = semi_finalists.get(0).getName() + semi_finalists.get(0).getInstantscore() + " : " + semi_finalists.get(1).getName() + semi_finalists.get(1).getInstantscore() + "\n";
				semi_scores += semi_finalists.get(2).getName() + semi_finalists.get(2).getInstantscore() + " : " + semi_finalists.get(3).getName() + semi_finalists.get(3).getInstantscore() + "\n";
				
				String final_scores = "";
				
				finalists.get(0).doMatch(finalists.get(1));
				final_scores += finalists.get(0).getName() + " " + finalists.get(0).getInstantscore() + " : " + finalists.get(1).getName() +  " " + finalists.get(1).getInstantscore() + "\n";
				
				results.setText(final_scores);
				
				if(finalists.get(0).getInstantscore() > finalists.get(1).getInstantscore()) {
					
					winner.setText(finalists.get(0).getName());
				}
				
				if(finalists.get(1).getInstantscore() > finalists.get(0).getInstantscore()) {
					
					winner.setText(finalists.get(1).getName());
				}
				
				String Winner = " The Champion is" + "\n" + winner.getText() + "!";
				
				JOptionPane.showMessageDialog(Play, Winner);
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("Playoff Results.txt"));
					writer.write("Quarter Final Results" + "\n" + matchscores + "\n" + "Semifinal Results:" + "\n" + semi_scores +  "\nFinal Result: " + "\n" + final_scores
							+ "\n" + "The Champion is: " + winner.getText());
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		
	}
}
