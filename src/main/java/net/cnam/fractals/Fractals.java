package net.cnam.fractals;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Fractals {
    // Variables permanentes
    // Couleurs
    private final List<Color> colors = new ArrayList<>();
    // maille (0-3)
    private final int initM;
    // hauteur de base
    private final int initH;
    // déviation
    private final int initD;
    // graine
    private final long initZ;
    // taille (128, 64, 32)
    private final int initL;
    private final Semaphore semaphore = new Semaphore(1);
    // Variables "temporaires"
    private int moveX;
    private int moveY;
    private int[][] h1;
    private int[] c1;
    private int m;
    private int p;
    private int h2;
    private int d;
    private Random random;
    private int l;
    private int n;
    private int x;
    private int y;
    private int c2;
    private int q;
    private int e;
    private int i;
    private int nm;
    private int nmx;
    private int a;
    private int o;
    private int k;
    private int t;
    private int fh;
    private int o1;
    private int o2;
    private int pv;
    private int xm;
    private int ym;
    private int xj;
    private int yj;
    private int tr;
    private int ds;
    // Variables "temporaires" custom
    private int magicC;
    private boolean calculFractalDone = false;

    public Fractals(int m, int h, int d, long z, int l) {
        this.initM = m;
        this.initH = h;
        this.initD = d;
        this.initZ = z;
        this.initL = l;
        Color[] seaGradient = Utils.createGradient(new Color(0, 0, 128), new Color(0, 255, 255), 15);
        Color[] sandGradient = Utils.createGradient(new Color(202, 205, 0), new Color(255, 237, 0), 5);
        Color[] grassGradient = Utils.createGradient(new Color(106, 234, 0), new Color(58, 129, 0), 15);
        Color[] mountainGradient = Utils.createGradient(new Color(153, 153, 153), new Color(255, 255, 255), 10);
        colors.addAll(Arrays.asList(seaGradient));
        colors.addAll(Arrays.asList(sandGradient));
        colors.addAll(Arrays.asList(grassGradient));
        colors.addAll(Arrays.asList(mountainGradient));
    }

    private void reset() {
        this.moveX = 0;
        this.moveY = 0;
        this.h1 = new int[initL + 1][initL + 1];
        this.magicC = initL * 2 + initL / 2;
        this.c1 = new int[magicC + 1];
        this.m = initM;
        this.p = (int) Math.pow(2, 7 - m);
        this.h2 = initH;
        this.d = initD;
        this.random = new Random(initZ);
        this.l = initL;
        this.n = h2 / colors.size();
        this.x = 0;
        this.y = 0;
        this.c2 = 0;
        this.q = 0;
        this.e = 0;
        this.i = 0;
        this.nm = 0;
        this.nmx = 0;
        this.a = 0;
        this.o = 0;
        this.k = 0;
        this.t = 0;
        this.fh = 0;
        this.o1 = 0;
        this.o2 = 0;
        this.pv = 0;
        this.xm = 0;
        this.ym = 0;
        this.xj = 0;
        this.yj = 0;
        this.tr = 0;
        this.ds = 0;
    }

    private void plot(Graphics2D graphics, int x, int y, int c) {
        if (graphics == null) {
            return;
        }
        graphics.setColor(colors.get(c));
        graphics.drawLine(x, (int) (graphics.getClipBounds().getHeight() - y), x,
                (int) (graphics.getClipBounds().getHeight() - y));

        move(x, y);
    }

    private void move(int x, int y) {
        this.moveX = x;
        this.moveY = y;
    }

    private void drawLine(Graphics2D graphics, int x, int y, int c) {
        if (graphics == null) {
            return;
        }
        graphics.setColor(colors.get(c));
        graphics.drawLine(moveX, (int) (graphics.getClipBounds().getHeight() - moveY), x,
                (int) (graphics.getClipBounds().getHeight() - y));

        move(x, y);
    }

    // lignes 290 à 350
    private void surfaceDeBase(Graphics2D graphics) {
        for (x = 0; x <= l; x += p) {
            for (y = 0; y <= l; y += p) {
                h1[x][y] = (int) (random.nextFloat() * h2);
                if (h1[x][y] < n) {
                    h1[x][y] = n;
                }
                c2 = h1[x][y] / n;
                if (c2 > colors.size() - 1) {
                    c2 = colors.size() - 1;
                }
                plot(graphics, x, y, c2);
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
                    c2 = h2 / n;
                    if (c2 > colors.size() - 1) {
                        c2 = colors.size() - 1;
                    }
                    h1[x][y] = h2;
                    plot(graphics, x, y, c2);
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
                    c2 = h2 / n;
                    if (c2 > colors.size() - 1) {
                        c2 = colors.size() - 1;
                    }
                    h1[x][y] = h2;
                    plot(graphics, x, y, c2);

                    h2 = (int) ((h1[y - q][x] + h1[y + q][x] + h1[y][x - q] + h1[y][x + q]) / 4 + d * random.nextFloat()
                            - e);
                    if (h2 < n) {
                        h2 = n;
                    }
                    c2 = h2 / n;
                    if (c2 > colors.size() - 1) {
                        c2 = colors.size() - 1;
                    }
                    h1[y][x] = h2;
                    plot(graphics, y, x, c2);
                }
            }

            // lignes 570 à 660
            for (i = q; i <= l - q; i += p) {
                h2 = (int) ((h1[0][i - q] + h1[0][i + q] + h1[q][i]) / 3 + d * random.nextFloat() - e);
                if (h2 < n) {
                    h2 = n;
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

    // lignes 770 à 840
    private void surface(Graphics2D graphics) {
        for (y = 0; y <= l; y++) {
            for (x = 0; x <= l; x++) {
                c2 = h1[x][y] / n;
                if (c2 > colors.size() - 1) {
                    c2 = colors.size() - 1;
                }
                plot(graphics, x, y, c2);
            }
        }
    }

    // lignes 980 à 1140
    private void strates(Graphics2D graphics) {
        nm = n * 4;

        // lignes 1000 à 1040
        for (i = 0; i <= l; i++) {
            h2 = h1[0][i] + i;
            if (h2 < nm + i) {
                h2 = nm + i;
            }
            c1[l - i] = h2 - 2;
            h2 = h1[i][0] + i;
            if (h2 < nm + i) {
                h2 = nm + i;
            }
            c1[l + i] = h2 - 2;
        }

        // lignes 1050 à 1130
        for (y = 0; y <= l; y++) {
            for (x = 0; x <= l - 1; x++) {
                nmx = nm + x + y;
                a = l - y + x;
                if (a < 0 || a > magicC - 1) {
                    continue;
                }
                h2 = h1[x][y] + x + y;
                c2 = h1[x][y] / n;
                if (c2 > colors.size() - 1) {
                    c2 = colors.size() - 1;
                }
                if (h2 < nmx) {
                    h2 = nmx;
                }
                if (h2 <= c1[a]) {
                    plot(graphics, a * 4, c1[a], 0);
                }
                if (h2 > c1[a]) {
                    move(a * 4, c1[a] + 2);
                    drawLine(graphics, a * 4, h2 + 1, c2);
                    c1[a] = h2;
                }
            }
        }
    }

    // lignes 1150 à 1370
    private void ombres(Graphics2D graphics) {
        // ligne 1180
        for (i = 0; i <= l; i++) {
            c1[l - i] = h1[0][i] + i - 2;
            c1[l + i] = h1[i][0] + i - 2;
        }

        // lignes 1190 à 1300
        for (y = 0; y <= l; y++) {
            o1 = 0;
            o2 = 0;
            for (x = l; x >= o; x--) {
                a = l - y + x;
                if (a < 0 || a > magicC - 1) {
                    ombresPrivate();
                    continue;
                }
                h2 = h1[x][y] + x + y;
                c2 = 3;
                if (h1[x][y] >= o1) {
                    o1 = h1[x][y] + 1;
                } else {
                    c2 = 2;
                }
                if (h1[x][y] >= o2) {
                    o2 = h1[x][y] + 2;
                } else {
                    c2 = 1;
                }
                if (h2 < c1[a]) {
                    plot(graphics, a * 4, c1[a] - 2, c2 + 1);
                    ombresPrivate();
                    continue;
                }
                move(a * 4, c1[a]);
                drawLine(graphics, a * 4, h2, c2);
                c1[a] = h2 + 2;
                ombresPrivate();
            }
        }
    }

    private void ombresPrivate() {
        o1 = o1 - 1;
        o2 = o2 - 2;
    }

    // lignes 850 à 970
    private void filDeFer(Graphics2D graphics) {
        // 0, 40
        move(0, magicC / 8);
        // 160
        o = magicC / 2;
        // 0
        k = 0;
        // 320, 0
        drawLine(graphics, magicC, 0, 1);
        // 640, 40
        drawLine(graphics, magicC * 2, magicC / 8, 1);
        c1 = new int[magicC + 1];
        // 0, 128
        for (y = 0; y <= l; y += 2) {
            // - 320
            move(o * 4 - magicC, c1[o + k]);
            // 0
            k = 0;
            // 160
            o = magicC / 2 - y;
            if (o < 0)
                k = -o;
            // k, 128
            for (x = k; x <= l; x += 2) {
                t = h1[x][y] + y + x;
                h2 = Math.max(c1[x + o], t);
                c1[x + o] = h2;
                // - 320
                drawLine(graphics, (o + x) * 4 - magicC, h2, 1);
            }
            if (y != 0)
                // - 322
                drawLine(graphics, (o + x) * 4 - magicC - 2, fh, 1);
            fh = h2;
        }
    }

    private void jeu(Graphics2D graphics) {
        pv = 100;
        xm = (int) (Math.random() * 20) + 5;
        ym = (int) (Math.random() * 10) + 5;

        // AFFICHAGE CABANE
        plot(graphics, xm * 4, ym * 2, 13);
        move(xm * 4, ym * 2);
        drawLine(graphics, (xm + 2) * 4, ym * 2, 13);
        drawLine(graphics, (xm + 2) * 4, (ym + 2) * 2, 13);
        drawLine(graphics, xm * 4, (ym + 2) * 2, 13);
        drawLine(graphics, xm * 4, ym * 2, 13);

        // PLACE JOUEUR
        xj = (int) (Math.random() * 30) + 10;
        yj = (int) (Math.random() * 10) + 10;
        plot(graphics, xj * 4, yj * 2, 1);
        // faire de 1500 à 1610

        // RESULTATS
        pv = pv - 1;
        tr = (int) (Math.random() * 100);
        if (h1[xj][yj] < 5 && tr < 15) {
            pv = 100;
        }
        // encore un locate en 1550
        if (pv <= 0) {
            // ecrire "VOUS ETES MORT !"
            System.exit(0);
        }
        plot(graphics, xj * 4, yj * 2, 3);
        ds = (int) ((Math.pow(xj - xm, 2)) + (Math.pow(yj - ym, 2)));
        if (ds < 3) {
            // ecrire "SAUVE !"
            System.exit(0);
        }
        // GOTO 1500
    }

    public void newSurface(Graphics2D graphics) {
        semaphore.acquireUninterruptibly();

        reset();
        surfaceDeBase(graphics);
        calculFractal(graphics);
        calculFractalDone = true;

        semaphore.release();
    }

    public void map(Graphics2D graphics) {
        if (!calculFractalDone) {
            newSurface(null);
        }

        semaphore.acquireUninterruptibly();

        surface(graphics);

        semaphore.release();
    }

    public void viewStrates(Graphics2D graphics) {
        if (!calculFractalDone) {
            newSurface(null);
        }

        semaphore.acquireUninterruptibly();

        strates(graphics);

        semaphore.release();
    }

    public void viewOmbres(Graphics2D graphics) {
        if (!calculFractalDone) {
            newSurface(null);
        }

        semaphore.acquireUninterruptibly();

        ombres(graphics);

        semaphore.release();
    }

    public void viewFilDeFer(Graphics2D graphics) {
        if (!calculFractalDone) {
            newSurface(null);
        }

        semaphore.acquireUninterruptibly();

        filDeFer(graphics);

        semaphore.release();
    }

    public void game(Graphics2D graphics) {
        if (!calculFractalDone) {
            newSurface(null);
        }

        semaphore.acquireUninterruptibly();

        jeu(graphics);

        semaphore.release();
    }
}
