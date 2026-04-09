package app;

import javax.swing.*;
import java.awt.*;

/**
 * page pour calculer le vecteur
 * 
 * @author mantoloutre
 */
public class pageVecteur extends JPanel {
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
    public pageVecteur(CardLayout cl, JPanel conteneur) {
        this.setLayout(new GridLayout(0, 2, 5, 5));

        this.champX = ajouterChamp("Coordonnée X :");
        this.champY = ajouterChamp("Coordonnée Y :");
        this.lblResultat = new JLabel("Résultat : ---");

        JButton btnCalculer = new JButton("Calculer Norme");
        JButton btnRetour = new JButton("<- Retour");

        this.add(btnCalculer);
        this.add(lblResultat);
        this.add(btnRetour);

        // Logique de calcul
        btnCalculer.addActionListener(e -> {
            try {
                Vecteur v = new Vecteur(Double.parseDouble(champX.getText()), Double.parseDouble(champY.getText()));
                lblResultat.setText(String.format("Norme : %.2f", v.calculerNorme()));
            } catch (NumberFormatException ex) {
                lblResultat.setText("Erreur !");
            }
        });

        // Navigation
        btnRetour.addActionListener(e -> cl.show(conteneur, "menu"));
    }

    /**
     * méthode pour rendre le code moins gros.
     * cette méthode va simplifier l'ajout de JLabel et de JTextfield
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