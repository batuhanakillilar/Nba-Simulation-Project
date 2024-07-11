package player;

import java.util.Random;

public class PF extends Player{
	

	public PF(String name, double PTS, double TRB, double AST, double BLK, double STL) {
		super(name, PTS, TRB, AST, BLK, STL);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Randomize the input data with N and make sure it does no go below 0
	 * @param data
	 * @return
	 */
	public double randomizeData(double data) {
		
		int N = 3;
		Random random = new Random();
		if(data - N < 0) {
			
			data = random.nextDouble(0,data +N);
			
		}
		else {
			
			data = random.nextDouble(data - N, data +N);
		}
		
		return data;
			
	}
	/**
	 * Use randomize data method and calculate scoring of players with different weights assigned
	 */
	public int getScore(double PTS, double TRB, double AST, double BLK, double STL) {
		
		
		randomizeData(PTS);
		randomizeData(TRB);
		randomizeData(AST);
		randomizeData(BLK);
		randomizeData(STL);
		
		int score = (int) Math.round((PTS*0.6) + (TRB*0.1) + (AST*0.1) + (BLK*0.1) + (STL*0.1));
		return score;
	}

	

	
	
}
