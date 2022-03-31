package net.cnam;

import java.awt.*;
import java.util.Random;

public class Fractals {
    // Lignes 290 à 350
    public static int[][] surfaceDeBase(Graphics2D g, int maille, int hauteur, int taille, Random random)
            throws IllegalArgumentException {
        if (maille < 0 || maille > 3)
            throw new IllegalArgumentException("maille doit être compris entre 0 et 3");

        int[][] surface = new int[taille + 1][taille + 1];
        int n = hauteur / 16;
        int pas = (int) Math.pow(2, 7 - maille);

        for (int x = 0; x <= taille; x += pas) {
            for (int y = 0; y <= taille; y += pas) {
                surface[x][y] = (int) (random.nextFloat() * hauteur);
                if (surface[x][y] < n) {
                    surface[x][y] = n;
                }

                int c = surface[x][y] / n;
                if (c > 15) {
                    c = 15;
                }

                Utils.plot(g, x, y, c);
            }
        }

        return surface;
    }

    // Lignes 360 à 690
    public static int[][] calculFractal(Graphics2D g, int maille, int hauteur, int deviation, int taille, Random random,
            int[][] surface) {
        int n = hauteur / 16;
        int pas = (int) Math.pow(2, 7 - maille);

        while (pas > 1) {
            int q = pas / 2;
            int e = deviation / 2;

            // lignes 390 à 450
            for (int x = q; x <= taille - q; x += pas) {
                for (int y = q; y <= taille - q; y += pas) {
                    hauteur = (int) ((surface[x - q][y - q] + surface[x - q][y + q] + surface[x + q][y - q]
                            + surface[x + q][y + q]) / 4 + deviation * random.nextFloat() - e);
                    if (hauteur < n) {
                        hauteur = n;
                    }

                    int c = hauteur / n;
                    if (c > 15) {
                        c = 15;
                    }

                    surface[x][y] = hauteur;

                    Utils.plot(g, x, y, c);
                }
            }

            // lignes 460 à 560
            for (int x = pas; x <= taille - pas; x += pas) {
                for (int y = q; y <= taille - q; y += pas) {
                    hauteur = (int) ((surface[x - q][y] + surface[x + q][y] + surface[x][y - q] + surface[x][y + q]) / 4
                            + deviation * random.nextFloat() - e);
                    if (hauteur < n) {
                        hauteur = n;
                    }

                    int c = hauteur / n;
                    if (c > 15) {
                        c = 15;
                    }

                    surface[x][y] = hauteur;

                    Utils.plot(g, x, y, c);

                    hauteur = (int) ((surface[y - q][x] + surface[y + q][x] + surface[y][x - q] + surface[y][x + q]) / 4
                            + deviation * random.nextFloat() - e);
                    if (hauteur < n) {
                        hauteur = n;
                    }

                    c = hauteur / n;
                    if (c > 15) {
                        c = 15;
                    }

                    surface[y][x] = hauteur;

                    Utils.plot(g, y, x, c);
                }
            }

            // lignes 570 à 660
            for (int i = q; i <= taille - q; i += pas) {
                hauteur = (int) ((surface[0][i - q] + surface[0][i + q] + surface[q][i]) / 3
                        + deviation * random.nextFloat() - e);
                if (hauteur < n) {
                    hauteur = n;
                }
                surface[0][i] = hauteur;

                hauteur = (int) ((surface[taille][i - q] + surface[taille][i + q] + surface[taille - q][i]) / 3
                        + deviation * random.nextFloat() - e);
                if (hauteur < n) {
                    hauteur = n;
                }
                surface[taille][i] = hauteur;

                hauteur = (int) ((surface[i - q][0] + surface[i + q][0] + surface[i][q]) / 3
                        + deviation * random.nextFloat() - e);
                if (hauteur < n) {
                    hauteur = n;
                }
                surface[i][0] = hauteur;

                hauteur = (int) ((surface[i - q][taille] + surface[i + q][taille] + surface[i][taille - q]) / 3
                        + deviation * random.nextFloat() - e);
                if (hauteur < n) {
                    hauteur = n;
                }
                surface[i][taille] = hauteur;
            }

            pas /= 2;
            deviation /= 2;
        }

        return surface;
    }
}
