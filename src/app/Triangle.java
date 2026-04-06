package app;

/**
 * classe qui représente un objet de type triangle.
 * cette classe contient aussi divers méthode pour faire des calculs avec les
 * triangles
 * 
 * @author mantoloutre
 */
public class Triangle {
    private double base;
    private double hauteur;
    private final double hypo;

    public double getBase() {
        return this.base;
    }

    public double getHauteur() {
        return this.hauteur;
    }

    public double getHypo() {
        return this.hypo;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * constructeur pour faire un triangle sachant que l'hypothénuse est calculer
     * automatiquement
     * 
     * @param base    base du triangle
     * @param hauteur hauteur du triangle
     */
    public Triangle(double base, double hauteur) {
        this.base = base;
        this.hauteur = hauteur;
        this.hypo = Vecteur.calculerNorme(base, hauteur);
    }

    public static double kTriangle(Triangle t1, Triangle t2) {
        double resultK, resultK1, resultK2, resultK3;
        if (aireTriangle(t1) >= aireTriangle(t2)) {
            resultK1 = t1.getBase() - t2.getBase();
            resultK2 = t1.getHauteur() - t2.getHauteur();
            resultK3 = t1.getHypo() - t2.getHypo();
        } else {
            resultK1 = t2.getBase() - t1.getBase();
            resultK2 = t2.getHauteur() - t1.getHauteur();
            resultK3 = t2.getHypo() - t1.getHypo();
        }
        if (resultK1 == resultK2 &&
                resultK1 == resultK3 &&
                resultK2 == resultK3) {
            resultK = resultK1;
        } else {
            resultK = -1;
        }
        return resultK;
    }

    /**
     * méthode pour calculer l'aire d'un triangle
     * 
     * @param t1 le triangle dont on veut calculer l'aire
     * @return ( base x hauteur ) / 2 qui représente l'aire
     */
    public static double aireTriangle(Triangle t1) {
        return (t1.getBase() * t1.getHauteur()) / 2;
    }

}
