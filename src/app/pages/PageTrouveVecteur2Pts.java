package app.pages;

import app.models.Point;
import app.models.Vecteur;

import java.awt.*;
import javax.swing.*;

/**
 * cette classe représente l'objet de la page pour trouver le vecteur a partir
 * de 2 points
 * 
 * @author mantoloutre
 */
public class PageTrouveVecteur2Pts extends PageDeBase {
    private final JTextField cX1, cY1, cX2, cY2;
    private final JLabel lblResultat, lblNorme;

    /**
     * constructeur de la page qui sert a trouver le vecteur a partie de deux points
     * 
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageTrouveVecteur2Pts(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        // ajouter les fields + faire la méthode pour rendre ca plus simple //
        this.cX1 = ajouterChamp("x du point 1 :");
        this.cX1.setToolTipText("x du point de départ");
        this.cY1 = ajouterChamp("y du point 1 :");
        this.cY1.setToolTipText("y du point de départ");
        this.cX2 = ajouterChamp("x du point 2 :");
        this.cX2.setToolTipText("x du point d'arrivé");
        this.cY2 = ajouterChamp("y du point 2 :");
        this.cY2.setToolTipText("y du point d'arrivé");
        // ajouter le JLabel qui va servir à afficher le résultat //
        this.lblResultat = new JLabel("Vecteur : ---");
        // ajouter le bouton qui va servir a faire le calcul //
        JButton btnCalculer = new JButton("Calculer Vecteur");
        // label pour la norme //
        this.lblNorme = new JLabel("Norme : ---");
        // tout ajouter au conteneur //
        this.add(btnCalculer);
        this.add(lblResultat);
        ajouterBoutonRetour();
        this.add(lblNorme);
        // ajouter le actionListener au bouton pour calculer la norme //
        btnCalculer.addActionListener(e -> {
            // utiliser un try catch au cas ou l'utilisateur ne met pas des données valides
            try {
                // créer les deux objets points //
                Point pt1 = new Point(trDouble(cX1.getText()), trDouble(cY1.getText()));
                Point pt2 = new Point(trDouble(cX2.getText()), trDouble(cY2.getText()));
                // on appelle le constructeur pour avoir le vecteur ( le déplacement ) //
                Vecteur res = new Vecteur(pt1, pt2);
                // on set le texte du lblResultat au résultat //
                lblResultat.setText("Vecteur : < " + res.getX() + " ; " + res.getY() + " >");
                // on set le texte du lblNorme a la norme //
                lblNorme.setText("Norme : " + res.calculerNorme());
            } catch (NumberFormatException ex) {
                // au cas ou l'utilisateur a entré des données invalides //
                lblResultat.setText("Donnée invalide!");
            }
        });
    }
}
