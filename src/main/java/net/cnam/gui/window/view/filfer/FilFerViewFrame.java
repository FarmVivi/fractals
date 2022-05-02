package net.cnam.gui.window.view.filfer;

import javax.swing.JFrame;

import net.cnam.App;

public class FilFerViewFrame extends JFrame {

    private final FilFerViewPanel panel;

    public FilFerViewFrame(App app) {
        panel = new FilFerViewPanel();

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en fil de fer");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
