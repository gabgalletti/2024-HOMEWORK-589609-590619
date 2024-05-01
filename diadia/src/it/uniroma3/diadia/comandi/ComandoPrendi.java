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
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().addAttrezzo(a)) {
			partita.getStanzaCorrente().removeAttrezzo(a);
		} 
		else {
			io.mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
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
