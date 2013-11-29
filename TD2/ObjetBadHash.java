/**
 * User: akh
 * Date: 10/11/13
 */
public class ObjetBadHash extends Objet {
    String nom;

    ObjetBadHash(String n) {
        nom = n;
    }
    int hash() {
        return -148;
    }

    String nom() {
        return nom;
    }
}
