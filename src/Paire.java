
import java.util.*;
public class Paire extends Liste {
	   static Scanner in = new Scanner (System.in);

	/**
	 * Les coordonnees de la paire avec x pour les absices et y pour les ordonees.
	 *
	 * @see Paire#Paire()
	 * @see Paire#Paire(int, int)
	 * @see Paire#equals(Object)
	 * @see Paire#hashCode()
	 * @see Paire#compare(Paire)
	 * @see Paire#getx()
	 * @see Paire#gety()
	 */
	public int x, y;



	 	/**
	 	Constructeur vide de Paire

		 @param x
		 	l'abscisse de la paire
		 @param y
		 	l'ordonnee de la paire

		 @see Paire#x
		 @see Paire#y
	 	 */
	    public Paire(int x, int y){
	        this.x = x;
	        this.y = y;
	    }


	/**
	 * Constructeur de Paire
	 *
	 * <p>
	 *     A la construction d'une paire, les coordonnées sont rensignees par l'utilisateur
	 * </p>
	 *
	 * @see Paire#x
	 * @see Paire#y
	 */
	public Paire(){
	        System.out.print("Entrez x : ");
	        int x = in.nextInt();
	        this.x = x;
	        System.out.print("Entrez y : ");
	        int y = in.nextInt();
	        this.y = y;
	    }

	/**
	 * Permet la comparaison de paires
	 *
	 * @param o
	 * 		l'objet a comparer
	 *
	 * @return true si les deux paires sont identiques et false sinon
	 *
	 * @see Paire#x
	 * @see Paire#y
	 */
	@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Paire paire = (Paire) o;
	        return x == paire.x && y == paire.y;
	    }

	/**
	 *
	 * @return
	 */
	@Override
	    public int hashCode() {
	        return Objects.hash(x, y);
	    }

	    public int compare (Paire p){
	        if (this.getx() < p.getx()){
                return -1;
            }
            if (this.getx() > p.getx()){
                return 1;
            }
            if (this.getx() == p.getx()){
                if (this.gety() < p.gety()){
                    return -1;
                }
                if (this.gety() > p.gety()){
                    return 1;
                }
            }
	        return 0;
        }

	    public int getx(){
	        return this.x;
	    }

	    public int gety(){
	        return this.y;
	    }

	    public String toString(){
	        return ("(" + x + ";" + y +")");
	    }
}
