package net.cnam.gui.window.menu;

import net.cnam.App;

import javax.swing.*;

@Deprecated
public class MenuFrame extends JFrame {
    @Deprecated
    public MenuFrame(App app) {
        MenuPanel panel = new MenuPanel(app);

        // Caractéristiques de la fenêtre
        this.setTitle("Fractals - Menu");
        this.setSize(480, 360);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(new JScrollPane(panel));

        this.pack();
    }
}
