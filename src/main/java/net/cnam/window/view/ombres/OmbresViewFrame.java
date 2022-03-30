package net.cnam.window.view.ombres;

import javax.swing.JFrame;

import net.cnam.App;

public class OmbresViewFrame extends JFrame {
    private OmbresViewPanel panel;

    public OmbresViewFrame(App app) {
        panel = new OmbresViewPanel();

        // Caractéristiques de la fenêtre
        setTitle("Fractals - Vue en ombres");
        setSize(1280, 720);
        setLocationRelativeTo(app.getMainFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
