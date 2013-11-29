import java.util.LinkedList;

/**
 * User: akh
 * Date: 14/11/13
 */
public class Noeud {
    private LinkedList<Noeud> enfant = new LinkedList<Noeud>();
    private char c;

    public Noeud(char c) {
        this.c = c;
    }

    public char getC() {
        return c;
    }

    public LinkedList<Noeud> getEnfant() {
        return enfant;
    }

    public String toString() {
        return String.valueOf(c);
    }
    public void ajouteFils(Noeud a) {
        if (enfant.size() == 0) {
            enfant.add(a);
            return;
        }
        for (int pos = 0; pos<enfant.size();pos++) {
            if (enfant.get(pos).getC() > a.getC()) {
                enfant.add(pos, a);
                return;
            }
        }
        enfant.add(enfant.size()-1, a);
    }

    // return the noeud in enfants which contains c null otherwise
    public Noeud trouveChar(char c) {
        //System.out.printf("noeud c:%c trouveChar c=%c enfant:%s\n", this.c, c, getEnfant());
        for (Noeud n: enfant) {

            if (n.getC() == c)
                return n;
        }
        return null;
    }

    public boolean existeMotRecursif(String s, int pos) {
        for (Noeud n: enfant) {
            if (pos == s.length()) {
                if (n.c == '*') {
                    return true;
                } else {
                    continue;
                }
            }

            if (n.c == s.charAt(pos)) {
                return n.existeMotRecursif(s, pos+1);
            }
        }
        return false;
    }
}
