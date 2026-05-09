package app.pages;

import java.awt.*;
import javax.swing.*;

/**
 * classe qui représente la page du menu
 *
 * @author mantoloutre
 */
public class PageMenu extends PageDeBase {
    /**
     * constructeur de la page qui sert a trouver un point avec un point de base et
     * un vecteur
     *
     * @param cl        le gestionnaire des pages qui permet l'affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageMenu(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        JLabel titre = new JLabel("Menu Principal");
        titre.setFont(new Font("Arial", Font.BOLD, 18));
        titre.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.panneauCentre.add(titre);
        this.panneauCentre.add(Box.createVerticalStrut(20));
        JButton btnVecteur = new JButton("calcul norme");
        JButton btnK = new JButton("Calcul de K");
        JButton btnKT = new JButton("Calcul de K triangle");
        JButton btnTV = new JButton("trouver vecteur 2 points");
        JButton btnRt = new JButton("calculer rotation point angle");
        JButton btnPAN = new JButton("trouver point avec norme");
        JButton btnPAV = new JButton("trouver point avec vecteur");
        JButton btnPS = new JButton("Calcul produit scalaire avec 2 vecteurs");
        JButton btnPSA = new JButton("Calcul produit scalaire avec normes/angle");
        JButton btnPageAV = new JButton("Calcul concernant les vecteurs");
        JButton btnPCM = new JButton("Calcul concernant les matrices");
        JButton[] tousLesBoutons = {
                btnVecteur, btnK, btnKT, btnTV, btnRt,
                btnPAN, btnPAV, btnPS, btnPSA, btnPageAV, btnPCM
        };

        for (JButton b : tousLesBoutons) {
            stylerBouton(b);
            b.setMaximumSize(new Dimension(400, 40));
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.panneauCentre.add(b);
            //espace entre les boutons
            this.panneauCentre.add(Box.createVerticalStrut(5));
        }
        btnVecteur.addActionListener(e -> cl.show(conteneur, "norme"));
        btnK.addActionListener(e -> cl.show(conteneur, "k"));
        btnKT.addActionListener(e -> cl.show(conteneur, "Kt"));
        btnTV.addActionListener(e -> cl.show(conteneur, "vecteur2Pts"));
        btnRt.addActionListener(e -> cl.show(conteneur, "calcRotation"));
        btnPAN.addActionListener(e -> cl.show(conteneur, "pointNorme"));
        btnPAV.addActionListener(e -> cl.show(conteneur, "PointVecteur"));
        btnPS.addActionListener(e -> cl.show(conteneur, "calculProdScalaire"));
        btnPSA.addActionListener(e -> cl.show(conteneur, "calculProdScalAngle"));
        btnPageAV.addActionListener(e -> cl.show(conteneur, "calcVecteur"));
        btnPCM.addActionListener(e -> cl.show(conteneur, "calcMatrice"));
    }
}