package net.cnam.gui.window.game;

import net.cnam.App;
import net.cnam.Fractals;

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
        this.add(new JScrollPane(panel));
    }
}
