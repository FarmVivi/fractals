package net.cnam.gui.window.game;

import javax.swing.JFrame;

import net.cnam.App;
import net.cnam.Fractals;

public class GameFrame extends JFrame {
    public GameFrame(App app, Fractals fractals) {
        GamePanel panel = new GamePanel(fractals);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Le jeu");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
