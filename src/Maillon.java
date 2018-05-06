/**
 *
 * Maillon est la classe qui permet de construire une liste
 */
public class Maillon<T extends Comparable> implements Comparable<Maillon>{

    /**
     * Représente la valeur du Maillon.
     */
    private T valeur;
    /**
     * Représente le Maillon suivant.
     */
    private Maillon<T> suivant;

    /**
     * Constructeur Maillon
     */
     public Maillon (){
        this.valeur = null;
        this.suivant = null;
     }

    /**
     * Constructeut Maillon qui initialise la valeur du maillon.
     * @param p
     * Un type T.
     */
    public Maillon (T p) {
        this.valeur=p;
        this.suivant=null;

    }

    /**
     * Constructeur Maillon.
     * @param p
     * Un type T
     * @param m
     * Un Maillon
     */
    public Maillon(T p, Maillon<T > m) {
        valeur = p;
        suivant = m;
    }

    /**
     * Retourne la valeur du Maillon.
     * @return la valeur du Maillon qui est de type T.
     */
    public T getValeur() {
        return valeur;
    }

    /**
     * Met à jour la valeur du Maillon.
     * @param valeur
     * Un type T.
     */
    public void setValeur(T valeur) {
        this.valeur = valeur;
    }

    /**
     * Retourne le suivant du Maillon this.
     * @return un Maillon qui est le suivant du Maillon this.
     */
    public Maillon<T> getSuivant() {
        return suivant;
    }

    /**
     * Met à jour le suivant du Maillon this.
     * @param suivant
     * Un maillon de type T.
     */
    public void setSuivant(Maillon<T> suivant) {
        this.suivant = suivant;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
        return result;
    }

    /**
     * Compare un objet avec le Maillon this.
     * @param obj
     * Un objet o.
     * @return un booléen vrai si l'objet est identique au Maillon this et faux sinon.
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

    /**
     * Compare la valeur d'un Maillon avec le Maillon this.
     * @param o
     * Un maillon.
     * @return un entier, 1 si la valeur de this est plus grande que la valeur du Maillon passée en paramètre, -1 pour l'inverse et 0 si ils sont identiques.
     */
    @Override
    public int compareTo(Maillon o) {
        return (this.getValeur().compareTo(o.getValeur()));
    }
}
