package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import masterMind.Computer;
import masterMind.Giocatore;
import masterMind.Giudice;
import masterMind.Umano;

public class TestGiocatore {
	@Test
	void testInit() {
		Computer c = new Computer();
		assertEquals("", c.stringaTentativi());
	}
	
	@Test
	void getTarget() {
		Computer g1 = new Computer();
		assertTrue(Giudice.valida(g1.getTarget()));
		assertTrue(Giudice.valida(g1.genTarget()));
		assertTrue(Giudice.valida(g1.genTarget()));
		assertTrue(Giudice.valida(g1.genTarget()));
		assertTrue(Giudice.valida(g1.genTarget()));
	}
	
	@Test
	void getGuess() {
		Computer g1 = new Computer();
		assertTrue(Giudice.valida(g1.genGuess()));
		assertTrue(Giudice.valida(g1.genGuess()));
		assertTrue(Giudice.valida(g1.genGuess()));
		assertTrue(Giudice.valida(g1.genGuess()));
		assertTrue(Giudice.valida(g1.genGuess()));
	}
	
	@Test
	void allComb() {
		assertEquals(5040, Giudice.comb(Giudice.LUNGHEZZA, Giudice.CHARS).size());
	}
	
}
