import java.util.NoSuchElementException;

public class Test {

  public static void main(String[] args) {
      //testListeakh();
      //test2();
      //test1squareAkh();
      //testHashbAkH();
      //test1akh();
      //test1a();
      //test1b();
      //test3();
      //test3akh();
    test4();
  }

    private static void test3akh() {
        System.out.print("testakh3 ");

        System.out.print("is equal ?? ");
        TableDeHachage t0 = new TableDeHachage(10);
        t0.ajoute(new Objet1("FB"));
        System.out.print(t0.contient(new Objet1("Ea")));
        System.out.print(t0.contient(new Objet1("FB")));
        t0.ajoute(new Objet1("Ea"));

        int[] remplissage = t0.remplissageMax();
        System.out.println( "\nremplissageMax" + remplissage[0] + " " + remplissage[1] + " end");

        System.out.printf(" FB %d Ea %d\n", new Objet1("FB").hash(), new Objet1("Ea").hash());
        TableDeHachage t = new TableDeHachage(3000);
        for (int i = 0; i < 1500; i++) {
           t.ajoute(new Objet1("chaine"+Prng.next()));
        }
        remplissage = t.remplissageMax();
        System.out.println( "Objet1 remplissageMax " + remplissage[0] + " " + remplissage[1] );

        TableDeHachage t1 = new TableDeHachage(3000);
        for (int i = 0; i < 1500; i++) {
            t1.ajoute(new Objet2("chaine"+Prng.next()));
        }
        remplissage = t1.remplissageMax();
        System.out.println( "Objet2 remplissageMax " + remplissage[0] + " " + remplissage[1] );

        TableDeHachage t4 = new TableDeHachage(3000);
        for (int i = 0; i < 1500; i++) {
            t4.ajoute(new Objet3("chaine"+Prng.next()));
        }
        remplissage = t4.remplissageMax();
        System.out.println( "Objet3 remplissageMax " + remplissage[0] + " " + remplissage[1]);


        TableDeHachage t5 = new TableDeHachage(3000);
        for (int i = 0; i < 1500; i++) {
            t5.ajoute(new ObjetBadHash("chaine"+Prng.next()));
        }
        remplissage = t5.remplissageMax();
        System.out.println( "Objetbashasg remplissageMax " + remplissage[0] + " " + remplissage[1]);
    }

    private static void testListeakh() {

        //test hash equals
        System.out.printf("hash toto = %d\n", new Objet1("toto").hash());

        TableDeHachage t = new TableDeHachage(10);
        t.ajoute(new Objet1("toto"));
        if (t.contient(new Objet1("toto"))) {
            System.out.printf("test ok TOTO is in\n");
        } else {
            System.out.printf("test not ok TOTO is not in\n");
        }


        t.ajoute(new Objet1("toto"));

        System.out.print("max:");
        int tmax[] = t.remplissageMax();
        System.out.printf("[pos:%d,max:%d]\n", tmax[0], tmax[1]);
    }

    private static void test1squareAkh() {
        System.out.printf("square 31**0: %d\n", Objet1.square(31,0));
        System.out.printf("square 31**1: %d\n", Objet1.square(31,1));
        System.out.printf("square 3**3: %d\n", Objet1.square(3,3));
        System.out.printf("square 4**2: %d\n", Objet1.square(4,2));
    }

    public static void test1akh() {
        System.out.print("test1akh ");
        System.out.print("coucou " + new Objet1("coucou").hash()+" ");
        System.out.println("end");
    }

  /* Cette fonction vérifie que les fonctions de hash se comportent bien de la
   * manière attendue. */
  public static void test1a() {
    System.out.print("test1a ");

    System.out.print(new Objet1("").hash()+" ");
    System.out.print(new Objet1("coucou").hash()+" ");
    System.out.print(new Objet1("Quelques tests").hash()+" ");
    System.out.print(new Objet1("pour s'assurer").hash()+" ");
    System.out.print(new Objet1("que votre fonction").hash()+" ");
    System.out.print(new Objet1("donne la bonne").hash()+" ");
    System.out.print(new Objet1("sortie").hash()+" ");

    System.out.println("end");
  }


  public static void testHashbAkH() {
        System.out.print(new Objet2("coucou").hash() + " valid is 1544958309\n");
    }

