import java.util.*;
public class Testjeudelaviedebase {

    public static void main (String[]args) {
        Liste tab = new Liste();
        tab.add(new Paire(2, 3));
        tab.add(new Paire(3, 3));
        tab.add(new Paire(4, 3));
        System.out.print(tab.toString());
        tab.verifierVoisins();
        System.out.println(" ");
        System.out.println(" ");
        System.out.print(tab.toString());
    }
}
