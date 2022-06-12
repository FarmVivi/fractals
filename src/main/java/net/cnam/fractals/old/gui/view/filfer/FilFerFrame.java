package net.cnam.fractals.old.gui.view.filfer;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.view.filfer.FilFerPanel;
import net.cnam.fractals.old.App;

import javax.swing.*;

@Deprecated
public class FilFerFrame extends JFrame {
    @Deprecated
    public FilFerFrame(App app, Fractals fractals) {
        FilFerPanel panel = new FilFerPanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Vue en fil de fer");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMenuFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(new JScrollPane(panel));
    }
}
