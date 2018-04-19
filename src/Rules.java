
public class Rules {
    public Liste<Paire> liste;

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
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
            if (this.liste.contains(p2)) {
                ref.getValeur().nbv++;
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
            if (this.liste.contains(p3)) {
                ref.getValeur().nbv++;
            }

            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
            if (this.liste.contains(p4)) {
                ref.getValeur().nbv++;
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
            if (this.liste.contains(p5)) {
                ref.getValeur().nbv++;
            }

            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
            if (this.liste.contains(p6)) {
                ref.getValeur().nbv++;
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
            if (this.liste.contains(p7)) {
                ref.getValeur().nbv++;
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
            if (this.liste.contains(p8)) {
                ref.getValeur().nbv++;
            }
            if (ref.getValeur().nbv == 2 || ref.getValeur().nbv == 3) {
                cellulesvivantes.addLast(ref.getValeur());
            }
            ref = ref.getSuivant();
        }
        return cellulesvivantes;
    }

    public Liste mortedevenantvivantes(Liste t) {
        Liste lesvoisinsvivants = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
            if (NombreVoisin(t, p1) == 3 && !lesvoisinsvivants.contains(p1)) {
                lesvoisinsvivants.addLast(p1); // ou ref car on est pas sur de pouvoir ajoute direct une paire
            }
            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
            if (NombreVoisin(t, p2) == 3 && !lesvoisinsvivants.contains(p2)) {
                lesvoisinsvivants.addLast(p2);
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
            if (NombreVoisin(t, p3) == 3 && !lesvoisinsvivants.contains(p3)) {
                lesvoisinsvivants.addLast(p3);
            }
            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
            if (NombreVoisin(t, p4) == 3 && !lesvoisinsvivants.contains(p4)) {
                lesvoisinsvivants.addLast(p4);
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
            if (NombreVoisin(t, p5) == 3 && !lesvoisinsvivants.contains(p5)) {
                lesvoisinsvivants.addLast(p5);
            }
            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
            if (NombreVoisin(t, p6) == 3 && !lesvoisinsvivants.contains(p6)) {
                lesvoisinsvivants.addLast(p6);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
            if (NombreVoisin(t, p7) == 3 && !lesvoisinsvivants.contains(p7)) {
                lesvoisinsvivants.addLast(p7);
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
            if (NombreVoisin(t, p8) == 3 && !lesvoisinsvivants.contains(p8)) {
                lesvoisinsvivants.addLast(p8);
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsvivants;
    }

    public Liste vivantsquirestentvivants(Liste t) {
        Liste lesvoisinsvivants = new Liste();
        Maillon<Paire> ref = t.tete;
        while (ref != null) {
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1, 0);
            if ((NombreVoisin(t, p1) == 2 || NombreVoisin(t, p1) == 3) && !lesvoisinsvivants.contains(p1) && t.contains(p1)) {
                lesvoisinsvivants.addLast(p1); // ou ref car on est pas sur de pouvoir ajoute direct une paire
            }
            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1, 0);
            if ((NombreVoisin(t, p2) == 2 || NombreVoisin(t, p2) == 3) && !lesvoisinsvivants.contains(p2) && t.contains(p2)) {
                lesvoisinsvivants.addLast(p2);
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1, 0);
            if ((NombreVoisin(t, p3) == 2 || NombreVoisin(t, p3) == 3) && !lesvoisinsvivants.contains(p3) && t.contains(p3)) {
                lesvoisinsvivants.addLast(p3);
            }
            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety(), 0);
            if ((NombreVoisin(t, p4) == 2 || NombreVoisin(t, p4) == 3) && !lesvoisinsvivants.contains(p4) && t.contains(p4)) {
                lesvoisinsvivants.addLast(p4);
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety(), 0);
            if ((NombreVoisin(t, p5) == 2 || NombreVoisin(t, p5) == 3) && !lesvoisinsvivants.contains(p5) && t.contains(p5)) {
                lesvoisinsvivants.addLast(p5);
            }
            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1, 0);
            if ((NombreVoisin(t, p6) == 2 || NombreVoisin(t, p6) == 3) && !lesvoisinsvivants.contains(p6) && t.contains(p6)) {
                lesvoisinsvivants.addLast(p6);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1, 0);
            if ((NombreVoisin(t, p7) == 2 || NombreVoisin(t, p7) == 3) && !lesvoisinsvivants.contains(p7) && t.contains(p7)) {
                lesvoisinsvivants.addLast(p7);
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1, 0);
            if ((NombreVoisin(t, p8) == 2 || NombreVoisin(t, p8) == 3) && !lesvoisinsvivants.contains(p8) && t.contains(p8)) {
                lesvoisinsvivants.addLast(p8);
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsvivants;
    }

    public Liste newgeneration() {
        Liste  a = new Liste() ;
        Liste genmere = this.liste;
        Liste listecellulevivante = verifierVoisinsretournecellulesvivantes(genmere);
        Liste listevoisinVivant = mortedevenantvivantes(genmere);
        Liste listevoisinMort = vivantsquirestentvivants(genmere);
        return listevoisinVivant.concatener((listevoisinMort));
    }

    public int comportement_asymptotique(Liste t) {
        Liste genmere;
        Liste genfille, genrecherche;
        int periode = 0;
        genmere = t;
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
}
