package net.cnam.fractals.old.gui.surface;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.ScrollPanel;
import net.cnam.fractals.gui.surface.NewSurfacePanel;
import net.cnam.fractals.old.App;

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
        this.add(new ScrollPanel(panel));
    }
}
