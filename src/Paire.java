package Projet;

import java.util.*;

/**
 * Projet.Paire est la classe représentant une cellule.
 */
public class Paire implements Comparable<Paire>{
    static Scanner in = new Scanner (System.in);

    /**
     * Représente la valeur de l'abscisse de la paire.
     */
    public int x ;
    /**
     * Représente la valeur de l'ordonnée de la paire.
     */
    public int y;
    /**
     * Représente le nombre de voisins de la paire.
     */
    public int nbv;

    /**
     *Constructeur Projet.Paire
     * @param x
     * La valeur de l'abscisse de la paire.
     * @param y
     * La valeur de l'ordonnée de la paire.
     * @param voisins
     * Le nombre de voisins de la paire.
     */
     public Paire(int x, int y, int voisins){
        this.x = x;
        this.y = y;
        this.nbv = voisins;
    }

    /**
     * Attribut a chaque paire sa coordonnée (abscisse, ordonnee) et le nombre de ses voisins initié à 0
     */
     public Paire(){
        System.out.print("Entrez x : ");
        int x = in.nextInt();
        this.x = x;
        System.out.print("Entrez y : ");
        int y = in.nextInt();
        this.y = y;
        this.nbv= 0;
    }

    /**
     * Vérifie si la paire this est égale à une autre paire.
     * @param o
     *un objet o
     * @return un booléen vrai si l'objet passé en paramètre est identique à la paire this.
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paire paire = (Paire) o;
        return x == paire.x && y == paire.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    /**
     * Retourne l'abscisse de la paire.
     * @return l'abscisse de la paire sous forme d'entier.
     */
    public int getx(){
        return this.x;
    }

    /**
     *  Retourne l'ordonnée de la paire.
     * @return l'ordonnée de la paire sous forme d'entier.
     */
    public int gety(){
        return this.y;
    }

    /**
     *  Retourne l'ordonnée de la paire.
     * @return l'ordonnée de la paire sous forme d'entier.
     */
    public String toString(){
        return ("(" + x + ";" + y +")");
    }

    /**
     * Compare les coordonnées de la paire this avec une autre paire.
     * @param p
     * Une paire
     * @return un entier , 1 si la la paire this est plus grande que la paire passée en paramètre, -1 pour l'inverse et 0 si elles sont égales.
     */
    public int compareTo(Paire p) {
        if (this.getx() < p.getx()){
            return -1 ;
        }
        if (this.getx() > p.getx()){
            return 1 ;
        }
        if (this.getx() == p.getx()){
            if (this.gety() < p.gety()){
                return -1 ;
            }
            if (this.gety() > p.gety()){
                return 1 ;
            }
        }
        return 0;
    }
}
