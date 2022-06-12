package net.cnam.fractals.old.gui.view.strates;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.view.strates.StratesViewPanel;
import net.cnam.fractals.old.App;

import javax.swing.*;

@Deprecated
public class StratesViewFrame extends JFrame {
    @Deprecated
    public StratesViewFrame(App app, Fractals fractals) {
        StratesViewPanel panel = new StratesViewPanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en strates");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMenuFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(new JScrollPane(panel));
    }
}
