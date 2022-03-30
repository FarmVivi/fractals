package net.cnam;

import javax.swing.JFrame;

public class StratesViewFrame extends JFrame {
    private StratesViewPanel panel;

    public StratesViewFrame(App app) {
        panel = new StratesViewPanel();

        // Caractéristiques de la fenêtre
        setTitle("Fractals - Vue en strates");
        setSize(1280, 720);
        setLocationRelativeTo(app.getMainFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
