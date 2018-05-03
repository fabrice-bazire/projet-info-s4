import java.io.*;
import java.util.Scanner;

public class Principale {

    public static String f;

    public static char [][] grille (Liste l, String fichier){
        Paire p = lecture_paire_fichier_lif (fichier);
        char  grille [][] = new char [30][30];
        for (int i = 0; i<grille.length; i++){
            for (int j = 0; j<grille[1].length; j++){
                grille[i][j] = ' ';
            }
        }
        Maillon<Paire> ref = l.tete;
        while (ref != null){
            grille[ref.getValeur().x + p.getx()][ref.getValeur().y + p.gety()] = 'X';
            ref = ref.getSuivant();
        }
        return grille;
    }

    public static void aff_grille (char [][] grille){
        System.out.println("\n\n");
        for (int i = 0; i<grille.length; i++) {
            for (int j = 0; j < grille[1].length; j++) {
                System.out.print(" | " + grille[i][j]);
            }
            System.out.println(" |");
        }
    }

    public static Paire lecture_paire_fichier_lif (String fichier) {
      String i;
      char [] x;
      Paire coin = new Paire(0,0,0);
      try{
        FileReader f = new FileReader (fichier);
        BufferedReader b = new BufferedReader(f);
        String s = " ";
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
                  }else{
                    coin = new Paire((Character.getNumericValue(x[4]) * -1), (Character.getNumericValue(x[7]) * -1), 0);
                  }
                }else{
                  if (x[5] != '-'){
                    coin = new Paire(Character.getNumericValue(x[3]), Character.getNumericValue(x[5]), 0);
                  }else{
                    coin = new Paire(Character.getNumericValue(x[3]), (Character.getNumericValue(x[6]) * -1), 0);
                  }
                }
              }
          }catch(Exception e) {
           System.out.print(e.getMessage());
          }
        }
      }catch (IOException e) {
        System.out.println(e);
      }
    return coin;
}

    public static Liste<Paire> lecture_config_initiale_fichier_lif (Paire coin, String fichier) {
    Liste<Paire> l = new Liste ();
    int numligne = coin.gety();
      String i;
      char [] x;
      try{
        FileReader f = new FileReader (fichier);
        BufferedReader b = new BufferedReader(f);
        String s = " ";
        while((s= b.readLine())!=null){ 
          Scanner sc = new Scanner (s);
          sc.useDelimiter("\n");
          try {
            i = sc.next();
            x = i.toCharArray();
              if (x[0] == '.' || x[0] == '*'){
                l.concatener(recensement(coin, i, numligne));
                numligne++;
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
        ar.addTrier(new Paire (numligne, i+coin.getx(), 0));
      }
    }
  }catch(Exception e) {
          System.out.print(e.getMessage());
    }
    return ar;
}

    public static void main (String [] args){
        if (args[0].equals("-game")){
            Rules a = new Rules();
            Liste dep = lecture_config_initiale_fichier_lif (lecture_paire_fichier_lif ("fichier.lif"), "fichier.lif");
            a.liste = dep;
            int [] x = (a.extraire_nb_pour_naitre(a.lecture_regles_fichier_lif()));
            int [] y = (a.extraire_nb_pour_survivre(a.lecture_regles_fichier_lif()));
            System.out.println(dep);
            aff_grille(grille(a.liste, "fichier.lif"));
            System.out.println(" ");
            a.liste = a.newgeneration(a.liste);
            aff_grille(grille(a.liste, "fichier.lif"));
            //System.out.println(a.liste);
            System.out.println(" ");
            a.liste = a.newgeneration(a.liste);
            //System.out.println(a.liste);
            aff_grille(grille(a.liste, "fichier.lif"));
        }
        if (args[0].equals("-name")) {
            System.out.println("Cécile, Amina, Martin et Fabrice");
        }
        if (args[0].equals("-h")){
            System.out.println("options possibles : \n-name : affiche le nom des créateurs de cette appli\n-s : effectue une simulation du jeu (nécéssite une durée et un fichier.lif en paramètre derrière -s)\n-c : calcule le type d'évolution du jeu (nécéssite une durée max et un fichier.lif en paramètre derrière -c)\n-w : calcule le type d'évolution de plusieurs jeux dans un dossier (nécéssite une durée max et le nom du dossier en paramètre derriere -w)");
        }
        if (args[0].equals("-s")){
          int duree = Integer.parseInt(args[1]);
          f = args[2];
          System.out.println("La durée est de : " + duree + "\nLe nom du fichier est : " + f);
          int i = 0;
          Rules a = new Rules();
          Liste dep = lecture_config_initiale_fichier_lif (lecture_paire_fichier_lif (f), f);
          a.liste = dep;
          int [] x = (a.extraire_nb_pour_naitre(a.lecture_regles_fichier_lif()));
          int [] y = (a.extraire_nb_pour_survivre(a.lecture_regles_fichier_lif()));
          aff_grille(grille(a.liste, f));
            System.out.println("generation n°0");
          while (duree >= 0){
            i++;
            duree--;
            a.liste = a.newgeneration(a.liste);
            aff_grille(grille(a.liste, f));
            System.out.println("generation n°" + i);
          }
        }
        if (args[0].equals("-c")){
            int duree_max = Integer.parseInt(args[1]);
            f = args[2];
            int i = 0;
            Rules a = new Rules();
            Liste dep = lecture_config_initiale_fichier_lif (lecture_paire_fichier_lif (f), f);
            a.liste = dep;
            int [] x = (a.extraire_nb_pour_naitre(a.lecture_regles_fichier_lif()));
            int [] y = (a.extraire_nb_pour_survivre(a.lecture_regles_fichier_lif()));
            if (a.periode(a.liste, duree_max) == 0){
                System.out.print("\n\n\nLe Temps max entré étant trop petit, aucune période n'a pu être obtenu,  et de ce fait aucun comportement n'as pu etre défini !!\n\n\n");
            }else {
                System.out.print(a.comportement(a.liste, a.periode(a.liste, duree_max), a.taille_queue(a.liste, a.periode(a.liste, duree_max))));
            }
        }
        if (args[0].equals("-queue")){
            int max = Integer.parseInt(args[1]);
            f = args[2];
            Rules a = new Rules();
            Liste dep = lecture_config_initiale_fichier_lif (lecture_paire_fichier_lif (f), f);
            a.liste = dep;
            System.out.println("\n\n\n" + a.taille_queue(a.liste, a.periode(a.liste, max)));
        }
    }
}
