package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.personaggi.*;

public class ComandoRegala extends AbstractComando {
    private String nomeAttrezzo;
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);

    @Override
    public void esegui(Partita partita) {
        Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
        AbstractPersonaggio aP = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
        if (a != null && aP != null) {            
            partita.getLabirinto().getStanzaCorrente().getPersonaggio().riceviRegalo(a, partita);
            partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
            io.mostraMessaggio("Attrezzo regalato!");
        } else {
            io.mostraMessaggio("Non puoi regalarlo, non ce l'hai!");
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
