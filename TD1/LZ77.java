import static java.lang.StrictMath.max;

// Ces squelettes sont à compléter et sont là uniquement pour prévenir des
// erreurs de compilation.
class Element {
    public Occurrence e;
    public int s;
    Element (Occurrence e, int s) {
        this.e = e;
        this.s = s;
    }
}

class Occurrence {
    public int retour;
    public int taille;

    Occurrence(int retour, int taille) {
        this.retour = retour;
        this.taille = taille;
    }

    @Override
    public String toString() {
        return "Occurrence{" +
                "retour=" + retour +
                ", taille=" + taille +
                '}';
    }
}

class LZ77 {
    public static boolean debug = false;
    public static boolean debugLongueur = false;
    public static Occurrence plusLongueOccurrence(
            int[] t,
            int positionCourante,
            int tailleFenetre
    ) {
        Occurrence biggestOccurrence = new Occurrence(0, 0);

        if (t.length < 2)
            return biggestOccurrence;

        if (positionCourante < 1)
            return   biggestOccurrence;

        if (debug)
            System.out.printf("size of input: %d\n", t.length);

        int size;
        int windowPos = max(positionCourante - tailleFenetre, 0);

        // on essaye toutes les tailles  depuis positionCourrant
        for (size = 1; positionCourante + size  <= t.length; size++) {
            if (debug)
                System.out.printf("in loop: size=%d windowPos=%d\n", size, windowPos);

            // on cree un tableau de longueur count (2) jusque fin ou 100 pour comparaison
            int[] searchTab = copyElemToNewTab(t, size, positionCourante);
            if (debug) {
                System.out.printf("create searchtab size %d ", searchTab.length);
                for (int r : searchTab) {
                    System.out.printf("%d ", r);
                }
                System.out.print("\n");
            }
            // on cherche dans les derniers bit
            for (int i = windowPos; i + size - 1 < positionCourante; i++) {
                windowPos = i;
                if (debug)
                    System.out.printf("search at: windowPos=%d with size %d\n", windowPos, size);
                if (isTabSameAtPosition(searchTab, windowPos, t)) {
                    if (debug) {
                        System.out.print("found occurrence:(");
                        for (int r : searchTab) {
                            System.out.printf("%d", r);
                        }
                        System.out.printf(") at windowPos %d\n", windowPos);
                    }
                    if (searchTab.length > biggestOccurrence.taille) {
                        biggestOccurrence.taille = searchTab.length;
                        biggestOccurrence.retour = positionCourante - windowPos;
                    }
                }
            }
            windowPos = max(positionCourante - tailleFenetre, 0);
        }

        if (debug) {
            System.out.printf("BIGGEST occurence: taille=%d retour=%d\n", biggestOccurrence.taille, biggestOccurrence.retour);
        }
        return biggestOccurrence;
    }

    public static Element[] LZ77(int[] t, int tailleFenetre) {
        if (t.length < 2) {
            return new Element[0];
        }
        Element[] res = new Element[LZ77Longueur(t, tailleFenetre)];

        int i = 0;
        int count = 0;
        while (i < t.length && t[i] != 2) {
            Occurrence lastOccurrence = plusLongueOccurrence(t, i, tailleFenetre);

            Element e = new Element(lastOccurrence, t[i+lastOccurrence.taille]);
            res[count] = e;
            if (lastOccurrence.taille == 0)
                i++;
            else
                i = i + lastOccurrence.taille + 1;
            count += 1;
        }
        return res;
    }

    public static void afficheEncode(Element[] tab) {
        for (Element e:tab) {
            System.out.printf("(%d,%d)%d", e.e.retour, e.e.taille, e.s);
        }
        System.out.printf("\n");
    }

    public static int LZ77InverseLongueur(Element[] t) {
        int count = 0;
        for (Element e:t) {
            count += e.e.taille + 1;
        }
        return count;
    }

    public static int[] LZ77Inverse(Element[] t) {
        int[] res = new int[LZ77InverseLongueur(t)];
        //int []tdebug = { 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 2};
        //((0,0)0 (1,1)0 (0,0)1 (4,4)1 (2,2)0 (10,3)1
        int pos = 0;
        int current_val = 0;
        for (Element e:t) {
            //System.out.println(e.e);
            for (int i=0; i<e.e.taille; i++) {
                //System.out.printf("pos: %d taille: %d\n", pos, e.e.taille);
                res[pos] = res[pos - e.e.retour];
                pos++;
            }
            // copy the char right after
            //pos = pos + e.e.taille;
            res[pos] = e.s;
            pos++;
        }
        return res;
    }

    void blit(int[] t1, int[] t2, int start1, int len, int start2) {

    }
    public static void afficheDecode(int[] t) {
        for (int i:t) {
            System.out.printf("%d ", i);
        }
        System.out.printf("\n");
    }
    public static int LZ77Longueur(int[] t, int tailleFenetre) {
        int count = 0;
        /*int []tdebug = { 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 2};
        //((0,0)0 (1,1)0 (0,0)1 (4,4)1 (2,2)0 (10,3)1
        tailleFenetre = 100;
        t = tdebug;*/
        if (t.length == 0)
            return count;
        int i = 0;

        while (i < t.length && t[i]  != 2) {
            Occurrence lastOccurrence = plusLongueOccurrence(t, i, tailleFenetre);

            if (debugLongueur)
                System.out.printf("at i=%d, (%d,%d)%d\n", i, lastOccurrence.taille, lastOccurrence.retour, t[i+lastOccurrence.taille]);

            // move from taille or 1
            if (lastOccurrence.taille == 0)
                i++;
            else
                i = i + lastOccurrence.taille + 1;
            count += 1;
        }

        return count;
    }

    // create a new tab size count elem and init it with src starting at pos
    public static int[] copyElemToNewTab(int[] src, int count, int pos) {
        if (pos + count > src.length)
            throw new IllegalArgumentException("out of bound");

        int[] res = new int[count];
        for (int i=0; i<count; i++) {
            res[i] = src[pos + i];
        }
        return res;
    }

    // return true if searchtab is at position in t
    public static boolean isTabSameAtPosition(int[] searchTab, int position, int[] t) {
        if (position + searchTab.length > t.length)
            return false;

        for (int i=0;i<searchTab.length; i++) {
            if (searchTab[i] != t[position + i])
                return false;
        }
        return true;
    }
}
