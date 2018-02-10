import java.util.*;
public class Testjeudelaviedebase {

    public static void main (String[]args) {
        Liste listededepart = new Liste();
        listededepart.addLast(new Paire(2, 3));
        listededepart.addLast(new Paire(3, 3));
        listededepart.addLast(new Paire(4, 3));
        System.out.print(listededepart.toString());
        System.out.println(" ");
        System.out.println(" ");
        System.out.print(listededepart.verifierVoisinsretournelistedesvoisinsmorts().toString());
        Liste lesvoisinsmort = listededepart.verifierVoisinsretournelistedesvoisinsmorts();

    }
}
