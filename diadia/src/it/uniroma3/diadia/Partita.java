package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.*;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private Stanza stanzaCorrente;
	//private Stanza stanzaVincente;	//spostata in Labirinto
	private boolean finita;
	private Giocatore giocatore;
	
	private Labirinto labirinto;
	
	public Partita(Labirinto labirinto){
		//Inizializzo una sola partita e gioco con più labirinti (?)
		//creaStanze();	//spostato il Labirinto
		
		this.labirinto = labirinto;
		this.stanzaCorrente = this.labirinto.getstanzaIniziale();
		this.giocatore = new Giocatore();
		
		this.finita = false;
		this.giocatore.setCfu(CFU_INIZIALI);
	}

    public Giocatore getGiocatore() {
    	return this.giocatore;
    }
    
    public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu() != 0;
	}
    
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	
}
