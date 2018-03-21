import java.util.*;
public class Testjeudelaviedebase {

    public static void main (String[]args) {
        Liste listededepart = new Liste();
        listededepart.addInHead(new Paire(14, 4));
        listededepart.addTrier(new Paire(8, 7));
        listededepart.addTrier(new Paire(6, 3));
        listededepart.addTrier(new Paire(6, 35));
        System.out.print(listededepart.toString());
    }
}
