package net.cnam.gui.window.view.ombres;

import javax.swing.JFrame;

import net.cnam.App;

public class OmbresViewFrame extends JFrame {

    private final OmbresViewPanel panel;

    public OmbresViewFrame(App app) {
        panel = new OmbresViewPanel();

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en ombres");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
