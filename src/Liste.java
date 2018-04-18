public class Liste<T extends Comparable> extends Rules {
    Maillon<T> tete;

    public Liste() {
        this.tete = null;
    }
    public Liste (Maillon<T> tete) {
        this.tete = tete;
    }
    public Maillon<T> getTete() {
        return this.tete;
    }
    public void setTete(Maillon<T> tete) {
        this.tete = tete;
    }
    public boolean isEmpty() {
        return (this.tete == null);
    }
    public boolean identique (Liste<T> l){
        Maillon<T> ref = this.tete;
        Maillon<T> ref1 = l.tete;

        if (this.taille() != l.taille() || this.isEmpty() || l.isEmpty()){
            return false;

        }
        while (ref.getSuivant() != null) {
            if (ref.getValeur().equals(ref1.getValeur())) {
                ref = ref.getSuivant();
                ref1 = ref1.getSuivant();

            } else {
                return false;

            }
        }


        return true;
    }
    public void addInHead(T p) {
        Maillon<T> ancienneTete = this.tete;
        tete = new Maillon<T>(p, ancienneTete);
    }

    public boolean addAfter(T p, Maillon<T> m) {
        if (m.getSuivant() == null) {
            return false;
        } else {
            Maillon<T> l = m.getSuivant();
            Maillon<T> x = new Maillon<T>(p);
            m.setSuivant(x);
            x.setSuivant(l);
            return true;
        }
    }

    protected void addLast(T valeur) {

        if (isEmpty()) {
            tete = new Maillon<T>(valeur);
        } else {
            Maillon<T> dernier = getDernierElement();
            dernier.setSuivant(new Maillon<T>(valeur));

        }

    }

    protected Maillon<T> getDernierElement(){
        Maillon<T> dernier=this.tete;
        while(dernier.getSuivant()!=null){
            dernier = dernier.getSuivant();
        }
        return dernier;
    }
    public int taille(){
        int longueur=0;
        Maillon<T> ref = getTete();
        while(ref!=null) {
            longueur++;
            ref=ref.getSuivant();
        }
        return longueur;

    }

    protected boolean contains(T valeur) {
        boolean trouve = false;
        Maillon<T> ref = getTete();
        while (!trouve && ref != null) {
            if (ref.getValeur().equals(valeur)) {
                trouve = true;
            } else {
                ref = ref.getSuivant();
            }
        }
        return trouve;

    }

    public Liste<T> concatener(Liste<T> l2) {
        Maillon<T> ref = this.tete;
        if(this.isEmpty()){
            this.tete=l2.getTete();
        }else{
            Maillon<T> dernier = this.getTete();
            while(dernier.getSuivant()!=null){
                dernier=dernier.getSuivant();
            }
            dernier.setSuivant(l2.getTete());
        }
        return this;
    }
  /* public  void supplesdoublons (){
        Liste<T> b = new Rules();
        Maillon<T> ref = this.tete;
        while(ref != null){
            if (!b.contains(ref.getValeur())) {
                b.addLast(ref.getValeur());
            }
            ref = ref.getSuivant();
        }
        this.tete = b.tete;

    }*/

    public String toString(){
        String s = "Voici les coordonnées des cellules :\n";

        if (! this.isEmpty()) {

            s = s + tete.getValeur().toString() + "\n";

            Maillon<T> paire=tete.getSuivant();
            while (paire != null) {

                s = s + paire.getValeur().toString()+"\n";

                paire=paire.getSuivant();
            }

        }
        return s;
    }

    public boolean addTrier(T p) {
        Maillon<T> x = new Maillon<T>(p);
        Maillon<T> ref = this.tete;
        Maillon<T> prec = null;
        if (this.isEmpty())
            this.addInHead(p);
        else if ((ref.compareTo (x)) > 0) {
            this.addInHead(p);
        }else {
            while (ref != null && ref.compareTo(x) <= 0) {
                prec = ref;
                ref = ref.getSuivant();

            }

            if (ref == null)
                this.addLast(p);

            else {

                x.setSuivant(prec.getSuivant());
                prec.setSuivant(x);
            }
        }
            /*
            Maillon tmp = ref.getSuivant();
            ref.setSuivant(x);
            x.setSuivant(tmp);
            ref = ref.getSuivant();*/
        return true;

              /* Paire a = ref.getValeur();
                ref.setValeur(x.getValeur());
                ref.getSuivant().setValeur(a);*/

    }


}
