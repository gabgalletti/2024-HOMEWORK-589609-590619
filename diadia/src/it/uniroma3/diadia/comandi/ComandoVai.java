package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	private IO io;
	private String direzione;
	
	public ComandoVai(IO io) {
		this.io = io;
	}
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione == null) {
			this.io.mostraMessaggio("Dove vuoi andare? "
					+ "Devi speficare una direzione!");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if(prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		this.io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			
	}

	public String getParametro() {
		return this.direzione;
	}
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	public String getNome() {
		return "vai";
	}
}
