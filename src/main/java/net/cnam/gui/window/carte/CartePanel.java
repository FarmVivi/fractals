package net.cnam.gui.window.carte;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import net.cnam.Fractals;

public class CartePanel extends JPanel {
    private final Fractals fractals;

    public CartePanel(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.map((Graphics2D) g);
    }
}
