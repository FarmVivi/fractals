package net.cnam.gui.window.menu;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.cnam.App;

import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {

    private final JButton newSurfaceButton;
    private final JButton carteButton;
    private final JButton stratesViewButton;
    private final JButton ombresViewButton;
    private final JButton filFerViewButton;
    private final JButton gameButton;

    public MenuPanel(App app) {
        // Bouton "Nouvelle surface"
        this.newSurfaceButton = new JButton("Nouvelle surface");
        this.newSurfaceButton.addActionListener((ActionEvent e) -> {
            app.launchNewSurfaceWindow();
        });
        this.add(newSurfaceButton);

        // Bouton "Carte"
        this.carteButton = new JButton("Carte");
        this.carteButton.addActionListener((ActionEvent e) -> {
            app.launchCarteWindow();
        });
        this.add(carteButton);

        // Bouton "Vue en strates"
        this.stratesViewButton = new JButton("Vue en strates");
        this.stratesViewButton.addActionListener((ActionEvent e) -> {
            app.launchStratesViewWindow();
        });
        this.add(stratesViewButton);

        // Bouton "Vue en ombres"
        this.ombresViewButton = new JButton("Vue en ombres");
        this.ombresViewButton.addActionListener((ActionEvent e) -> {
            app.launchOmbresViewWindow();
        });
        this.add(ombresViewButton);

        // Bouton "Vue en fils de fer"
        this.filFerViewButton = new JButton("Vue en fil de fer");
        this.filFerViewButton.addActionListener((ActionEvent e) -> {
            app.launchFilFerViewWindow();
        });
        this.add(filFerViewButton);

        // Bouton "Le jeu"
        this.gameButton = new JButton("Le jeu");
        this.gameButton.addActionListener((ActionEvent e) -> {
            app.launchGameWindow();
        });
        this.add(gameButton);
    }
}
