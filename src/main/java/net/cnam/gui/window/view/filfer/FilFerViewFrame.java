package net.cnam.gui.window.view.filfer;

import javax.swing.JFrame;

import net.cnam.App;
import net.cnam.Fractals;

public class FilFerViewFrame extends JFrame {
    public FilFerViewFrame(App app, Fractals fractals) {
        FilFerViewPanel panel = new FilFerViewPanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en fil de fer");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
