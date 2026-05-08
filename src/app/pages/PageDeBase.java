package app.pages;

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
        this.setLayout(new BorderLayout(10, 10));
        this.panneauCentre = new JPanel();
        this.panneauCentre.setLayout(new BoxLayout(panneauCentre,
                BoxLayout.Y_AXIS));
        this.panneauCentre.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.add(this.panneauCentre, BorderLayout.CENTER);
    }

    /**
     * intercepte l'ajout de composants pour les rediriger vers le panneau central,
     * sauf si une position spécifique (NORTH/SOUTH) est demandée.
     *
     * @param comp        le composant à ajouter
     * @param constraints la position ou contrainte de placement
     */
    @Override
    public void add(Component comp, Object constraints) {
        if (comp == panneauCentre || constraints == BorderLayout.SOUTH
                || constraints == BorderLayout.NORTH) {
            super.add(comp, constraints);
        } else {
            panneauCentre.add(comp);
        }
    }

    /**
     * ajoute un composant directement dans le panneau central par défaut.
     *
     * @param comp le composant à ajouter
     * @return le composant ajouté
     */
    @Override
    public Component add(Component comp) {
        Component resultat;
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
        // Couleur de fond (Bleu acier) et texte blanc
        bouton.setBackground(new Color(70, 130, 180));
        bouton.setForeground(Color.WHITE);

        // Enlève le contour de focus moche et change la police
        bouton.setFocusPainted(false);
        bouton.setFont(new Font("Arial", Font.BOLD, 12));
        bouton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Ajoute une bordure propre (ligne foncée + marge interne)
        bouton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(50, 100, 150), 1),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));

        // Effet de survol (Hover)
        bouton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // Plus clair
                bouton.setBackground(new Color(90, 150, 200));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // Couleur originale
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
        JPanel panneauBas = new JPanel(new FlowLayout(FlowLayout.RIGHT));
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
        JLabel label = new JLabel(texte);
        JTextField champ = new JTextField(10); // '10' donne une largeur naturelle
        ligne.add(label);
        ligne.add(champ);
        this.panneauCentre.add(ligne);
        this.panneauCentre.revalidate();
        this.panneauCentre.repaint();
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
    protected final double trDouble(String texte) throws NumberFormatException {
        return Double.parseDouble(texte.trim());
    }
}
