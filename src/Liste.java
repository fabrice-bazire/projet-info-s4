
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
			Maillon dernier= getDernierElement();
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
			 if(ref.getValeur()==p) {
				 trouve=true;
			 }else {
				 ref=ref.getSuivant();
			 }
		 }
		 return trouve;
		 
	 }
	 

	    public String toString(){
	        String s = "Voici les coordonn�es des cellules vivantes :\n";
			
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

	  public void verifierVoisins() {
	        Liste provisoire = new Liste();
	        int nbvoisins = 0;
	        List<Paire> t = this.tab;
	        for (Paire paire : t) {
	        	System.out.println("il passe");
	            System.out.println("0)" + nbvoisins);
	            Paire p1 = new Paire(paire.getx()-1, paire.gety()+1);
	              if (t.contains(p1)) {
	                nbvoisins++;
	                System.out.print("1)" + nbvoisins);
	            }
	              
	              Paire p2 = new Paire(paire.getx(), paire.gety()+1);
	            if (this.tab.contains(p2)) {
	                nbvoisins++;
	                System.out.print("2)" + nbvoisins);
	            }
	            Paire p3 = new Paire(paire.getx()+1, paire.gety()+1);
	            if (this.tab.contains(p3)) {
	                nbvoisins++;
	                System.out.print("3)" + nbvoisins);
	            }
	            
	            Paire p4 = new Paire(paire.getx()-1, paire.gety());
	            if (this.tab.contains(p4)) {
	                nbvoisins++;
	                System.out.print("4)" + nbvoisins);
	            }
	            Paire p5 = new Paire(paire.getx()+1, paire.gety());
	            if (this.tab.contains(p5)) {
	                nbvoisins++;
	                System.out.print("5)" + nbvoisins);
	            }
	            
	            Paire p6 = new Paire(paire.getx()-1, paire.gety()-1);
	            if (this.tab.contains(p6)) {
	                nbvoisins++;
	                System.out.print("6)" + nbvoisins);
	            }
	            Paire p7 = new Paire(paire.getx(), paire.gety()-1);
	            if (this.tab.contains(p7)) {
	                nbvoisins++;
	                System.out.println("7)" + nbvoisins);
	            }
	            Paire p8 = new Paire(paire.getx()+1, paire.gety()-1);
	            if (this.tab.contains(p8)) {
	                nbvoisins++;
	                System.out.println("8)" + nbvoisins);
	            }
	            if (nbvoisins == 2 || nbvoisins == 3) {
	                provisoire.add(paire);
	            }
	            nbvoisins = 0;
	        }
	        this.tab = new LinkedList<Paire>();
	        for (Paire paire : provisoire.tab) {
	            this.tab.add(paire);
	        }
	    }
}
	    
	/*    public void verifierVois() {
	    	System.out.println("je suis dans la fonction");
	    	 Liste provisoire = new Liste();
	    	 Liste t = this;
		     Maillon ref=this.tete;
	    	int nbvoisins=0;
	    	while( ref != null) {
	        System.out.println("je suis dans la boucle");
	        int x = ref.getValeur().getx();
	        int x2 = x - 1;
	        int y=ref.getValeur().gety();
	        int y2 =y+1;
	        
	    	Paire p1 = new Paire(x2,y2);
	    	p1.toString();
	    	if (this.contains(p1)){
	                nbvoisins++;
	                System.out.print("1) "+nbvoisins);
	            }
	              
	              Paire p2 = new Paire (ref.getValeur().getx(), ref.getValeur().gety()+1);
	              
	            if (this.contains(p2)) {
	                nbvoisins++;
	                System.out.print("2) "+ nbvoisins);
	            }
	            Paire p3 = new Paire (ref.getValeur().getx()+1,  ref.getValeur().gety()+1);
	            	
	            if (this.contains(p3)) {
	                nbvoisins++;
	                System.out.print("3)" + nbvoisins);
	            }
	            
	            Paire p4 =  new Paire (ref.getValeur().getx()-1, ref.getValeur().gety());
	            		
	            if (this.contains(p4)) {
	                nbvoisins++;
	                System.out.print("4)" + nbvoisins);
	                }
	            Paire p5 =  new Paire (ref.getValeur().getx()+1,  ref.getValeur().gety());
	            	
	            if (this.contains(p5)) {
	                nbvoisins++;
	                System.out.print("5)" + nbvoisins);
	            }
	            
	            Paire p6 =  new Paire (ref.getValeur().getx()-1,  ref.getValeur().gety()-1);
	            	
	            if(this.contains(p6)) {	             
	            	nbvoisins++;
	                System.out.print("6)" + nbvoisins);
	            }
	            Paire p7 =  new Paire (ref.getValeur().getx(),  ref.getValeur().gety()-1);
	            	
	            if (this.contains(p7)) {
	                nbvoisins++;
	                System.out.println("7)" + nbvoisins);
	            }
	            Paire p8 =  new Paire (ref.getValeur().getx()+1,  ref.getValeur().gety()-1);
	            	
	            if (this.contains(p8)) {
	                nbvoisins++;
	                System.out.println("8)" + nbvoisins);
	            }
	            
	            
	            
	           /*f (nbvoisins == 2 || nbvoisins == 3) {
	                provisoire.addLast(ref.getValeur());
	            }
	            
	            ref=ref.getSuivant();
	    	}
	    	 
	    his.tete=provisoire.tete;
	    	
	    	
	    	*/
	    	
	    	
	    
	    
	    
	    
	    

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    



