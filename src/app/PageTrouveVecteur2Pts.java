package app;

import java.awt.*;
import javax.swing.*;

/**
 * cette classe représente l'objet de la page pour trouver le vecteur a partir
 * de 2 points
 * 
 * @author mantoloutre
 */
public class PageTrouveVecteur2Pts extends PageDeBase {
    private JTextField cX1, cY1, cX2, cY2;
    private JLabel lblResultat;

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
        this.cY1 = ajouterChamp("y du point 1 :");
        this.cX2 = ajouterChamp("x du point 2 :");
        this.cY2 = ajouterChamp("y du point 2 :");
        // ajouter le JLabel qui va servir à afficher le résultat //
        this.lblResultat = new JLabel("Résultat : ---");
        // ajouter le bouton qui va servir a faire le calcul //
        JButton btnCalculer = new JButton("Calculer norme");
        // tout ajouter au conteneur //
        this.add(btnCalculer);
        this.add(lblResultat);
        ajouterBoutonRetour();
        // ajouter le actionListener au bouton pour calculer la norme //
        btnCalculer.addActionListener(e -> {
            // utiliser un try catch au cas ou l'utilisateur ne met pas des données valides
            try {
                // créer les deux objets points //
                Point pt1 = new Point(Double.parseDouble(cX1.getText()), Double.parseDouble(cY1.getText()));
                Point pt2 = new Point(Double.parseDouble(cX2.getText()), Double.parseDouble(cY2.getText()));
                // on appelle le constructeur pour avoir le vecteur ( le déplacement ) //
                Vecteur res = new Vecteur(pt1, pt2);
                // on set le texte du lblResultat au résultat //
                lblResultat.setText("( " + res.getX() + " ; " + res.getY() + " )");
            } catch (NumberFormatException ex) {
                // au cas ou l'utilisateur a entré des données invalides //
                lblResultat.setText("Erreur !");
            }
        });
    }
}
