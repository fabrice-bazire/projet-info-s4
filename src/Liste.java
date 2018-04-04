public class Liste {


    Maillon tete;


    public Liste() {
        this.tete = null;
    }

    public Liste(Maillon tete) {
        this.tete = tete;
    }

    public Maillon getTete() {
        return this.tete;
    }

    public void setTete(Maillon tete) {
        this.tete = tete;
    }

    public boolean isEmpty() {
        return (this.tete == null);
    }

    //ajoute en debut
    public void addInHead(Paire p) {
        Maillon ancienneTete = this.tete;
        tete = new Maillon(p, ancienneTete);
    }

    public void addLast(Paire p) {
        if (isEmpty()) {
            tete = new Maillon(p);
        } else {
            Maillon dernier = getDernierElement();
            dernier.setSuivant(new Maillon(p));

        }
    }

    public boolean addAfter(Paire p, Maillon m) {
        if (m.getSuivant() == null) {
            return false;
        } else {
            Maillon l = m.getSuivant();
            Maillon x = new Maillon(p);
            m.setSuivant(x);
            x.setSuivant(l);
            return true;
        }
    }

   /* public boolean addBefore(Paire p, Maillon m){
        Maillon x = new Maillon (p);
        Maillon ref = this.getTete();
        while (ref.getSuivant() != null){
            if (ref.getSuivant().getValeur().equals(m.getValeur())){
                Maillon l = ref.getSuivant();
                ref.setSuivant(x);
                x.setSuivant(l);
                return true;
            }else{
                ref = ref.getSuivant();
            }
        }
        return false;
    }*/

  /* public void add (Paire p){
       Maillon ref = this.tete;
       if ( ref == null){
           this.tete=new Maillon (p);
       }else{
           while ( ref.getSuivant()!=null){
               ref =ref.getSuivant();
           }
           if (ref.getValeur().compareto(p)> 0) {
               Maillon x = ref.getSuivant();
               Maillon a = new Maillon (p);
               a.setSuivant(x);
               ref.setSuivant(a);
           }else{
               this.addLast(p);
           }
       }

   }*/


    public boolean addTrier(Paire p) {
        Maillon x = new Maillon(p);
        Maillon ref = this.tete;
        Maillon prec = null;

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







    private Maillon getDernierElement(){
        Maillon dernier=this.tete;
        while(dernier.getSuivant()!=null){
            dernier = dernier.getSuivant();
        }
        return dernier;
    }

    public int taille(){
        int longueur=0;
        Maillon ref = getTete();
        while(ref!=null) {
            longueur++;
            ref=ref.getSuivant();
        }
        return longueur;

    }

    public boolean contains(Paire p) {
        boolean trouve = false;
        Maillon ref = getTete();
        while(!trouve && ref !=null) {
            if(ref.getValeur().equals(p)){
                trouve=true;
            }else {
                ref=ref.getSuivant();
            }
        }
        return trouve;
    }

    public Liste concatener(Liste l2) {
        Maillon ref = this.tete;
        if(this.isEmpty()){
            this.tete=l2.getTete();
        }else{
            Maillon dernier = this.getTete();
            while(dernier.getSuivant()!=null){
                dernier=dernier.getSuivant();
            }
            dernier.setSuivant(l2.getTete());
        }
        return this;
    }


    public String toString(){
        String s = "Voici les coordonnées des cellules :\n";

        if (! this.isEmpty()) {

            s = s + tete.getValeur().toString() + "\n";

            Maillon paire=tete.getSuivant();
            while (paire != null) {

                s = s + paire.getValeur().toString()+"\n";

                paire=paire.getSuivant();
            }

        }
        return s;
    }


}
