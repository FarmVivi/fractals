package net.cnam.fractals.old.gui.view.ombres;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.ScrollPanel;
import net.cnam.fractals.gui.view.ombres.OmbresPanel;
import net.cnam.fractals.old.App;

import javax.swing.*;

@Deprecated
public class OmbresFrame extends JFrame {
    @Deprecated
    public OmbresFrame(App app, Fractals fractals) {
        OmbresPanel panel = new OmbresPanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en ombres");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMenuFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(new ScrollPanel(panel));
    }
}
