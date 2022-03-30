package net.cnam.window.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public Color getColor(int c) {
        if (c < 0 || c > 15)
            throw new IllegalArgumentException("c doit être compris entre 0 et 15");

        // Méthode temporaire
        // TODO Faire un switch avec les bonnes couleurs
        return new Color(c * 17, c * 17, c * 17);
    }

    public void plot(Graphics g, int x, int y, int c) {
        Color color = getColor(c);
        g.setColor(color);
        g.drawLine(x, y, x, y);
    }
}