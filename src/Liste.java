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

		public void add (Paire p){
            Maillon ref = this.tete;
		    if (ref == null){
		    	this.tete = new Maillon (p);
			}else{
		        while (ref.getSuivant() != null) {
					if (ref.getValeur().compareto(p) > 0) {
						Maillon x = ref.getSuivant();
						Maillon a = new Maillon(p);
						a.setSuivant(x);
						ref.setSuivant(a);
					} else {
						this.addLast(p);
					}
					ref = ref.getSuivant();
				}
            }
        }

		public boolean addTrier(Paire p){
			Maillon x = new Maillon (p);
			Maillon ref = this.tete;
			System.out.println(ref.toString());
			while(ref != null){
				if (ref.getValeur().compareto(x.getValeur()) > 0){
					Paire a = ref.getValeur();
					ref.setValeur(x.getValeur());
					ref.getSuivant().setValeur(a);
					return true;
				}
				ref = ref.getSuivant()
			}
			return false;
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
	
	
	
	
	
	
	
	
	
	
	
