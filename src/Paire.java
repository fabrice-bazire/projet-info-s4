
import java.util.*;

public class Paire implements Comparable<Paire>{
    static Scanner in = new Scanner (System.in);

    public int x, y, nbv;

    public Paire(int x, int y, int voisins){
        this.x = x;
        this.y = y;
        this.nbv = voisins;
    }

    public Paire(){
        System.out.print("Entrez x : ");
        int x = in.nextInt();
        this.x = x;
        System.out.print("Entrez y : ");
        int y = in.nextInt();
        this.y = y;
        this.nbv= 0;
    }

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

    public int getx(){
        return this.x;
    }

    public int gety(){
        return this.y;
    }

    public String toString(){
        return ("(" + x + ";" + y +")");
    }


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
