package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rubrica.Contatto;

public class TestRubricaContatto {
	@BeforeEach
	void setup() {
		
	}
	
	@Test
	void costruttore1() {
		Contatto c = new Contatto("leo@123.it", "Leo");
		
		String nome = c.getName();
		assertEquals("Leo", nome);
	}
	
	@Test
	void costruttore2() {
		Contatto c = new Contatto("leo@123.it");
		
		String nome = c.getName();
		assertEquals("", nome);
	}
	
	@Test
	void get_nome() {
		Contatto c = new Contatto("leo@123.it", "Leo123");
		assertEquals("Leo123", c.getName());
	}
	
	@Test
	void set_nome() {
		Contatto c = new Contatto("leo@123.it");
		c.setName("Leo1");
		assertEquals("Leo1", c.getName());
	}
	
	@Test
	void get_email() {
		Contatto c = new Contatto("leo@321.it");
		assertEquals("leo@321.it", c.getEmail());
	}
	
	@Test
	void ins_num() {
		Contatto c = new Contatto("leo@321.it");
		boolean esito1 = c.inserisciNumTel("456");
		boolean esito2 = c.inserisciNumTel("567");
		boolean esito3 = c.inserisciNumTel("456");
		
		assertEquals(true, esito1);
		assertEquals(true, esito2);
		assertEquals(false, esito3);
	}
	
	@Test
	void elim_num() {
		Contatto c = new Contatto("leo@321.it");
		c.inserisciNumTel("456");
		c.inserisciNumTel("567");
		
		boolean esito1 = c.eliminaNumTel("456");
		boolean esito2 = c.eliminaNumTel("567");
		boolean esito3 = c.eliminaNumTel("456");
		
		assertEquals(true, esito1);
		assertEquals(true, esito2);
		assertEquals(false, esito3);
	}
	
	@Test
	void num_tel() {
		Contatto c = new Contatto("leo@321.it");
		c.inserisciNumTel("123");
		c.inserisciNumTel("456");
		
		String numbers = c.numTel();
		
		assertEquals("123,456", numbers);
	}
	
	@Test
	void nome_match() {
		Contatto c = new Contatto("leo@321.it", "LeoGa");
		boolean esito1 = c.matchNome("LeoGa");
		boolean esito2 = c.matchNome("Leo");
		boolean esito3 = c.matchNome("Non");

		
		assertTrue(esito1);
		assertEquals(true, esito2);
		assertEquals(false, esito3);

	}
	
	@Test
	void emailMatch() {
		Contatto c = new Contatto("leo@321.it", "LeoGa");
		boolean esito1 = c.matchEmail("leo@321.it");
		boolean esito2 = c.matchEmail("pippo@altro.com");

		
		assertTrue(esito1);
		assertFalse(esito2);

	}
	
	@Test
	void contatto_equals() {
		Contatto c1 = new Contatto("leo@321.it", "LeoGa");
		Contatto c2 = new Contatto("leo@123.com");
		Contatto c3 = new Contatto("leo@321.it");
		
		boolean esito1 = c1.equals(c2);
		boolean esito2 = c1.equals(c3);
		
		assertFalse(esito1);
		assertTrue(esito2);
	}
	
	@Test
	void contattoToString() {
		Contatto c1 = new Contatto("leo@321.it", "LeoGa");
		Contatto c2 = new Contatto("leo@123.com");
		
		c1.inserisciNumTel("1234");
		
		String cont1 = c1.toString();
		String cont2 = c2.toString();
		
		
		assertEquals("leo@321.it,LeoGa,1234", cont1);
		assertEquals("leo@123.com,,", cont2);
	}
}
