package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {
	private Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("Atrio")
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("Atrio", "Biblioteca", Direzione.NORD)
			.getLabirinto();
	@Test
	public void testInit_stanzaIngressoCreata() {
		assertNotNull(this.labirinto.getstanzaIniziale());
	}
	
	@Test
	public void testInit_stanzaUscitaCreata() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}
	
	@Test
	public void testInit_esisteStanzaAdiacenteIngresso() {
		assertNotEquals(0, this.labirinto.getstanzaIniziale().getMapStanzeAdiacenti());
	}
	
	@Test
	public void testInit_esisteStanzaAdiacenteUscita() {
		assertNotEquals(0, this.labirinto.getStanzaVincente());
	}

}
