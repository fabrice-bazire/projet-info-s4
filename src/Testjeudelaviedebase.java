import java.util.*;
public class Testjeudelaviedebase {

    public static void main (String[]args) {
        Liste listededepart = new Liste();
        listededepart.add(new Paire(1, 3));
        listededepart.add(new Paire(4, 3));
        listededepart.add(new Paire(6, 3));
        listededepart.add(new Paire(2, 3));
        listededepart.add(new Paire(8, 3));
        listededepart.add(new Paire(3, 3));
        listededepart.add(new Paire(5, 3));
        System.out.print(listededepart.toString());

    }
}
