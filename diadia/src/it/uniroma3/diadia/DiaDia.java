package it.uniroma3.diadia;

import java.io.FileNotFoundException;
import java.util.Scanner;
import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.*;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	


	private Labirinto labirinto;
	private Partita partita;
	private IO io;
	

	public DiaDia(IO io, String nomeFile) {
		this.io = io;
		try {
			this.partita = new Partita(labirinto.getNewBuilder(nomeFile).getLabirinto());
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Eccezione: File non trovato!");
		} catch (FormatoFileNonValidoException e) {
			throw new RuntimeException("Eccezione: Formato file non valido!");
		}
	}
	public DiaDia(Labirinto labirinto, IO io) {
		this.io = io;
		this.labirinto = labirinto;
		this.partita = new Partita(this.labirinto);
	}

	public void gioca() throws Exception{
		String istruzione; 
		
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		this.io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {	
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(this.io);
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if(this.partita.vinta())
			this.io.mostraMessaggio("Hai vinto!");
		if(!this.partita.giocatoreIsVivo())
			this.io.mostraMessaggio("Hai esaurito i CFU!");
		return this.partita.isFinita();
	}      


	public static void main(String[] argc) throws Exception {
		Scanner scannerDiLinee = new Scanner(System.in);
		IO io = new IOConsole(scannerDiLinee);
		Labirinto labirinto;
		try {
            LabirintoBuilder builder = new LabirintoBuilder("labirinto.txt");
            labirinto = builder.getLabirinto();
        } catch (FileNotFoundException | FormatoFileNonValidoException e) {
			labirinto = new LabirintoBuilder()
					.addStanza("Atrio")
					.addAttrezzo("osso", 1)
					.addStanza("Aula N11")
					.addStanza("Aula N10")
					.addAttrezzo("lanterna", 3)
					.addStanza("Laboratorio Campus")
					.addStanza("Biblioteca")
					.addStanzaIniziale("Atrio")
					.addStanzaVincente("biblioteca")
					.addAdiacenza("Atrio", "Biblioteca", Direzione.NORD)
					.addAdiacenza("Atrio", "Aula N11", Direzione.EST)
					.addAdiacenza("Atrio", "Aula N10", Direzione.SUD)
					.addAdiacenza("Atrio", "Laboratorio Campus", Direzione.OVEST)
					.addAdiacenza("Aula N11", "Laboratorio Campus", Direzione.EST)
					.addAdiacenza("Aula N11", "Atrio", Direzione.OVEST)
					.addAdiacenza("Aula N10", "Atrio", Direzione.NORD)
					.addAdiacenza("Aula N10", "Aula N11", Direzione.EST)
					.addAdiacenza("Laboratorio Campus", "Aula N11", Direzione.OVEST)
					.addAdiacenza("Laboratorio Campus", "Atrio", Direzione.EST)
					.addAdiacenza("Biblioteca", "Atrio", Direzione.SUD)
					.getLabirinto();
			
		}
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();		//il gioco si avvia, ma se si prova a scrivere una qualsiasi direzione, non si sposta; la versione precedente funzionava
		scannerDiLinee.close();
		
	}
}