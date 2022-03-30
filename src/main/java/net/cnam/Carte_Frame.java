package net.cnam;

import javax.swing.JFrame;

public class Carte_Frame extends JFrame {
    private Carte_Panel panel;

    public Carte_Frame(App app) {
        panel = new Carte_Panel(3, 100, 100, 62548759613L, 128);

        // Caractéristiques de la fenêtre
        setTitle("Fractals - Carte");
        setSize(1280, 720);
        setLocationRelativeTo(app.getMainFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
