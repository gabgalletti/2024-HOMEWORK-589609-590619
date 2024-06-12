package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.*;

@SuppressWarnings("unused")

public class ComandoNonValido extends AbstractComando {
    private final static String NOME = "comando non valido";
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);
    String parametro = null;
    
    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio("Comando non valido");
    }

	@Override
	public void leggiRiga() {
		// TODO Auto-generated method stub
		
	}
}