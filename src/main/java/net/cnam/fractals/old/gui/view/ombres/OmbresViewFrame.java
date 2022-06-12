package net.cnam.fractals.old.gui.view.ombres;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.view.ombres.OmbresViewPanel;
import net.cnam.fractals.old.App;

import javax.swing.*;

@Deprecated
public class OmbresViewFrame extends JFrame {
    @Deprecated
    public OmbresViewFrame(App app, Fractals fractals) {
        OmbresViewPanel panel = new OmbresViewPanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en ombres");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMenuFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(new JScrollPane(panel));
    }
}
