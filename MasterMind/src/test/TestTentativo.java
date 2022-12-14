package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import masterMind.Tentativo;

public class TestTentativo {
	@Test
	void getString() {
		Tentativo t1 = new Tentativo("1234", 1, 1);
		assertEquals("TENTATIVO: 1234 B:1 M:1", t1.toString());
		Tentativo t2 = new Tentativo("6789", 0, 0);
		assertEquals("TENTATIVO: 6789 B:0 M:0", t2.toString());
	}
	
	@Test
	void getGuess() {
		Tentativo t1 = new Tentativo("1234", 1, 1);
		assertEquals("1234", t1.getGuess());
		Tentativo t2 = new Tentativo("6789", 0, 0);
		assertEquals("6789", t2.getGuess());
	}
	
	void getBulls() {
		Tentativo t1 = new Tentativo("1234", 1, 2);
		assertEquals(1, t1.getBulls());
		Tentativo t2 = new Tentativo("6789", 0, 4);
		assertEquals(0, t2.getBulls());
	}
	
	void getMaggots() {
		Tentativo t1 = new Tentativo("1234", 1, 2);
		assertEquals(2, t1.getGuess());
		Tentativo t2 = new Tentativo("6789", 0, 4);
		assertEquals(4, t2.getGuess());
	}
}
