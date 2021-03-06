/**
 *
 * Liste est la classe qui permet de stocker les cellules vivantes
 */
public class Liste<T extends Comparable> extends Rules {

    /**
     * Représente le premier Maillon de la liste
     */
    Maillon<T> tete;

    /**
     * Constructeur Liste
     */
    public Liste() {
        this.tete = null;
    }

    /**
     * Constructeur Liste qui initialise le premier Maillon de la liste
     * @param tete
     * Un Maillon
     */
    public Liste (Maillon<T> tete) {
        this.tete = tete;
    }

    /**
     * Retourne la tête de la Liste
     * @return le premier Maillon de la Liste
     */
    public Maillon<T> getTete() {
        return this.tete;
    }

    /**
     * Met à jour la tête de la Liste
     * @param tete
     * Un Maillon
     */
    public void setTete(Maillon<T> tete) {
        this.tete = tete;
    }

    /**
     * Vérifie si la Liste this est vide
     * @return un booléen vrai si la tête de la Liste est null et faux sinon.
     */
    public boolean isEmpty() {
        return (this.tete == null);
    }

    /**
     * Vérifie si la Liste en paramètre est identique à la Liste this.
     * @param l
     * Une Liste de T
     * @return un booléen vrai si la Liste passée en paramètre est égale à Liste this et faux sinon.
     */
    public boolean identique (Liste<T> l){
        Maillon<T> ref = this.tete;
        Maillon<T> ref1 = l.tete;
        if (this.taille() != l.taille() || this.isEmpty() || l.isEmpty()){
            return false;
        }else {
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
    }

    /**
     * Ajoute un Maillon en tête de Liste.
     * @param p
     * Un type T qui sera la valeur du Maillon
     */
    public void addInHead(T p) {
        Maillon<T> ancienneTete = this.tete;
        tete = new Maillon<T>(p, ancienneTete);
    }

    /**
     * Ajoute un Maillon en fin de Liste.
     * @param valeur
     * Un type T qui sera la valeur du Maillon
     */
    protected void addLast(T valeur) {

        if (isEmpty()) {
            tete = new Maillon<T>(valeur);
        } else {
            Maillon<T> dernier = getDernierElement();
            dernier.setSuivant(new Maillon<T>(valeur));

        }

    }

    /**
     * Retourne le dernier Maillon de la Liste
     * @return le dernier Maillon de la Liste
     */
    protected Maillon<T> getDernierElement(){
        Maillon<T> dernier=this.tete;
        while(dernier.getSuivant()!=null){
            dernier = dernier.getSuivant();
        }
        return dernier;
    }

    /**
     * Retourne la taille de la Liste.
     * @return la taille de la Liste sous forme d'entier.
     */
    public int taille(){
        int longueur=0;
        Maillon<T> ref = getTete();
        while(ref!=null) {
            longueur++;
            ref=ref.getSuivant();
        }
        return longueur;

    }

    /**
     * Vérifie si la valeur T est contenue dans un des Maillon de la Liste.
     * @param valeur
     * Un type T
     * @return vrai si la valeur est contenu dans la Liste
     */
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

    /**
     * Concatène la Liste passée en paramètre a la Liste this.
     * @param l2
     * Une Liste de type T.
     * @return la Liste qui a été concatenée.
     */
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

    /**
     * Permet de supprimer de la liste courante les élements en présents plusieurs fois
     */
    public  void supplesdoublons (){
        Liste<T> b = new Liste<T>();
        Maillon<T> ref = this.tete;
        while(ref != null){
            if (!b.contains(ref.getValeur())) {
                b.addLast(ref.getValeur());
            }
            ref = ref.getSuivant();
        }
        this.tete = b.tete;
    }

    /**
     * Affiche les coordonnées de toutes les paires de la Liste.
     * @return  les coordonnées de toutes les paires de la Liste sous forme de chaine de caractère.
     */
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

    /**
     * Permet d'ajouter un Maillon dans la Liste en respectant l'ordre des coordonnées de sa valeur
     * @param p
     * Un type p.
     * @return vrai si l'ajout a bien été effectué
     */
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
