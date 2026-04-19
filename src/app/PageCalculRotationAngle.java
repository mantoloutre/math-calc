package app;

import java.awt.*;
import javax.swing.*;

/**
 * objet qui représente la page pour faire le calcul de rotation d'un point avec
 * un angle ( possiblement ajouter possibiliter d'ajouter avec un triangle plus
 * tard )
 * 
 * @author mantoloutre
 */
public class PageCalculRotationAngle extends JPanel {
    private JTextField x, y, pX, pY, rotation;
    private JLabel lblResultat;

    /**
     * constructeur de la page pour calculer un point avec un angle de rotation
     * 
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageCalculRotationAngle(CardLayout cl, JPanel conteneur) {
        this.setLayout(new GridLayout(0, 2, 5, 5));
        this.x = ajouterChamp("le X du point :");
        this.y = ajouterChamp("le Y du point :");
        this.pX = ajouterChamp("le X du point pivot :");
        this.pY = ajouterChamp("le Y du point pivot");
        this.rotation = ajouterChamp("l'angle de rotation :");
        this.lblResultat = new JLabel("Résultat : ---");
        JButton btnCalculer = new JButton("Calculer K");
        JButton btnRetour = new JButton("<- Retour");
        this.add(btnCalculer);
        this.add(lblResultat);
        this.add(btnRetour);
        btnCalculer.addActionListener(e -> {
            try {
                Point p1 = new Point(Double.parseDouble(x.getText()), Double.parseDouble(y.getText()));
                Point res = p1.calculRotation(Double.parseDouble(rotation.getText()), Double.parseDouble(pX.getText()),
                        Double.parseDouble(pY.getText()));
                lblResultat.setText(String.format("nouveau : (%.2f ; %.2f)", res.getX(), res.getY()));
            } catch (NumberFormatException ex) {
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
