package net.cnam;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    private MainPanel panel;

    public MainFrame(App app) {
        panel = new MainPanel(app);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Menu");
        this.setSize(480, 360);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
