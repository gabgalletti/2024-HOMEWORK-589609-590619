package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	private IO io;
	private String pNull;
	private final static String NOME = "aiuto";
	static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine","prendi", "posa", "guarda"};
	
	public ComandoAiuto(IO io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			io.mostraMessaggio(ELENCO_COMANDI[i]+" ");
		io.mostraMessaggio("");
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
