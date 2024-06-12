package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private Direzione DirezioneBloccata;
	private String AttrezzoSbloccaDirezione;

	public StanzaBloccata(String nome, Direzione direzione, String AttrezzoSbloccaDirezione) {
		super(nome);
		this.DirezioneBloccata = direzione;
		this.AttrezzoSbloccaDirezione = AttrezzoSbloccaDirezione;
	}

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(this.hasAttrezzo(this.AttrezzoSbloccaDirezione))
			return super.getStanzaAdiacente(direzione);
		else if(this.DirezioneBloccata != direzione)
			return super.getStanzaAdiacente(direzione);
		else 
			return this;
	}

	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.getNome());
		risultato.append(""
				+ "Uscite: ");
		for (Direzione direzione : this.getDirezioni())
			if (direzione!=null) {
				if(direzione != this.DirezioneBloccata)
					risultato.append(" " + direzione);
				else
					risultato.append("Direzione bloccata");
			}
		risultato.append(""
				+ "Attrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.getAttrezzi()) {
			if (attrezzo != null) {
				risultato.append(attrezzo.toString()+" ");
			}
		}
		return risultato.toString();
	}
}
