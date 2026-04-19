package app;

import java.awt.*;
import javax.swing.*;

/**
 * <p>
 * objet qui représente la page pour faire le calcul de rotation d'un point
 * avec un angle
 * <p>
 * <p>
 * possiblement ajouter possibiliter d'ajouter avec un triangle plus tard
 * </p>
 * 
 * @author mantoloutre
 */
public class PageCalculRotationAngle extends PageDeBase {
    private JTextField x, y, pX, pY, rotation;
    private JLabel lblResultat;

    /**
     * constructeur de la page pour calculer un point avec un angle de rotation
     * 
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageCalculRotationAngle(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        this.x = ajouterChamp("le X du point :");
        this.y = ajouterChamp("le Y du point :");
        this.pX = ajouterChamp("le X du point pivot :");
        this.pY = ajouterChamp("le Y du point pivot");
        this.rotation = ajouterChamp("l'angle de rotation :");
        this.lblResultat = new JLabel("Résultat : ---");
        JButton btnCalculer = new JButton("Calculer Rotation");
        this.add(btnCalculer);
        this.add(lblResultat);
        ajouterBoutonRetour();
        btnCalculer.addActionListener(e -> {
            try {
                Point p1 = new Point(Double.parseDouble(x.getText()), Double.parseDouble(y.getText()));
                Point res = p1.calculRotation(Double.parseDouble(rotation.getText()), Double.parseDouble(pX.getText()),
                        Double.parseDouble(pY.getText()));
                lblResultat.setText(String.format("nouveau : (%.2f ; %.2f)", res.getX(), res.getY()));
            } catch (NumberFormatException ex) {
                lblResultat.setText("Erreur !");
            }
        });
    }
}
