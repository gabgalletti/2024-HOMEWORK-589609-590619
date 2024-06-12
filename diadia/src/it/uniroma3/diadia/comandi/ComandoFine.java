package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.*;

@SuppressWarnings("unused")

public class ComandoFine extends AbstractComando {
    String parametro = null;
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);
    private final static String NOME = "fine";

    @Override
    public void esegui(Partita partita) {
        partita.setFinita();
        io.mostraMessaggio("Grazie di aver giocato!");
    }

	@Override
	public void leggiRiga() {
		// TODO Auto-generated method stub
		
	}
}
