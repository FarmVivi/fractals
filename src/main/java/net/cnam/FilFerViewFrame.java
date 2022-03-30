package net.cnam;

import javax.swing.JFrame;

public class FilFerViewFrame extends JFrame {
    private FilFerViewPanel panel;

    public FilFerViewFrame(App app) {
        panel = new FilFerViewPanel();

        // Caractéristiques de la fenêtre
        setTitle("Fractals - Vue en fil de fer");
        setSize(1280, 720);
        setLocationRelativeTo(app.getMainFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
