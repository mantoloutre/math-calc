package app.pages;

import app.models.Vecteur;

import java.awt.*;
import javax.swing.*;

/**
 * page pour calculer le vecteur
 * 
 * @author mantoloutre
 */
public class PageVecteur extends PageDeBase {
    private JTextField champX;
    private JTextField champY;
    private JLabel lblResultat;

    /**
     * constructeur de la page pour calculer le vecteur
     * 
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageVecteur(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        this.champX = ajouterChamp("Vecteur X :");
        this.champY = ajouterChamp("Vecteur Y :");
        this.lblResultat = new JLabel("Résultat : ---");

        JButton btnCalculer = new JButton("Calculer Norme");

        this.add(btnCalculer);
        this.add(lblResultat);
        ajouterBoutonRetour();

        // Logique de calcul
        btnCalculer.addActionListener(e -> {
            try {
                Vecteur v = new Vecteur(trDouble(champX.getText()), trDouble(champY.getText()));
                lblResultat.setText(String.format("Norme : %.2f", v.calculerNorme()));
            } catch (NumberFormatException ex) {
                lblResultat.setText("Erreur !");
            }
        });
    }
}