package app;

/**
 * <p>
 * Classe qui représente un vecteur mathématique en 2D.
 * </p>
 * <p>
 * Elle permet de stocker les coordonnées et de calculer la norme.
 * </p>
 * 
 * @author mantoloutre
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
     * constructeur pour creer un vecteur avec deux objet points
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
     * méthode pour calculer la norme a partir de deux point directement
     * 
     * @param p1 le premier point
     * @param p2 le deuxième point
     * @return retourne la norme calculer a partir des deux points
     */
    public static double calculerNorme(Point p1, Point p2) {
        return (new Vecteur(p1, p2)).calculerNorme();
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

    /**
     * méthode pour calculer le produit scalaire avec 2 vecteur
     * 
     * @param v1 le premier vecteur
     * @param v2 le deuxième vecteur
     * @return retourne le produit scalaire
     */
    public static double calculProduitScalaire(Vecteur v1, Vecteur v2) {
        return (v1.getX() * v2.getX()) + (v1.getY() * v2.getY());
    }

    /**
     * méthode pour calculer le produit scalaire avec les deux normes et l'angle
     * entre les normes.
     * 
     * @param norme1      la longueur de la première norme
     * @param norme2      la longueur de la deuxième norme
     * @param angleDegree l'angle en degree
     * @return retour le produit scalaire
     */
    public static double calculProduitScalaireAngle(double norme1, double norme2, double angleDegree) {
        double angleRad = Math.toRadians(angleDegree);
        return (norme1 * norme2) * Math.cos(angleRad);
    }

    /**
     * méthode pour calculer l'addition avec 2 vecteur
     * 
     * @param v1 représente le premier vecteur
     * @param v2 représente le deuxième vecteur
     * @return retourne un nouveau vecteur qui est le résultat de l'addition des
     *         deux vecteurs
     */
    public static Vecteur additionVecteur(Vecteur v1, Vecteur v2) {
        return new Vecteur(v1.getX() + v2.getX(), v1.getY() + v2.getY());
    }

    /**
     * méthode pour calculer la multiplication d'un vecteur
     * 
     * @param nb représente le nombre par lequel on veut multiplier le vecteur
     * @param v  le vecteur en question que l'on veut multiplier par lui même
     * @return retourne un nouveau vecteur qui est le résultat de la multiplication
     */
    public static Vecteur multiVecteur(double nb, Vecteur v) {
        return new Vecteur(v.getX() * nb, v.getY() * nb);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}