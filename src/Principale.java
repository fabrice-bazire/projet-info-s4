public class Principale {
    public static void main (String [] args){
        Liste listededepart = new Rules ();
        listededepart.addLast(new Paire(2, 3));
        listededepart.addLast(new Paire(4, 9));
        listededepart.addLast(new Paire(4, 3));
        System.out.println("Voci la liste de depart : \n ");
        System.out.print(listededepart.toString());
        System.out.println(" ");
        System.out.println(" ");

        /*Liste b = new Rules();
        b.addInHead(new Paire (5, 10));
        System.out.println(b.addTrier(new Paire(1, 3 )));
        System.out.println(b.addTrier (new Paire (1, 1)));
        System.out.println(b.addTrier( new Paire (2, 6)));
        System.out.println(b.addTrier ( new Paire ( 0 , 1)));
        System.out.println(b.addTrier (new Paire ( 1 , 0)));
        b.supplesdoublons();


        Liste m = new Rules ();
        m.addInHead(new Paire (5, 10));
        System.out.println(m.addTrier(new Paire(1, 3 )));
        System.out.println(m.addTrier (new Paire (1, 1)));
        System.out.println(m.addTrier( new Paire (2, 6)));
        System.out.println(m.addTrier ( new Paire ( 0 , 1)));
        System.out.println(b.addTrier (new Paire ( 1 , 0)));
        m.supplesdoublons();
        System.out.println(b.toString());

        System.out.println("b et m identique : " + b.identique(m));*/

        //System.out.println("peridoe :" +listededepart.comportement_asymptotique());

    }
}
