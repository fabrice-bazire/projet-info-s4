public class Maillon {
	
	private Paire valeur;
	private Maillon suivant;
		
	public Maillon(Paire p, Maillon m) {
		valeur = p;
		suivant = m;
	}

	public Paire getValeur() {
		return valeur;
	}

	public void setValeur(Paire valeur) {
		this.valeur = valeur;
	}

	public Maillon getSuivant() {
		return suivant;
	}

	public void setSuivant(Maillon suivant) {
		this.suivant = suivant;
	}
}
