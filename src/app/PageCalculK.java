package app;

import javax.swing.*;
import java.awt.*;

/**
 * page pour faire le calcul de K avec 2 rectangles
 * 
 * @author mantoloutre
 */
public class PageCalculK extends JPanel {
    private JTextField cL1, cH1, cL2, cH2, cK;
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
        // initialisation des champs d'écriture et label
        this.cL1 = ajouterChamp("Largeur Rect 1 :");
        this.cH1 = ajouterChamp("Longueur Rect 1 :");
        this.cL2 = ajouterChamp("Largeur Rect 2 :");
        this.cH2 = ajouterChamp("Longueur Rect 2 :");
        this.cK = ajouterChamp("Mesure K");
        this.lblResultat = new JLabel("Résultat : ---");
        JButton btnCalculer = new JButton("Calculer K");
        JButton btnRetour = new JButton("<- Retour");

        this.add(btnCalculer);
        this.add(lblResultat);
        this.add(btnRetour);
        // bouton d'actions
        btnCalculer.addActionListener(e -> {
            try {
                // lire les champ de texte
                double h1 = cH1.getText().isEmpty() ? 0 : Double.parseDouble(cH1.getText());
                double l1 = cL1.getText().isEmpty() ? 0 : Double.parseDouble(cL1.getText());
                double h2 = cH2.getText().isEmpty() ? 0 : Double.parseDouble(cH2.getText());
                double l2 = cL2.getText().isEmpty() ? 0 : Double.parseDouble(cL2.getText());
                double k = cK.getText().isEmpty() ? 0 : Double.parseDouble(cK.getText());
                // On demande à la classe Rectangle de faire les calculs
                double[] resultats = Rectangle.calculerTout(h1, l1, h2, l2, k);
                // mettre les resultat dans les champs approprié
                cH1.setText(String.format("%.2f", resultats[0]));
                cL1.setText(String.format("%.2f", resultats[1]));
                cH2.setText(String.format("%.2f", resultats[2]));
                cL2.setText(String.format("%.2f", resultats[3]));
                cK.setText(String.format("%.4f", resultats[4]));
                lblResultat.setText("Calcul fait");
            } catch (NumberFormatException ex) {
                lblResultat.setText("Erreur : veuillez entrez des nombres, merci");
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