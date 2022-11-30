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
		assertTrue(Giudice.valida("4321"));
	}
	
	@Test
	void validaNonRipetuti() {
		assertTrue(Giudice.valida("1234"));
		assertFalse(Giudice.valida("1231"));
		assertFalse(Giudice.valida("1224"));
		assertFalse(Giudice.valida("44{4"));
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
}

//////////////////

package masterMind;

import java.util.ArrayList;
import java.util.Arrays;

public class Giudice {
	public final static int LUNGHEZZA = 4;
	public final static int TENTATIVI = 10;
	public final static ArrayList<Character> CHARS = new ArrayList<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
	
	public static boolean valida(String stringa) {
		return (stringa.length() == LUNGHEZZA && caratteriGiusti(stringa)) && caratteriNonRipetuti(stringa);
	}
	
	private static boolean caratteriGiusti(String str) {
		for(int i=0; i<LUNGHEZZA; i++) {
			if(!CHARS.contains(str.charAt(i))) return false;
		}
		return true;
	}
	
	private static boolean caratteriNonRipetuti(String stringa) {
		for(int i=0; i<LUNGHEZZA; i++) {
			for(int j=i+1; j<LUNGHEZZA; j++) {
				if(stringa.charAt(i) == stringa.charAt(j)) return false;
			}
		}
		return true;
	}

	public static int numBulls(String guess, String target) {
		int bulls=0;
		for(int i=0; i<LUNGHEZZA; i++) {
			if(guess.charAt(i) == target.charAt(i)) bulls++;
		}
		return bulls;
	}
}
