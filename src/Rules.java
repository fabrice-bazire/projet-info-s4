package Projet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

<<<<<<< HEAD
/**
 * <b>Projet.Rules est la classe qui recense les regles du jeu de la vie</b>
 */
=======
>>>>>>> parent of a4c55b4... javadoc quasi complete + taille de la queue fonctionne + -s et -c fonctionne
public class Rules {
    public Liste<Paire> liste;

    public String fichier = Principale.f;

    public char[] lecture_regles_fichier_lif() {
        char[] r = new char[21];
        String i;
        char[] x;
        try {
            FileReader f = new FileReader(this.fichier);
            BufferedReader b = new BufferedReader(f);
            String s = " ";
            while ((s = b.readLine()) != null) {
                Scanner sc = new Scanner(s);
                sc.useDelimiter("\n");
                try {
                    i = sc.next();
                    x = i.toCharArray();
                    if (x[0] == '#' && x[1] == 'R') {
                        for (int j = 3; j < x.length; j++) {
                            r[j - 3] = x[j];
                        }
                    }
                    if (x[0] == '#' && x[1] == 'N') {
                        r[0] = '2';
                        r[1] = '3';
                        r[2] = '/';
                        r[3] = '3';
                    }
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return r;
    }

    public int NombreVoisin(Liste l, Paire p) {
        int nb = 0;
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

    public Liste mortedevenantvivantes(Liste t, int[] tab) {
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

<<<<<<< HEAD
    /**
     * <p>
     *     Renvois la liste des cellules qui survivent.
     *     Pour chaque valeur du tableau placé en parametres,
     *
     * </p>
     * @param t
     * @param tab
     * @return
     */
    /*public Projet.Liste vivantsquirestentvivants(Projet.Liste t, int[] tab) {
        Projet.Liste lesvoisinsvivants = new Projet.Liste();
        Projet.Maillon<Projet.Paire> ref = t.tete;
=======
    /*public Liste vivantsquirestentvivants(Liste t, int[] tab) {
        Liste lesvoisinsvivants = new Liste();
        Maillon<Paire> ref = t.tete;
>>>>>>> parent of a4c55b4... javadoc quasi complete + taille de la queue fonctionne + -s et -c fonctionne
        while (ref != null) {
            for (int i = 0; i < tab.length; i++) {
                Projet.Paire p1 = new Projet.Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
                if ((NombreVoisin(t, p1) == tab[i]) && !lesvoisinsvivants.contains(p1) && t.contains(p1)) {
                    lesvoisinsvivants.addTrier(p1); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Projet.Paire p2 = new Projet.Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
                if ((NombreVoisin(t, p2) == tab[i]) && !lesvoisinsvivants.contains(p2) && t.contains(p2)) {
                    lesvoisinsvivants.addTrier(p2); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Projet.Paire p3 = new Projet.Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
                if ((NombreVoisin(t, p3) == tab[i]) && !lesvoisinsvivants.contains(p3) && t.contains(p3)) {
                    lesvoisinsvivants.addTrier(p3); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Projet.Paire p4 = new Projet.Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
                if ((NombreVoisin(t, p4) == tab[i]) && !lesvoisinsvivants.contains(p4) && t.contains(p4)) {
                    lesvoisinsvivants.addTrier(p4); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Projet.Paire p5 = new Projet.Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
                if ((NombreVoisin(t, p5) == tab[i]) && !lesvoisinsvivants.contains(p5) && t.contains(p5)) {
                    lesvoisinsvivants.addTrier(p5); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Projet.Paire p6 = new Projet.Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
                if ((NombreVoisin(t, p6) == tab[i]) && !lesvoisinsvivants.contains(p6) && t.contains(p6)) {
                    lesvoisinsvivants.addTrier(p6); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Projet.Paire p7 = new Projet.Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
                if ((NombreVoisin(t, p7) == tab[i]) && !lesvoisinsvivants.contains(p7) && t.contains(p7)) {
                    lesvoisinsvivants.addTrier(p7); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Projet.Paire p8 = new Projet.Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
                if ((NombreVoisin(t, p8) == tab[i]) && !lesvoisinsvivants.contains(p8) && t.contains(p8)) {
                    lesvoisinsvivants.addTrier(p8); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                System.out.println(" ");
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsvivants;
    }*/

    public Liste vivantsquirestentvivants(Liste t, int[] tab) {
        Liste lessurvivants = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            for (int i = 0; i < tab.length; i++) {
                if (NombreVoisin(t, ref.getValeur()) == tab[i]){
                    lessurvivants.addTrier(ref.getValeur());
                }
            }
            ref = ref.getSuivant();
        }
        return lessurvivants;
    }

    public Liste newgeneration(Liste t) {
        Liste a = new Liste();
        int[] x = (a.extraire_nb_pour_naitre(a.lecture_regles_fichier_lif()));
        int[] y = (a.extraire_nb_pour_survivre(a.lecture_regles_fichier_lif()));
        Liste listevoisinVivant = mortedevenantvivantes(t, x);
        Liste listevoisinMort = vivantsquirestentvivants(t, y);
        a = listevoisinVivant.concatener((listevoisinMort));
        return a;
    }

    public int taille_queue(Liste t, int periode) {
        int taille = 0;
        Liste l = t;
        Liste lp = t;
        while (periode > 0) {
            lp = lp.newgeneration(lp);
            periode--;
        }
        if (!l.identique(lp)) {
            taille++;
            l = l.newgeneration(l);
            lp = lp.newgeneration(lp);
        }
        return taille;
    }

    public int[] extraire_nb_pour_survivre(char[] l) {
        int taille = 0;
        while (l[taille] != '/') {
            taille++;
        }
        int[] a = new int[l.length / 2];
        for (int i = 0; i < l.length; i++) {
            if (l[i] != '/') {
                a[i] = Character.getNumericValue(l[i]);
            } else {
                i = l.length;
            }
        }
        int[] p = new int[taille];
        for (int w = 0; w < taille; w++) {
            p[w] = a[w];
        }
        return p;
    }

    public int[] extraire_nb_pour_naitre(char[] l) {
        int taille_autre = 0;
        while (l[taille_autre] != '/') {
            taille_autre++;
        }
        taille_autre++;
        System.out.println(taille_autre);
        int[] a = new int[l.length];
        for (int i = l.length - 1; i >= 0; i--) {
            if (l[i] != '/') {
                a[i - taille_autre] = Character.getNumericValue(l[i]);
            } else {
                i = 0;
            }
        }
        int s = 0;
        while (a[s] != -1) {
            s++;
        }
        int p[] = new int[s];
        for (int b = 0; b < s; b++) {
            p[b] = a[b];
        }
        return p;
    }

    public boolean verif_regles(Paire p, Liste t, int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Nombre voisin : " + NombreVoisin(t, p));
            System.out.println("tab [" + i + "] : " + tab[i]);
            if (NombreVoisin(t, p) == tab[i]) {
                return true;
            }
        }
        return false;
    }

    public int periode(Liste t) {
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
                sameconfig = true;
                periode++;
            }
        }
        return periode;
    }

    public String comportement(Liste t, int periode, int queue) {
        if (t == null) {
            return "Le comportement est : mort\nLa période est de : " + periode + "\nLa taille de la queue est : " + queue;
        }
        if (periode == 1) {
            return "Le comportement est : stable\nLa période est de : " + periode + "\nLa taille de la queue est : " + queue;
        }
        if (periode > 1) {
            return "Le comportement est : oscillateur\nLa période est de : " + periode + "\nLa taille de la queue est : " + queue;
        }
        return " ";
    }
}
