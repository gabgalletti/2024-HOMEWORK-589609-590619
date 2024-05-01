package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza {
	
	private String AttrezzoPerIlluminare;

	public StanzaBuia(String nome, String AttrezzoPerIlluminare) {
		super(nome);
		this.AttrezzoPerIlluminare = AttrezzoPerIlluminare;
	}
	@Override
	public String getDescrizione() {
		String buio = new String();
		buio = "qui c'è un buio pesto";
		if(!this.hasAttrezzo(AttrezzoPerIlluminare))
			return buio;
		return super.getDescrizione();
	}
}