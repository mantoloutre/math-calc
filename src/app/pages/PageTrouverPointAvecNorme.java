package app.pages;

import app.models.Point;

import java.awt.*;
import javax.swing.*;

/**
 * classe qui représente la page pour trouver un point avec un norme
 * 
 * @author mantoloutre
 */
public class PageTrouverPointAvecNorme extends PageDeBase {
    private JTextField cX, cY, norme, angleDegre;
    private JLabel lblResultat;

    /**
     * constructeur de la page pour trouver un point avec un point de départ et la
     * norme
     * 
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageTrouverPointAvecNorme(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        this.cX = ajouterChamp("X du point d'origine:");
        this.cY = ajouterChamp("Y du point d'origine:");
        this.norme = ajouterChamp("Norme:");
        this.angleDegre = ajouterChamp("angle en degré:");
        this.lblResultat = new JLabel("Résultat: ---");
        JButton btnCalculer = new JButton("Calculer nouveau point");
        this.add(lblResultat);
        this.add(btnCalculer);
        ajouterBoutonRetour();
        btnCalculer.addActionListener(e -> {
            try {
                Point p1 = new Point(trDouble(cX.getText()), trDouble(cY.getText()));
                Point pResultat = new Point(p1, trDouble(norme.getText()), trDouble(angleDegre.getText()));
                lblResultat.setText("X : " + pResultat.getX() + " Y : " + pResultat.getY());
            } catch (NumberFormatException ex) {
                lblResultat.setText("Erreur !");
            }
        });
    }
}
