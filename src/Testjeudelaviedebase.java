import java.util.*;
public class Testjeudelaviedebase {

    public static void main (String[]args) {
        Liste listededepart = new Liste();
        listededepart.addInHead(new Paire(14, 4));
        listededepart.addInHead(new Paire(8, 7));
        listededepart.addInHead(new Paire(6, 3));
        listededepart.addInHead(new Paire(66, 43));
        listededepart.addInHead(new Paire(6, 5));
        listededepart.addInHead(new Paire(6, 43));
        listededepart.addInHead(new Paire(6, 32));
        listededepart.addInHead(new Paire(6, 13));
        listededepart.addInHead(new Paire(6, 39));
        listededepart.addInHead(new Paire(6, 35));
        System.out.print(listededepart.toString());
        System.out.print(listededepart.comportementasymptotique());
    }
}
