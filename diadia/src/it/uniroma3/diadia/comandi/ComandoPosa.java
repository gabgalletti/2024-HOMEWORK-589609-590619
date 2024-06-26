package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;

@SuppressWarnings("unused")

public class ComandoPosa extends AbstractComando {
    private String nomeAttrezzo;
    private final static String NOME = "posa";
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);

    @Override
    public void esegui(Partita partita) {
        Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
        if (a != null) {
            partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
            partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
            io.mostraMessaggio("Attrezzo posato!");
        } else {
            io.mostraMessaggio("Non hai questo attrezzo nella borsa!");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

	@Override
	public void leggiRiga() {
		// TODO Auto-generated method stub
		
	}
}