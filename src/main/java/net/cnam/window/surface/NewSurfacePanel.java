package net.cnam.window.surface;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import net.cnam.App;
import net.cnam.Utils;

// A partir de la ligne 180
public class NewSurfacePanel extends JPanel {
    private App app;

    private int p; // pas
    private int m; // maille
    private int h; // hauteur
    private int d; // deviation
    private int l; // taille (à voir si on met des limites (128, 64, 32))
    private int n; // à voir son utilité plus tard

    private Random random; // z

    private int[][] surface; // h

    // Paramètres
    // Lignes 170 à 270
    public NewSurfacePanel(App app, int maille, int hauteur, int deviation, long graine, int taille)
            throws IllegalArgumentException {
        if (maille < 0 || maille > 3)
            throw new IllegalArgumentException("maille doit être compris entre 0 et 3");

        this.app = app;

        // + 1 car en basic il y a pas d'indice 0, ça va de 1 à taille
        this.surface = new int[taille + 1][taille + 1];

        this.m = maille;
        this.p = (int) Math.pow(2, 7 - this.m);
        System.out.println("Pas: " + this.p);
        this.h = hauteur;
        this.d = deviation;
        this.l = taille;

        this.random = new Random(graine);

        this.n = this.h / 16;
    }

    // Lignes 290 à 350
    public void surfaceDeBase(Graphics g) {
        for (int x = 0; x <= l; x += p) {
            for (int y = 0; y <= l; y += p) {
                surface[x][y] = (int) (random.nextFloat() * h);
                if (surface[x][y] < n) {
                    surface[x][y] = n;
                }

                int c = surface[x][y] / n;
                if (c > 15) {
                    c = 15;
                }

                Utils.plot(g, x * 4, y * 2, c);
            }
        }
    }

    // Lignes 360 à 690
    public void calculFractal(Graphics g) {
        while (p > 1) {
            int q = p / 2;
            int e = d / 2;

            // lignes 390 à 450
            for (int x = q; x <= l - q; x += p) {
                for (int y = q; y <= l - q; y += p) {
                    h = (int) ((surface[x - q][y - q] + surface[x - q][y + q] + surface[x + q][y - q]
                            + surface[x + q][y + q]) / 4 + d * random.nextFloat() - e);
                    if (h < n) {
                        h = n;
                    }

                    int c = h / n;
                    if (c > 15) {
                        c = 15;
                    }

                    surface[x][y] = h;

                    Utils.plot(g, x * 4, y * 2, c);
                }
            }

            // lignes 460 à 560
            for (int x = p; x <= l - p; x += p) {
                for (int y = q; y <= l - q; y += p) {
                    h = (int) ((surface[x - q][y] + surface[x + q][y] + surface[x][y - q] + surface[x][y + q]) / 4
                            + d * random.nextFloat() - e);
                    if (h < n) {
                        h = n;
                    }

                    int c = h / n;
                    if (c > 15) {
                        c = 15;
                    }

                    surface[x][y] = h;

                    Utils.plot(g, x * 4, y * 2, c);

                    h = (int) ((surface[y - q][x] + surface[y + q][x] + surface[y][x - q] + surface[y][x + q]) / 4
                            + d * random.nextFloat() - e);
                    if (h < n) {
                        h = n;
                    }

                    c = h / n;
                    if (c > 15) {
                        c = 15;
                    }

                    surface[y][x] = h;

                    Utils.plot(g, y * 4, x * 2, c);
                }
            }

            // lignes 570 à 660
            for (int i = q; i <= l - q; i += p) {
                h = (int) ((surface[0][i - q] + surface[0][i + q] + surface[q][i]) / 3
                        + d * random.nextFloat() - e);
                if (h < n) {
                    h = n;
                }
                surface[0][i] = h;

                h = (int) ((surface[l][i - q] + surface[l][i + q] + surface[l - q][i]) / 3
                        + d * random.nextFloat() - e);
                if (h < n) {
                    h = n;
                }
                surface[l][i] = h;

                h = (int) ((surface[i - q][0] + surface[i + q][0] + surface[i][q]) / 3
                        + d * random.nextFloat() - e);
                if (h < n) {
                    h = n;
                }
                surface[i][0] = h;

                h = (int) ((surface[i - q][l] + surface[i + q][l] + surface[i][l - q]) / 3
                        + d * random.nextFloat() - e);
                if (h < n) {
                    h = n;
                }
                surface[i][l] = h;
            }

            p /= 2;
            d /= 2;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        surfaceDeBase(g);
        calculFractal(g);
        this.app.getCarteFrame().getCartePanel().setValues(this.surface, this.n);
    }
}