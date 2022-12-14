package masterMind;

import java.util.ArrayList;

public abstract class Giocatore {
	private String target;
	public ArrayList<Tentativo> tentativi;
	
	public Giocatore() {
		inizializza();
	}
	
	public void inizializza() {
		target = genTarget();
		tentativi = new ArrayList<Tentativo>();
	}

	public String getTarget() {
		return target;
	}
	
	public boolean addTentativo(String guess, int numBulls, int numMaggots) {
		return tentativi.add(new Tentativo(guess, numBulls, numMaggots));
	}
	
	public String stringaTentativi() {
		String str = "";
		for(Tentativo t: tentativi) {
			str = str.concat(t.toString() + "\t");
		}
		
		return str;
	}
	
	public abstract String genTarget();
	public abstract String genGuess();
}
