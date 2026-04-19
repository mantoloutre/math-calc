package app;

import java.awt.*;
import javax.swing.*;

/**
 * cette classe est la page pour faire le calcul de différence ( l ) avec des
 * triangle
 * 
 * @author mantoloutre
 */
public class PageCalculKTriangle extends PageDeBase {
    private JTextField cL1, cH1, cL2, cH2;
    private JLabel lblResultat;

    /**
     * constructeur de la page de calcul de K pour les triangles
     * 
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageCalculKTriangle(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        // initialisation des champs d'écriture pour les deux triangles
        this.cL1 = ajouterChamp("Largeur ( base Triangle 1 :");
        this.cH1 = ajouterChamp("Hauteur premier triangle :");
        this.cL2 = ajouterChamp("Largeur ( base Triangle 2 :");
        this.cH2 = ajouterChamp("Hauteur deuxième triangle :");
        this.lblResultat = new JLabel("Résultat : ---");
        JButton btnCalculer = new JButton("Calculer K");
        this.add(btnCalculer);
        this.add(lblResultat);
        ajouterBoutonRetour();

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
    }
}
