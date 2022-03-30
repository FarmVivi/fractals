package net.cnam;

import javax.swing.JFrame;

public class NewSurface_Frame extends JFrame {
    private NewSurface_Panel panel;

    public NewSurface_Frame(App app) {
        panel = new NewSurface_Panel(3, 100, 100, 62548759613L, 127);

        // Caractéristiques de la fenêtre
        setTitle("Fractals - Nouvelle surface");
        setSize(1280, 720);
        setLocationRelativeTo(app.getMainFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
