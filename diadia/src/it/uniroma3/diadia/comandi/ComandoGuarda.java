package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.*;

@SuppressWarnings("unused")

public class ComandoGuarda extends AbstractComando {
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);
    String parametro = null;
    private final static String NOME = "guarda";

    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
    }

	@Override
	public void leggiRiga() {
		// TODO Auto-generated method stub
		
	}
}