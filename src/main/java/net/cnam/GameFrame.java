package net.cnam;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    private GamePanel panel;

    public GameFrame(App app) {
        panel = new GamePanel();

        // Caractéristiques de la fenêtre
        setTitle("Fractals - Le jeu");
        setSize(1280, 720);
        setLocationRelativeTo(app.getMainFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
