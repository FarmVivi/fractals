package net.cnam.fractals.old.gui.view.strates;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.ScrollPanel;
import net.cnam.fractals.gui.view.strates.StratesPanel;
import net.cnam.fractals.old.App;

import javax.swing.*;

@Deprecated
public class StratesFrame extends JFrame {
    @Deprecated
    public StratesFrame(App app, Fractals fractals) {
        StratesPanel panel = new StratesPanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en strates");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMenuFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(new ScrollPanel(panel));
    }
}
