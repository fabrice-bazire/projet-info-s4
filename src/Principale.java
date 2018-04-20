public class Principale {

    public static char [][] grille (Liste l){
        char  grille [][] = new char [30][30];
        for (int i = 0; i<grille.length; i++){
            for (int j = 0; j<grille[1].length; j++){
                grille[i][j] = ' ';
            }
        }
        Maillon<Paire> ref = l.tete;
        while (ref != null){
            grille[ref.getValeur().x-1][ref.getValeur().y-1] = 'X';
            ref = ref.getSuivant();
        }
        return grille;
    }

    public static void aff_grille (char [][] grille){
        System.out.println("     1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30");
        for (int i = 0; i<grille.length; i++) {
            if (i < 9){
                System.out.print(i+1 + " ");
            }else{
                System.out.print(i+1);
            }

            for (int j = 0; j < grille[1].length; j++) {
                System.out.print(" | " + grille[i][j]);
            }
            System.out.println(" |");
        }
    }

    public static void main (String [] args){
       Rules a = new Rules();
       Liste dep = new Liste();
       dep.addTrier(new Paire(12,14, 0));
       dep.addTrier(new Paire(12,16,0));
       dep.addTrier(new Paire(13,11,0));
       dep.addTrier(new Paire(13,14,0));
        dep.addTrier(new Paire(13,15,0));
        dep.addTrier(new Paire(13,17,0));
        dep.addTrier(new Paire(14,12,0));
        dep.addTrier(new Paire(14,15,0));
        dep.addTrier(new Paire(15,12,0));
        dep.addTrier(new Paire(15,15,0));
        dep.addTrier(new Paire(16,11,0));
        dep.addTrier(new Paire(16,13,0));
        dep.addTrier(new Paire(16,14,0));
        dep.addTrier(new Paire(16,16,0));
        dep.addTrier(new Paire(17,14,0));
        dep.addTrier(new Paire(17,16,0));

       a.liste = dep;
       System.out.print(dep);
       aff_grille(grille(a.liste));
       System.out.println(" ");
       a.liste = a.newgeneration(a.liste);
       a.liste = a.newgeneration(a.liste);
       aff_grille(grille(a.liste));
       System.out.println(" ");
       a.liste = a.newgeneration(a.liste);
       aff_grille(grille(a.liste));
       System.out.println(" ");
       a.liste = a.newgeneration(a.liste);
       aff_grille(grille(a.liste));
       System.out.println("periode : " + a.comportement_asymptotique(a.liste));
       // aff_grille(grille(a.retournetouslesvoisinsmorts(dep)));
    }
}
