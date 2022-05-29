package net.cnam.gui.window.menu;

import javax.swing.JFrame;

import net.cnam.App;

public class MenuFrame extends JFrame {
    public MenuFrame(App app) {
        MenuPanel panel = new MenuPanel(app);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Menu");
        this.setSize(480, 360);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
