package net.cnam.gui.window.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import net.cnam.Fractals;

public class GamePanel extends JPanel {

    private final Fractals fractals;

    public GamePanel(Fractals fractals) {
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.game((Graphics2D) g);
    }
}
