

import java.util.Scanner;
public class Paire extends Liste {
    static Scanner in = new Scanner (System.in);

    private int x;
    private int y;

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
