package net.cnam.fractals.old.gui.game;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.ScrollPanel;
import net.cnam.fractals.gui.game.GamePanel;
import net.cnam.fractals.old.App;

import javax.swing.*;

@Deprecated
public class GameFrame extends JFrame {
    @Deprecated
    public GameFrame(App app, Fractals fractals) {
        GamePanel panel = new GamePanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Le jeu");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMenuFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(new ScrollPanel(panel));
    }
}
