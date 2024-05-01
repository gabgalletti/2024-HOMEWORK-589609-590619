package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	private String pNull;

	IO io;

	public ComandoGuarda(IO io) {
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio(partita.getStanzaCorrente().toString());

	}

	@Override
	public void setParametro(String parametro) {
		this.pNull = parametro;

	}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return this.pNull;
	}
}
