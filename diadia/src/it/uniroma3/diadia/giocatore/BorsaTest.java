package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BorsaTest {
	Attrezzo attrezzo;
	Borsa borsa;
	@Test
	public void addAttrezzo_null() {
		assertNull(borsa.addAttrezzo(null));
	}
	@Test
	public void test_addAttrezzo_peso_true() {
		assertTrue(borsa.addAttrezzo(attrezzo));
	}
	@Test
	public void test_addAttrezzo_peso_false() {
		assertFalse(borsa.addAttrezzo(attrezzo));
	}
	@Test
	public void getAttrezzo_null() {
		assertNull(borsa.getAttrezzo(null));
	}
	@Test
	public void getAttrezzo_Presente() {
		attrezzo = new Attrezzo("attrezzo", 0); 
		assertNotNull(borsa.getAttrezzo("attrezzo"));
	}
	@Test
	public void getAttrezzo_Assente() {
		attrezzo = new Attrezzo("attrezzo", 0); 
		assertNull(borsa.getAttrezzo("attrezzo assente"));
	}
	@Test
	public void test_hasAttrezzo() {
		assertNull(borsa.hasAttrezzo(null));
	}
	@Test
	public void hasAttrezzo_Presente() {
		attrezzo = new Attrezzo("attrezzo", 0); 
		assertTrue(borsa.hasAttrezzo("attrezzo"));
	}
	@Test
	public void hasAttrezzo_Assente() {
		attrezzo = new Attrezzo("attrezzo", 0); 
		assertFalse(borsa.hasAttrezzo("attrezzo"));
	}
}
