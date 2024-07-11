package player;

public abstract class Player {
	
	protected String name;
	protected double PTS;
	protected double TRB;
	protected double AST;
	protected double BLK;
	protected double STL;
	
	public Player(String name, double PTS, double TRB, double AST, double BLK, double STL) {
		
		this.name = name;
		this.PTS = PTS;
		this.TRB = TRB;
		this.AST = AST;
		this.BLK = BLK;
		this.STL = STL;
	}
	/**
	 * An abstract method that every type of player subclass should implement differently
	 * @param PTS
	 * @param TRB
	 * @param AST
	 * @param BLK
	 * @param STL
	 * @return
	 */
	public abstract int getScore(double PTS,double TRB, double AST, double BLK, double STL);
	
	public String getName() {
		return name;
	}

	public double getPTS() {
		return PTS;
	}

	public double getTRB() {
		return TRB;
	}

	public double getAST() {
		return AST;
	}

	public double getBLK() {
		return BLK;
	}

	public double getSTL() {
		return STL;
	}

	
	

}
