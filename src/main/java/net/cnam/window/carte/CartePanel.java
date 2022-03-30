package net.cnam.window.carte;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import net.cnam.Utils;

public class CartePanel extends JPanel {
    private int surface[][];
    private int n;

    public void setValues(int[][] surface, int n) {
        this.surface = surface;
        this.n = n;
    }

    public void carte(Graphics2D g) {
        // Lignes 790 à 830
        for (int y = 0; y <= surface.length - 1; y++) {
            for (int x = 0; x <= surface.length - 1; x++) {
                int c = surface[x][y] / n;
                if (c > 15) {
                    c = 15;
                }

                Utils.plot(g, x * 4, y * 2, c);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        carte((Graphics2D) g);
    }
}