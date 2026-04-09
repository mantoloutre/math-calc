package app;

/**
 * cette classe représente un objet de type rectangle.
 * cette classe contient aussi divers méthode utile aux calcul lier au rectangle
 * 
 * @author mantoloutre
 */
public class Rectangle {
    /** longueur du rectangle */
    private double longueur;
    /** largeur du rectangle */
    private double largeur;

    /**
     * constructeur par défaut pour faire un rectangle
     * 
     * @param longueur la longueur du rectangle
     * @param largeur  la largeur du rectangle
     */
    public Rectangle(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    /**
     * calcule la valeur manquante selon ce qui est fourni.
     * 
     * @param h1 Hauteur 1 (0 si inconnu)
     * @param l1 Largeur 1 (0 si inconnu)
     * @param h2 Hauteur 2 (0 si inconnu)
     * @param l2 Largeur 2 (0 si inconnu)
     * @param k  Rapport (0 si inconnu)
     * @return Un tableau de double contenant [h1, l1, h2, l2, k] complété
     */
    public static double[] calculerTout(double h1, double l1, double h2, double l2, double k) {
        if (k == 0 && h1 != 0 && h2 != 0) {
            // chercher le k
            k = h2 / h1;
        } else if (h2 == 0 && h1 != 0 && k != 0) {
            // chercher le rectangle 2
            h2 = h1 * k;
            l2 = l1 * k;
        } else if (h1 == 0 && h2 != 0 && k != 0) {
            // chercher le rectangle 1
            h1 = h2 / k;
            l1 = l2 / k;
        }
        return new double[] { h1, l1, h2, l2, k };
    }

    /**
     * cette méthode est pour calculer l'aire d'un rectangle
     * 
     * @param rectangle l'objet rectangle dont on veut calculer l'aire
     * @return retourne l'aire du rectangle
     */
    public static double calculAir(Rectangle rectangle) {
        return rectangle.getLargeur() * rectangle.getLongueur();
    }

    /**
     * cette méthode est pour calculer le périmètre d'un rectangle
     * 
     * @param rectangle l'objet rectangle dont on veut calculer le périmètre
     * @return retourne le périmètre du rectangle
     */
    public static double calculPerim(Rectangle rectangle) {
        return (rectangle.getLargeur() * 2) + (rectangle.getLongueur() * 2);
    }
}
