package masterMind;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends Giocatore{
	private ArrayList<String> possibili;
	
	public Computer() {
		super();
		init();
	}
	
	private void init() {
		
	}
	
	@Override
	public String genTarget() {
		return Giudice.genTarget();
	}

	@Override
	public String genGuess() {
		ArrayList<String> possibili = Giudice.comb(Giudice.LUNGHEZZA, Giudice.CHARS);
		
		possibili.removeIf(s -> !ckTargetTnts(s, tentativi));
		
		Random r = new Random();
		
		return possibili.get(r.nextInt()%(possibili.size()-1));
	}

	private boolean ckTargetTnts(String str, ArrayList<Tentativo> tnts) {
		for(Tentativo t: tnts) {
			if(!ckTargetTnt(str, t)) return false;
		}
		return true;
	}
	
	private boolean ckTargetTnt(String str, Tentativo tnt) {
		return Giudice.numBulls(str, tnt.getGuess()) == tnt.getBulls() && Giudice.numMaggots(str, tnt.getGuess()) == tnt.getBulls();
	}
}
