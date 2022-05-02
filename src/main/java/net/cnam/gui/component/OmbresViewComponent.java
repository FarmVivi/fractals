package net.cnam.gui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import net.cnam.Utils;

public class OmbresViewComponent extends JComponent {

    private int surface[][];
    private int hauteur;

    public OmbresViewComponent(int surface[][], int hauteur) {
        this.surface = surface;
        this.hauteur = hauteur;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int n = hauteur / 16;

        // TODO A FAIRE
    }

    public void setValues(int[][] surface, int hauteur) {
        this.surface = surface;
        this.hauteur = hauteur;

        this.setSize(surface.length, surface[0].length);
        this.repaint();
    }
}
