package team;

import java.util.ArrayList;
import java.util.Random;

import player.C;
import player.PF;
import player.PG;
import player.Player;
import player.SF;
import player.SG;

public class Drafting {
	
	/**
	 * A method to randomly draft C players to teams
	 * @param teams
	 * @param players
	 */
	public static void DraftC(ArrayList<Team> teams,ArrayList<C> players) {
		
		for(int i = 0 ; i < 15 ; i++) {
			Random random = new Random();
			int random_num = random.nextInt(players.size());
			teams.get(i).team.add(players.get(random_num));
			players.remove(random_num);
			
		}
		
		
	}
	
	/**
	 * A method to randomly draft C players to teams
	 * @param teams
	 * @param players
	 */
	public static void DraftPF(ArrayList<Team> teams,ArrayList<PF> players) {
			
			for(int i = 0 ; i < 15 ; i++) {
				Random random = new Random();
				int random_num = random.nextInt(players.size());
				teams.get(i).team.add(players.get(random_num));
				players.remove(random_num);
				
			}
			
			
		}
	
	/**
	 * A method to randomly draft C players to teams
	 * @param teams
	 * @param players
	 */
	public static void DraftPG(ArrayList<Team> teams,ArrayList<PG> players) {
		
		for(int i = 0 ; i < 15 ; i++) {
			Random random = new Random();
			int random_num = random.nextInt(players.size());
			teams.get(i).team.add(players.get(random_num));
			players.remove(random_num);
			
		}
		
		
	}
	
	/**
	 * A method to randomly draft C players to teams
	 * @param teams
	 * @param players
	 */
	public static void DraftSF(ArrayList<Team> teams,ArrayList<SF> players) {
		
		for(int i = 0 ; i < 15 ; i++) {
			Random random = new Random();
			int random_num = random.nextInt(players.size());
			teams.get(i).team.add(players.get(random_num));
			players.remove(random_num);
			
		}
		
		
	}
	/**
	 * A method to randomly draft C players to teams
	 * @param teams
	 * @param players
	 */
	public static void DraftSG(ArrayList<Team> teams,ArrayList<SG> players) {
		
		for(int i = 0 ; i < 15 ; i++) {
			Random random = new Random();
			int random_num = random.nextInt(players.size());
			teams.get(i).team.add(players.get(random_num));
			players.remove(random_num);
			
		}
		
		
	}

}
