package app;

import java.awt.*;
import javax.swing.*;

/**
 * classe qui représente la page de calcul de produit scalaire avec 2 vecteur
 * 
 * @author mantoloutre
 */
public class PageCalculProduitScalaire extends PageDeBase {
    private JTextField cVX1, cVY1, cVX2, cVY2;
    private JLabel lblResultat;

    /**
     * constructeur de la page pour calculer le produit scalaire avec deux vecteur
     * 
     * @param cl        le gestionnaire des pages qui permet l'affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageCalculProduitScalaire(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        this.cVX1 = ajouterChamp("Vecteur 1 X:");
        this.cVY1 = ajouterChamp("Vecteur 1 Y:");
        this.cVX2 = ajouterChamp("Vecteur 2 X:");
        this.cVY2 = ajouterChamp("Vecteur 2 Y:");
        this.lblResultat = new JLabel("Résultat : ---");
        JButton btnCalculer = new JButton("calculer produit scalaire");
        this.add(lblResultat);
        this.add(btnCalculer);
        ajouterBoutonRetour();
        btnCalculer.addActionListener(e -> {
            try {
                Vecteur v1 = new Vecteur(trDouble(cVX1.getText()), trDouble(cVY1.getText()));
                Vecteur v2 = new Vecteur(trDouble(cVX2.getText()), trDouble(cVY2.getText()));
                double prodScalaire = Vecteur.calculProduitScalaire(v1, v2);
                lblResultat.setText("Produit Scalaire: " + prodScalaire);
            } catch (NumberFormatException ex) {
                lblResultat.setText("erreur, chiffre invalide!");
            }
        });
    }
}
