package app;

import javax.swing.*;
import java.awt.*;

/**
 * cette classe est la page pour faire le calcul de différence ( l ) avec des
 * triangle
 * 
 * @author mantoloutre
 */
public class pageCalculKTriangle extends JPanel {
    private JTextField cL1, cH1, cL2, cH2;
    private JLabel lblResultat;

    /**
     * constructeur de la page de calcul de K pour les triangles
     * 
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public pageCalculKTriangle(CardLayout cl, JPanel conteneur) {
        this.setLayout(new GridLayout(0, 2, 5, 5));
        // champ largeur 1 //
        this.cL1 = ajouterChamp("Largeur ( base Triangle 1 :");
        // champ hauteur 1 //
        this.cH1 = ajouterChamp("Hauteur premier triangle :");
        // champ largeur 2 //
        this.cL2 = ajouterChamp("Largeur ( base Triangle 2 :");
        // champ hauteur 2 //
        this.cH2 = ajouterChamp("Hauteur deuxième triangle :");
        this.lblResultat = new JLabel("Résultat : ---");
        JButton btnCalculer = new JButton("Calculer K");
        JButton btnRetour = new JButton("<- Retour");
        this.add(btnCalculer);
        this.add(lblResultat);
        this.add(btnRetour);

        btnCalculer.addActionListener(e -> {
            try {
                Triangle t1 = new Triangle(Double.parseDouble(cH1.getText()), Double.parseDouble(cL1.getText()));
                Triangle t2 = new Triangle(Double.parseDouble(cH2.getText()), Double.parseDouble(cL2.getText()));
                double res = Triangle.kTriangle(t1, t2);
                // (condition ? valeur si vraie : valeur si faux) ( mieux que des if else pour
                // des petits calcul )
                lblResultat.setText(res == -1 ? "Non semblables" : String.format("K = %.4f", res));
            } catch (NumberFormatException ex) {
                lblResultat.setText("Erreur !");
            }
        });
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
