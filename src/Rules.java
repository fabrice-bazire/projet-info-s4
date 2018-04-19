import javafx.util.Pair;

public class Rules {
    public Liste<Paire> liste;

    public Liste resurrection(Liste CelluleVivante, Liste voisinmort) {
        Liste CelluleMorteQuiPasseAVivant = new Liste();
        Maillon<Paire> ref = voisinmort.tete;
        int nombreVoisins = 0;
        while (ref != null) {
            Paire p = ref.getValeur();
            nombreVoisins = NombreVoisin(CelluleVivante, p);
            System.out.println("Le couple " + ref.getValeur().toString() + " possede " + nombreVoisins + " voisins vivants");
            ;
            if (nombreVoisins == 3) {
                CelluleMorteQuiPasseAVivant.addLast(ref.getValeur());
            }
            ref = ref.getSuivant();
        }
        return CelluleMorteQuiPasseAVivant;
    }

    public int NombreVoisin(Liste l, Paire p) {

        Paire voisin1 = new Paire(p.getx() - 1, p.gety() + 1, 0);
        Paire voisin2 = new Paire(p.getx(), p.gety() + 1, 0);
        Paire voisin3 = new Paire(p.getx() + 1, p.gety() + 1, 0);
        Paire voisin4 = new Paire(p.getx() - 1, p.gety(), 0);
        Paire voisin5 = new Paire(p.getx() + 1, p.gety(), 0);
        Paire voisin6 = new Paire(p.getx() - 1, p.gety() - 1, 0);
        Paire voisin7 = new Paire(p.getx(), p.gety() - 1, 0);
        Paire voisin8 = new Paire(p.getx() + 1, p.gety() - 1, 0);
        if (l.contains(voisin1)) {
            p.nbv++;
        }
        if (l.contains(voisin2)) {
            p.nbv++;
        }
        if (l.contains(voisin3)) {
            p.nbv++;
        }
        if (l.contains(voisin4)) {
            p.nbv++;
        }
        if (l.contains(voisin5)) {
            p.nbv++;
        }
        if (l.contains(voisin6)) {
            p.nbv++;
        }
        if (l.contains(voisin7)) {
            p.nbv++;
        }
        if (l.contains(voisin8)) {
            p.nbv++;
        }
        return p.nbv;
    }

    public Liste verifierVoisinsretournecellulesvivantes(Liste t) {
        Liste cellulesvivantes = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
            if (t.contains(p1)) {
                ref.getValeur().nbv++;
                System.out.print("1)" + ref.getValeur().nbv);
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
            if (this.liste.contains(p2)) {
                ref.getValeur().nbv++;
                System.out.print("2)" + ref.getValeur().nbv);
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
            if (this.liste.contains(p3)) {
                ref.getValeur().nbv++;
                System.out.print("3)" + ref.getValeur().nbv);
            }

            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
            if (this.liste.contains(p4)) {
                ref.getValeur().nbv++;
                System.out.print("4)" + ref.getValeur().nbv);
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
            if (this.liste.contains(p5)) {
                ref.getValeur().nbv++;
                System.out.print("5)" + ref.getValeur().nbv);
            }

            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
            if (this.liste.contains(p6)) {
                ref.getValeur().nbv++;
                System.out.print("6)" + ref.getValeur().nbv);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
            if (this.liste.contains(p7)) {
                ref.getValeur().nbv++;
                System.out.println("7)" + ref.getValeur().nbv);
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
            if (this.liste.contains(p8)) {
                ref.getValeur().nbv++;
                System.out.println("8)" + ref.getValeur().nbv);
            }
            if (ref.getValeur().nbv == 2 || ref.getValeur().nbv == 3) {
                cellulesvivantes.addLast(ref.getValeur());
            }
            ref = ref.getSuivant();
        }
        return cellulesvivantes;
    }

    public Liste verifierVoisinsretournelistedesvoisinsvivants(Liste t) {
        Liste lesvoisinsvivants = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
            if (this.liste.contains(p1)) {
                lesvoisinsvivants.addLast(p1); // ou ref car on est pas sur de pouvoir ajoute direct une paire
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
            if (this.liste.contains(p2)) {
                lesvoisinsvivants.addLast(p2);
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
            if (this.liste.contains(p3)) {
                lesvoisinsvivants.addLast(p3);
            }
            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
            if (this.liste.contains(p4)) {
                lesvoisinsvivants.addLast(p4);
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
            if (this.liste.contains(p5)) {
                lesvoisinsvivants.addLast(p5);
            }
            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
            if (this.liste.contains(p6)) {
                lesvoisinsvivants.addLast(p6);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
            if (this.liste.contains(p7)) {
                lesvoisinsvivants.addLast(p7);
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
            if (this.liste.contains(p8)) {
                lesvoisinsvivants.addLast(p8);
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsvivants;
    }

    public Liste verifierVoisinsretournelistedesvoisinsmorts(Liste t) {
        Liste lesvoisinsmorts = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
            if (!this.liste.contains(p1)) {
                lesvoisinsmorts.addLast(p1);
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
            if (!this.liste.contains(p2)) {
                lesvoisinsmorts.addLast(p2);
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
            if (!this.liste.contains(p3)) {
                lesvoisinsmorts.addLast(p3);
            }
            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
            if (!this.liste.contains(p4)) {
                lesvoisinsmorts.addLast(p4);
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
            if (!this.liste.contains(p5)) {
                lesvoisinsmorts.addLast(p5);
            }
            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
            if (!this.liste.contains(p6)) {
                lesvoisinsmorts.addLast(p6);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
            if (!this.liste.contains(p7)) {
                lesvoisinsmorts.addLast(p7);
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
            if (!this.liste.contains(p8)) {
                lesvoisinsmorts.addLast(p8);
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsmorts;
    }

    public Liste newgeneration() {
        Liste  a = new Liste() ;
        Liste genmere = this.liste;
        System.out.print("genmere : " + genmere.toString());
        Liste listecellulevivante = verifierVoisinsretournecellulesvivantes(genmere);
        Liste listevoisinVivant = verifierVoisinsretournelistedesvoisinsvivants(genmere);
        Liste listevoisinMort = verifierVoisinsretournelistedesvoisinsmorts(genmere);
        Liste MortAVie = a.resurrection(listevoisinVivant, listevoisinMort);
        return listecellulevivante.concatener(MortAVie);
    }


    public int comportement_asymptotique() {
        Liste genmere;
        Liste genfille, genrecherche;
        int periode = 0;
        genmere = this.liste;
        genfille = genmere.newgeneration();
        boolean sameconfig = false;
        while (!sameconfig) {
            periode++;
            genmere = genmere.newgeneration();
            genfille = genfille.newgeneration();
            if (genmere.identique(genfille)) {
                sameconfig = true;
                genrecherche = genfille;
            }
        }
        return periode;
    }
}
