package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.*;

public class ComandoSaluta extends AbstractComando {
    private IO io;
	@Override
	public void esegui(Partita partita) {
		if (partita.getLabirinto().getStanzaCorrente().getPersonaggio() != null) {
			io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().saluta());
        } else {
			io.mostraMessaggio("Non c'è alcun personaggio in questa stanza!");
        }
	}
    
    public void setIO(IO io) {
        this.io = io;
    }

	@Override
	public void leggiRiga() {
		// TODO Auto-generated method stub
		
	}
}
