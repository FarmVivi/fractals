package net.cnam.gui.window.view.strates;

import javax.swing.JFrame;

import net.cnam.App;
import net.cnam.Fractals;

public class StratesViewFrame extends JFrame {
    public StratesViewFrame(App app, Fractals fractals) {
        StratesViewPanel panel = new StratesViewPanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en strates");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
