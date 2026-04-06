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
     * méthode pour calculer la mesure de différence ( le K ).
     * les deux rectangles doivent obligatoirement être semblable ( pareil, juste
     * différente taille )
     * 
     * @param rect1 rectangle 1
     * @param rect2 rectangle 2
     * @return retourne la valeur K si le K des largeurs et longueurs est identique,
     *         sinon ca veut dire que les rectangles ne sont pas semblable et ca
     *         retourne -1 dans ce cas
     */
    public static double kRectangle(Rectangle rect1, Rectangle rect2) {
        double resultK, resultK1, resultK2;
        if (calculAir(rect1) >= calculAir(rect2)) {
            resultK1 = rect1.getLargeur() / rect2.getLargeur();
            resultK2 = rect1.getLongueur() / rect2.getLargeur();
        } else {
            resultK1 = rect2.getLargeur() / rect1.getLargeur();
            resultK2 = rect2.getLongueur() / rect1.getLongueur();
        }
        if (resultK1 == resultK2) {
            resultK = resultK1;
        } else {
            resultK = -1;
        }
        return resultK;
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
