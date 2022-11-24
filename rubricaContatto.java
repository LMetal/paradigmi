package rubrica;

import java.util.ArrayList;

	public class Rubrica {
		public Rubrica(String name, int max_dim) {
	        rubrica = new ArrayList<Contatto>();
	        numRubriche++;
	        MAX_DIM = max_dim;
	        nome = name;
	    }
	    public Rubrica() {
	        this("Rubrica " + (numRubriche+1), 6);
	    }
	
	    public Rubrica(String name) {
	        this(name, 6);
	    }
	
	    public Rubrica(int max_dim) {
	        this("Rubrica " + (numRubriche+1), max_dim);
	    }
	
	    private ArrayList<Contatto> rubrica;
	    public final int MAX_DIM;
	    public final String nome;
	    public static int numRubriche;
	    
	    public int numE1() {
			return rubrica.size();
		}
		
	    public int aggiungi(String email, String nome) {
	    	if(rubrica.size() == MAX_DIM) return -1;
	    	if(this.containsContatto(email)) return 0;
			
			Contatto c1 = new Contatto(email, nome);
			rubrica.add(c1);
			return 1;
		}
	    
		public int aggiungi(String email) {
			return aggiungi(email, "");
		}
		
		public int aggiungi(Contatto c1) {
			if(rubrica.size() == MAX_DIM) return -1;
	    	if(this.containsContatto(c1.getEmail())) return 0;
	    	
	    	rubrica.add(c1);
	    	return 1;
	    	
		}
		
		public ArrayList<Contatto> cercaPerNome(String nome) {
			ArrayList<Contatto> trovati = new ArrayList<Contatto>();
			
			return trovati;
		}
	    
	    private boolean containsContatto(String email) {
	    	Contatto c;
			for(int i=0; i<rubrica.size(); i++) {
				c = rubrica.get(i);
				if(c.getEmail() == email) return true;
			}
			return false;
		}
		
	    private String[] iterator() {
	    	String[] listaEmailNome;
	    	
	    	//for(int i.i..)
	    		//aggiungi liste[email, nome] listaEmailNome
	    	
	    	//ritorna e usa in aggiungi, cerca
	    }
		
		
		
	    
	    
	    

}


///////////////////////////////////////////////////////

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rubrica.Contatto;
import rubrica.Rubrica;

public class TestRubrica {
	@BeforeEach
    void setup() {
        Rubrica.numRubriche = 0;
    }
	
 @Test
    void costruttore1(){
        Rubrica r1 = new Rubrica("amici", 10);
        assertEquals(1, Rubrica.numRubriche);
        Rubrica r2 = new Rubrica("parenti", 5);
        assertEquals(2, Rubrica.numRubriche);

        assertEquals("amici", r1.nome);
        assertEquals(10, r1.MAX_DIM);
        assertEquals("parenti", r2.nome);
        assertEquals(5, r2.MAX_DIM);
    }

    @Test
    void costruttore2(){
        Rubrica r1 = new Rubrica();
        assertEquals(1, Rubrica.numRubriche);

        assertEquals("Rubrica " + Rubrica.numRubriche, r1.nome);
        assertEquals(6, r1.MAX_DIM);
    }

    @Test
    void costruttore3(){
        Rubrica r1 = new Rubrica("studenti");
        assertEquals(1, Rubrica.numRubriche);
        assertEquals("studenti", r1.nome);
        assertEquals(6, r1.MAX_DIM);
    }

    @Test
    void costruttore4(){
        Rubrica r1 = new Rubrica(10);
        assertEquals(1, Rubrica.numRubriche);
        assertEquals("Rubrica " + Rubrica.numRubriche, r1.nome);
        assertEquals(10, r1.MAX_DIM);
    }
    
    @Test
    void numElem() {
    	Rubrica r1 = new Rubrica();
    	int e1 = r1.numE1();
    	r1.aggiungi("pippo@123.it", "Leo");
    	int e2 = r1.numE1();
    	r1.aggiungi("pippo123@123.it", "Leo");
    	int e3 = r1.numE1();
    	
    	assertEquals(0, e1);
    	assertEquals(1, e2);
    	assertEquals(2, e3);
    }
    
    @Test
    void aggiungiEmailNome() {
    	Rubrica r1 = new Rubrica(3);
    	int esito1 = r1.aggiungi("leo@123.it", "Leo");			//aggiunge
    	int esito2 = r1.aggiungi("pippo@123.it", "Pippo");		//aggiunge
    	int esito3 = r1.aggiungi("leo@123.it", "LEO");			//gia' presente
    	int esito4 = r1.aggiungi("pippo123@456.it", "PIPPO");	//aggiunge
    	int esito5 = r1.aggiungi("lollo@123.it", "Lollo");		//MAX_DIM raggiunto
    	
    	assertEquals(1, esito1);
    	assertEquals(1, esito2);
    	assertEquals(0, esito3);
    	assertEquals(1, esito4);
    	assertEquals(-1, esito5);
    }
    
    @Test
    void aggiungiEmail() {
    	Rubrica r1 = new Rubrica(3);
    	int esito1 = r1.aggiungi("leo@123.it");			//aggiunge
    	int esito2 = r1.aggiungi("pippo@123.it");		//aggiunge
    	int esito3 = r1.aggiungi("leo@123.it");			//gia' presente
    	int esito4 = r1.aggiungi("pippo123@456.it");	//aggiunge
    	int esito5 = r1.aggiungi("lollo@123.it");		//MAX_DIM raggiunto
    	
    	assertEquals(1, esito1);
    	assertEquals(1, esito2);
    	assertEquals(0, esito3);
    	assertEquals(1, esito4);
    	assertEquals(-1, esito5);
    }
    
    @Test
    void aggiungiContatto() {
    	Rubrica r1 = new Rubrica(3);
    	int esito11 = r1.aggiungi(new Contatto("leo@123.it"));			//aggiunge
    	int esito12 = r1.aggiungi(new Contatto("pippo@123.it", "nome"));		//aggiunge
    	int esito13 = r1.aggiungi(new Contatto("leo@123.it"));			//gia' presente
    	int esito14 = r1.aggiungi(new Contatto("pippo123@456.it"));	//aggiunge
    	int esito15 = r1.aggiungi(new Contatto("lollo@123.it"));		//MAX_DIM raggiunto
    	
    	assertEquals(1, esito11);
    	assertEquals(1, esito12);
    	assertEquals(0, esito13);
    	assertEquals(1, esito14);
    	assertEquals(-1, esito15);
    	
    	Rubrica r2 = new Rubrica(3);
    	int esito21 = r2.aggiungi(new Contatto("leo@123.it"));
    	assertEquals(1, esito21);
    }
    
    @Test
    void cercaPerNome() {
    	Rubrica r1 = new Rubrica(3);
    	r1.aggiungi("leo@123.it", "Leo");
    	r1.aggiungi("pippo@123.it", "Pippo");
    	r1.aggiungi("nome@123.it", "Nome");
    	r1.aggiungi("andrea345@456.it", "Leo");
    	r1.aggiungi("lollo@123.it", "Lollo");
    	
    	ArrayList<Contatto> trovati1 = r1.cercaPerNome("Leo");
    	
    }
}
