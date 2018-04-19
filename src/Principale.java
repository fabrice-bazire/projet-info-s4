public class Principale {

    public static char [][] grille (Liste l){
        char  grille [][] = new char [10][10];
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
        System.out.println("     1   2   3   4   5   6   7   8   9   10");
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
       dep.addTrier(new Paire(4,3, 0));
       dep.addTrier(new Paire(2,3,0));
       dep.addTrier(new Paire(3,3,0));
       dep.addTrier(new Paire(3,7,0));
        dep.addTrier(new Paire(3,8,0));
        dep.addTrier(new Paire(4,7,0));
        dep.addTrier(new Paire(4,8,0));
        dep.addTrier(new Paire(8,3,0));
        dep.addTrier(new Paire(9,3,0));
        dep.addTrier(new Paire(10,3,0));
        dep.addTrier(new Paire(8,4,0));
        dep.addTrier(new Paire(8,5,0));
        dep.addTrier(new Paire(9,5,0));
        dep.addTrier(new Paire(10,5,0));
       a.liste = dep;
       //System.out.print(dep);
       aff_grille(grille(a.liste));
        System.out.println(" ");
       a.liste = a.newgeneration();
       aff_grille(grille(a.liste));
        System.out.println(" ");
        a.liste = a.newgeneration();
        aff_grille(grille(a.liste));
        System.out.println(" ");
        a.liste = a.newgeneration();
        aff_grille(grille(a.liste));
       // aff_grille(grille(a.retournetouslesvoisinsmorts(dep)));
    }
}
