package net.cnam.gui.window.surface;

import javax.swing.JFrame;

import net.cnam.App;
import net.cnam.Fractals;

public class NewSurfaceFrame extends JFrame {
    public NewSurfaceFrame(App app, Fractals fractals) {
        NewSurfacePanel panel = new NewSurfacePanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Nouvelle surface");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
