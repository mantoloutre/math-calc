package app;

import java.awt.*;
import javax.swing.*;

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
        this.setLayout(new GridLayout(0, 2, 5, 5));
    }

    /**
     * méthode pour ajouter le bouton de retour
     */
    protected final void ajouterBoutonRetour() {
        JButton btnRetour = new JButton("Retour au menu");
        btnRetour.addActionListener(e -> cl.show(conteneur, "menu"));
        this.add(btnRetour);
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
        this.add(new JLabel(texte));
        JTextField champ = new JTextField();
        this.add(champ);
        return champ;
    }

    /**
     * méthode pour simplifier la transformation d'un champ de texte en Double et en
     * enlevant les espace accidentels (s'il y en a)
     * 
     * @param texte le .getText() du champ que on veut transformer
     * @return retourne le double qui représente le .getText()
     */
    protected final double trDouble(String texte) {
        return Double.parseDouble(texte.trim());
    }
}
