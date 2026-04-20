package app;

import java.awt.*;
import javax.swing.*;

/**
 * classe qui représente la page pour calculer le produit scalaire avec 2 normes
 * et l'angle entre les normes
 * 
 * @author mantoloutre
 */
public class PageCalculProduitScalaireAngle extends PageDeBase {
    private JTextField cN1, cN2, cAngle;
    private JLabel lblResultat;

    /**
     * constructeur de la page pour calculer le produit scalaire avec 2 normes et
     * l'angle entre les normes
     * 
     * @param cl        le gestionnaire des pages qui permet l'affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageCalculProduitScalaireAngle(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        this.cN1 = ajouterChamp("longueur norme 1:");
        this.cN2 = ajouterChamp("longueur norme 2:");
        this.cAngle = ajouterChamp("angle entre les normes:");
        this.cAngle.setToolTipText("angle en degree");
        this.lblResultat = new JLabel("Résultat : ---");
        JButton btnCalculer = new JButton("calculer produit scalaire");
        this.add(lblResultat);
        this.add(btnCalculer);
        ajouterBoutonRetour();
        btnCalculer.addActionListener(e -> {
            try {
                double norme1 = trDouble(cN1.getText());
                double norme2 = trDouble(cN2.getText());
                double angleDeg = trDouble(cAngle.getText());
                double prodScalaire = Vecteur.calculProduitScalaireAngle(norme1, norme2, angleDeg);
                lblResultat.setText("Produit Scalaire: " + prodScalaire);
            } catch (NumberFormatException ex) {
                lblResultat.setText("erreur, chiffre invalide!");
            }
        });
    }
}
