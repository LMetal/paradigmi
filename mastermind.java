package masterMind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Giudice {
	public final static int LUNGHEZZA = 4;
	public final static int TENTATIVI = 0;
	public final static ArrayList<Character> CHARS = new ArrayList<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
	
	public static boolean valida(String stringa) {
		return (stringa.length() == LUNGHEZZA && caratteriGiusti(stringa)) && caratteriNonRipetuti(stringa);
	}
	
	private static boolean caratteriGiusti(String guess) {
		for(int i=0; i<LUNGHEZZA; i++) {
			if(!CHARS.contains(guess.charAt(i))) return false;
		}
		return true;
	}
	
	private static boolean caratteriNonRipetuti(String guess) {
		for(int i=0; i<LUNGHEZZA-1; i++) {
			if(guess.lastIndexOf(guess.charAt(i)) != i) return false;
		}
		return true;
	}

	public static int numBulls(String target, String guess) {
		int bulls=0;
		for(int i=0; i<LUNGHEZZA; i++) {
			if(guess.charAt(i) == target.charAt(i)) bulls++;
		}
		return bulls;
	}

	public static int numMaggots(String target, String guess) {
		int maggots=0;
		for(int i=0; i<LUNGHEZZA; i++) {
			for(int j=0; j<LUNGHEZZA; j++) {
				if(j==i) continue;
				if(guess.charAt(i) == target.charAt(j)) {
					maggots++;
					break;
				}
			}
		}
		
		return maggots;
	}

	public static String genTarget() {
		Random random = new Random();
		char n;
		String target = "";
		
		for(int i=0; i<LUNGHEZZA; i++) {
			
			do {
				n = (char)(random.nextInt(10) + '0');	//genera caratteri da '0' a '9'
			}while(target.indexOf(n) != -1);	//se non e' presente in target
			
			target = target.concat(String.valueOf(n));
		}
		return target;
	}
}


/////////////////////////


package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import masterMind.Giudice;

public class TestMetodi {
	@Test
	void validaLunghezza(){
		assertTrue(Giudice.valida("1234"));
		assertFalse(Giudice.valida("123"));
		assertFalse(Giudice.valida("12345"));
		assertTrue(Giudice.valida("4312"));
	}
	
	@Test
	void validaCaratteri() {
		assertTrue(Giudice.valida("1234"));
		assertFalse(Giudice.valida("1f34"));
		assertFalse(Giudice.valida("1233"));
		assertFalse(Giudice.valida("AAAA"));
		assertFalse(Giudice.valida("#321"));
		assertTrue(Giudice.valida ("3617"));
		assertFalse(Giudice.valida ("567!"));
		assertFalse(Giudice.valida ("ab%t"));
		assertTrue(Giudice.valida ("3124"));
	}
	
	@Test
	void validaNonRipetuti() {
		assertTrue(Giudice.valida("1234"));
		assertFalse(Giudice.valida("1231"));
		assertFalse(Giudice.valida("1224"));
		assertFalse(Giudice.valida("4444"));
		assertFalse(Giudice.valida("1444"));
	}
	
	@Test
	void testValidaNumBulls () {
		assertEquals (0 , Giudice.numBulls ("1234" , "5678" ));
		assertEquals (1 , Giudice.numBulls ("1234" , "1876" ));
		assertEquals (1 , Giudice.numBulls ("1234" , "9874" ));
		assertEquals (1 , Giudice.numBulls ("1234" , "9243" ));
		assertEquals (1 , Giudice.numBulls ("9876" , "5573" ));
		assertEquals (2 , Giudice.numBulls ("1234" , "1256" ));
		assertEquals (2 , Giudice.numBulls ("1234" , "1537" ));
		assertEquals (2 , Giudice.numBulls ("1234" , "1764" ));
		assertEquals (2 , Giudice.numBulls ("1234" , "8237" ));
		assertEquals (2 , Giudice.numBulls ("1234" , "9834" ));
		assertEquals (3 , Giudice.numBulls ("9264" , "9261" ));
		assertEquals (3 , Giudice.numBulls ("9264" , "9284" ));
		assertEquals (3 , Giudice.numBulls ("9264" , "9764" ));
		assertEquals (3 , Giudice.numBulls ("9264" , "5264" ));
		assertEquals (4 , Giudice.numBulls ("9264" , "9264" ));
		assertEquals (4 , Giudice.numBulls ("8725" , "8725" ));
	}
	
	@Test 
	void testValidaNumMaggots() {
		assertEquals(0, Giudice.numMaggots("1234", "1234"));
		assertEquals(0, Giudice.numMaggots("1234", "5678"));
		assertEquals(1, Giudice.numMaggots("1234", "1245"));
		assertEquals(1, Giudice.numMaggots("1234", "4567"));
		assertEquals(1, Giudice.numMaggots("1234", "1489"));
		assertEquals(1, Giudice.numMaggots("1234", "4238"));
		assertEquals(2, Giudice.numMaggots("1234", "1243"));
		assertEquals(2, Giudice.numMaggots("1234", "1326"));
		assertEquals(2, Giudice.numMaggots("1234", "4516"));
		assertEquals(2, Giudice.numMaggots("1234", "3456"));
		assertEquals(3, Giudice.numMaggots("1234", "2345"));
		assertEquals(3, Giudice.numMaggots("1234", "2543"));
		assertEquals(3, Giudice.numMaggots("1234", "2473"));
		assertEquals(3, Giudice.numMaggots("1234", "7321"));
		assertEquals(4, Giudice.numMaggots("1234", "2341"));
		assertEquals(4, Giudice.numMaggots("1234", "3412"));
	}
	
	@Test
	void testGenTarget() {
		for(int i=0; i<100; i++) {
			assertTrue(Giudice.valida(Giudice.genTarget()));
		}
	}
}
