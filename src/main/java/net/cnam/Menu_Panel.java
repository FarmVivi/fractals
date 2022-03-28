package net.cnam;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

public class Menu_Panel extends JPanel {
    private JButton carteButton;

    public Menu_Panel() {
        carteButton = new JButton("Carte");
        carteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Carte_Frame ex = new Carte_Frame();
                        ex.setVisible(true);
                    }
                });
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
