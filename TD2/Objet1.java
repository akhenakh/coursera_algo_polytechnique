/**
 * User: akh
 * Date: 06/11/13
 */

public class Objet1 extends Objet {
    private String nom;
    public Objet1(String nom) {
        this.nom = nom;
    }

    public String nom() {
        return this.nom;
    }

    public static int square(int num, int elevation) {
        if (num == 0)
            return 0;
        int res = num;
        for (int x=1;x<elevation;x++) {
            res = res * num;
        }
        return res;
    }

    int hash() {
        if (this.nom.length() == 0)
            return 0;
        int pos = 1;
        int hash = this.nom.charAt(this.nom.length() - 1);
        //System.out.printf("%d", (int)this.nom.charAt(this.nom.length() - 1));
        //System.out.printf("nom: %s length: %d pos: %d c: %d hash: %d\n", this.nom(), this.nom().length(), pos, this.nom.length() - 1, hash);
        for (int c=this.nom.length()-2;c>=0;c--) {
            //System.out.printf(" + %d * 31^%d", (int)this.nom.charAt(c), pos);
            hash += this.nom.charAt(c) * square(31, pos);
            //System.out.printf("nom: %s length: %d pos: %d val: %d, c: %d hash: %d\n", this.nom(), this.nom().length(), pos, (int)this.nom.charAt(c), c, hash);
            pos++;
        }
        //System.out.printf("= %d\n", hash);
        return hash;
    }
}
