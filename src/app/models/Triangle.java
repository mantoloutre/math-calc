package app.models;

/**
 * classe qui représente un objet de type triangle.
 * cette classe contient aussi divers méthode pour faire des calculs avec les
 * triangles
 * 
 * @author mantoloutre
 */
public class Triangle {
    private double coterA;
    private double coterB;
    private double coterC;

    /**
     * getter pour la longueur de la base dans un triangle rectangle
     * 
     * @return retourne la longueur de la base
     */
    public double getBase() {
        return this.coterA;
    }

    /**
     * getter pour la longueur de la hauteur dans un triangle rectangle
     * 
     * @return retourne la longueur de la hauteur
     */
    public double getHauteur() {
        return this.coterB;
    }

    /**
     * getter pour la longueur de l'hypothénuse dans un triangle rectangle
     * 
     * @return retourne la longueur de l'hypothénuse
     */
    public double getHypo() {
        return this.coterC;
    }

    /**
     * setter pour le coter A ( ou la base pour un triangle rectangle )
     * 
     * @param coterA la longueur du coter
     */
    public void setCoterA(double coterA) {
        this.coterA = coterA;
    }

    /**
     * getter pour le coter A ( ou la base pour un triangle rectangle )
     * 
     * @return retourne la longueur du coter A
     */
    public double getCoterA() {
        return this.coterA;
    }

    /**
     * setter pour le coter B ( ou la hauteur dans un triangle rectangle )
     * 
     * @param coterB la longueur de la hauteur
     */
    public void setCoterB(double coterB) {
        this.coterB = coterB;
    }

    public double getCoterB() {
        return this.coterB;
    }

    /**
     * méthode pour set le coter C ( ne s'applique par pour un triangle rectangle )
     * 
     * @param coterC la longueur du coter C
     */
    public void setCoterC(double coterC) {
        this.coterC = coterC;
    }

    public double getCoterC() {
        return this.coterC;
    }

    /**
     * constructeur pour faire un triangle a partir de trois points
     * 
     * @param pA le premier point
     * @param pB le deuxième point
     * @param pC le troisième point
     */
    public Triangle(Point pA, Point pB, Point pC) {
        this.coterA = Vecteur.calculerNorme(pB, pC);
        this.coterB = Vecteur.calculerNorme(pA, pC);
        this.coterC = Vecteur.calculerNorme(pA, pB);
    }

    /**
     * constructeur pour faire un triangle sachant que l'hypothénuse est calculer
     * automatiquement
     * 
     * <h3>triangle rectangle uniquement!</h3>
     * 
     * @param base    base du triangle
     * @param hauteur hauteur du triangle
     */
    public Triangle(double base, double hauteur) {
        this.coterA = base;
        this.coterB = hauteur;
        this.coterC = Vecteur.calculerNorme(base, hauteur);
    }

    /**
     * méthode pour calculer la différence de grosseur ( k ) avec deux triangles
     * 
     * @param t1 le premier triangle
     * @param t2 le deuxième triangle
     * @return retourne le rapport de grosseur
     */
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
        double p = (t1.getCoterA() + t1.getCoterB() + t1.getCoterC()) / 2.0;
        return Math.sqrt(p * (p - t1.getCoterA()) * (p - t1.getCoterB()) * (p - t1.getCoterC()));
    }

    /**
     * méthode pour calculer la longueur de chacun des côter d'un triangle
     * 
     * @param pA le premier point du triangle
     * @param pB le deuxième point du triangle
     * @param pC le troisième point du triangle
     * @return retourne un tableau contenant respectivement : la longueur du côter :
     *         A, B et C
     */
    public static double[] calculLongueur(Point pA, Point pB, Point pC) {
        // calculer la longueur de chacun des côté //
        double longA, longB, longC;
        longA = Vecteur.calculerNorme(pA, pB);
        longB = Vecteur.calculerNorme(pB, pC);
        longC = Vecteur.calculerNorme(pC, pA);
        return new double[]{ longA, longB, longC };
    }
}
