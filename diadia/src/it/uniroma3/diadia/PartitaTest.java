package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PartitaTest {
	Stanza stanza;
	Partita partita;
	Labirinto labirinto;
	@Test
    public void setStanzaCorrente_Notnull() {
        Stanza stanza = new Stanza("Stanza");
        Partita partita = new Partita(labirinto);
        partita.setStanzaCorrente(stanza);
        assertNotNull(partita.getStanzaCorrente());
    }

    @Test
    public void testSetStanzaCorrente_True() {
        Stanza stanza = new Stanza("Stanza");
        Partita partita = new Partita(labirinto);
        partita.setStanzaCorrente(stanza);
        assertTrue(partita.getStanzaCorrente() == stanza);
    }

    @Test
    public void testSetStanzaCorrente_False() {
        Stanza stanza1 = new Stanza("Stanza 1");
        Stanza stanza2 = new Stanza("Stanza 2");
        partita = new Partita(labirinto);
        partita.setStanzaCorrente(stanza1);
        assertFalse(partita.getStanzaCorrente() == stanza2);
    }
	
    

}
