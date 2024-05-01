package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.*;
import org.junit.Test;

public class StanzaBuiaTest {

	private StanzaBuia stanza;
    private Attrezzo attrezzo;

    @Test
    public void testToStringConAttrezzo() {
        stanza.addAttrezzo(attrezzo);
        assertEquals("Stanza Buia\n Uscite: \n Attrezzi nella stanza: torcia (2 kg) ", stanza.toString());
    }
    
    @Test
    public void testToStringSenzaAttrezzi() {
        assertEquals("Qui c'è buio pesto...", stanza.toString());
    }
    
    @Test
    public void testToStringConAttrezzoIlluminante() {
        stanza.addAttrezzo(attrezzo);
        assertEquals("Stanza Buia\nUscite: \nAttrezzi nella stanza: torcia (2 kg) ", stanza.toString());
    }

    @Test
    public void testToStringSenzaAttrezzoIlluminante() {
        assertEquals("Qui c'è buio pesto...", stanza.toString());
    }
    @Test
    public void testToStringConAttrezzoNonIlluminante() {
    	stanza.addAttrezzo(new Attrezzo("torcia", 1));
    	assertEquals("Qui c'è buio pesto ", stanza.toString());
    }
    
}
