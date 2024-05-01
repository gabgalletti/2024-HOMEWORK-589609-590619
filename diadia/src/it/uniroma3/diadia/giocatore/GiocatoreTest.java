package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {
	Giocatore giocatore;

    @Test
    public void testSetCfu() {
        giocatore.setCfu(10);
        assertEquals(10, giocatore.getCfu());
    }

    @Test
    public void testSetCfu_NegativeValue() {
        giocatore.setCfu(-5);
        assertEquals(0, giocatore.getCfu());
    }

    @Test
    public void testSetCfu_ZeroValue() {
        giocatore.setCfu(0);
        assertEquals(0, giocatore.getCfu());
    }
    
    @Test
    public void testGetCfu_Iniziali() {
    	assertEquals(20, giocatore.getCfu());
    }
    @Test
    public void testGetBorsa_notNull() {
    	assertNotNull(giocatore.getBorsa());
    }
    @Test
    public void testGetBorsa_VuotaInizialmente() {
    	assertTrue(giocatore.getBorsa().isEmpty());
    }
}
