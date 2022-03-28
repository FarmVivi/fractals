package net.cnam;

import javax.swing.JFrame;

public class Menu_Frame extends JFrame {
    private Menu_Panel panel;

    public Menu_Frame() {
        panel = new Menu_Panel();

        // Caractéristiques de la fenètre
        this.setTitle("Fractals - Menu");
        this.setSize(480, 360); // (x , y)
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ajout du panel
        this.add(panel);
    }
}
