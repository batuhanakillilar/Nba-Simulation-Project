package team;

import java.util.ArrayList;
import java.util.HashMap;

import player.Player;

public class Team {
	
	protected String name;
	protected boolean isSelected;
	protected ArrayList<Player> team; 
	protected int wins;
	protected int loses;
	protected int points;
	protected int instantscore;

	public Team(String name) {
		this.name = name;
		this.isSelected = false;
		this.team = new ArrayList<Player>();
		this.points = 0;
		this.instantscore = 0;
		this.wins = 0;
		this.loses = 0;
		
	}
	
	
	public int getWins() {
		return wins;
	}
	
	public int getLoses() {
		return loses;
	}

	public void IncreaseWins() {
		wins += 1;
	}

	public void IncreaseLoses() {
		loses +=1;
	}

	public int getInstantscore() {
		return instantscore;
	}

	public void setInstantscore(int instantscore) {
		this.instantscore = instantscore;
	}

	public void IncreasePoint() {
		
		points += 1;
	}
	
	
	public void SelectTeam() {
		
		isSelected = true;
		
	}
	
	public void addPlayer(Player player){
		
			team.add(player);
		
		
	}
	
	public ArrayList<Player> getTeam() {
		return team;
	}

	public void setTeam(ArrayList<Player> team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public boolean isSelected() {
		return isSelected;
	}
	
	
	/**
	 * A method to calculate score of the teams in match using the scoring methods of players
	 * @return
	 */
	public int CalculateScore() {
		
		int total_score = 0;
		
		for(int i = 0; i < team.size(); i++) {
			
			total_score += team.get(i).getScore(team.get(i).getPTS(),team.get(i).getTRB(),team.get(i).getAST(),team.get(i).getBLK(),team.get(i).getSTL());
			
		}
		
		
		return total_score;
	}
	
	/**
	 * A method to do a match between two teams. I keep instant scores to print and log them and increase wins and loses for both teams.
	 * @param awayteam
	 */
	
	public void doMatch(Team awayteam) {
		
		int score1 = CalculateScore();
		int score2 = awayteam.CalculateScore();
		
		score1 = (int) Math.round(score1*1.05);
		instantscore = score1;
		awayteam.instantscore = score2;
		
		if(score1 >= score2) {
			wins += 1;
			awayteam.IncreaseLoses();
			;			
		}
		if(score2 > score1){
			
			awayteam.points +=1;
			awayteam.IncreaseWins();
			IncreaseLoses();
		}
		

	}
	
	
	
	
	
	
	
	

}
