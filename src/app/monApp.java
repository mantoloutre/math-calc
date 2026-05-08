package app;

import app.pages.*;

import java.awt.*;
import javax.swing.*;

/**
 * Interface principale de l'application.
 *
 * @author mantoloutre
 */
public class monApp {

    public static void main(String[] args) {
        //config fenetre
        JFrame fenetre = new JFrame("Mon projet");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocationRelativeTo(null); // Centre la fenêtre à l'écran
        //organisation page
        CardLayout cl = new CardLayout();
        JPanel conteneur = new JPanel(cl);
        conteneur.add(new PageMenu(cl, conteneur), "menu");
        conteneur.add(new PageVecteur(cl, conteneur), "norme");
        conteneur.add(new PageCalculK(cl, conteneur), "k");
        conteneur.add(new PageCalculKTriangle(cl, conteneur), "Kt");
        conteneur.add(new PageTrouveVecteur2Pts(cl, conteneur), "vecteur2Pts");
        conteneur.add(new PageCalculRotationAngle(cl, conteneur), "calcRotation");
        conteneur.add(new PageTrouverPointAvecNorme(cl, conteneur), "pointNorme");
        conteneur.add(new PageTrouverPointAvecVecteur(cl, conteneur), "PointVecteur");
        conteneur.add(new PageCalculProduitScalaire(cl, conteneur), "calculProdScalaire");
        conteneur.add(new PageCalculProduitScalaireAngle(cl, conteneur), "calculProdScalAngle");
        conteneur.add(new PageCalculVecteur(cl, conteneur), "calcVecteur");
        fenetre.add(conteneur);
        fenetre.setVisible(true);
    }
}