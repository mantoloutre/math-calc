package app;

import javax.swing.*;
import java.awt.*;

/**
 * Interface principale de mon application.
 * Centralise les outils de calcul pour le cours de mathématiques.
 * * @author mantoloutre
 */
public class monApp {

    public static void main(String[] args) {
        // --- configuration ---
        JFrame fenetre = new JFrame("Mon projet");
        fenetre.setSize(600, 400);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // organisation des pages
        CardLayout cl = new CardLayout();
        // conteneur qui contient toutes les pages
        JPanel conteneur = new JPanel(cl);

        // page menu
        JPanel pageMenu = new JPanel();
        pageMenu.setBackground(Color.LIGHT_GRAY);
        JButton btnVecteur = new JButton("calcul norme");
        JButton btnK = new JButton("Calcul de K");
        JButton btnKT = new JButton("Calcul de K triangle");
        JButton btnTV = new JButton("trouver vecteur 2 points");
        pageMenu.add(btnVecteur);
        pageMenu.add(btnK);
        pageMenu.add(btnKT);
        pageMenu.add(btnTV);

        // ajoute des pages dans le conteneur
        conteneur.add(pageMenu, "menu");
        conteneur.add(new pageVecteur(cl, conteneur), "norme");
        conteneur.add(new PageCalculK(cl, conteneur), "k");
        conteneur.add(new pageCalculKTriangle(cl, conteneur), "Kt");
        conteneur.add(new pageTrouveVecteur2Pts(cl, conteneur), "vecteur2Pts");

        // navigation du menu
        btnVecteur.addActionListener(e -> cl.show(conteneur, "norme"));
        btnK.addActionListener(e -> cl.show(conteneur, "k"));
        btnKT.addActionListener(e -> cl.show(conteneur, "Kt"));
        btnTV.addActionListener(e -> cl.show(conteneur, "vecteur2Pts"));

        fenetre.add(conteneur);
        fenetre.setVisible(true);
    }
}