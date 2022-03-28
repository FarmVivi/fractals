package net.cnam;

import javax.swing.JFrame;

public class Main_Frame extends JFrame {
    private Main_Panel panel;

    public Main_Frame(App app) {
        panel = new Main_Panel(app);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Menu");
        this.setSize(480, 360);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
