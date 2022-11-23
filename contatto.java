package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
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

		
		assertEquals(true, esito1);
		assertEquals(true, esito2);
		assertEquals(false, esito3);

	}
}


///////////////////////////////////////////////


package rubrica;

import java.util.ArrayList;

public class Contatto {
	public Contatto ( String email , String nome ){
		this.email = email;
		this.name = nome;
		this.numbers = new ArrayList<String>();
	}
	
	public Contatto(String email) {
		this(email, "");
	}

	private final String email;
	private String name;
	private ArrayList<String> numbers;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public String getEmail() {
		return email;
	}

	public boolean inserisciNumTel(String numero) {
		if(numbers.contains(numero)) return false;
		
		numbers.add(numero);
		return true;
	}

	public boolean eliminaNumTel(String numero) {
		if(!numbers.contains(numero)) return false;
		
		numbers.remove(numero);
		return true;
	}

	public String numTel() {
        String out = numbers.toString();
        out = out.replace("[", "");
        out = out.replace("]", "");
        out = out.replace(" ", "");
    
		return out;
	}

	public boolean matchNome(String nome) {
		return name.contains(nome);
	}
	
	
	
	
}
