package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import player.PlayerManagement;
import team.Drafting;
import team.Team;
import team.TeamManagement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class PlayerDrafting extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerDrafting frame = new PlayerDrafting();
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
	public PlayerDrafting() {
		
		Team chosenteam =null;
		for (Team t : TeamManagement.teams) {
			if (t.isSelected() == true) {
				chosenteam = t;
			}
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 384);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Draft Your Players For Each Position");
		lblNewLabel.setFont(new Font("Euphemia UCAS", Font.BOLD, 15));
		lblNewLabel.setBounds(118, 6, 331, 38);
		contentPane.add(lblNewLabel);
		
		JLabel team = new JLabel("");
		team.setBounds(136, 29, 69, 25);
		contentPane.add(team);
		
		JLabel lblNewLabel_2 = new JLabel("Choose Your Center Player:");
		lblNewLabel_2.setBounds(22, 54, 183, 38);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBoxCenter = new JComboBox();
		comboBoxCenter.setBounds(250, 62, 239, 25);
		contentPane.add(comboBoxCenter);
		
		JComboBox comboBoxPower = new JComboBox();
		comboBoxPower.setBounds(250, 104, 239, 27);
		contentPane.add(comboBoxPower);
		
		JComboBox comboBoxPoint = new JComboBox();
		comboBoxPoint.setBounds(250, 143, 239, 27);
		contentPane.add(comboBoxPoint);
		
		JComboBox comboBoxSmall = new JComboBox();
		comboBoxSmall.setBounds(250, 182, 239, 27);
		contentPane.add(comboBoxSmall);
		
		JComboBox comboBoxShooting = new JComboBox();
		comboBoxShooting.setBounds(250, 221, 239, 27);
		contentPane.add(comboBoxShooting);
		
		JButton Choose = new JButton("Choose");
		Choose.setVisible(false);
		Choose.setEnabled(false);
		Choose.addActionListener(new ActionListener() {
			
			/**
			 * Let the user choose the players for each position and then other teams choose their players randomly in a random order. After that teams' info written 
			 * into the Teams.txt file 
			 */
			public void actionPerformed(ActionEvent e) {
				
				Team chosenteam =null;
				for (Team t : TeamManagement.teams) {
					if (t.isSelected() == true) {
						chosenteam = t;
					}
				}
				
			
				
				for(int i = 0; i < PlayerManagement.CenterPlayers.size(); i++){
					
					if(comboBoxCenter.getSelectedItem().toString() == PlayerManagement.CenterPlayers.get(i).getName()) {
						
						chosenteam.getTeam().add(PlayerManagement.CenterPlayers.get(i));
						PlayerManagement.CenterPlayers.remove(i);
						
							
						
					}
					
					
				}
				
				for(int i = 0; i < PlayerManagement.PowerForwards.size(); i++){
					
					if(comboBoxPower.getSelectedItem().toString() == PlayerManagement.PowerForwards.get(i).getName()) {
						
						chosenteam.getTeam().add(PlayerManagement.PowerForwards.get(i));
						PlayerManagement.PowerForwards.remove(i);
						
							
						
					}
					
					
				}
				
				for(int i = 0; i < PlayerManagement.PointGuards.size(); i++){
					
					if(comboBoxPoint.getSelectedItem().toString() == PlayerManagement.PointGuards.get(i).getName()) {
						
						chosenteam.getTeam().add(PlayerManagement.PointGuards.get(i));
						PlayerManagement.PointGuards.remove(i);
						
							
						
					}
					
					
				}
				
				for(int i = 0; i < PlayerManagement.ShootingGuards.size(); i++){
					
					if(comboBoxShooting.getSelectedItem().toString() == PlayerManagement.ShootingGuards.get(i).getName()) {
						
						chosenteam.getTeam().add(PlayerManagement.ShootingGuards.get(i));
						PlayerManagement.ShootingGuards.remove(i);
						
							
						
					}
					
					
				}
				
				for(int i = 0; i < PlayerManagement.SmallForwards.size(); i++){
					
					if(comboBoxSmall.getSelectedItem().toString() == PlayerManagement.SmallForwards.get(i).getName()) {
						
						chosenteam.getTeam().add(PlayerManagement.SmallForwards.get(i));
						PlayerManagement.SmallForwards.remove(i);
						
							
						
					}
					
					
				}
				
				TeamManagement.teams.remove(chosenteam);
				
				Collections.shuffle(TeamManagement.teams);
				Drafting.DraftC(TeamManagement.teams, PlayerManagement.CenterPlayers);
				Drafting.DraftPF(TeamManagement.teams, PlayerManagement.PowerForwards);
				Drafting.DraftPG(TeamManagement.teams, PlayerManagement.PointGuards);
				Drafting.DraftSG(TeamManagement.teams, PlayerManagement.ShootingGuards);
				Drafting.DraftSF(TeamManagement.teams, PlayerManagement.SmallForwards);
				
				
				TeamManagement.teams.add(chosenteam);
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("Teams.txt"));
					for(int i = 0; i < TeamManagement.teams.size(); i++) {
						writer.write("Team Name: " + TeamManagement.teams.get(i).getName() + " Players: " + TeamManagement.teams.get(i).getTeam().get(0).getName() + "," + 
								TeamManagement.teams.get(i).getTeam().get(1).getName() + "," + TeamManagement.teams.get(i).getTeam().get(2).getName() + "," + TeamManagement.teams.get(i).getTeam().get(3).getName() + "," + 
								TeamManagement.teams.get(i).getTeam().get(4).getName() + "\n");
						
					}
					writer.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				String message = "Your Team is: " + chosenteam.getName() + "\n" + "Your players: " + "\n";
				
				for(int i = 0; i< chosenteam.getTeam().size(); i++) {
					
					message += chosenteam.getTeam().get(i).getName() + "\n";
					
				}
				
				
				JOptionPane.showMessageDialog(Choose, message);
				setVisible(false);
				SeasonMenu menu = new SeasonMenu();
				menu.setVisible(true);
				
				

				
				
			}
		});
		Choose.setBounds(279, 315, 131, 34);
		contentPane.add(Choose);
		
		JButton Start = new JButton("Start drafting");
		Start.addActionListener(new ActionListener() {
			
			/**
			 * Fill the comboBox's with the players 
			 */
			public void actionPerformed(ActionEvent e) {
				
				
				
				PlayerManagement pg = new PlayerManagement();
				pg.PlayerCreation();
				
				
				
					
					for(int i = 0; i < PlayerManagement.CenterPlayers.size(); i++) {
						
						comboBoxCenter.addItem(PlayerManagement.CenterPlayers.get(i).getName());
						
						
					}
					
					for(int i = 0; i < PlayerManagement.PowerForwards.size(); i++) {
						
						comboBoxPower.addItem(PlayerManagement.PowerForwards.get(i).getName());
						
						
						
					}
					
					for(int i = 0; i < PlayerManagement.PointGuards.size(); i++) {
						
						comboBoxPoint.addItem(PlayerManagement.PointGuards.get(i).getName());
						
						
						
					}
					
					for(int i = 0; i < PlayerManagement.ShootingGuards.size(); i++) {
						
						comboBoxShooting.addItem(PlayerManagement.ShootingGuards.get(i).getName());
						
						
						
					}
					
					for(int i = 0; i < PlayerManagement.SmallForwards.size(); i++) {
						
						comboBoxSmall.addItem(PlayerManagement.SmallForwards.get(i).getName());
						
						
						
					}
					
					Start.setVisible(false);
					Start.setEnabled(false);
					Choose.setVisible(true);
					Choose.setEnabled(true);
					
					

				
			}
		});
		Start.setBounds(279, 315, 131, 34);
		contentPane.add(Start);
		
		JLabel lblNewLabel_3 = new JLabel("Choose Your Power Forward:");
		lblNewLabel_3.setBounds(22, 104, 183, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Choose Your Point Guard:");
		lblNewLabel_4.setBounds(22, 147, 183, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Choose Your Small Forward:");
		lblNewLabel_5.setBounds(22, 186, 183, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Choose Your Shooting Guard:");
		lblNewLabel_6.setBounds(22, 225, 199, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Press \"Choose\" to lock in your drafts");
		lblNewLabel_7.setBounds(22, 325, 245, 16);
		contentPane.add(lblNewLabel_7);
		
		
		
	
	}
}
