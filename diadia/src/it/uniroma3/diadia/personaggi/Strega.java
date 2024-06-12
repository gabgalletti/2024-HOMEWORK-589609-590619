package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;

public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_SALUTATA = "Solo perche' mi hai salutato, non ti mando in uno scantinato!";
	private static final String MESSAGGIO_NON_SALUTATA = "Sei proprio una brutta persona, vai nella stanza con meno attrezzi!";

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		
		List<Stanza> mapStanzeAdiacenti = (List<Stanza>) partita.getStanzaCorrente().getMapStanzeAdiacenti();
		Stanza maxAtrezzi = mapStanzeAdiacenti.get(0);
		Stanza minAtrezzi = mapStanzeAdiacenti.get(0);

		for(Stanza s : mapStanzeAdiacenti) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maxAtrezzi.getNumeroAttrezzi())
					maxAtrezzi = s;
				if(s.getNumeroAttrezzi() < minAtrezzi.getNumeroAttrezzi())
					minAtrezzi = s;
			}
		}

		if(this.haSalutato()) {
			partita.setStanzaCorrente(maxAtrezzi);
			msg = MESSAGGIO_SALUTATA;
		} else {
			partita.setStanzaCorrente(minAtrezzi);
			msg = MESSAGGIO_NON_SALUTATA;
		}

		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "AHAHAHAHAHAHHA";
	}
}
