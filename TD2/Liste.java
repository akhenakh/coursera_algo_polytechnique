import java.util.NoSuchElementException;

/**
 * User: akh
 * Date: 10/11/13
 */

class Cellule {
    Objet o;
    Cellule suivante;

    Cellule(Objet o, Cellule c) {
        this.o = o;
        this.suivante = c;
    }
}

public class Liste {

    private Cellule tete;

    public Liste() {
        tete = null;
    }

    public Liste ajouteTete(Objet val) {
        Cellule newCellule = new Cellule(val, this.tete);
        tete = newCellule;
        return this;
    }

    public Liste supprimeTete() throws NoSuchElementException {
        if (tete == null)
            throw new java.util.NoSuchElementException();
        tete = tete.suivante;
        return this;
    }

    public boolean contient(Objet o) {
        Cellule next = this.tete;

        while (next != null) {
            if (next.o.nom().equals(o.nom()))
                return true;
            next = next.suivante;
        }
        return false;
    }

    public int longueur() {
        Cellule next = this.tete;
        int count = 0;
        while (next != null) {
            count++;
            next = next.suivante;
        }
        return count;
    }
}
