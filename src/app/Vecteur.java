package app;

/**
 * <p>
 * Classe qui représente un vecteur mathématique en 2D.
 * </p>
 * <p>
 * Elle permet de stocker les coordonnées et de calculer la norme.
 * </p>
 * * @author mantoloutre
 */
public class Vecteur {
    private final double x;
    private final double y;

    /**
     * Constructeur pour créer un nouveau vecteur.
     * 
     * @param x La coordonnée horizontale
     * @param y La coordonnée verticale
     */
    public Vecteur(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * constructeur pour calculer la norme avec 2 point
     * 
     * @param p1 premier objet point
     * @param p2 deuxieme objet point
     */
    public Vecteur(Point p1, Point p2) {
        this.x = p2.getX() - p1.getX();
        this.y = p2.getY() - p1.getY();
    }

    /**
     * méthode pour trouver le vecteur ( le déplacement, avec le x et le y de deux
     * points)
     * 
     * @param x1 le x du premier point
     * @param y1 le y du premier point
     * @param x2 le x du deuxième point
     * @param y2 le y du deuxième point
     * @return retourne le vecteur du déplacement
     */
    public static Vecteur creerDepuisPoints(double x1, double y1, double x2, double y2) {
        return new Vecteur(x2 - x1, y2 - y1);
    }

    /**
     * Calcule la longueur (norme) du vecteur.
     * peut aussi être utiliser par d'autre classe pour éviter de devoir la reécrire
     * à chaque fois.
     * Formule : racine carrée de (x^2 + y^2).
     * 
     * @return retourne la norme du vecteur
     */
    public static double calculerNorme(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
     * calculer la longueur norme ( cette méthode est pour les objet de type vecteur
     * )
     * 
     * @return retourne la norme du vecteur
     */
    public double calculerNorme() {
        return calculerNorme(this.x, this.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}