public class Principale {
    public static void main (String [] args){
       Rules a = new Rules();
       Liste dep = new Liste();
       dep.addTrier(new Paire(4,3, 0));
       dep.addTrier(new Paire(2,3,0));
       dep.addTrier(new Paire(3,3,0));
       a.liste = dep;
       System.out.print(dep);
    }
}
