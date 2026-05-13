package app.pages;

import app.models.Matrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * page pour fait divers calcul avec des matrices
 * <p>addition / soustraction</p>
 * <p>multiplication / division</p>
 *
 * @author mantoloutre
 */
public class PageCalculMatrice extends PageDeBase {
    private final JTextField cLM1, cLM2;
    private final JLabel lblResultat = new JLabel("Résultat : ---");
    private final JButton addition;
    private final JButton soustraction;
    private final JButton multiplication;
    private final JButton division;

    /**
     * constructeur de la page pour les calculs avec les matrices
     *
     * @param cl        le gestionnaire des pages qui permet l'affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageCalculMatrice(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        this.cLM1 = ajouterChamp("Matrice 1");
        this.cLM1.setToolTipText("écrire: x nombre de fois la matrice" +
                "Optionnel(1 par défaut), séparer par des points-virgules ( ; )" +
                "chacun des élément de la matrice, ex: 4x4;5;2;8 = 4 fois la matrice" +
                "a=4,b=5,c=2,d=8");
        this.cLM2 = ajouterChamp("Matrice 2");
        this.cLM2.setToolTipText("écrire: x nombre de fois la matrice" +
                "Optionnel(1 par défaut), séparer par des points-virgules ( ; )" +
                "chacun des élément de la matrice, ex: 4x4;5;2;8 = 4 fois la matrice" +
                "a=4,b=5,c=2,d=8");
        addition = new JButton("addition");
        soustraction = new JButton("soustraction");
        multiplication = new JButton("multiplicaiton");
        division = new JButton("division");
        addition.addActionListener(new PageCalculMatrice.OptionListener());
        soustraction.addActionListener(new PageCalculMatrice.OptionListener());
        multiplication.addActionListener(new PageCalculMatrice.OptionListener());
        division.addActionListener(new PageCalculMatrice.OptionListener());
        JPanel panelBouton = new JPanel();
        panelBouton.setLayout(new GridLayout(4, 1, 5, 5));
        panelBouton.add(addition);
        panelBouton.add(soustraction);
        panelBouton.add(multiplication);
        panelBouton.add(division);
        this.add(panelBouton, BorderLayout.EAST);
        this.add(lblResultat);
        ajouterBoutonRetour();
    }

    /**
     * classe pour gérer l'action des boutons
     */
    class OptionListener implements ActionListener {
        /**
         * on redéfinit cette méthode pour pouvoir choisir ce que le bouton
         * fait
         *
         * @param e l'action
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Matrice m1 = textToMatrice(cLM1);
                Matrice m2 = textToMatrice(cLM2);
                Matrice mR;
                if (e.getSource() == addition) {
                    mR = Matrice.calcAddition(m1, m2);
                    afficheMatrice(mR);
                } else if (e.getSource() == soustraction) {
                    mR = Matrice.calcSoustraction(m1, m2);
                    afficheMatrice(mR);
                } else if (e.getSource() == multiplication) {
                    mR = Matrice.calcMultiplication(m1, m2);
                    afficheMatrice(mR);
                } else if (e.getSource() == division) {
                    mR = Matrice.calcDivision(m1, m2);
                    afficheMatrice(mR);
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null,
                        "le/les champ(s) sont null");
            } catch (ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null,
                        "format invalide!");
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(null,
                        ex);
            }
        }

        /**
         * méthode pour ne pas répéter l'affichage de matrice a chaque
         * fois
         *
         * @param mR matrice a afficher sur le JLabel lblResultat
         */
        public void afficheMatrice(Matrice mR) throws NullPointerException {
            lblResultat.setText("Résultat : A = " + mR.getA() +
                    " | B = " + mR.getB() + " | C = " + mR.getC() +
                    " | D = " + mR.getD());
        }
    }
}
