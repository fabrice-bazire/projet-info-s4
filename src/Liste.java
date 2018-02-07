import java.util.LinkedList;
import java.util.List;

public class Liste {
    List<Paire> tab;

    public Liste(){
        this.tab = new LinkedList<Paire>();
    }

    public void add (Paire p){
        this.tab.add(p);
    }

    public boolean isEmpty(){
        return this.tab.isEmpty();
    }

    public int taille(){
        return this.tab.size();
    }

    public String toString(){
        String s = "Voici les coordonnées des cellules vivantes :\n";
        for (Liste paire : this.tab){
            s += paire.toString() + "\n";
        }
        return s;
    }

    public void verifierVoisins() {
        Liste provisoire = new Liste();
        int nbvoisins = 0;
        for (Paire paire : this.tab) {
            System.out.println("0)" + nbvoisins);
            if (this.tab.contains(new Paire(paire.getx() - 1, paire.gety() + 1))) {
                nbvoisins++;
                System.out.print("1)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx(), paire.gety() + 1))) {
                nbvoisins++;
                System.out.print("2)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx() + 1, paire.gety() + 1))) {
                nbvoisins++;
                System.out.print("3)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx() - 1, paire.gety()))) {
                nbvoisins++;
                System.out.print("4)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx() + 1, paire.gety()))) {
                nbvoisins++;
                System.out.print("5)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx() - 1, paire.gety() - 1))) {
                nbvoisins++;
                System.out.print("6)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.x, paire.y - 1))) {
                nbvoisins++;
                System.out.println("7)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx() + 1, paire.gety() - 1))) {
                nbvoisins++;
                System.out.println("8)" + nbvoisins);
            }
            if (nbvoisins == 2 || nbvoisins == 3) {
                provisoire.add(paire);
            }
            nbvoisins = 0;
        }
        this.tab = new LinkedList<Paire>();
        for (Paire paire : provisoire.tab) {
            this.tab.add(paire);
        }
    }
}
