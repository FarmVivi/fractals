package net.cnam;

import java.awt.Graphics2D;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Fractals {

    // Variables permanentes
    private int[][] h1;
    private int[] C;
    // maille (0-3)
    private int m;
    private int p;
    // hauteur de base
    private int h2;
    // déviation
    private int d;
    // random
    private Random random;
    // taille (128, 64, 32)
    private int l;
    private int n;

    // Variables "temporaires"
    private int x;
    private int y;
    private int c;
    private int q;
    private int e;
    private int i;

    // Variables en plus pour le bon déroulement du programme
    private Semaphore semaphore = new Semaphore(1);
    private boolean calculFractalDone = false;

    public Fractals(int m, int h, int d, long z, int l) {
        this.h1 = new int[129][129];
        this.C = new int[321];
        this.m = m;
        this.p = (int) Math.pow(2, 7 - m);
        this.h2 = h;
        this.d = d;
        this.random = new Random(z);
        this.l = l;
        this.n = h2 / 16;
    }

    private static void plot(Graphics2D graphics, int x, int y, int c) {
        if (graphics == null)
            return;
        graphics.setColor(Utils.getSurfaceColor(c));
        graphics.drawRect(x, y, 1, 1);
    }

    // lignes 290 à 350
    private void surfaceDeBase(Graphics2D graphics) {
        for (x = 0; x <= l; x += p) {
            for (y = 0; y <= l; y += p) {
                h1[x][y] = (int) (random.nextFloat() * h2);
                if (h1[x][y] < n) {
                    h1[x][y] = n;
                }
                c = h1[x][y] / n;
                if (c > 15) {
                    c = 15;
                }
                plot(graphics, x, y, c);
            }
        }
    }

    // lignes 360 à 690
    private void calculFractal(Graphics2D graphics) {
        while (p > 1) {
            q = p / 2;
            e = d / 2;

            // lignes 390 à 450
            for (x = q; x <= l - q; x += p) {
                for (y = q; y <= l - q; y += p) {
                    h2 = (int) ((h1[x - q][y - q] + h1[x - q][y + q] + h1[x + q][y - q] + h1[x + q][y + q]) / 4
                            + d * random.nextFloat() - e);
                    if (h2 < n) {
                        h2 = n;
                    }
                    c = h2 / n;
                    if (c > 15) {
                        c = 15;
                    }
                    h1[x][y] = h2;
                    plot(graphics, x, y, c);
                }
            }

            // lignes 460 à 560
            for (x = p; x <= l - p; x += p) {
                for (y = q; y <= l - q; y += p) {
                    h2 = (int) ((h1[x - q][y] + h1[x + q][y] + h1[x][y - q] + h1[x][y + q]) / 4 + d * random.nextFloat()
                            - e);
                    if (h2 < n) {
                        h2 = n;
                    }
                    c = h2 / n;
                    if (c > 15) {
                        c = 15;
                    }
                    h1[x][y] = h2;
                    plot(graphics, x, y, c);

                    h2 = (int) ((h1[y - q][x] + h1[y + q][x] + h1[y][x - q] + h1[y][x + q]) / 4 + d * random.nextFloat()
                            - e);
                    if (h2 < n) {
                        h2 = n;
                    }
                    c = h2 / n;
                    if (c > 15) {
                        c = 15;
                    }
                    h1[y][x] = h2;
                    plot(graphics, x, y, c);
                }
            }

            // lignes 570 à 660
            for (i = q; i <= l - q; i += p) {
                h2 = (int) ((h1[0][i - q] + h1[0][i + q] + h1[q][i]) / 3 + d * random.nextFloat() - e);
                if (h2 < n) {
                    h2 = n;
                }
                c = h2 / n;
                if (c > 15) {
                    c = 15;
                }
                h1[0][i] = h2;

                h2 = (int) ((h1[l][i - q] + h1[l][i + q] + h1[l - q][i]) / 3 + d * random.nextFloat() - e);
                if (h2 < n) {
                    h2 = n;
                }
                h1[l][i] = h2;

                h2 = (int) ((h1[i - q][0] + h1[i + q][0] + h1[i][q]) / 3 + d * random.nextFloat() - e);
                if (h2 < n) {
                    h2 = n;
                }
                h1[i][0] = h2;

                h2 = (int) ((h1[i - q][l] + h1[i + q][l] + h1[i][l - q]) / 3 + d * random.nextFloat() - e);
                if (h2 < n) {
                    h2 = n;
                }
                h1[i][l] = h2;
            }

            p = p / 2;
            d = d / 2;
        }
    }

    private void surface(Graphics2D graphics) {
        for (y = 0; y <= 128; y++) {
            for (x = 0; x <= 128; x++) {
                c = h1[x][y] / n;
                if (c > 15) {
                    c = 15;
                }
                plot(graphics, x, y, c);
            }
        }
    }

    public void newSurface(Graphics2D graphics) {
        semaphore.acquireUninterruptibly();
        surfaceDeBase(graphics);
        calculFractal(graphics);
        calculFractalDone = true;
        semaphore.release();
    }

    public void map(Graphics2D graphics) {
        semaphore.acquireUninterruptibly();
        if (!calculFractalDone) {
            newSurface(null);
        }
        surface(graphics);
        semaphore.release();
    }
}
