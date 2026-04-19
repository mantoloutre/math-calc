package app;

import java.awt.*;
import javax.swing.*;

/**
 * <h4>page pour faire le calcul de K avec 2 rectangles ou pour trouver les mesure
 * manquante avec le k et 1 rectangle</h4>
 * 
 * @author mantoloutre
 */
public class PageCalculK extends PageDeBase {
    private final JTextField cL1, cH1, cL2, cH2, cK;
    private final JLabel lblResultat;

    /**
     * constructeur de page calcul k
     * 
     * @param cl        le gestionnaire des pages qui permet l'affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageCalculK(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        // initialisation des champs d'écriture et label
        this.cL1 = ajouterChamp("Largeur Rect 1 :");
        this.cL1.setToolTipText("largeur du rectangle original");
        this.cH1 = ajouterChamp("Longueur Rect 1 :");
        this.cH1.setToolTipText("Longueur du rectangle original");
        this.cL2 = ajouterChamp("Largeur Rect 2 :");
        this.cL2.setToolTipText("Largeur du rectangle final");
        this.cH2 = ajouterChamp("Longueur Rect 2 :");
        this.cH2.setToolTipText("Longueur du rectangle final");
        this.cK = ajouterChamp("Mesure K");
        this.lblResultat = new JLabel("Résultat : ---");
        JButton btnCalculer = new JButton("Calculer K");

        this.add(btnCalculer);
        this.add(lblResultat);
        ajouterBoutonRetour();
        // bouton d'actions
        btnCalculer.addActionListener(e -> appliquerCalcul());
    }

    /**
     * Logique principale pour récupérer les données, appeler le calcul
     * et mettre à jour l'interface.
     */
    private void appliquerCalcul() {
        double h1 = videOuPas(cH1);
        double l1 = videOuPas(cL1);
        double h2 = videOuPas(cH2);
        double l2 = videOuPas(cL2);
        double k = videOuPas(cK);

        if (h1 == -1 || l1 == -1 || h2 == -1 || l2 == -1 || k == -1) {
            return;
        }
        double[] resultats = Rectangle.calculerTout(h1, l1, h2, l2, k);
        this.cH1.setText(String.format("%.2f", resultats[0]));
        this.cL1.setText(String.format("%.2f", resultats[1]));
        this.cH2.setText(String.format("%.2f", resultats[2]));
        this.cL2.setText(String.format("%.2f", resultats[3]));
        this.cK.setText(String.format("%.4f", resultats[4]));
        lblResultat.setText("Calcul fait");
    }

    /**
     * méthode qui vérifie si le champ est vide ou non
     * 
     * @param champ champ de texte que l'on veut vérifier
     * @return retourne la valeur
     *         <p>
     *         si le champ comporte une erreur, retourne -1
     *         </p>
     */
    private double videOuPas(JTextField champ) {
        double valeur;
        try {
            if (champ.getText().trim().isEmpty()) {
                valeur = 0;
            } else {
                valeur = trDouble(champ.getText().replace(',', '.'));
            }
        } catch (NumberFormatException ex) {
            lblResultat.setText("Erreur : Nombres seulement !");
            valeur = -1;
        }
        return valeur;
    }
}