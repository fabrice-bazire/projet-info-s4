public class Rules extends Liste{
    public Liste verifierVoisinsretournecellulesvivantes() {
        Liste cellulesvivantes = new Liste();
        int nbvoisins = 0;
        Liste t = this;
        Maillon ref = this.tete;
        while(ref != null){
            System.out.println("il passe");
            System.out.println("0)" + nbvoisins);
            Paire p1 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety()+1);
            if (t.contains(p1)) {
                nbvoisins++;
                System.out.print("1)" + nbvoisins);
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety()+1);
            if (this.contains(p2)) {
                nbvoisins++;
                System.out.print("2)" + nbvoisins);
            }
            Paire p3 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety()+1);
            if (this.contains(p3)) {
                nbvoisins++;
                System.out.print("3)" + nbvoisins);
            }

            Paire p4 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety());
            if (this.contains(p4)) {
                nbvoisins++;
                System.out.print("4)" + nbvoisins);
            }
            Paire p5 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety());
            if (this.contains(p5)) {
                nbvoisins++;
                System.out.print("5)" + nbvoisins);
            }

            Paire p6 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety()-1);
            if (this.contains(p6)) {
                nbvoisins++;
                System.out.print("6)" + nbvoisins);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety()-1);
            if (this.contains(p7)) {
                nbvoisins++;
                System.out.println("7)" + nbvoisins);
            }
            Paire p8 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety()-1);
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

    public Liste verifierVoisinsretournelistedesvoisinsvivants(){
        Liste lesvoisinsvivants = new Liste();
        Maillon ref = this.tete;
        while(ref != null){
            Paire p1 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety()+1);
            if (this.contains(p1)) {
                lesvoisinsvivants.addLast(p1);
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety()+1);
            if (this.contains(p2)) {
                lesvoisinsvivants.addLast(p2);
            }
            Paire p3 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety()+1);
            if (this.contains(p3)) {
                lesvoisinsvivants.addLast(p3);
            }
            Paire p4 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety());
            if (this.contains(p4)) {
                lesvoisinsvivants.addLast(p4);
            }
            Paire p5 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety());
            if (this.contains(p5)) {
                lesvoisinsvivants.addLast(p5);
            }
            Paire p6 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety()-1);
            if (this.contains(p6)) {
                lesvoisinsvivants.addLast(p6);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety()-1);
            if (this.contains(p7)) {
                lesvoisinsvivants.addLast(p7);
            }
            Paire p8 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety()-1);
            if (this.contains(p8)) {
                lesvoisinsvivants.addLast(p8);
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsvivants;
    }

    public Liste verifierVoisinsretournelistedesvoisinsmorts(){
        Liste lesvoisinsmorts = new Liste();
        Maillon ref = this.tete;
        while(ref != null){
            Paire p1 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety()+1);
            if (!this.contains(p1)) {
                lesvoisinsmorts.addLast(p1);
            }

            Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety()+1);
            if (!this.contains(p2)) {
                lesvoisinsmorts.addLast(p2);
            }
            Paire p3 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety()+1);
            if (!this.contains(p3)) {
                lesvoisinsmorts.addLast(p3);
            }
            Paire p4 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety());
            if (!this.contains(p4)) {
                lesvoisinsmorts.addLast(p4);
            }
            Paire p5 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety());
            if (!this.contains(p5)) {
                lesvoisinsmorts.addLast(p5);
            }
            Paire p6 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety()-1);
            if (!this.contains(p6)) {
                lesvoisinsmorts.addLast(p6);
            }
            Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety()-1);
            if (!this.contains(p7)) {
                lesvoisinsmorts.addLast(p7);
            }
            Paire p8 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety()-1);
            if (!this.contains(p8)) {
                lesvoisinsmorts.addLast(p8);
            }
            ref = ref.getSuivant();
        }
        return lesvoisinsmorts;
    }

    /* public Liste lescellulesvivantes (){
		Maillon ref = this.tete;
		while (ref!=null){
        ref=ref.getSuivant();
		}
	}*/

    public void supplesdoublons (){
        Liste b = new Liste();
        Maillon ref = this.tete;
        while(ref != null){
            if (!b.contains(ref.getValeur())) {
                b.addLast(ref.getValeur());
            }
            ref = ref.getSuivant();
        }
        this.tete = b.tete;

    }

       /* public void triliste () {
            Liste b = new Liste();
            b.addInHead(this.tete.getValeur());
            Maillon ref = this.tete.getSuivant();
            Maillon refbis;
            while (ref != null) {
                refbis = b.tete;
                while (refbis != null) {
                    if (ref.getValeur().compare(refbis.getValeur()) > 0) {
                        b.addAfter(ref.getValeur(), refbis);
                        refbis = null;
                    } else {
                        if (ref.getValeur().compare(refbis.getValeur()) < 0) {
                            b.addBefore(ref.getValeur(), refbis);
                            refbis = null;
                        } else {
                            refbis = refbis.getSuivant();
                        }
                    }
                    ref = ref.getSuivant();
                }
                this.tete = b.tete;
            }
        }*/

    /*public Liste newgeneration (){
        Liste a = new Liste();
        Liste genmere = this;
        Liste listecellulevivante = genmere.verifierVoisinsretournecellulesvivantes();
        Liste listevoisinVivant = genmere.verifierVoisinsretournelistedesvoisinsvivants();
        Liste listevoisinMort = genmere.verifierVoisinsretournelistedesvoisinsmorts()  ;
        Liste MortAVie = a.compare(listevoisinVivant, listevoisinMort);
        return listecellulevivante.concatener(MortAVie);
    }*/

        /*public void comportementasymptotique() {
            Liste genmere, genfille;
            genmere = this;
            genfille = newgeneration();
            while (diff) {
                genmere = newgeneration();
                genfille = newgeneration();
                genfille = newgeneration();
            }
        }*/

    public Liste Ressurection (Liste CelluleVivante, Liste voisinmort) {
        Liste CelluleMorteQuiPasseAVivant = new Liste();
        Maillon ref = voisinmort.tete;
        int nombreVoisins = 0;
        while ( ref!= null) {
            Paire p = ref.getValeur();
            nombreVoisins= NombreVoisin(CelluleVivante, p);
            System.out.println("Le couple "+ref.getValeur().toString()+" possede "+nombreVoisins+" voisins vivants");;
            if(nombreVoisins == 3) {
                CelluleMorteQuiPasseAVivant.addLast(ref.getValeur());
            }
            ref=ref.getSuivant();
        }
        return CelluleMorteQuiPasseAVivant;
    }
}
