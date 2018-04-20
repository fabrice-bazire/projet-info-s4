public abstract class Liste<T> {
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
    public abstract boolean addTrier(T p) ;

    protected abstract void addLast(T p);


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


   public  void supplesdoublons (){
        Liste<T> b = new Rules();
        Maillon<T> ref = this.tete;
        while(ref != null){
            if (!b.contains(ref.getValeur())) {
                b.addLast(ref.getValeur());
            }
            ref = ref.getSuivant();
        }
        this.tete = b.tete;

    }

    protected abstract boolean contains(T valeur);

    protected abstract void addLast(Paire valeur);

    protected abstract boolean contains(Paire valeur);

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

    public abstract int comportement_asymptotique () ;
    public abstract Liste<T> verifierVoisinsretournecellulesvivantes();
    public abstract Liste<T> verifierVoisinsretournelistedesvoisinsvivants();
    public abstract Liste<T> verifierVoisinsretournelistedesvoisinsmorts();
    public abstract int NombreVoisin(Liste<T> l, T p);
    public abstract Liste<T> resurrection (Liste<T> CelluleVivante, Liste<T> voisinmort) ;
    public abstract Liste<T> newgeneration ();




}
