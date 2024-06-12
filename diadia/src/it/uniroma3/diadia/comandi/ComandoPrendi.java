package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;

@SuppressWarnings("unused")

public class ComandoPrendi extends AbstractComando {
    private String nomeAttrezzo;
    private final static String NOME = "prendi";
    Scanner scanner = new Scanner(System.in);
    IOConsole io = new IOConsole(scanner);

    @Override
    public void esegui(Partita partita) {
        Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
        int pesoBorsa = partita.getGiocatore().getBorsa().getPeso();
        int pesoBorsaMax = partita.getGiocatore().getBorsa().getPesoMax();
        if (a != null) {
            if (pesoBorsa + a.getPeso() <= pesoBorsaMax) {
                partita.getGiocatore().getBorsa().addAttrezzo(a);
                partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
                io.mostraMessaggio("Attrezzo preso!");
            } else {
                io.mostraMessaggio("Borsa piena! Non puoi prendere questo attrezzo.");
            }
        } else {
            io.mostraMessaggio("Attrezzo non esistente!");
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
