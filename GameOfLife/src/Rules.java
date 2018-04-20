import javafx.util.Pair;

public class Rules extends Liste {


    public Liste resurrection(Liste CelluleVivante, Liste voisinmort) {
        Liste CelluleMorteQuiPasseAVivant = new Rules();
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
        int nombreVoisin = 0;
        Paire voisin1 = new Paire(p.getx() - 1, p.gety() + 1);
        Paire voisin2 = new Paire(p.getx(), p.gety() + 1);
        Paire voisin3 = new Paire(p.getx() + 1, p.gety() + 1);
        Paire voisin4 = new Paire(p.getx() - 1, p.gety());
        Paire voisin5 = new Paire(p.getx() + 1, p.gety());
        Paire voisin6 = new Paire(p.getx() - 1, p.gety() - 1);
        Paire voisin7 = new Paire(p.getx(), p.gety() - 1);
        Paire voisin8 = new Paire(p.getx() + 1, p.gety() - 1);
        if (l.contains(voisin1)) {
            nombreVoisin++;
        }
        if (l.contains(voisin2)) {
            nombreVoisin++;
        }
        if (l.contains(voisin3)) {
            nombreVoisin++;
        }
        if (l.contains(voisin4)) {
            nombreVoisin++;
        }
        if (l.contains(voisin5)) {
            nombreVoisin++;
        }
        if (l.contains(voisin6)) {
            nombreVoisin++;
        }
        if (l.contains(voisin7)) {
            nombreVoisin++;
        }
        if (l.contains(voisin8)) {
            nombreVoisin++;
        }
        return nombreVoisin;
    }

