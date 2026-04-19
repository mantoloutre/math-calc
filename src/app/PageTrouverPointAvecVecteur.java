package app;

import java.awt.*;
import javax.swing.*;

/**
 * documentation a faire
 * 
 * @author mantoloutre
 */
public class PageTrouverPointAvecVecteur extends PageDeBase {
    private JTextField cX, cY, cVX, cVY;
    private JLabel lblResultat;

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
