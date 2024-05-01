package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;


import org.junit.Test;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;


    @Test
    public void testGetStanzaAdiacenteBloccata() {
        Stanza adiacente = stanzaBloccata.getStanzaAdiacente("nord");
        assertEquals(stanzaBloccata, adiacente);
    }

    @Test
    public void testGetStanzaAdiacenteSbloccata() {
        stanzaBloccata.addAttrezzo(new Attrezzo("chiave", 1));
        Stanza adiacente = stanzaBloccata.getStanzaAdiacente("nord");
        assertNotEquals(stanzaBloccata, adiacente);
    }
    
    @Test
    public void testGetStanzaAdiacenteAttesoStanzaAdiacente() {
    	Stanza stanza = new Stanza("nord");
        assertEquals(stanza, stanza.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteAttesoStanzaBloccata() {
    	Stanza stanza = new Stanza("sud");
        assertNull(stanza.getStanzaAdiacente("sud"));
    }

    @Test
    public void testToStringBloccata() {
        String stanza = "Stanza Bloccata Uscite: Direzione bloccata Attrezzi nella stanza: ";
        assertEquals(stanza, stanzaBloccata.toString());
    }

    @Test
    public void testToStringSbloccata() {
        stanzaBloccata.addAttrezzo(new Attrezzo("pala", 2));
        String stanza = "Stanza Bloccata Uscite: nord Attrezzi nella stanza: pala ";
        assertEquals(stanza, stanzaBloccata.toString());
    }

    @Test
    public void testToStringDirezioneBloccata() {
    	Stanza stanza = new Stanza("Stanza Principale");
        assertEquals("Stanza Principale Uscite: nord\n Direzione bloccata Attrezzi nella stanza: chiave (1 kg) ", stanza.toString());
    }
    @Test
    public void testToStringDirezioneSbloccata() {
    	Stanza stanza = new Stanza("Stanza Principale");
    	stanza.addAttrezzo(new Attrezzo("spada", 2));
    	assertEquals("Stanza Principale Uscite: Direzione bloccata\n Attrezzi nella stanza: chiave (1 kg) spada (2 kg) ", stanza.toString());
    }
}
	
	

