package app.pages;

import java.awt.*;
import javax.swing.*;

public class PageMenu extends PageDeBase {

    public PageMenu(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);

        // 1. Ajout du titre au sommet du panneau
        JLabel titre = new JLabel("Menu Principal - Calculs Mathématiques");
        titre.setFont(new Font("Arial", Font.BOLD, 18));
        titre.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.panneauCentre.add(titre);

        // Espace vide entre le titre et le premier bouton
        this.panneauCentre.add(Box.createVerticalStrut(20));

        // 2. Initialisation de tes 10 boutons originaux
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

        // 3. Application du style et ajout au panneau
        JButton[] tousLesBoutons = {
                btnVecteur, btnK, btnKT, btnTV, btnRt,
                btnPAN, btnPAV, btnPS, btnPSA, btnPageAV
        };

        for (JButton b : tousLesBoutons) {
            stylerBouton(b);
            b.setMaximumSize(new Dimension(400, 40));
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.panneauCentre.add(b);

            // Espace de 10 pixels entre chaque bouton
            this.panneauCentre.add(Box.createVerticalStrut(10));
        }

        // 4. Tes actions de navigation originales
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
    }
}