import java.util.*;
public class Testjeudelaviedebase {

    public static void main (String[]args) {
        Liste listededepart = new Liste();
        listededepart.addLast(new Paire(8, 3));
        listededepart.addLast(new Paire(7, 3));
        listededepart.addLast(new Paire(5, 3));
        listededepart.addLast(new Paire(6, 3));
        listededepart.addLast(new Paire(5, 3));
        listededepart.addLast(new Paire(4, 3));
        listededepart.addLast(new Paire(3, 3));
        listededepart.addLast(new Paire(2, 3));
        System.out.print(listededepart.toString());
        System.out.println(" ");
        System.out.println(" ");
        listededepart.triliste();
        System.out.print(listededepart.toString());
    }
}
