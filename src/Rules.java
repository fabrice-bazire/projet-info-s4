import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * <b>Rules est la classe qui recense les regles du jeu de la vie</b>
 */
public class Rules {
    public Liste<Paire> liste;

    public String fichier = Principale.f;

    /**
     * <p>
     * Cette methode permet la lecture des regles dans un fichier lif.
     * La ligne commencant par #R est stockée dans un tableau.
     * Si les regles sont inchangées (#N) le tableau est rempli avec les valeurs [1, 2, /, 3].
     * </p>
     *
     * @return le tableau contenant la ligne des regles.
     *
     * @see Rules#fichier
     */
    public char[] lecture_regles_fichier_lif() {
        char[] r = new char[21];
        String i;
        char[] x;
        try {
            FileReader f = new FileReader("lif/b.lif");
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

    /**
     * Compte le nombre de voisins vivants d'une cellule
     *
     * @param l
     *      La liste des cellules vivantes
     * @param p
     *      La paire correspondant aux coordonnées de la cellule dont on compte le nombre de voisins
     *
     * @return le nombre de voisins vivants de la cellule
     *
     * @see Liste#contains
     */
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

    /**
     * <p>
     *     Renvois la liste des cellules qui naissent.
     *     Seule les cellules mortes a proximite d'au moins une cellule vivante sont sucseptible de naitre.
     *     On verifie donc seulement ces cellules, c'est a dire que pour chaque cellule vivante on regarde les caracteristiques de ses voisins.
     *     Si la cellule verifie un nombre de voisins compris dans le tableau placé en parametres, qu'elle n'appartient pas a la liste des vivantes,
     *     et qu'elle n'est pas deja dans la liste que l'on renvoie, alors on l'ajoute a cette liste.
     * </p>
     *
     * @param t
     *      La liste des cellules vivantes
     * @param tab
     *      Le tableau contanant le nombre de voisin possible pour qu'une cellule naisse
     *
     * @return la liste des cellules qui naissent
     *
     * @see Liste#contains
     * @see Liste#addTrier
     */
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
    /*public Liste vivantsquirestentvivants(Liste t, int[] tab) {
        Liste lesvoisinsvivants = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            for (int i = 0; i < tab.length; i++) {
                Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
                if ((NombreVoisin(t, p1) == tab[i]) && !lesvoisinsvivants.contains(p1) && t.contains(p1)) {
                    lesvoisinsvivants.addTrier(p1); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
                if ((NombreVoisin(t, p2) == tab[i]) && !lesvoisinsvivants.contains(p2) && t.contains(p2)) {
                    lesvoisinsvivants.addTrier(p2); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
                if ((NombreVoisin(t, p3) == tab[i]) && !lesvoisinsvivants.contains(p3) && t.contains(p3)) {
                    lesvoisinsvivants.addTrier(p3); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
                if ((NombreVoisin(t, p4) == tab[i]) && !lesvoisinsvivants.contains(p4) && t.contains(p4)) {
                    lesvoisinsvivants.addTrier(p4); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
                if ((NombreVoisin(t, p5) == tab[i]) && !lesvoisinsvivants.contains(p5) && t.contains(p5)) {
                    lesvoisinsvivants.addTrier(p5); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
                if ((NombreVoisin(t, p6) == tab[i]) && !lesvoisinsvivants.contains(p6) && t.contains(p6)) {
                    lesvoisinsvivants.addTrier(p6); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
                if ((NombreVoisin(t, p7) == tab[i]) && !lesvoisinsvivants.contains(p7) && t.contains(p7)) {
                    lesvoisinsvivants.addTrier(p7); // ou ref car on est pas sur de pouvoir ajoute direct une paire
                }
                Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
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

    /**
     * Renvois la liste des cellules a la generation suivante
     *
     * @param t
     *      La liste des cellules a partir de laquelle on va faire une nouvelle generation
     *
     * @return la liste des cellules vivantes de la nouvelle generation
     *
     * @see Rules#extraire_nb_pour_naitre
     * @see Rules#extraire_nb_pour_survivre
     * @see Rules#lecture_regles_fichier_lif
     * @see Rules#mortedevenantvivantes
     * @see Rules#vivantsquirestentvivants
     *
     */
     public Liste newgeneration(Liste t) {
        Liste a = new Liste();
        int[] x = (a.extraire_nb_pour_naitre(a.lecture_regles_fichier_lif()));
        int[] y = (a.extraire_nb_pour_survivre(a.lecture_regles_fichier_lif()));
        Liste listevoisinVivant = mortedevenantvivantes(t, x);
        Liste listevoisinMort = vivantsquirestentvivants(t, y);
        a = listevoisinVivant.concatener((listevoisinMort));
        return a;
     }

    /**
     * Calcule la taille de la queue
     *
     * @param t
     *      La liste dont on cherche la taille de la queue
     *
     * @param periode
     *      La periode de la liste étudiée
     *
     * @return la taille de la queue
     *
     * @see Rules#newgeneration
     * @see Liste#identique
     */
     public int taille_queue(Liste t, int periode) {
        int taille = 0;
        Liste l = t;
        Liste lp = t;
        while (periode > 0) {
            lp = newgeneration(lp);
            periode--;
        }
        while (!l.identique(lp)) {
            taille++;
            l = newgeneration(l);
            lp = newgeneration(lp);
        }
        return taille-1;
     }

    /**
     * Retourne le nombre de voisins necessaire pour survivre
     *
     * @param l
     *      Le tableau contenant la ligne des regles du fichier lif (#R)
     *
     * @return le nombre de voisins possible pour survivre sous forme de tableau
     *
     */
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

    /**
     * Retourne le nombre de voisins necessaire pour qu'une cellule morte naisse
     *
     * @param l
     *      Le tableau contenant la ligne des regles du fichier lif (#R)
     *
     * @return le nombre de voisins possible pour naitre sous forme de tableau
     *
     */
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

    /**
     *
     * @param p
     * @param t
     * @param tab
     * @return
     */
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

    /**
     * Retourne la periode de la liste en parametre
     *
     * @param t
     *      La liste dont on cherche la periode
     *
     * @return la periode de la liste en parametre
     *
     * @see Rules#newgeneration
     * @see Liste#identique
     */
     public int periode(Liste t, int max) {
        Liste initiale;
        Liste suivante;
        int periode = 0;
        initiale = t;
        suivante = newgeneration(t);
        if (initiale.identique(suivante)) {
            return 1;
        }
        while(max != 0) {
            periode++;
            initiale = newgeneration(initiale);
            suivante = newgeneration(suivante);
            suivante = newgeneration(suivante);
            max--;
            if (initiale.identique(suivante)) {
                return periode;
            }
        }
        return 0; //si la methode retourne 0, cela signifie que la periode n'as pas ete trouvé dans le temps max donné
     }

     int periode(Liste t) {
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

    /**
     * Retourne le comportement asymptotique de la liste en parametre
     *
     * @param t
     *      La liste étudiée
     * @param periode
     *      La periode de la liste étudiée
     * @param queue
     *      La taille de la queue de la liste étudiée
     *
     * @return le comortement asymptotique de la liste en parametre
     */
     public String comportement(Liste t, int periode, int queue) {
        System.out.print("\n");
        if (t == null) {
            return "Le comportement est : mort\nLa période est de : " + periode + "\nLa taille de la queue est : " + queue + "\n";
        }
        if (periode == 1) {
            return "Le comportement est : stable\nLa période est de : " + periode + "\nLa taille de la queue est : " + queue + "\n";
        }
        if (periode > 1) {
            return "Le comportement est : oscillateur\nLa période est de : " + periode + "\nLa taille de la queue est : " + queue + "\n";
        }
        return " ";
     }
}
