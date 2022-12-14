package masterMind;

public class Tentativo {
	private String guess;
	private int numBulls;
	private int numMaggots;
	
	public Tentativo(String guess, int numBulls, int numMaggots) {
		this.guess = guess;
		this.numBulls = numBulls;
		this.numMaggots = numMaggots;
	}
	
	public String toString() {
		return "T: " + guess + " B:" + numBulls + " M:" + numMaggots;
	}
	
	public String getGuess() {
		return guess;
	}
	
	public int getBulls() {
		return numBulls;
	}
	
	public int getMaggots() {
		return numMaggots;
	}
}
