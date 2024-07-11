package team;

import java.util.ArrayList;

public class TeamManagement {
	
	public static ArrayList<Team> teams;
	
	
	
	public TeamManagement() {
		teams = new ArrayList<Team>();
	}

	/**
	 * Method to create team objects and add them to teams arraylist
	 */
	public void CreateTeams() {
		
		Team Celtics = new Team("Boston Celtics");
		Team ChicagoBulls = new Team("Chicago Bulls");
		Team Cavaliers = new Team("Cleveland Cavaliers");
		Team MiamiHeat = new Team("Miami Heat");
		Team OrlandoMagic = new Team("Orlando Magic");
		Team DenverNuggets = new Team("Denver Nuggets");
		Team UtahJazz = new Team("Utah Jazz");
		Team GoldenState = new Team("Golden State Warriors");
		Team Lakers = new Team("Los Angeles Lakers");
		Team HoustonRockets = new Team("Houston Rockets");
		Team Spurs = new Team("San Antonio Spurs");
		Team Mavericks = new Team("Dallas Mavericks");
		Team Raptors = new Team("Toronto Raptors");
		Team Nets = new Team("Brooklyn Nets");
		Team Knicks = new Team("New York Nicks");
		Team Hawks = new Team("Atlanta Hawks"); 
		
		teams.add(Celtics);
		teams.add(ChicagoBulls);
		teams.add(Cavaliers);
		teams.add(MiamiHeat);
		teams.add(OrlandoMagic);
		teams.add(DenverNuggets);
		teams.add(UtahJazz);
		teams.add(GoldenState);
		teams.add(Lakers);
		teams.add(HoustonRockets);
		teams.add(Spurs);
		teams.add(Mavericks);
		teams.add(Raptors);
		teams.add(Nets);
		teams.add(Knicks);
		teams.add(Hawks);
		

	}
	
	
	

	

}
