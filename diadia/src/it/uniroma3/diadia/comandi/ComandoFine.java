package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	private IO io;
	private String pNull;
	private final static String NOME = "fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";

	public ComandoFine(IO io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE); 
	}

	@Override
	public void setParametro(String pNull) {
		this.pNull = pNull;
	}

	@Override
	public String getParametro() {
		return this.pNull;
	}
	@Override
	public String getNome() {
		return NOME;
	}
}