package net.cnam.gui.window.surface;

import java.util.Random;

import javax.swing.JFrame;

import net.cnam.App;

public class NewSurfaceFrame extends JFrame {

    private final NewSurfacePanel panel;

    public NewSurfaceFrame(App app) {
        panel = new NewSurfacePanel(app, 1, 32, 1, 512, new Random().nextLong());

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Nouvelle surface");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
