import java.util.Scanner;
public class Paire {
    static Scanner in = new Scanner (System.in);

    private int x, y;

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
}
