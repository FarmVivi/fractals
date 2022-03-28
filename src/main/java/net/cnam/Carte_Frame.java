package net.cnam;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Carte_Frame extends JFrame {
    private Carte_Panel panel;

    public Carte_Frame(App app) {
        panel = new Carte_Panel();

        // Caractéristiques de la fenêtre
        setTitle("Fractals - Carte");
        setSize(1280, 720);
        setLocationRelativeTo(app.getMainFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajout du panel
        this.add(panel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panel.getTimer().stop();
            }
        });
    }
}
