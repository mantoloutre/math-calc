package app;

import javax.swing.*;
import java.awt.*;

/**
 * cette classe représente l'objet de la page pour trouver le vecteur a partir
 * de 2 points
 * 
 * @author mantoloutre
 */
public class pageTrouveVecteur2Pts extends JPanel {
    private JTextField cX1, cY1, cX2, cY2;
    private JLabel lblResultat;

    /**
     * constructeur de la page qui sert a trouver le vecteur a partie de deux points
     * 
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public pageTrouveVecteur2Pts(CardLayout cl, JPanel conteneur) {
        // ajouter le layout voulu //
        this.setLayout(new GridLayout(0, 2, 5, 5));
        // ajouter les fields + faire la méthode pour rendre ca plus simple //
        this.cX1 = ajouterChamp("x du point 1 :");
        this.cY1 = ajouterChamp("y du point 1 :");
        this.cX2 = ajouterChamp("x du point 2 :");
        this.cY2 = ajouterChamp("y du point 2 :");
        // ajouter le JLabel qui va servir à afficher le résultat //
        this.lblResultat = new JLabel("Résultat : ---");
        // ajouter le bouton qui va servir a faire le calcul //
        JButton btnCalculer = new JButton("Calculer norme");
        // ajouter le bouton pour revenir au menu //
        JButton btnRetour = new JButton("<- Retour");
        // tout ajouter au conteneur //
        this.add(btnCalculer);
        this.add(lblResultat);
        this.add(btnRetour);
        // ajouter le actionListener au bouton pour calculer la norme //
        btnCalculer.addActionListener(e -> {
            // utiliser un try catch au cas ou l'utilisateur ne met pas des données valides
            try {
                // créer les deux objets points //
                Point pt1 = new Point(Double.parseDouble(cX1.getText()), Double.parseDouble(cY1.getText()));
                Point pt2 = new Point(Double.parseDouble(cX2.getText()), Double.parseDouble(cY2.getText()));
                // on appelle le constructeur pour avoir le vecteur ( le déplacement ) //
                Vecteur res = Vecteur.creerDepuisPoints(pt1, pt2);
                // on set le texte du lblResultat au résultat //
                lblResultat.setText("( " + res.getX() + " ; " + res.getY() + " )");
            } catch (NumberFormatException ex) {
                // au cas ou l'utilisateur a entré des données invalides //
                lblResultat.setText("Erreur !");
            }
        });
        btnRetour.addActionListener(e -> cl.show(conteneur, "menu"));
    }

    /**
     * méthode pour simplifier l'ajoute de JTextField et de JLabel en 1 ligne (
     * simplifie la lecture du code ).
     * cette méthode ajoute le label avec le texte voulu et retourne un JTextfield
     * qui est ajouter juste après.
     * 
     * @param texte le texte que on veut mettre dans le JLabel
     * @return retourne le JTextField
     */
    private JTextField ajouterChamp(String texte) {
        this.add(new JLabel(texte));
        JTextField champ = new JTextField();
        this.add(champ);
        return champ;
    }
}
