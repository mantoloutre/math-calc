package app;

import app.pages.*;

import java.awt.*;
import javax.swing.*;

/**
 * interface principale de l'application
 * 
 * @author mantoloutre
 */
public class monApp {

    public static void main(String[] args) {
        // --- configuration ---
        JFrame fenetre = new JFrame("Mon projet");
        fenetre.setSize(800, 600);
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
        JButton btnRt = new JButton("calculer rotation point angle");
        JButton btnPAN = new JButton("trouver point avec norme");
        JButton btnPAV = new JButton("trouver point avec vecteur");
        JButton btnPS = new JButton("Calcul produit scalaire avec 2 vecteurs");
        JButton btnPSA = new JButton("Calcul produit scalaire avec normes/angle");
        JButton btnPageAV = new JButton("Calcul concernant les vecteurs");
        pageMenu.add(btnVecteur);
        pageMenu.add(btnK);
        pageMenu.add(btnKT);
        pageMenu.add(btnTV);
        pageMenu.add(btnRt);
        pageMenu.add(btnPAN);
        pageMenu.add(btnPAV);
        pageMenu.add(btnPS);
        pageMenu.add(btnPSA);
        pageMenu.add(btnPageAV);

        // ajoute des pages dans le conteneur
        conteneur.add(pageMenu, "menu");
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

        // navigation du menu
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
        fenetre.add(conteneur);
        fenetre.setVisible(true);
    }
}