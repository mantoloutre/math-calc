package app;

import java.awt.*;
import javax.swing.*;

/**
 * <p>
 * classe qui représente la page pour faire divers calcul avec des vecteurs
 * </p>
 * <p>
 * calcul implémenter : addition, multiplication
 * </p>
 * <p>
 * + note, pour la multiplication, c'est uniquement exemple : 2 fois le vecteur
 * A
 * additioner par 4 fois le vecteur B
 * </p>
 * 
 * @author mantoloutre
 */
public class PageCalculVecteur extends PageDeBase {
    // légende : c = champ, v = vecteur //
    private JTextField cvX1, cvY1, cvX2, cvY2, nombreV1, nombreV2;
    private JCheckBoxMenuItem addition = new JCheckBoxMenuItem("Addition");
    private JCheckBoxMenuItem multiplication = new JCheckBoxMenuItem("Multiplication");
    private JMenu listeCalcul = new JMenu("Choix de l'opération");
    private JLabel lblResultat, lblNombreV1, lblNombreV2;
    Vecteur vResultat;

    /**
     * constructeur de page pour les calculs concernant les vecteurs
     * 
     * @param cl        le gestionnaire des pages qui permet l'affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageCalculVecteur(CardLayout cl, JPanel conteneur) {
        super(cl, conteneur);
        // this.setLayout(new GridLayout(0, 3, 5, 5));
        this.cvX1 = ajouterChamp("vecteur 1 x : ");
        this.cvY1 = ajouterChamp("vecteur 1 y : ");
        this.cvX2 = ajouterChamp("vecteur 2 x : ");
        this.cvY2 = ajouterChamp("vecteur 2 Y : ");
        this.lblResultat = new JLabel("Résultat : ---");
        this.lblNombreV1 = new JLabel("nombre de vecteur 1(min 1)");
        this.lblNombreV2 = new JLabel("nombre de vecteur 2(min 1)");
        this.nombreV1 = new JTextField(5);
        this.nombreV2 = new JTextField(5);
        JButton btnCalcul = new JButton("calculer");
        this.add(btnCalcul);
        this.add(lblResultat);
        ajouterBoutonRetour();
        JMenuBar barreMenu = new JMenuBar();

        // le groupe va permettre de n'avoir qu'un seul choix actif a la fois //
        ButtonGroup groupe = new ButtonGroup();
        groupe.add(addition);
        groupe.add(multiplication);
        // pour que addition soit sélectionner par défaut //
        addition.setSelected(true);
        // action pour l'addition //
        addition.addActionListener(l -> {
            if (addition.isSelected()) {
                this.remove(lblNombreV1);
                this.remove(nombreV1);
                this.remove(lblNombreV2);
                this.remove(nombreV2);
                barreMenu.revalidate();
                barreMenu.repaint();
            }
        });

        // action pour la multiplication //
        multiplication.addActionListener(l -> {
            if (multiplication.isSelected()) {
                this.add(lblNombreV1);
                this.add(nombreV1);
                this.add(lblNombreV2);
                this.add(nombreV2);
                barreMenu.revalidate();
                barreMenu.repaint();
            }
        });
        // la hiéarchie : Items -> Menu -> Barre -> Panneau //
        listeCalcul.add(addition);
        listeCalcul.add(multiplication);
        barreMenu.add(listeCalcul);
        // ajouter la barre a la page //
        this.add(barreMenu);
        btnCalcul.addActionListener(e -> {
            try {
                Vecteur v1 = new Vecteur(trDouble(cvX1.getText()), trDouble(cvY1.getText()));
                Vecteur v2 = new Vecteur(trDouble(cvX2.getText()), trDouble(cvY2.getText()));
                if (addition.isSelected()) {
                    vResultat = Vecteur.additionVecteur(v1, v2);
                    lblResultat.setText("Vecteur : < " + vResultat.getX() + " ; " + vResultat.getY() + " >");
                } else if (multiplication.isSelected()) {
                    double nbV1 = trDouble(nombreV1.getText());
                    double nbV2 = trDouble(nombreV2.getText());
                    vResultat = Vecteur.additionVecteur(Vecteur.multiVecteur(nbV1, v1), Vecteur.multiVecteur(nbV2, v2));
                    lblResultat.setText("Vecteur : < " + vResultat.getX() + " ; " + vResultat.getY() + " > ");
                }
            } catch (NumberFormatException ex) {
                lblResultat.setText("Donnée(s) invalide(s)!");
            } catch (ArithmeticException exc) {
                lblResultat.setText("Division par 0 impossible!");
            }
        });
    }
}
