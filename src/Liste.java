import java.util.*;
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
	 

	 public String toString(){
	        String s = "Voici les coordonnées des cellules :\n";
			
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
}