package net.cnam;

import java.awt.Color;
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

    // TODO revoir le pas
    public void surfaceDeBase(Graphics g) {

        int[][] surface = new int[taille][taille];

        // lignes 290 à 350
        for (int x = 0; x <= this.taille; x += this.pas) {
            for (int y = 0; y <= this.taille; y += this.pas) {
                surface[x][y] = random.nextInt() * this.hauteur;
                if (surface[x][y] < this.n) {
                    surface[x][y] = this.n;
                }

                int c = surface[x][y] / this.n;
                if (c > 15) {
                    c = 15;
                }

                plot(g, x * 4, y * 2, c);
            }
        }

        calculFractal(g, surface);
    }

    public void calculFractal(Graphics g, int[][] surface) {
        // lignes 360 à 380
        while (this.pas > 1) {
            int q = this.pas / 2;
            int e = this.deviation / 2;

            // lignes 390 à 450
            for (int x = q; x <= this.taille - q; x += this.pas) {
                for (int y = q; y <= this.taille - q; y += this.pas) {
                    this.hauteur = (surface[x - q][y - q] + surface[x - q][y + q] + surface[x + q][y - q]
                            + surface[x + q][y + q]) / 4 + this.deviation * this.random.nextInt() - e;
                    if (this.hauteur < this.n) {
                        this.hauteur = this.n;
                    }
                    int c = this.hauteur / this.n;
                    if (c > 15) {
                        c = 15;
                    }
                    surface[x][y] = this.hauteur;

                    plot(g, x * 4, y * 2, c);
                }
            }

            // lignes 460 à 560
            for (int x = this.pas; x <= this.taille - this.pas; x += this.pas) {
                for (int y = q; y <= this.taille - q; y += this.pas) {
                    this.hauteur = (surface[x - q][y] + surface[x + q][y] + surface[x][y - q] + surface[x][y + q]) / 4
                            + this.deviation * this.random.nextInt() - e;
                    if (this.hauteur < this.n) {
                        this.hauteur = this.n;
                    }
                    int c = this.hauteur / this.n;
                    if (c > 15) {
                        c = 15;
                    }
                    surface[x][y] = this.hauteur;

                    plot(g, x * 4, y * 2, c);

                    this.hauteur = (surface[y - q][x] + surface[y + q][x] + surface[y][x - q] + surface[y][x + q]) / 4
                            + this.deviation * this.random.nextInt() - e;
                    if (this.hauteur < this.n) {
                        this.hauteur = this.n;
                    }
                    c = this.hauteur / this.n;
                    if (c > 15) {
                        c = 15;
                    }
                    surface[y][x] = this.hauteur;

                    plot(g, y * 4, x * 2, c);
                }
            }

            // lignes 570 à 660
            for (int i = q; i <= this.taille - q; i += this.pas) {
                this.hauteur = (surface[0][i - q] + surface[0][i + q] + surface[q][i]) / 3
                        + this.deviation * this.random.nextInt() - e;
                if (this.hauteur < this.n) {
                    this.hauteur = this.n;
                }
                surface[0][i] = this.hauteur;
                this.hauteur = (surface[this.taille][i - q] + surface[this.taille][i + q] + surface[this.taille - q][i])
                        / 3
                        + this.deviation * this.random.nextInt() - e;
                if (this.hauteur < this.n) {
                    this.hauteur = this.n;
                }
                surface[this.taille][i] = this.hauteur;
                this.hauteur = (surface[i - q][0] + surface[i + q][0] + surface[i][q]) / 3
                        + this.deviation * this.random.nextInt() - e;
                if (this.hauteur < this.n) {
                    this.hauteur = this.n;
                }
                surface[i][0] = this.hauteur;
                this.hauteur = (surface[i - q][this.taille] + surface[i + q][this.taille] + surface[i][this.taille - q])
                        / 3
                        + this.deviation * this.random.nextInt() - e;
                if (this.hauteur < this.n) {
                    this.hauteur = this.n;
                }
                surface[i][this.taille] = this.hauteur;
            }

            // lignes 670 à 680
            this.pas /= 2;
            this.deviation /= 2;
        }
    }

    public void plot(Graphics g, int x, int y, int c) {
        Color color = new Color(c * 17, c * 17, c * 17);
        // System.out.println("x" + x + " y" + y + " c" + color.getRGB());
        g.setColor(color);
        g.drawLine(x, y, x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        surfaceDeBase(g);
    }
}