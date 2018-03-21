package JeuDeLavieModif;

public class Liste {


	Maillon tete;

	public Liste(){
		this.tete= null;
	}

	public Liste (Maillon tete)
	{
		this.tete=tete;
	}
	public Maillon getTete() {
		return this.tete;
	}
	public void setTete(Maillon tete) {
		this.tete = tete;
	}

	public boolean isEmpty(){
		return(this.tete==null);
	}
	//ajoute en debut
	public void addInHead(Paire p){
		Maillon ancienneTete = this.tete;
		tete = new Maillon(p,ancienneTete);
	}

	public void addLast(Paire p){
		if(isEmpty()){
			tete = new Maillon (p);
		} else{
			Maillon dernier = getDernierElement();
			dernier.setSuivant(new Maillon(p));

		}
	}

	public boolean addBefore (Paire p, Maillon m) {
		Maillon x = new Maillon (p);
		Maillon ref = this.getTete();
		while ( ref.getSuivant() != null) {
			if(ref.getSuivant().getValeur().equals(m.getValeur())) {
				Maillon l = ref.getSuivant();
				ref.setSuivant(x);
				x.setSuivant(l);
				return true;
			}else {
				ref= ref.getSuivant();
			}
		}
		return false;
	}
	public boolean addAfter (Paire p, Maillon m) {
		if(m.getSuivant() == null ) {
			return false;
		}else {
			Maillon l = m.getSuivant();
			Maillon x = new Maillon(p);
			m.setSuivant(x);
			x.setSuivant(l);
			return true;
		}

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


	public Liste compare (Liste CelluleVivante, Liste voisinmort) {
		Liste CelluleMorteQuiPasseAVivant = new Liste();
		Maillon ref = voisinmort.tete;
		int nombreVoisins = 0;
		while ( ref!= null) {
			Paire p = ref.getValeur();
			nombreVoisins= NombreVoisin(CelluleVivante, p);
			/*	System.out.println("Le couple "+ref.getValeur().toString()+" possede "+nombreVoisins+" voisins vivants");*/
			if(nombreVoisins == 3) {
				CelluleMorteQuiPasseAVivant.addLast(ref.getValeur());
			}
			ref=ref.getSuivant();
		}


		return CelluleMorteQuiPasseAVivant;
	}


	public int NombreVoisin(Liste l, Paire p) {
		int nombreVoisin = 0;
		Paire voisin1 = new Paire(p.getx()-1, p.gety()+1);
		Paire voisin2 = new Paire(p.getx(), p.gety()+1);
		Paire voisin3 = new Paire(p.getx()+1, p.gety()+1);
		Paire voisin4 = new Paire(p.getx()-1, p.gety());
		Paire voisin5 = new Paire(p.getx()+1, p.gety());
		Paire voisin6 = new Paire(p.getx()-1, p.gety()-1);
		Paire voisin7 = new Paire(p.getx(), p.gety()-1);
		Paire voisin8 = new Paire(p.getx()+1, p.gety()-1);


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





	public String toString(){
		String s = "Les coordonn�es des cellules :\n";

		if (! this.isEmpty()) {

			s = s + tete.getValeur().toString();

			Maillon paire=tete.getSuivant();
			while (paire != null) {

				s = s + paire.getValeur().toString()+"\n";

				paire=paire.getSuivant();
			}

		}
		return s;
	}

	public Liste verifierVoisinsretournecellulesvivantes() {
		Liste cellulesvivantes = new Liste();
		int nbvoisins = 0;
		Liste t = this;
		Maillon ref = this.tete;
		while(ref != null){

			Paire p1 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety()+1);
			if (t.contains(p1)) {
				nbvoisins++;

			}

			Paire p2 = new Paire(ref.getValeur().getx(), ref.getValeur().gety()+1);
			if (this.contains(p2)) {
				nbvoisins++;

			}
			Paire p3 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety()+1);
			if (this.contains(p3)) {
				nbvoisins++;

			}

			Paire p4 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety());
			if (this.contains(p4)) {
				nbvoisins++;

			}
			Paire p5 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety());
			if (this.contains(p5)) {
				nbvoisins++;

			}

			Paire p6 = new Paire(ref.getValeur().getx()-1, ref.getValeur().gety()-1);
			if (this.contains(p6)) {
				nbvoisins++;

			}
			Paire p7 = new Paire(ref.getValeur().getx(), ref.getValeur().gety()-1);
			if (this.contains(p7)) {
				nbvoisins++;

			}
			Paire p8 = new Paire(ref.getValeur().getx()+1, ref.getValeur().gety()-1);
			if (this.contains(p8)) {
				nbvoisins++;

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



	/* Retourne vrai quand c'est la m�me liste  sinon false  */
	public boolean comparaison (Liste l) {
		boolean identique =false;

		Maillon ref = this.tete;
		Maillon ref1 = l.tete;


		while ( ref!= null && identique ) {
			Paire p = ref.getValeur();
			Paire p1 = ref1.getValeur();
			if(p.equals(p1)) {
				ref=ref.getSuivant();
				identique = true;

			}else {
				identique = false;
			}



		}
		return identique ; 
	}

	public void supprimerDoublon () {

		Liste b = new Liste();
		Maillon ref = this.tete;
		while (ref!=null) {
			if(!b.contains(ref.getValeur())) {
				b.addLast(ref.getValeur());
			}
			ref = ref.getSuivant();
		}
		this.tete=b.tete;

	}

	public void triliste() {
		Liste b = new Liste();
		b.addInHead(this.tete.getValeur());
		Maillon ref = this.tete.getSuivant();
		Maillon refbis;
		while ( ref!=null) {
			refbis=b.tete;
			while (refbis!=null) {
				if(ref.getValeur().compare(refbis.getValeur()) > 0 ) {
					b.addAfter(ref.getValeur(), refbis);
					refbis= null;

				}else {
					if(ref.getValeur().compare(refbis.getValeur()) < 0){
						b.addBefore(ref.getValeur(), refbis);
						refbis=null;
					}else{
						refbis=refbis.getSuivant();
					}
				}
				ref= ref.getSuivant();
			}
			this.tete=b.tete;
		}
	}

	public boolean listetriee () {
		Maillon m = this.tete;
		while ( m.getSuivant() != null) {
			if(m.getValeur().compare(m.getSuivant().getValeur()) < 0) {
				m=m.getSuivant();
			}else {
				return false;
			}
		}
		return true;
	}

	public boolean comparaListe(Liste l) {
		Boolean bool = true; 
		Maillon ref = this.getTete();
		Maillon ref1= l.getTete();
		if(this.taille()==l.taille()) {
			while((ref != null && ref1 != null) && bool ) {

				if(ref.equals(ref1)) {
					bool = true;
				}else {
					bool = false;
				}

			}
			if(bool != false) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}






	}


}
  










