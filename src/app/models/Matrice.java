package app.models;

/**
 * classe pour représenter une matrice
 * <p>matrice 2x2</p>
 * matrice : {{a,b},{c,d}}
 * ou
 * matrice : {a,b,c,d}
 *
 * @author mantoloutre
 */
public class Matrice {
    private double a, b, c, d;

    /**
     * constructeur pour faire une matrice a partir d'un
     * tableau a deux dimension
     *
     * @param matrice le tableau a deux dimension
     *                contenant les éléments de la matrice
     */
    public Matrice(double[][] matrice) {
        setA(matrice[0][0]);
        setB(matrice[0][1]);
        setC(matrice[1][0]);
        setD(matrice[1][1]);
    }

    /**
     * constructeur pour faire une matrice avec les 4 éléments
     * de la matrices
     * matrice : {{a,b},{c,d}}
     *
     * @param a le a dans la matrice
     * @param b le b dans la matrice
     * @param c le c dans la matrice
     * @param d le d dans la matrice
     */
    public Matrice(double a, double b, double c, double d) {
        setA(a);
        setB(b);
        setC(c);
        setD(d);
    }

    /**
     * constructeur pour faire une matrice avec un tableau a une
     * dimension
     * matrice : {{a,b},{c,d}}
     *
     * @param matrice matrice a une dimension comme ce
     *                qui suis: {a,b,c,d}
     */
    public Matrice(double[] matrice) {
        setA(matrice[0]);
        setB(matrice[1]);
        setC(matrice[2]);
        setD(matrice[3]);
    }

    /**
     * faire une addition a partir de deux matrices
     *
     * @param m1 premiere matrice
     * @param m2 deuxieme matrice
     * @return retourne une nouvelle matrice qui est l'addition
     * des deux matrices
     */
    public static Matrice calcAddition(Matrice m1, Matrice m2) {
        return new Matrice(m1.getA() + m2.getA(), m1.getB() + m2.getB(),
                m1.getC() + m2.getC(), m1.getD() + m2.getD());
    }

    /**
     * faire une soustraction a partir de deux matrices
     *
     * @param m1 premiere matrice
     * @param m2 deuxieme matrice
     * @return une nouvelle matrice qui est la
     * soustraction des deux matrices
     */
    public static Matrice calcSoustraction(Matrice m1, Matrice m2) {
        return new Matrice(m1.getA() - m2.getA(), m1.getB() - m2.getB(),
                m1.getC() - m2.getC(), m1.getD() - m2.getD());
    }

    /**
     * faire une multiplication avec deux matrices
     *
     * @param m1 premiere matrice
     * @param m2 deuxieme matrice
     * @return une nouvelle matrice qui est le résultat
     * de la multiplication de la matrice m1 et m2
     */
    public static Matrice calcMultiplication(Matrice m1, Matrice m2) {
        return new Matrice((m1.getA() * m2.getA() + m1.getB() * m2.getC()),
                (m1.getA() * m2.getB() + m1.getB() * m2.getD()),
                (m1.getC() * m2.getA() + m1.getD() * m2.getC()),
                (m1.getC() * m2.getB() + m1.getD() * m2.getD()));
    }

    /**
     * méthode pour faire genre : 2 fois la matrice A
     *
     * @param scalaire le nombre de fois
     * @param m        la matrice
     * @return retourne une nouvelle matrice qui est le résultat du calcul
     */
    public static Matrice calcMultiplication(double scalaire, Matrice m) {
        return new Matrice((m.getA() * scalaire),
                (m.getB() * scalaire),
                (m.getC() * scalaire),
                (m.getD() * scalaire));
    }

    /**
     * calcule la division avec deux matrice
     * <p>matrice m1 divisé par matrice m2</p>
     *
     * @param m1 la premiere matrice
     * @param m2 la deuxieme matrice
     * @return retourne une matrice résultant de la division
     */
    public static Matrice calcDivision(Matrice m1, Matrice m2) {
        return calcMultiplication(m1, inverserMatrice(m2));
    }

    /**
     * Calcule l'inverse d'une matrice
     *
     * @param matrice la matrice don on veut calculer l'inverse
     * @return nouvelle matrice qui est l'inverse de celle mit
     * en parametre
     * @throws ArithmeticException lance cette exception pour
     *                             éviter une division par 0 si le déterminant de la
     *                             matrice est égal a 0
     */
    public static Matrice inverserMatrice(Matrice matrice) throws ArithmeticException {
        double detMatrice = calcDetMatrice(matrice);
        if (detMatrice == 0) {
            throw new ArithmeticException(
                    "Impossible d'inverser : le déterminant est nul");
        }
        return new Matrice(
                matrice.getD() / detMatrice,
                -matrice.getB() / detMatrice,
                -matrice.getC() / detMatrice,
                matrice.getA() / detMatrice
        );
    }

    /**
     * calcule le déterminant de la matrice
     *
     * @param matrice la matrice dont on veut calculer le
     *                déterminant
     * @return retourne le déterminant
     */
    public static double calcDetMatrice(Matrice matrice) {
        return (matrice.getA() * matrice.getD()) - (matrice.getC() * matrice.getB());
    }


    public double getA() {
        return this.a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }
}
