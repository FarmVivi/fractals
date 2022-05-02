package net.cnam.gui.window.carte;

import javax.swing.JFrame;

import net.cnam.App;

public class CarteFrame extends JFrame {

    private final CartePanel panel;

    public CarteFrame(App app) {
        panel = new CartePanel();

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Carte");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }

    public CartePanel getCartePanel() {
        return panel;
    }
}
