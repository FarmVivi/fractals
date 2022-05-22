package net.cnam.gui.window.view.ombres;

import javax.swing.JFrame;

import net.cnam.App;
import net.cnam.Fractals;

public class OmbresViewFrame extends JFrame {
    public OmbresViewFrame(App app, Fractals fractals) {
        OmbresViewPanel panel = new OmbresViewPanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en ombres");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
