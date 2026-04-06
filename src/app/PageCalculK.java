package app;

import javax.swing.*;
import java.awt.*;

/**
 * page pour faire le calcul de K avec 2 rectangles
 * 
 * @author mantoloutre
 */
public class PageCalculK extends JPanel {
    private JTextField cL1, cH1, cL2, cH2;
    private JLabel lblResultat;

    /**
     * constructeur de page calcul k
     * 
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageCalculK(CardLayout cl, JPanel conteneur) {
        this.setLayout(new GridLayout(0, 2, 5, 5));
        // champs largeur 1 //
        this.cL1 = ajouterChamp("Largeur Rect 1 :");
        // champ hauteur 1 //
        this.cH1 = ajouterChamp("Longueur Rect 1 :");
        // champ Longueur 2 //
        this.cL2 = ajouterChamp("Largeur Rect 2 :");
        // champ hauteur 2 //
        this.cH2 = ajouterChamp("Longueur Rect 2 :");
        this.lblResultat = new JLabel("Résultat : ---");

        JButton btnCalculer = new JButton("Calculer K");
        JButton btnRetour = new JButton("<- Retour");

        this.add(btnCalculer);
        this.add(lblResultat);
        this.add(btnRetour);

        btnCalculer.addActionListener(e -> {
            try {
                Rectangle r1 = new Rectangle(Double.parseDouble(cH1.getText()), Double.parseDouble(cL1.getText()));
                Rectangle r2 = new Rectangle(Double.parseDouble(cH2.getText()), Double.parseDouble(cL2.getText()));
                double res = Rectangle.kRectangle(r1, r2);
                // (condition ? valeur si vraie : valeur si faux) ( mieux que des if else pour
                // des petits calcul )
                lblResultat.setText(res == -1 ? "Non semblables" : String.format("K = %.4f", res));
            } catch (NumberFormatException ex) {
                lblResultat.setText("Erreur !");
            }
        });

        btnRetour.addActionListener(e -> cl.show(conteneur, "menu"));
    }

    private JTextField ajouterChamp(String texte) {
        this.add(new JLabel(texte));
        JTextField champ = new JTextField();
        this.add(champ);
        return champ;
    }
}