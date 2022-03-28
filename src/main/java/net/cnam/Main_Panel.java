package net.cnam;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Panel extends JPanel {
    private JButton carteButton;

    public Main_Panel(App app) {
        this.carteButton = new JButton("Carte");
        this.carteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.launchCarteWindow();
            }
        });

        this.add(carteButton);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
