package net.cnam.gui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import net.cnam.Utils;

public class CarteFractalComponent extends JComponent {

    private int surface[][];
    private int hauteur;

    public CarteFractalComponent(int surface[][], int hauteur) {
        this.surface = surface;
        this.hauteur = hauteur;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON);
        int n = hauteur / 16;

        // Lignes 790 à 830
        for (int y = 0; y < surface.length; y++) {
            for (int x = 0; x < surface.length; x++) {
                int c = surface[x][y] / n;
                if (c > 15) {
                    c = 15;
                }

                Utils.plot(g2d, x, y, Utils.getSurfaceColor(c));
            }
        }
    }

    public void setValues(int[][] surface, int hauteur) {
        this.surface = surface;
        this.hauteur = hauteur;

        this.setSize(surface.length, surface[0].length);
        this.repaint();
    }
}
