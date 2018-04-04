public class Principale {
    public static void main (String [] args){
      /*Liste a = new Rules();
        Liste listededepart = new Rules ();
        listededepart.addLast(new Paire(2, 3));
        listededepart.addTrier(new Paire(3, 3));
        listededepart.addTrier(new Paire(4, 3));
        System.out.println("Voci la liste de depart : \n ");
        System.out.print(listededepart.toString());
        System.out.println(" ");
        System.out.println(" ");
      /* Liste listecellulevivante = listededepart.verifierVoisinsretournecellulesvivantes();
        Liste listevoisinVivant = listededepart.verifierVoisinsretournelistedesvoisinsvivants();
        Liste listevoisinMort = listededepart.verifierVoisinsretournelistedesvoisinsmorts()  ;
        Liste MortAVie = a.compare(listevoisinVivant, listevoisinMort);
        System.out.println("Voici la liste des cellules qui sont n�es et  qui etaient initialement morte : ");
        System.out.println(MortAVie.toString());
        System.out.println("Voici la liste finale :");
        Liste finale = listecellulevivante.concatener(MortAVie);

        System.out.println(finale.toString());*/

        /*Liste b = new Rules();
        b.addInHead(new Paire (5, 10));
       System.out.println(b.addTrier(new Paire(1, 3 )));
        System.out.println(b.addTrier (new Paire (1, 1)));
       System.out.println(b.addTrier( new Paire (2, 6)));
       System.out.println(b.addTrier ( new Paire ( 0 , 1)));
       System.out.println(b.addTrier (new Paire ( 1 , 0)));


        Liste m = new Rules ();
        m.addInHead(new Paire (5, 10));
        System.out.println(m.addTrier(new Paire(1, 3 )));
        System.out.println(m.addTrier (new Paire (1, 1)));
        System.out.println(m.addTrier( new Paire (2, 6)));
        System.out.println(m.addTrier ( new Paire ( 0 , 1)));
        System.out.println(b.addTrier (new Paire ( 2 , 0)));
        System.out.println("identique " +b.identique(m));
        /*System.out.println(b.toString());*/

      //  System.out.println("peridoe :" +a.comportement_asymptotique());

      Liste<Integer> i = new Liste<Integer>();
      i.addInHead(1);
      System.out.print(i);


    }
}