    public Liste verifierVoisinsretournecellulesvivantes() {
        Liste cellulesvivantes = new Rules();
        int nbvoisins = 0;
        Liste t = this;
        Maillon<Paire> ref = this.tete;
        while (ref != null) {
            System.out.println("il passe");
            System.out.println("0)" + nbvoisins);
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1);
            if (t.contains(p1)) {
                nbvoisins++;
                System.out.print("1)" + nbvoisins);
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1);
            if (this.contains(p2)) {
                nbvoisins++;
                System.out.print("2)" + nbvoisins);
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1);
            if (this.contains(p3)) {
                nbvoisins++;
                System.out.print("3)" + nbvoisins);
            }

            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety());
            if (this.contains(p4)) {
                nbvoisins++;
                System.out.print("4)" + nbvoisins);
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety());
            if (this.contains(p5)) {
                nbvoisins++;
                System.out.print("5)" + nbvoisins);
            }

            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1);
            if (this.contains(p6)) {
                nbvoisins++;
                System.out.print("6)" + nbvoisins);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1);
            if (this.contains(p7)) {
                nbvoisins++;
                System.out.println("7)" + nbvoisins);
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1);
            if (this.contains(p8)) {
                nbvoisins++;
                System.out.println("8)" + nbvoisins);
            }
            if (nbvoisins == 2 || nbvoisins == 3) {
                cellulesvivantes.addLast(ref.getValeur());
            }
            nbvoisins = 0;
            ref = ref.getSuivant();
        }
		        /*this = new Liste();
		        for (Paire paire : provisoire) {
		            this.addInHead(paire);
		        }*/
        return cellulesvivantes;
    }

    public Liste verifierVoisinsretournelistedesvoisinsvivants() {
        Liste lesvoisinsvivants = new Rules();
        Maillon<Paire> ref = this.tete;
        while (ref != null) {
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1);
            if (this.contains(p1)) {
                lesvoisinsvivants.addLast(p1);
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1);
            if (this.contains(p2)) {
                lesvoisinsvivants.addLast(p2);
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1);
            if (this.contains(p3)) {
                lesvoisinsvivants.addLast(p3);
            }
            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety());
            if (this.contains(p4)) {
                lesvoisinsvivants.addLast(p4);
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety());
            if (this.contains(p5)) {
                lesvoisinsvivants.addLast(p5);
            }
            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1);
            if (this.contains(p6)) {
                lesvoisinsvivants.addLast(p6);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1);
            if (this.contains(p7)) {
                lesvoisinsvivants.addLast(p7);
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1);
            if (this.contains(p8)) {
                lesvoisinsvivants.addLast(p8);
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsvivants;
    }

    public Liste verifierVoisinsretournelistedesvoisinsmorts() {
        Liste lesvoisinsmorts = new Rules();
        Maillon<Paire> ref = this.tete;
        while (ref != null) {
            Paire p1 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() + 1);
            if (!this.contains(p1)) {
                lesvoisinsmorts.addLast(p1);
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() + 1);
            if (!this.contains(p2)) {
                lesvoisinsmorts.addLast(p2);
            }
            Paire p3 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() + 1);
            if (!this.contains(p3)) {
                lesvoisinsmorts.addLast(p3);
            }
            Paire p4 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety());
            if (!this.contains(p4)) {
                lesvoisinsmorts.addLast(p4);
            }
            Paire p5 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety());
            if (!this.contains(p5)) {
                lesvoisinsmorts.addLast(p5);
            }
            Paire p6 = new Paire(ref.getValeur().getx() - 1, ref.getValeur().gety() - 1);
            if (!this.contains(p6)) {
                lesvoisinsmorts.addLast(p6);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety() - 1);
            if (!this.contains(p7)) {
                lesvoisinsmorts.addLast(p7);
            }
            Paire p8 = new Paire(ref.getValeur().getx() + 1, ref.getValeur().gety() - 1);
            if (!this.contains(p8)) {
                lesvoisinsmorts.addLast(p8);
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsmorts;
    }

    @Override
    public int NombreVoisin(Liste l, Object o) {
        try {
            Paire p = (Paire) o;
            int nombreVoisin = 0;
            Paire voisin1 = new Paire(p.getx() - 1, p.gety() + 1);
            Paire voisin2 = new Paire(p.getx(), p.gety() + 1);
            Paire voisin3 = new Paire(p.getx() + 1, p.gety() + 1);
            Paire voisin4 = new Paire(p.getx() - 1, p.gety());
            Paire voisin5 = new Paire(p.getx() + 1, p.gety());
            Paire voisin6 = new Paire(p.getx() - 1, p.gety() - 1);
            Paire voisin7 = new Paire(p.getx(), p.gety() - 1);
            Paire voisin8 = new Paire(p.getx() + 1, p.gety() - 1);
            if (l.contains(voisin1)) {
                nombreVoisin++;
            }
            if (l.contains(voisin2)) {
                nombreVoisin++;
            }
            if (l.contains(voisin3)) {
                nombreVoisin++;
            }
            if (l.contains(voisin4)) {
                nombreVoisin++;
            }
            if (l.contains(voisin5)) {
                nombreVoisin++;
            }
            if (l.contains(voisin6)) {
                nombreVoisin++;
            }
            if (l.contains(voisin7)) {
                nombreVoisin++;
            }
            if (l.contains(voisin8)) {
                nombreVoisin++;
            }
            return nombreVoisin;
        } catch (Exception e) {
            e.getMessage();
        }
        return 0;
    }


    public Liste newgeneration() {
        Liste a = new Rules();
        Liste genmere = this;
        Liste listecellulevivante = genmere.verifierVoisinsretournecellulesvivantes();
        Liste listevoisinVivant = genmere.verifierVoisinsretournelistedesvoisinsvivants();
        Liste listevoisinMort = genmere.verifierVoisinsretournelistedesvoisinsmorts();
        Liste MortAVie = a.resurrection(listevoisinVivant, listevoisinMort);
        return listecellulevivante.concatener(MortAVie);
    }

    @Override
    protected void addLast(Paire valeur) {

        if (isEmpty()) {
            tete = new Maillon<Paire>(valeur);
        } else {
            Maillon<Paire> dernier = getDernierElement();
            dernier.setSuivant(new Maillon<Paire>(valeur));

        }

    }

    @Override
    public boolean addTrier(Object o) {
        Paire p = (Paire) o;

            Maillon<Paire> x = new Maillon<Paire>(p);
            Maillon<Paire> ref = this.tete;
            Maillon<Paire> prec = null;

            //System.out.println(p.toString());
            if (this.isEmpty())
                this.addInHead(p);

            else if(ref.getValeur().compareto(x.getValeur()) > 0)
                this.addInHead(p);

            else {

                while (ref.getValeur().compareto(x.getValeur()) <= 0 && ref != null) {

                    prec = ref;
                    ref = ref.getSuivant();

                }

                if(ref == null)
                    this.addLast(p);

                else {

                    x.setSuivant(prec.getSuivant());
                    prec.setSuivant(x);}}
            /*
            Maillon tmp = ref.getSuivant();
            ref.setSuivant(x);
            x.setSuivant(tmp);
            ref = ref.getSuivant();*/
            System.out.println(this);
            return true;

              /* Paire a = ref.getValeur();
                ref.setValeur(x.getValeur());
                ref.getSuivant().setValeur(a);
*/



        }


    protected void addLast(Object o) {
        try {
            Paire valeur = (Paire) o;

            if (isEmpty()) {
                tete = new Maillon<Paire>(valeur);
            } else {
                Maillon<Paire> dernier = getDernierElement();
                dernier.setSuivant(new Maillon<Paire>(valeur));

            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    protected boolean contains(Object o) {
        try {
            Paire valeur = (Paire) o;
            boolean trouve = false;
            Maillon<Paire> ref = getTete();
            while (!trouve && ref != null) {
                if (ref.getValeur().equals(valeur)) {
                    trouve = true;
                } else {
                    ref = ref.getSuivant();
                }
            }
            return trouve;
        }catch(Exception e){
            e.getMessage();        }
        return false;


    }


    @Override
    protected boolean contains(Paire valeur) {
        boolean trouve = false;
        Maillon<Paire> ref = getTete();
        while (!trouve && ref != null) {
            if (ref.getValeur().equals(valeur)) {
                trouve = true;
            } else {
                ref = ref.getSuivant();
            }
        }
        return trouve;

    }

    public int comportement_asymptotique() {
        Liste genmere, genfille, genrecherche ;
        int periode = 0;
        genmere = this;
        genfille = genmere.newgeneration();
        int nbTours;
        while (nbTours != 10) {
            periode++;
            genmere = genmere.newgeneration();
            genfille = genfille.newgeneration();
            if (genmere.identique(genfille)) {
                nbTours = nbTours + 1;
                genrecherche= genfille;
            }
        }
        return periode ;
    }


}