  public static void testHashAkH() {
        System.out.print(new Objet1("bonjour").hash() + " valid is -1354586272\n");
        System.out.print(new Objet1("coucou").hash() + " valid is -1354586272\n");
        System.out.print(new Objet1("Bonjour Coursera").hash() + " valid is -1895827609\n");
    }
  public static void test1b() {
    System.out.print("test1b ");

    System.out.print(new Objet2("").hash()+" ");
    System.out.print(new Objet2("coucou").hash()+" ");
    System.out.print(new Objet2("Quelques tests").hash()+" ");
    System.out.print(new Objet2("pour s'assurer").hash()+" ");
    System.out.print(new Objet2("que votre fonction").hash()+" ");
    System.out.print(new Objet2("donne la bonne").hash()+" ");
    System.out.print(new Objet2("sortie").hash()+" ");

    System.out.println("end");
  }

  /* Cette fonction vérifie votre implémentation des listes. */
  public static void test2() {
    System.out.print("test2 ");
    Liste l = new Liste();
    Objet o = new Objet2("1");
    l.ajouteTete(o);
    System.out.print(l.longueur()+" ");
    l.ajouteTete(new Objet2("2")).ajouteTete(new Objet2("3"));
    System.out.print(l.contient(o)+" ");
    System.out.print(l.longueur()+" ");
    System.out.print(l.contient(new Objet2("4"))+" ");
    System.out.print(l.contient(new Objet2("2"))+" ");
    System.out.print(l.supprimeTete().longueur()+" ");
    System.out.print(l.contient(new Objet2("3"))+" ");
    System.out.print(l.contient(o)+" ");
    try {
       System.out.print("1 ");
       l.supprimeTete();
       System.out.print(l.longueur()+" ");
       System.out.print("2 ");
       l.supprimeTete();
       System.out.print(l.longueur()+" ");
       System.out.print("3 ");
       l.supprimeTete();
       System.out.print("4 ");
    } catch (NoSuchElementException e) {
       System.out.print("5 ");
       System.out.print(l.longueur()+" ");
    } catch (Exception e) {
       System.out.print("6 ");
       System.out.print(l.longueur()+" ");
    }
    l.ajouteTete(new Objet2("5"));
    System.out.print(l.longueur()+" ");
    System.out.print(l.contient(new Objet2("5"))+" ");
    System.out.println("end");
  }

  /* Cette fonction vérifie votre gestion des collisions. Ces deux chaînes ont
   * quelque chose de particulier. Quoi donc ? */
  public static void test3() {
    System.out.print("test3 ");
    TableDeHachage t = new TableDeHachage(10);
    t.ajoute(new Objet1("FB"));
    System.out.print(t.contient(new Objet1("Ea")));
    System.out.println(" end");
  }

  /* Cette fonction vérifie que la table de hachage se comporte de la manière
   * attendue, en générant des chaînes aléatoires, et en les ajoutant
   * successivement dans la table de hachage. Cette fonction utilise Objet2,
   * avec une fonction de hash déjà écrite, pour ne pas vous pénaliser si vous
   * n'avez pas réussi à faire la partie 1. */
  public static void test4() {
    System.out.print("test4 ");
    TableDeHachage t = new TableDeHachage(3000);
    for (int i = 0; i < 1500; i++) {
       t.ajoute(new Objet3("chaine"+Prng.next()));
    }
    System.out.print(t.contient(new Objet3(""))+" ");
    System.out.print(t.contient(new Objet3("chaine"))+" ");
    System.out.print(t.contient(new Objet3("eniach"))+" ");
    System.out.print(t.contient(new Objet3("chaine877819790"))+" ");
    System.out.print(t.contient(new Objet3("chaine878197790"))+" ");
    System.out.print(t.contient(new Objet3("chaine1517273377"))+" ");
    System.out.print(t.contient(new Objet3("chaine1172753377"))+" ");
    System.out.print(t.contient(new Objet3("chaine1462863342"))+" ");
    System.out.print(t.contient(new Objet3("chaine1628643342"))+" ");
    System.out.print(t.contient(new Objet3("chaine1715469037"))+" ");
    int[] remplissage = t.remplissageMax();
    assert remplissage.length == 2;
    System.out.println(remplissage[0] + " " + remplissage[1] + " end");
  }

}

class Prng {
  static int seed = 1;
  static int m = 2147483647;
  static int a = 16807;
  static int b = 0;

  static int next() {
    seed = (int) ((((long) seed) * a + b) % m);
    return seed;
  }
}
