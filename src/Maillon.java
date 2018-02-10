public class Maillon {
	private Paire valeur;
	private Maillon suivant;
		
	
	
	public Maillon (Paire p) {
		this.valeur=p;
		this.suivant=null;
		
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Maillon))
			return false;
		Maillon other = (Maillon) obj;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		return true;
	}
	


}
