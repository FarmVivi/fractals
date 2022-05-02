package net.cnam.gui.window.game;

import javax.swing.JFrame;

import net.cnam.App;

public class GameFrame extends JFrame {

    private final GamePanel panel;

    public GameFrame(App app) {
        panel = new GamePanel();

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Le jeu");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(app.getMainFrame());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
