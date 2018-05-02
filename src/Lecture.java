import java.io.*;
import java.util.Scanner;

public class Lecture {
	
	public static char[] lecture_regles_fichier_lif () {
	  char [] r = new char [20];
      String i;
      char [] x;
      try{
      	FileReader f = new FileReader ("fichier.lif");
        BufferedReader b = new BufferedReader(f);
        String s = " ";
        while((s= b.readLine())!=null){ 
          Scanner sc = new Scanner (s);
          sc.useDelimiter("\n");
          try {
          	i = sc.next();
            x = i.toCharArray();
            	if(x[0] == '#' && x[1] == 'R'){
            		for (int j = 3; j < x.length; j++){  
            			r[j-3] = x[j]; 
            		}
            	}
            	if(x[0] == '#' && x[1] == 'N'){
            		r[0] = '2';
            		r[1] = '3';
            		r[2] = '/';
            		r[3] = '3';
            	}
          }catch(Exception e) {
          System.out.print(e.getMessage());
  		}
  		}
  	}catch (IOException e) {
        System.out.println(e);
    }
  	return r;
}

public static Liste<Paire> lecture_config_initiale_fichier_lif () {
	  Liste<Paire> l = new Liste ();
	  int numligne = 0;
      String i;
      char [] x;
      try{
      	FileReader f = new FileReader ("fichier.lif");
        BufferedReader b = new BufferedReader(f);
        String s = " ";
        Paire coin = new Paire(0,0,0);
        while((s= b.readLine())!=null){ 
          Scanner sc = new Scanner (s);
          sc.useDelimiter("\n");
          try {
          	i = sc.next();
            x = i.toCharArray();
            	if(x[0] == '#' && x[1] == 'P'){
            		if(x[3] == '-'){
            			if (x[6] != '-'){
            				coin = new Paire((Character.getNumericValue(x[4]) * -1), Character.getNumericValue(x[6]), 0);
            				numligne = coin.gety();
            				//l.addLast(coin);
            			}else{
            				coin = new Paire((Character.getNumericValue(x[4]) * -1), (Character.getNumericValue(x[7]) * -1), 0);
            				numligne = coin.gety();
            				//l.addLast(coin);
            			}
            		}else{
            			if (x[5] != '-'){
            				coin = new Paire(Character.getNumericValue(x[3]), Character.getNumericValue(x[5]), 0);
            				numligne = coin.gety();
            				//l.addLast(coin);
            			}else{
            				coin = new Paire(Character.getNumericValue(x[3]), (Character.getNumericValue(x[6]) * -1), 0);
            				numligne = coin.gety();
            				//l.addLast(coin);
            			}
            		}
            	}
            	if (x[0] == '.' || x[0] == '*'){
            		l.concatener(recensement(coin, i, numligne));
            		numligne--;
            	}
          }catch(Exception e) {
          System.out.print(e.getMessage());
      	  }
        }
  	}catch (IOException e) {
        System.out.println(e);
    }
  	return l;
}

public static Liste recensement (Paire coin, String ligne, int numligne){
	Liste ar = new Liste();
	char [] x;
	try {
		x = ligne.toCharArray();
		for (int i = 0; i < ligne.length(); i++){
			if (x[i] == '*'){
				ar.addTrier(new Paire (i+coin.getx(), numligne, 0));
			}
		}
	}catch(Exception e) {
          System.out.print(e.getMessage());
    }
    return ar;
}
	
	public static void main (String [] args){
		//char [] d = lecture_regles_fichier_lif ();
		//System.out.println(d);
		System.out.println(lecture_config_initiale_fichier_lif ());
	}
}