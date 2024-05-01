package it.uniroma3.diadia.ambienti;


import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	@Test
	public void testGetAttrezzo_StanzaVuota() {
		Stanza vuota = new Stanza("vuota");			
		assertNull(vuota.getAttrezzo("Non esiste")); 
	}
	
	@Test
	public void testGetAttrezzo_StanzaNonVuota_Presente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetAttrezzo_StanzaNonVuota_Assente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo("Nome di attrezzo non presente"));

	}
	
		
	@Test
	public void testRemoveAttrezzo_true() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.removeAttrezzo(attrezzo));
	}
	
	@Test
	public void testRemoveAttrezzo_falseNessunOggetto() {
		Stanza stanza = new Stanza("stanza");
		assertFalse(stanza.removeAttrezzo(null));
	}
	
	
	@Test
	public void testRemoveAttrezzo_getAttrezzoRimosso() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		stanza.removeAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo("attrezzo"));

	}
	
	
	@Test
	public void testhasAttrezzo_AttrezzoEsistente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("attrezzo"));

	}
	
	@Test
	public void testhasAttrezzo_attrezzoNonEsistente() {
		Stanza stanza = new Stanza("stanza");
		assertFalse(stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	public void testhasAttrezzo_attrezzoNull() {
		Stanza stanza = new Stanza("stanza");
		assertFalse(stanza.hasAttrezzo(null));
	}
}
