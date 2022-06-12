package net.cnam.gui.window.menu;

import net.cnam.App;

import javax.swing.*;
import java.awt.event.ActionEvent;

@Deprecated
public class MenuPanel extends JPanel {
    @Deprecated
    public MenuPanel(App app) {
        // Bouton "Nouvelle surface"
        JButton newSurfaceButton = new JButton("Nouvelle surface");
        newSurfaceButton.addActionListener((ActionEvent e) -> app.getNewSurfaceFrame().setVisible(true));
        this.add(newSurfaceButton);

        // Bouton "Carte"
        JButton carteButton = new JButton("Carte");
        carteButton.addActionListener((ActionEvent e) -> app.getCarteFrame().setVisible(true));
        this.add(carteButton);

        // Bouton "Vue en strates"
        JButton stratesViewButton = new JButton("Vue en strates");
        stratesViewButton.addActionListener((ActionEvent e) -> app.getStratesViewFrame().setVisible(true));
        this.add(stratesViewButton);

        // Bouton "Vue en ombres"
        JButton ombresViewButton = new JButton("Vue en ombres");
        ombresViewButton.addActionListener((ActionEvent e) -> app.getOmbresViewFrame().setVisible(true));
        this.add(ombresViewButton);

        // Bouton "Vue en fils de fer"
        JButton filFerViewButton = new JButton("Vue en fil de fer");
        filFerViewButton.addActionListener((ActionEvent e) -> app.getFilFerViewFrame().setVisible(true));
        this.add(filFerViewButton);

        // Bouton "Le jeu"
        JButton gameButton = new JButton("Le jeu");
        gameButton.addActionListener((ActionEvent e) -> app.getGameFrame().setVisible(true));
        this.add(gameButton);
    }
}
