package app;

/**
 * cette classe représente le point que l'on est sur la carte
 * 
 * @author mantoloutre
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * méthode pour calculer la rotation d'un point sur un angle que l'on donne (
     * méthhode utile pour tout les angle)
     * 
     * @param angleDegree l'angle sur lequel on veut faire la rotation
     * @return retourne un objet point qui contient les nouvelles coordonné du point
     */
    public Point calculRotation(double angleDegree) {
        double angleRad = Math.toRadians(angleDegree);
        double nx = this.x * Math.cos(angleRad) - this.y * Math.sin(angleRad);
        double ny = this.x * Math.sin(angleRad) + this.y * Math.cos(angleRad);
        return new Point(nx, ny);
    }

    /**
     * Crée un nouveau point à partir d'un point de départ et d'un déplacement.
     * * @param depart Le point initial
     * 
     * @param deplacement Le vecteur de déplacement
     */
    public Point(Point depart, Vecteur deplacement) {
        this.x = depart.getX() + deplacement.getX();
        this.y = depart.getY() + deplacement.getY();
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
