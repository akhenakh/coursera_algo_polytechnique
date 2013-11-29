/**
 * User: akh
 * Date: 10/11/13
 */

public class Objet2 extends Objet {
    private String nom;
    public Objet2(String nom) {
        this.nom = nom;
    }

    public String nom() {
        return this.nom;
    }

    int hash() {
        int hash = 5381;
        for (int i = 0; i < this.nom().length(); i++)  {
            //System.out.printf("i=%d hash=%d\n=", i, hash);
            hash = hash * 33 ^ this.nom().charAt(i);
        }
        return hash;
    }
}
