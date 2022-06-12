package net.cnam.fractals.old.gui.carte;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.carte.CartePanel;
import net.cnam.fractals.old.App;

import javax.swing.*;

@Deprecated
public class CarteFrame extends JFrame {
    @Deprecated
    public CarteFrame(App app, Fractals fractals) {
        CartePanel panel = new CartePanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Carte");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMenuFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(new JScrollPane(panel));
    }
}
