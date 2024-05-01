package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private String DirezioneBloccata;
	private String AttrezzoSbloccaDirezione;

	public StanzaBloccata(String nome, String DirezioneBloccata, String AttrezzoSbloccaDirezione) {
		super(nome);
		this.DirezioneBloccata = DirezioneBloccata;
		this.AttrezzoSbloccaDirezione = AttrezzoSbloccaDirezione;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
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
		for (String direzione : this.getDirezioni())
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
