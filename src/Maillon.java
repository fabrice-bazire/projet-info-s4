public class Maillon<T>  implements Comparable<T>{


    private T valeur;
    private Maillon<T> suivant;

     public Maillon (){
        this.valeur = null;
        this.suivant = null;
     }

    public Maillon (T p) {
        this.valeur=p;
        this.suivant=null;

    }
    public Maillon(T p, Maillon<T> m) {
        valeur = p;
        suivant = m;
    }

    public T getValeur() {
        return valeur;
    }

    public void setValeur(T valeur) {
        this.valeur = valeur;
    }

    public Maillon<T> getSuivant() {
        return suivant;
    }

    public void setSuivant(Maillon<T> suivant) {
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
        Maillon<T> other = (Maillon<T>) obj;
        if (valeur == null) {
            if (other.valeur != null)
                return false;
        } else if (!valeur.equals(other.valeur))
            return false;
        return true;
    }

   @Override
    public int compareTo(T o) {
        return (this.compareTo(o));
    }
}
