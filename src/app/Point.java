package app;

/**
 * cette classe représente un objet point
 * 
 * @author mantoloutre
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructeur par défaut pour faire un objet points
     * 
     * @param x le x du point
     * @param y le y du point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * méthode pour calculer la rotation d'un point avec un angle et son pivot
     * 
     * @param angleDegree l'angle du point par rapport au point pivot
     * @param xPivot      le x du point pivot
     * @param yPivot      le y du point pivot
     * @return retourne un nouveau point qui représente le point apres avoir
     *         effectuer la rotation
     */
    public Point calculRotation(double angleDegree, double xPivot, double yPivot) {
        double angleRad = Math.toRadians(angleDegree);
        double tempX = this.x - xPivot;
        double tempY = this.y - yPivot;
        double nouveauX = (tempX * Math.cos(angleRad)) - (tempY * Math.sin(angleRad));
        double nouveauY = (tempX * Math.sin(angleRad)) + (tempY * Math.cos(angleRad));
        return new Point(nouveauX, nouveauY);
    }

    /**
     * Crée un nouveau point à partir d'un point de départ et d'un déplacement.
     * 
     * @param depart      Le point initial
     * @param deplacement Le vecteur de déplacement
     */
    public Point(Point depart, Vecteur deplacement) {
        this.x = depart.getX() + deplacement.getX();
        this.y = depart.getY() + deplacement.getY();
    }

    /**
     * créer un nouveau point a partir d'un point de départ, de la longueur de la
     * norme et de l'angle de la norme par rapport au point que l'on recherche
     * 
     * @param depart
     * @param norme
     * @param angleDeg
     */
    public Point(Point depart, double norme, double angleDeg) {
        double angleRad = Math.toRadians(angleDeg);
        this.x = depart.getX() + (norme * Math.cos(angleRad));
        this.y = depart.getY() + (norme * Math.sin(angleRad));
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
