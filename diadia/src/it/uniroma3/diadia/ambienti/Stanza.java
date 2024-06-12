package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import it.uniroma3.diadia.personaggi.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */
public class Stanza {
    
    static final private int NUMERO_MASSIMO_DIREZIONI = 4;
    static final private int NUMERO_MASSIMO_ATTREZZI = 10;
    
    private String nome;
    
    private List<Attrezzo> attrezzi;
    private int numeroAttrezzi;
    
    private AbstractPersonaggio personaggio;
    private Map<Direzione, Stanza> stanzeAdiacenti;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new ArrayList<>();
        this.numeroAttrezzi = 0;
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
        if(this.stanzeAdiacenti.size() < NUMERO_MASSIMO_DIREZIONI || this.stanzeAdiacenti.containsKey(direzione)) {
            this.stanzeAdiacenti.put(direzione, stanza);
        }
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata.
     * @param direzione la direzione della stanza adiacente da restituire.
     * @return la stanza adiacente nella direzione specificata.
     */
    public Stanza getStanzaAdiacente(Direzione direzione) {
        return this.stanzeAdiacenti.get(direzione);
    }
    public Stanza getStanzaAdiacente(String direzione) {
    	return this.stanzeAdiacenti.get(direzione);
    }

    /**
     * Restituisce il nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public List<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi.add(attrezzo);
            this.numeroAttrezzi++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Restituisce una rappresentazione stringa di questa stanza,
     * stampandone la descrizione, le uscite e gli eventuali attrezzi contenuti.
     * @return la rappresentazione stringa
     */
    public String toString() {
        StringBuilder risultato = new StringBuilder();
        risultato.append(this.nome);
        risultato.append("\nUscite: ");
        for (Direzione direzione : this.stanzeAdiacenti.keySet()) {
            risultato.append(" " + direzione);
        }
        risultato.append("\nAttrezzi nella stanza: ");
        
        for(Attrezzo attrezzo: this.attrezzi) {
            risultato.append(attrezzo.toString() + " ");
        }
        return risultato.toString();
    }

    /**
     * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
     * @return true se l'attrezzo esiste nella stanza, false altrimenti.
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        for (Attrezzo attrezzo : this.attrezzi) {
            if (attrezzo.getNome().equals(nomeAttrezzo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
     * @param nomeAttrezzo il nome dell'attrezzo da cercare.
     * @return l'attrezzo presente nella stanza, null se l'attrezzo non e' presente.
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (Attrezzo attrezzo: this.attrezzi) {
            if (attrezzo.getNome().equals(nomeAttrezzo)) {
                return attrezzo;
            }
        }
        return null;
    }

    /**
     * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
     * @param attrezzo l'attrezzo da rimuovere.
     * @return true se l'attrezzo e' stato rimosso, false altrimenti.
     */
    public boolean removeAttrezzo(Attrezzo attrezzo) {
        return this.attrezzi.remove(attrezzo);
    }

    /**
     * Restituisce la mappa delle stanze adiacenti.
     * @return la mappa delle stanze adiacenti.
     */
    public Map<Direzione, Stanza> getMapStanzeAdiacenti() {
        return this.stanzeAdiacenti;
    }

    /**
     * Restituisce la lista delle direzioni disponibili.
     * @return la lista delle direzioni disponibili.
     */
    public List<Direzione> getDirezioni() {
        Set<Direzione> setDirezioni = this.stanzeAdiacenti.keySet();
        return new ArrayList<>(setDirezioni);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stanza stanza = (Stanza) o;
        return nome.equals(stanza.nome);
    }
    
    @Override
    public int hashCode() {
        return nome.hashCode();
    }
    
    public void setPersonaggio(AbstractPersonaggio ap) {
        this.personaggio = ap;
    }
    
    public AbstractPersonaggio getPersonaggio() {
        return this.personaggio;
    }
    public int getNumeroAttrezzi() {
    	return this.numeroAttrezzi;
    }
}
