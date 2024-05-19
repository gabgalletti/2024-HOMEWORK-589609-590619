package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	public ComandoPrendi(IO io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			this.io.mostraMessaggio("Non hai inserito nessun oggetto da prendere!");
		}
		else if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
			this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			this.io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		} else {
			this.io.mostraMessaggio(nomeAttrezzo + " non presente in questa stanza!");;
			this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;
	}
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	@Override
	public String getNome() {
		return NOME;
	}

}
