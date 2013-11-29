/**
 * User: akh
 * Date: 14/11/13
 */
public class Dictionnaire {
    Noeud racine;

    public Dictionnaire() {
        this.racine = new Noeud('_');
    }

    public Noeud getRacine() {
        return racine;
    }

    public boolean existeMot(String s) {
        Noeud current = racine;

        return current.existeMotRecursif(s, 0);
    }
    public void listeMotsAlphabetique() {

    }
    boolean estPrefixe(String s) {
        if (s.length() < 1)
            return false;

        Noeud lastNoeud = racine;

        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            lastNoeud = lastNoeud.trouveChar(c);
            if(lastNoeud == null) {
                return false;
            }
        }
        return true;
    }

    public boolean ajouteMot(String s) {
        if (s.length() < 1)
            return false;

        Noeud lastNoeud = racine;
        boolean insert = false;
        for (int i=0;i<=s.length();i++) {
            char c;
            if (i==s.length())
                c = '*';
            else
                c = s.charAt(i);

            Noeud tempNoeud = lastNoeud.trouveChar(c);
            //System.out.printf("word %s i=%d lookup=%c tempNoeud=%s\n", s, i, c, tempNoeud);
            if (tempNoeud == null) {
                //System.out.printf("word %s does not exist at node %s\n", s, lastNoeud);
                insert = true;
            }
            if (insert) {
                tempNoeud = new Noeud(c);
                lastNoeud.ajouteFils(tempNoeud);
            }
            lastNoeud = tempNoeud;

            if (lastNoeud.getC() == '*') {
               return insert;
            }
        }
        return true;
    }

}
