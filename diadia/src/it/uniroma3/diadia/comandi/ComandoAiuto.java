package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import java.util.Scanner;

public class ComandoAiuto extends AbstractComando {
    static final public String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "interagisci", "saluta", "regala", "aiuto", "fine"};
    private final static String NOME = "aiuto";
    String parametro = null;
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);
    private String pNull;

    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio("Questi sono i comandi del gioco:");
        for (int i=0; i<elencoComandi.length; i++) {
            io.mostraMessaggio(elencoComandi[i]+ " ");
        }
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
	@Override
	public void leggiRiga() {
		// TODO Auto-generated method stub
		
	}
}
