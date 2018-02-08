import java.util.LinkedList;
import java.util.List;

public class Liste {
    LinkedList tab;

    public Liste(){
        this.tab = new LinkedList();
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
        for (int i = 0; i < this.tab.size(); i++){
            s += this.tab.get(i).toString() + "\n";
        }
        return s;
    }

    public void verifierVoisins() {
        LinkedList provisoire = new LinkedList();
        int nbvoisins = 0;
        /*for (int i = 0; i < this.tab.size(); i++){
            System.out.println("0)" + nbvoisins);
            if (this.tab.contains(new Paire(this.tab.get(i).x- 1, this.tab.get(i).y + 1))) {
                nbvoisins++;
                System.out.println("1)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(this.tab.get(i).x, this.tab.get(i).y + 1))) {
                nbvoisins++;
                System.out.println("2)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(this.tab.get(i).x + 1, this.tab.get(i).y + 1))) {
                nbvoisins++;
                System.out.println("3)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(this.tab.get(i).x - 1, this.tab.get(i).y))) {
                nbvoisins++;
                System.out.println("4)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(this.tab.get(i).x + 1, this.tab.get(i).y))) {
                nbvoisins++;
                System.out.println("5)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(this.tab.get(i).x - 1, this.tab.get(i).y - 1))) {
                nbvoisins++;
                System.out.println("6)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(this.tab.get(i).x, this.tab.get(i).y - 1))) {
                nbvoisins++;
                System.out.println("7)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(this.tab.get(i).x + 1, this.tab.get(i).y - 1))) {
                nbvoisins++;
                System.out.println("8)" + nbvoisins);
            }
            if (nbvoisins == 2 || nbvoisins == 3) {
                provisoire.add(this.tab.get(i));
            }
            //nbvoisins = 0;
        }*/
       /* for (Paire paire : this.tab) {
            System.out.println("0)" + nbvoisins);
            if (this.tab.contains(new Paire(paire.getx() - 1, paire.gety() + 1))) {
                nbvoisins++;
                System.out.println("1)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx(), paire.gety() + 1))) {
                nbvoisins++;
                System.out.println("2)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx() + 1, paire.gety() + 1))) {
                nbvoisins++;
                System.out.println("3)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx() - 1, paire.gety()))) {
                nbvoisins++;
                System.out.println("4)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx() + 1, paire.gety()))) {
                nbvoisins++;
                System.out.println("5)" + nbvoisins);
            }
            if (this.tab.contains(new Paire(paire.getx() - 1, paire.gety() - 1))) {
                nbvoisins++;
                System.out.println("6)" + nbvoisins);
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
            //nbvoisins = 0;
        }*/
        this.tab = new LinkedList<Paire>();
        for (int i = 0; i < provisoire.size(); i++){
            this.tab.add(provisoire.get(i));
        }
    }
}
