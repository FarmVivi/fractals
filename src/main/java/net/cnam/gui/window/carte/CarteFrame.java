package net.cnam.gui.window.carte;

import javax.swing.JFrame;

import net.cnam.App;
import net.cnam.Fractals;
import net.cnam.gui.component.Carte;

public class CarteFrame extends JFrame {
    public CarteFrame(App app, Fractals fractals) {
        Carte panel = new Carte(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Carte");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
