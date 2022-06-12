package net.cnam.gui.window.surface;

import net.cnam.App;
import net.cnam.Fractals;

import javax.swing.*;

@Deprecated
public class NewSurfaceFrame extends JFrame {
    @Deprecated
    public NewSurfaceFrame(App app, Fractals fractals) {
        NewSurfacePanel panel = new NewSurfacePanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Nouvelle surface");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMenuFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(new JScrollPane(panel));
    }
}
