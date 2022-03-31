package net.cnam.gui.window.surface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

import net.cnam.App;
import net.cnam.Utils;

// A partir de la ligne 180
public class NewSurfacePanel extends JPanel {
    private App app;

    private int maille;
    private int hauteur;
    private int deviation;
    private int taille;
    private long graine;

    public NewSurfacePanel(App app, int maille, int hauteur, int deviation, int taille, long graine)
            throws IllegalArgumentException {
        if (maille < 0 || maille > 3)
            throw new IllegalArgumentException("maille doit être compris entre 0 et 3");

        this.app = app;

        this.maille = maille;
        this.hauteur = hauteur;
        this.deviation = deviation;
        this.taille = taille;
        this.graine = graine;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Random random = new Random(graine);

        int[][] surface = Utils.surfaceDeBase((Graphics2D) g, maille, hauteur, taille, random);
        surface = Utils.calculFractal((Graphics2D) g, maille, hauteur, deviation, taille, random, surface);
        this.app.getCarteFrame().getCartePanel().setValues(surface, hauteur);
    }
}