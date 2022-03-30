package net.cnam;

import javax.swing.JFrame;

public class CarteFrame extends JFrame {
    private CartePanel panel;

    public CarteFrame(App app) {
        panel = new CartePanel();

        // Caractéristiques de la fenêtre
        setTitle("Fractals - Carte");
        setSize(1280, 720);
        setLocationRelativeTo(app.getMainFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
