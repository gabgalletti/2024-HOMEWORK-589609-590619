package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	private Map<String, Stanza> mapStanze;
	private LabirintoBuilder builder;
	
	public Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	public Labirinto() {
	}

	public LabirintoBuilder getNewBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		LabirintoBuilder builder = new LabirintoBuilder(labirinto);
		return builder;
	}

	
	public Stanza getstanzaIniziale() {
		return this.stanzaIniziale;
	}
	public void setStanzaIniziale(Stanza inizio) {
		this.stanzaIniziale = inizio;
	}
	public void setStanzaVincente(Stanza fine) {
		this.stanzaVincente = fine;
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	public Map<String, Stanza> getMappaStanze(){
		return this.mapStanze;
	}
	public class LabirintoBuilder {
		 private Labirinto labirinto;
		    private Map<String, Stanza> nomeStanza;
		    private Stanza ultimaStanzaAggiunta;

		    public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
				this.labirinto = new Labirinto(labirinto);
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
}
