package it.uniroma3.diadia.giocatore;


import it.uniroma3.diadia.attrezzi.*;

import java.util.*;
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>(); 
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (Attrezzo attrezzo: this.attrezzi)
			if (attrezzo.getNome().equals(nomeAttrezzo))
				a = attrezzo;

		return a;
	}
	public int getPeso() {
		int peso = 0;
		for (Attrezzo attrezzo: this.attrezzi)
			peso += attrezzo.getPeso();

		return peso;
	}
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		for (Attrezzo attrezzo : this.attrezzi){
			if(attrezzo.getNome().equals(nomeAttrezzo)) {
				this.attrezzi.remove(attrezzo);
				return attrezzo;
			}
		}
		return null;
	}
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo attrezzo: this.attrezzi)
				s.append(attrezzo.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
        List<Attrezzo> lista = new ArrayList<>(this.attrezzi);
        ComparatoreAttrezzoPeso comparatore = new ComparatoreAttrezzoPeso();
        Collections.sort(lista, comparatore);
        return lista;
    }

    public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
        SortedSet<Attrezzo> set = new TreeSet<>(this.attrezzi);
        return set;
    }
    public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
        Map<Integer, Set<Attrezzo>> mappa = new TreeMap<Integer, Set<Attrezzo>>();
        for(Attrezzo attrezzo : this.attrezzi) {
			if(!mappa.containsKey(attrezzo.getPeso())) {
				Set<Attrezzo> setNuovoPeso = new HashSet<Attrezzo>();
				setNuovoPeso.add(attrezzo);
				mappa.put(attrezzo.getPeso(), setNuovoPeso);
			}else {
				mappa.get(attrezzo.getPeso()).add(attrezzo);
			}
        }
        return mappa;
    }
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatoreAttrezzoPeso comparatore = new ComparatoreAttrezzoPeso();
		SortedSet<Attrezzo> ordinato = new TreeSet<Attrezzo>(comparatore);
		ordinato.addAll(this.attrezzi);
		return ordinato;
	}
}
