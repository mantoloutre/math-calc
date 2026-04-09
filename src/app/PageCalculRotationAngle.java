package app;

import javax.swing.*;
import java.awt.*;

/**
 * objet qui représente la page pour faire le calcul de rotation d'un point avec
 * un angle ( possiblement ajouter possibiliter d'ajouter avec un triangle plus
 * tard )
 */
public class PageCalculRotationAngle extends JPanel {
    private JTextField x, y;
    private JLabel lblResultat;

    public PageCalculRotationAngle(CardLayout cl, JPanel conteneur) {
        this.setLayout(new GridLayout(0, 2, 5, 5));
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
