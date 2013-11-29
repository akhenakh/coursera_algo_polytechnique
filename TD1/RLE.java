
/**
 * User: akh
 * Date: 01/11/13
 */
public class RLE {
    public static int longueurRLE(int[] t) {
        if (t.length == 0)
            return 0;
        int compressedLength = 2;
        int lastOccurence = t[0];
        for (int i = 0; i < t.length; i++) {
            if (lastOccurence != t[i]) {
                compressedLength+=2;
                lastOccurence = t[i];
            }
        }
        return compressedLength;
    }

    public static int[] RLE(int[] t) {
        int longueur = longueurRLE(t);
        if (longueur == 0) {
            return t;
        }
        int[] r = new int[longueur];
        r[0] = t[0];
        int compressedPos = 0;
        for (int i = 0; i < t.length; i++) {
            if (r[2*compressedPos] != t[i]) {
                compressedPos++;
                r[2*compressedPos] = t[i];
            }
            r[2*compressedPos + 1]++;
        }
        return r;
    }

    public static int longueurRLEInverse(int[] t) {
        if (t.length < 2)
            return 0;

        if (t.length % 2 != 0)
            throw new IllegalArgumentException("t length cannot be odd");

        int length = 0;
        for (int i = 0; i < t.length; i+=2) {
           length += t[i+1];
        }
        return length;
    }

    public static int[] RLEInverse(int[] t) {
        int longueur = longueurRLEInverse(t);
        if (longueur == 0) {
            return t;
        }
        int[] r = new int[longueur];

        int pos = 0;
        for (int i = 0; i < t.length; i+=2) {
            for (int j=0; j < t[i + 1]; j++) {
                r[pos] = t[i];
                pos++;
            }
        }
        return r;
    }
}
