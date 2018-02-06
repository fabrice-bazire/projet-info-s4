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

    public String toString(){
       String s = "Voici les coordonnées des cellules vivantes :\n";
       int taille = this.tab.size();
       for (int i = 0; i < taille; i++){
           s += this.tab.get(i).toString() + "\n";
       }
       return s;
    }
}
