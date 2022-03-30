package net.cnam;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Carte_Panel extends JPanel {

    // CHAMPS
    private int pas; // p
    private int maille; // m
    private int hauteur; // h
    private int deviation; // d
    private int taille; // l (à voir si on met des limites (128, 64, 32))
    private int n; // à voir son utilité plus tard

    private Random random; // z

    // CONSTRUCTEUR
    public Carte_Panel(int maille, int hauteur, int deviation, long graine, int taille)
            throws IllegalArgumentException {
        if (maille < 0 || maille > 3)
            throw new IllegalArgumentException("maille doit être compris entre 0 et 3");

        this.maille = maille;
        this.pas = (int) Math.pow(2, 7 - this.maille);
        System.out.println("Pas: " + this.pas);
        this.hauteur = hauteur;
        this.deviation = deviation;
        this.taille = taille;

        this.random = new Random(graine);

        this.n = this.hauteur / 16;

        repaint();
    }

    public void affichage() {
        this.repaint();
    }

    // ligne 290 - 350 ||| revoir le pas
    public void surfaceDeBase(Graphics g) {

        int[][] surface = new int[taille][taille];

        for (int x = 0; x < this.taille; x += this.pas) {
            for (int y = 0; y < this.taille; y += this.pas) {
                surface[x][y] = random.nextInt() * this.hauteur;
                if (surface[x][y] < this.n) {
                    surface[x][y] = this.n;
                }

                int c = surface[x][y] / this.n;
                if (c > 15) {
                    c = 15;
                }

                plot(g, x * 4, y * 2, new Color(c * 17, c * 17, c * 17));
            }
        }

        calculFractal(surface);
    }

    // on s'est arrêté dans se gros bourbier rpz la ligne 410
    public void calculFractal(int[][] h) {
        while (this.pas>1) {
            
            int q = this.pas / 2;
            int e = this.deviation / 2;

            for (int x = q ; x < this.taille - q ; x += this.pas){
                for (int y = q ; y < this.taille - q ; y += this.pas){
                    this.hauteur = (h[h[x-q,y-q]+h[x-q,y+q]+h[x+q,y-q]+h[x+q,y+q]]) / 4;
                }
            }
        }
    }

    public void plot(Graphics g, int x, int y, Color c) {
        System.out.println("x" + x + " y" + y + " c" + c.getRGB());
        g.setColor(c);
        g.drawLine(x, y, x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        surfaceDeBase(g);
    }
}