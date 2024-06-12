package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Map<String, Stanza> nomeStanza;
	private Stanza ultimaStanzaAggiunta;

	public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = new Labirinto(labirinto);
		this.nomeStanza = new HashMap<>();
	}
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nomeStanza = new HashMap<>();
	}

	public Map<String, Stanza> getListaStanze(){
		return this.nomeStanza;
	}
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		this.labirinto.setStanzaIniziale(stanza);
		this.nomeStanza.put(nomeStanza, stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza stanza = this.nomeStanza.get(nomeStanza);
		if (stanza == null) {
			stanza =new Stanza(nomeStanza);
			this.nomeStanza.put(nomeStanza, stanza);
		}
		this.labirinto.setStanzaVincente(stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}

	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza= new Stanza(nomeStanza);
		this.nomeStanza.put(nomeStanza, stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}
	public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
		StanzaMagica stanza = new StanzaMagica(nome, soglia);
		this.nomeStanza.put(nome, stanza);
		this.labirinto.getMappaStanze().put(nome, stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}
	public LabirintoBuilder addStanzaMagica(String nome) {
		StanzaMagica stanza = new StanzaMagica(nome);
		this.nomeStanza.put(nome, stanza);
		this.labirinto.getMappaStanze().put(nome, stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, Direzione direzione, String nomeSblocco){
		StanzaBloccata stanza = new StanzaBloccata(nome, direzione, nomeSblocco);
		this.nomeStanza.put(nome, stanza);
		this.labirinto.getMappaStanze().put(nome, stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome, String nomeAttrezzoLuminoso) {
		StanzaBuia stanza = new StanzaBuia(nome, nomeAttrezzoLuminoso);
		this.nomeStanza.put(nome, stanza);
		this.labirinto.getMappaStanze().put(nome, stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		if (this.ultimaStanzaAggiunta != null) {
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			this.ultimaStanzaAggiunta.addAttrezzo(attrezzo);
		}
		return this;
	}

	public LabirintoBuilder addAdiacenza(String nomeStanza1, String nomeStanza2, Direzione direzione) {
		Stanza stanza1 = this.nomeStanza.get(nomeStanza1);
		Stanza stanza2 = this.nomeStanza.get(nomeStanza2);
		if (stanza1 != null && stanza2 != null) {
			stanza1.impostaStanzaAdiacente(direzione, stanza2);
		}
		return this;
	}

	public Labirinto getLabirinto() {return this.labirinto;}
}
