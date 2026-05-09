package app.pages;

import app.models.Matrice;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * <p>
 * Cette classe représente la base de toute les pages
 * </p>
 * <p>
 * le but de cette classe est de ne pas toujours répéter les mêmes choses à
 * travers les pages
 * </p>
 *
 * @author mantoloutre
 */
public abstract class PageDeBase extends JPanel {
    protected CardLayout cl;
    protected JPanel conteneur;
    protected JPanel panneauCentre;

    /**
     * constructeur par défaut pour toute les pages
     *
     * @param cl        le gestionnaire des pages qui permet l'Affichage de une
     *                  seule page a la fois
     * @param conteneur le conteneur principal qui contient toute les pages
     */
    public PageDeBase(CardLayout cl, JPanel conteneur) {
        this.cl = cl;
        this.conteneur = conteneur;
        super.setLayout(new BorderLayout());
        this.setBackground(new Color(240, 240, 240));
        this.panneauCentre = new JPanel();
        this.panneauCentre.setLayout(new BoxLayout(panneauCentre, BoxLayout.Y_AXIS));
        this.panneauCentre.setOpaque(false);
        this.panneauCentre.setBorder(new EmptyBorder(40, 60, 40, 60));
        super.add(this.panneauCentre, BorderLayout.NORTH);
    }

    /**
     * méthode utilitaire pour transformer le contenu d'un champ de texte
     * en matrice
     *
     * @param champ le champ de texte a transformer
     * @return retourne la matrice
     */
    public static Matrice textToMatrice(JTextField champ) throws ArrayIndexOutOfBoundsException{
        Matrice m = null;
        try {
            String input = champ.getText().replace(" ", ""); // On vire les espaces
            double scalaire = 1.0;
            String matriceTexte = input;
            // Si y'a un 'x', on sépare le chiffre de la matrice
            if (input.contains("x")) {
                String[] splitX = input.split("x");
                scalaire = Double.parseDouble(splitX[0]);
                matriceTexte = splitX[1];
            }
            //split les 4 chiffres par le ";"
            String[] num = matriceTexte.split(";");
            //verif pas trop d'élément
            if (num.length != 4) {
                throw new ArrayIndexOutOfBoundsException("trop d'élément écrit");
            }
            // création matrice
            m = new Matrice(
                    trDouble(num[0]), trDouble(num[1]),
                    trDouble(num[2]), trDouble(num[3])
            );
            // appliquer le scalaire
            if (scalaire != 1.0) {
                m = Matrice.calcMultiplication(scalaire, m);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                    "Format invalide ! : scalaire x a;b;c;d");
        }
        return m;
    }

    /**
     * intercepte l'ajout de composants pour les rediriger vers le panneau central,
     * sauf si une position spécifique (NORTH/SOUTH/EAST/WEST) est demandée.
     *
     * @param comp        le composant à ajouter
     * @param constraints la position ou contrainte de placement
     */
    @Override
    public void add(Component comp, Object constraints) {
        if (comp == panneauCentre || constraints == BorderLayout.SOUTH
                || constraints == BorderLayout.NORTH ||
                constraints == BorderLayout.EAST || constraints ==
                BorderLayout.WEST) {
            super.add(comp, constraints);
        } else {
            panneauCentre.add(comp);
        }
    }

    /**
     * Ajoute un composant directement dans le panneau central par défaut.
     *
     * @param comp le composant à ajouter
     * @return le composant ajouté
     */
    @Override
    public Component add(Component comp) {
        Component resultat;
        if (comp instanceof JButton) {
            stylerBouton((JButton) comp);
        }
        if (comp == panneauCentre) {
            resultat = super.add(comp);
        } else {
            resultat = panneauCentre.add(comp);
        }
        return resultat;
    }


    /**
     * Applique un style visuel moderne aux boutons.
     *
     * @param bouton Le JButton à styler.
     */
    protected void stylerBouton(JButton bouton) {
        bouton.setBackground(new Color(70, 130, 180));
        bouton.setForeground(Color.WHITE);
        bouton.setFocusPainted(false);
        bouton.setFont(new Font("Arial", Font.BOLD, 12));
        bouton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bouton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(50, 100, 150), 1),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        bouton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                bouton.setBackground(new Color(90, 150, 200));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                bouton.setBackground(new Color(70, 130, 180));
            }
        });
    }

    /**
     * méthode pour ajouter le bouton de retour
     */
    protected final void ajouterBoutonRetour() {
        JButton btnRetour = new JButton("Retour au menu");
        btnRetour.addActionListener(e -> cl.show(conteneur, "menu"));
        JPanel panneauBas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panneauBas.add(btnRetour);

        this.add(panneauBas, BorderLayout.SOUTH);
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
    protected final JTextField ajouterChamp(String texte) {
        JPanel ligne = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ligne.setOpaque(false);
        JLabel label = new JLabel(texte);
        label.setPreferredSize(new Dimension(220, 25));
        JTextField champ = new JTextField(12);
        ligne.add(label);
        ligne.add(champ);
        this.panneauCentre.add(ligne);
        return champ;
    }

    /**
     * méthode pour simplifier la transformation d'un champ de texte en Double et en
     * enlevant les espace accidentels (s'il y en a)
     *
     * @param texte le .getText() du champ que on veut transformer
     * @return retourne le double qui représente le .getText()
     * @throws NumberFormatException lance cette erreur s'il est impossible de
     *                               transformer le texte
     */
    protected static double trDouble(String texte) throws NumberFormatException {
        return Double.parseDouble(texte.trim());
    }
}
