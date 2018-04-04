public class Principale {
    public static void main (String [] args){
      Liste a = new Liste();
       /* Liste listededepart = new Liste();
        listededepart.addLast(new Paire(2, 3));
        listededepart.addLast(new Paire(3, 3));
        listededepart.addLast(new Paire(4, 3));
        System.out.println("Voci la liste de depart : \n ");
        System.out.print(listededepart.toString());
        System.out.println(" ");
        System.out.println(" ");*/
      /*  Liste listecellulevivante = listededepart.verifierVoisinsretournecellulesvivantes();
        Liste listevoisinVivant = listededepart.verifierVoisinsretournelistedesvoisinsvivants();
        Liste listevoisinMort = listededepart.verifierVoisinsretournelistedesvoisinsmorts()  ;
        Liste MortAVie = a.compare(listevoisinVivant, listevoisinMort);
        System.out.println("Voici la liste des cellules qui sont n�es et  qui etaient initialement morte : ");
        System.out.println(MortAVie.toString());
        System.out.println("Voici la liste finale :");
        Liste finale = listecellulevivante.concatener(MortAVie);

        System.out.println(finale.toString());*/

        Liste b = new Liste ();
        b.addInHead(new Paire (5, 10));
       System.out.println(b.addTrier(new Paire(1, 3 )));
        System.out.println(b.addTrier (new Paire (1, 1)));
       System.out.println(b.addTrier( new Paire (2, 6)));
       System.out.println(b.addTrier ( new Paire ( 0 , 1)));
       System.out.println(b.addTrier (new Paire ( 1 , 0)));

        System.out.println(b.toString());
    }
}
