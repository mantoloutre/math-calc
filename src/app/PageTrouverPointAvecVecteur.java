package app;

import java.awt.*;
import javax.swing.*;

/**
 * classe qui représente la page pour trouver un point a partir d'un point de
 * base et d'un vecteur
 * 
 * @author mantoloutre
 */
public class PageTrouverPointAvecVecteur extends PageDeBase {
    private JTextField cX, cY, cVX, cVY;
    private JLabel lblResultat;

    /**
     * constructeur de la page qui sert a trouver un point avec un point de base et
     * un vecteur
     * 
     * @param cl        le gestionnaire des pages qui permet l'affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageTrouverPointAvecVecteur(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        this.cX = ajouterChamp("X du point de base:");
        this.cY = ajouterChamp("Y du point de base:");
        this.cVX = ajouterChamp("X du vecteur:");
        this.cVY = ajouterChamp("Y du vecteur:");
        this.lblResultat = new JLabel("Résultat: ---");
        JButton btnCalculer = new JButton("calculer point");
        this.add(btnCalculer);
        this.add(lblResultat);
        btnCalculer.addActionListener(e -> {
            try {
                Point p1 = new Point(trDouble(cX.getText()), trDouble(cY.getText()));
                Vecteur v1 = new Vecteur(trDouble(cVX.getText()), trDouble(cVY.getText()));
                Point pResultat = new Point(p1, v1);
                lblResultat.setText("(x = " + pResultat.getX() + " ; y = " + pResultat.getY() + " )");
            } catch (NumberFormatException ex) {
                lblResultat.setText("erreur, chiffre invalide!");
            }
        });
        ajouterBoutonRetour();
    }
}
