package net.cnam.gui.window.view.strates;

import javax.swing.JFrame;

import net.cnam.App;

public class StratesViewFrame extends JFrame {

    private final StratesViewPanel panel;

    public StratesViewFrame(App app) {
        panel = new StratesViewPanel();

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en strates");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
