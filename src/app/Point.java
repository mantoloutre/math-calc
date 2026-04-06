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
