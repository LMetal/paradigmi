package masterMind;

import jbook.util.Input;

public class Umano extends Giocatore {

	public Umano() {
		super();
	}
	
	@Override
	public String genTarget() {
		String target;
		
		do {
			System.out.print("\n\nInserire target: ");
			target = Input.readString();
		}while(!Giudice.valida(target));
		
		return target;
	}

	@Override
	public String genGuess() {
		String guess;
		
		do {
			System.out.print("\n\nInserire guess: ");
			guess = Input.readString();
		}while(!Giudice.valida(guess));
		
		return guess;
	}
	
}
