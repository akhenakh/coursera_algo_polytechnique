/**
 * User: akh
 * Date: 10/11/13
 */
public class TableDeHachage {
    Liste[] tab;

    TableDeHachage(int n) {
        tab = new Liste[n];
        for (int i=0; i<n; i++) {
            tab[i] = new Liste();
        }
    }

    public void ajoute(Objet o) {
        if (contient(o))
            return;
        int hash = o.hash();
        int modhash = hash % tab.length;
        if (modhash < 0)
            modhash += tab.length;
        tab[modhash].ajouteTete(o);
    }

    public boolean contient(Objet o) {
        int hash = o.hash();
        int modhash = hash % tab.length;
        if (modhash < 0)
            modhash += tab.length;
        // find the list and search in it

        return tab[modhash].contient(o);
    }

    public int[] remplissageMax() {
        int max = 0;
        int pos = 0;
        for (int i=0;i<this.tab.length; i++) {
            int size = 0;
            if (tab[i] == null)  {
                size = 0;
            } else {
                size = tab[i].longueur();
            }
            if (size > max) {
                max = size;
                pos = i;
            }
        }
        return new int[] {pos, max};
    }
}
