package app;

import java.awt.*;
import javax.swing.*;
/**
 * classe qui représente la page pour trouver un point avec un norme
 */
public class PageTrouverPointAvecNorme extends PageDeBase {
    private JTextField cX, cY, norme;
    private JLabel lblResultat;
    /**
     * documentation a faire
     * @param cl documentation a faire
     * @param conteneur documentation a faire
     */
    public PageTrouverPointAvecNorme(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        this.cX = ajouterChamp("X du point d'origine:");
        this.cY = ajouterChamp("Y du point d'origine:");
        this.norme = ajouterChamp("Norme:");
        this.lblResultat = new JLabel("Résultat: ---");
        JButton btnCalculer = new JButton("Calculer nouveau point");
        this.add(lblResultat);
        this.add(btnCalculer);
        ajouterBoutonRetour();
        btnCalculer.addActionListener(e -> {
            try {
                Point p1 = new Point(Double.parseDouble(cX.getText()), Double.parseDouble(cY.getText()));
                //Point pResultat = new Point(p1, Vecteur.p)
            } catch (NumberFormatException ex) {
                lblResultat.setText("Erreur !");
            }
        });
    }
}
