import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Rules {
    public Liste<Paire> liste;

    public static char[] lecture_regles_fichier_lif () {
        char [] r = new char [21];
        String i;
        char [] x;
        try{
            FileReader f = new FileReader ("fichier.lif");
            BufferedReader b = new BufferedReader(f);
            String s = " ";
            while((s= b.readLine())!=null){
                Scanner sc = new Scanner (s);
                sc.useDelimiter("\n");
                try {
                    i = sc.next();
                    x = i.toCharArray();
                    if(x[0] == '#' && x[1] == 'R'){
                        for (int j = 3; j < x.length; j++){
                            r[j-3] = x[j];
                        }
                    }
                    if(x[0] == '#' && x[1] == 'N'){
                        r[0] = '2';
                        r[1] = '3';
                        r[2] = '/';
                        r[3] = '3';
                    }
                }catch(Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        }catch (IOException e) {
            System.out.println(e);
        }
        return r;
    }

    public int NombreVoisin(Liste l, Paire p) {
        int nb = 0 ;
        Paire voisin1 = new Paire(p.getx() - 1, p.gety() + 1, 0);
        Paire voisin2 = new Paire(p.getx(), p.gety() + 1, 0);
        Paire voisin3 = new Paire(p.getx() + 1, p.gety() + 1, 0);
        Paire voisin4 = new Paire(p.getx() - 1, p.gety(), 0);
        Paire voisin5 = new Paire(p.getx() + 1, p.gety(), 0);
        Paire voisin6 = new Paire(p.getx() - 1, p.gety() - 1, 0);
        Paire voisin7 = new Paire(p.getx(), p.gety() - 1, 0);
        Paire voisin8 = new Paire(p.getx() + 1, p.gety() - 1, 0);
        if (l.contains(voisin1)) {
            nb++;
        }
        if (l.contains(voisin2)) {
            nb++;
        }
        if (l.contains(voisin3)) {
            nb++;
        }
        if (l.contains(voisin4)) {
            nb++;
        }
        if (l.contains(voisin5)) {
            nb++;
        }
        if (l.contains(voisin6)) {
            nb++;
        }
        if (l.contains(voisin7)) {
            nb++;
        }
        if (l.contains(voisin8)) {
            nb++;
        }
        return nb;
    }

    public Liste mortedevenantvivantes(Liste t, int [] tab) {
        Liste lesvoisinsvivants = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
            for (int i = 0; i < tab.length; i++) {
                if (NombreVoisin(t, p1) == tab[i] && !lesvoisinsvivants.contains(p1)) {
                    lesvoisinsvivants.addTrier(p1);
                }
            }
            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
            for (int i = 0; i < tab.length; i++) {
                if (NombreVoisin(t, p2) == tab[i] && !lesvoisinsvivants.contains(p2)) {
                    lesvoisinsvivants.addTrier(p2);
                }
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
            for (int i = 0; i < tab.length; i++) {
                if (NombreVoisin(t, p3) == tab[i] && !lesvoisinsvivants.contains(p3)) {
                    lesvoisinsvivants.addTrier(p3);
                }
            }
            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
            for (int i = 0; i < tab.length; i++) {
                if (NombreVoisin(t, p4) == tab[i] && !lesvoisinsvivants.contains(p4)) {
                    lesvoisinsvivants.addTrier(p4);
                }
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
            for (int i = 0; i < tab.length; i++) {
                if (NombreVoisin(t, p5) == tab[i] && !lesvoisinsvivants.contains(p5)) {
                    lesvoisinsvivants.addTrier(p5);
                }
            }
            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
            for (int i = 0; i < tab.length; i++) {
                if (NombreVoisin(t, p6) == tab[i] && !lesvoisinsvivants.contains(p6)) {
                    lesvoisinsvivants.addTrier(p6);
                }
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
            for (int i = 0; i < tab.length; i++) {
                if (NombreVoisin(t, p7) == tab[i] && !lesvoisinsvivants.contains(p7)) {
                    lesvoisinsvivants.addTrier(p7);
                }
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
            for (int i = 0; i < tab.length; i++) {
                if (NombreVoisin(t, p8) == tab[i] && !lesvoisinsvivants.contains(p8)) {
                    lesvoisinsvivants.addTrier(p8);
                }
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsvivants;
    }

    public Liste vivantsquirestentvivants(Liste t, int [] tab) {
        Liste lesvoisinsvivants = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            for (int i = 0; i < tab.length; i++) {
                System.out.println("tour n°" + i + " : " + tab[i]);
                Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
                if ((NombreVoisin(t, p1) == tab[i]) && !lesvoisinsvivants.contains(p1) && t.contains(p1)) {
                    System.out.println("p1");
                    System.out.println("nombre voisin"+NombreVoisin(t,p1));
                    lesvoisinsvivants.addTrier(p1); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
                if ((NombreVoisin(t, p2) == tab[i]) && !lesvoisinsvivants.contains(p2) && t.contains(p2)) {
                    System.out.println("p2");
                    System.out.println("nombre voisin"+NombreVoisin(t,p2));
                    lesvoisinsvivants.addTrier(p2); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
                if ((NombreVoisin(t, p3) == tab[i]) && !lesvoisinsvivants.contains(p3) && t.contains(p3)) {
                    System.out.println("p3");
                    System.out.println("nombre voisin"+NombreVoisin(t,p3));
                    lesvoisinsvivants.addTrier(p3); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
                if ((NombreVoisin(t, p4) == tab[i]) && !lesvoisinsvivants.contains(p4) && t.contains(p4)) {
                    System.out.println("p4");
                    System.out.println("nombre voisin"+NombreVoisin(t,p4));
                    lesvoisinsvivants.addTrier(p4); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
                if ((NombreVoisin(t, p5) == tab[i]) && !lesvoisinsvivants.contains(p5) && t.contains(p5)) {
                    System.out.println("p5");
                    System.out.println("nombre voisin"+NombreVoisin(t,p5));
                    lesvoisinsvivants.addTrier(p5); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
                if ((NombreVoisin(t, p6) == tab[i]) && !lesvoisinsvivants.contains(p6) && t.contains(p6)) {
                    System.out.println("p6");
                    System.out.println("nombre voisin"+NombreVoisin(t,p6));
                    lesvoisinsvivants.addTrier(p6); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
                if ((NombreVoisin(t, p7) == tab[i]) && !lesvoisinsvivants.contains(p7) && t.contains(p7)) {
                    System.out.println("p7");
                    System.out.println("nombre voisin"+NombreVoisin(t,p7));
                    lesvoisinsvivants.addTrier(p7); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
                if ((NombreVoisin(t, p8) == tab[i]) && !lesvoisinsvivants.contains(p8) && t.contains(p8)) {
                    System.out.println("p8");
                    System.out.println("nombre voisin"+NombreVoisin(t,p8));
                    lesvoisinsvivants.addTrier(p8); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                System.out.println(" ");
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsvivants;
    }

    public Liste newgeneration(Liste t) {
        Liste  a = new Liste() ;
        int [] x = (a.extraire_nb_pour_naitre(a.lecture_regles_fichier_lif()));
        int [] y = (a.extraire_nb_pour_survivre(a.lecture_regles_fichier_lif()));
        for (int i = 0; i < y.length; i++){
            System.out.print(y[i] + " ");
        }
        System.out.print("/ ");
        for (int i = 0; i < x.length; i++){
            System.out.print(x[i] + " ");
        }
        System.out.println(" ");
        Liste listevoisinVivant = mortedevenantvivantes(t, x);
        Liste listevoisinMort = vivantsquirestentvivants(t, y);
        return listevoisinVivant.concatener((listevoisinMort));
    }

    public int taille_queue (Liste t, int periode){
        int taille = 0;
        Liste l = t;
        Liste lp = t;
        while (periode > 0){
            lp = lp.newgeneration(lp);
            periode --;
        }
        if (!l.identique(lp)){
            taille++;
            l = l.newgeneration(l);
            lp = lp.newgeneration(lp);
        }
        return taille;
    }

    public int[] extraire_nb_pour_survivre (char [] l){
        int taille = 0;
        while (l[taille] != '/'){
            taille++;
        }
        int [] a = new int [l.length/2];
        for (int i = 0; i<l.length; i++) {
            if (l[i] != '/') {
                a[i] = Character.getNumericValue(l[i]);
            }else{
                i = l.length;
            }
        }
        int [] p = new int [taille];
        for (int w = 0; w < taille; w++){
            p[w] = a[w];
        }
        return p;
    }

    public int[] extraire_nb_pour_naitre (char [] l){
        int taille_autre = 0;
            while (l[taille_autre] != '/') {
                taille_autre++;
            }
        taille_autre++;
        System.out.println(taille_autre);
        int [] a = new int [l.length];
        for (int i = l.length-1; i >= 0; i--) {
            if (l[i] != '/') {
                a[i-taille_autre] = Character.getNumericValue(l[i]);
            }else{
                i = 0;
            }
        }
        int s = 0;
        while (a[s] != -1){
            s++;
        }
        int p [] = new int [s];
        for (int b = 0; b < s; b++){
            p[b] = a[b];
        }
        return p;
    }

    public boolean verif_regles (Paire p, Liste t, int [] tab){
        for(int i=0; i<tab.length; i++){
            System.out.println("Nombre voisin : " + NombreVoisin(t,p));
            System.out.println("tab [" + i + "] : " + tab[i]);
            if (NombreVoisin(t, p) == tab[i]) {
                return true;
            }
        }
        return false;
    }

    public int periode (Liste t) {
        Liste initiale;
        Liste suivante;
        int periode = 0;
        boolean sameconfig = false;
        initiale = t;
        suivante = newgeneration(t);
        if (initiale.identique(suivante)) {
            return periode;
        }
        while (!sameconfig) {
            periode++;
            initiale = newgeneration(initiale);
            suivante = newgeneration(suivante);
            suivante = newgeneration(suivante);
            if (initiale.identique(suivante)) {
                sameconfig=true;
                periode++;
            }
        }
        return periode;
    }

    public String comportement (Liste t, int periode, int queue){
        if (t == null){
            return "Le comportement est : mort\nLa période est de : " + periode +"\nLa taille de la queue est : " + queue;
        }
        if (periode == 1){
            return "Le comportement est : stable\nLa période est de : " + periode +"\nLa taille de la queue est : " + queue;
        }
        if (periode > 1){
            return "Le comportement est : oscillateur\nLa période est de : " + periode +"\nLa taille de la queue est : " + queue;
        }
        return " ";
    }

    public Liste retournetouslesvoisinsmorts (Liste t){
        Liste voisins = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null){
            Paire voisin1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
            Paire voisin2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
            Paire voisin3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
            Paire voisin4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
            Paire voisin5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
            Paire voisin6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
            Paire voisin7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
            Paire voisin8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
            if (!voisins.contains(voisin1) && !t.contains(voisin1)){
                voisins.addInHead(voisin1);
            }
            if (!voisins.contains(voisin2) && !t.contains(voisin2)){
                voisins.addInHead(voisin2);
            }
            if (!voisins.contains(voisin3) && !t.contains(voisin3)){
                voisins.addInHead(voisin3);
            }
            if (!voisins.contains(voisin4) && !t.contains(voisin4)){
                voisins.addInHead(voisin4);
            }
            if (!voisins.contains(voisin5) && !t.contains(voisin5)){
                voisins.addInHead(voisin5);
            }
            if (!voisins.contains(voisin6) && !t.contains(voisin6)){
                voisins.addInHead(voisin6);
            }
            if (!voisins.contains(voisin7) && !t.contains(voisin7)){
                voisins.addInHead(voisin7);
            }
            if (!voisins.contains(voisin8) && !t.contains(voisin8)){
                voisins.addInHead(voisin8);
            }
            ref = ref.getSuivant();
        }
        return voisins;
    }

    public Liste verifierVoisinsretournecellulesvivantes(Liste t) {
        Liste cellulesvivantes = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
            if (t.contains(p1)) {
                ref.getValeur().nbv++;
            }
            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
            if (t.contains(p2)) {
                ref.getValeur().nbv++;
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
            if (t.contains(p3)) {
                ref.getValeur().nbv++;
            }

            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
            if (t.contains(p4)) {
                ref.getValeur().nbv++;
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
            if (t.contains(p5)) {
                ref.getValeur().nbv++;
            }

            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
            if (t.contains(p6)) {
                ref.getValeur().nbv++;
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
            if (t.contains(p7)) {
                ref.getValeur().nbv++;
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
            if (t.contains(p8)) {
                ref.getValeur().nbv++;
            }
            if (ref.getValeur().nbv == 2 || ref.getValeur().nbv == 3) {
                cellulesvivantes.addTrier(ref.getValeur());
            }
            ref = ref.getSuivant();
        }
        return cellulesvivantes;
    }
}
