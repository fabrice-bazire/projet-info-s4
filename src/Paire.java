import java.util.Objects;
import java.util.Scanner;
public class Paire extends Liste {
    static Scanner in = new Scanner (System.in);

    public int x, y;

    public Paire(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Paire(){
        System.out.print("Entrez x : ");
        int x = in.nextInt();
        this.x = x;
        System.out.print("Entrez y : ");
        int y = in.nextInt();
        this.y = y;
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
}
