package net.cnam;

import java.awt.Color;
import java.awt.Graphics2D;

public class Utils {

    public static void plot(Graphics2D graphics, int x, int y, int c) {
        if (graphics == null)
            return;
        graphics.setColor(Utils.getSurfaceColor(c));
        // graphics.drawLine(x, y, x, y);
        graphics.drawRect(x, y, 1, 1);
    }

    public static void drawLine(Graphics2D graphics, int x1, int y1, int x2, int y2, int c) {
        if (graphics == null)
            return;
        graphics.setColor(Utils.getSurfaceColor(c));
        // graphics.drawLine(x1, y1, x2, y2);
        if (x1 == x2) {
            if (y2 > y1) {
                for (int i = y1; i <= y2; i++) {
                    graphics.drawRect(x1, i, 1, 1);
                }
            } else {
                for (int i = y2; i <= y1; i++) {
                    graphics.drawRect(x1, i, 1, 1);
                }
            }
        } else if (y1 == y2) {
            if (x2 > x1) {
                for (int i = x1; i <= x2; i++) {
                    graphics.drawRect(i, y1, 1, 1);
                }
            } else {
                for (int i = x2; i <= x1; i++) {
                    graphics.drawRect(i, y1, 1, 1);
                }
            }
        } else {
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    public static Color getSurfaceColor(int c) {
        if (c < 0 || c > 15) {
            throw new IllegalArgumentException("c doit être compris entre 0 et 15");
        }

        switch (c) {
            case 0:
                // Blanc
                // sommet montagne
                return new Color(255, 255, 255);
            case 1:
                // Blanc
                // haut de montagne (blanc)
                return new Color(255, 255, 255);
            case 2:
                // gris très clair
                // presque haut de montagne (gris très clair)
                return new Color(243, 244, 244);
            case 3:
                // gris moins clair
                // flanc de montagne (gris moins clair)
                return new Color(218, 221, 221);
            case 4:
                // gris foncé
                // flanc de montagne (gris foncé)
                return new Color(149, 151, 151);
            case 5:
                // vert très foncé
                // haut de pleine / début montagne (vert très foncé)
                return new Color(56, 82, 64);
            case 6:
                // vert foncé
                // haut de pleine (vert foncé)
                return new Color(64, 119, 81);
            case 7:
                // Vert
                // pleine (vert)
                return new Color(43, 153, 77);
            case 8:
                // vert clair
                // pleine basse (vert clair)
                return new Color(11, 194, 66);
            case 9:
                // jaune
                // plage (jaune)
                return new Color(218, 211, 4);
            case 10:
                // Turquoise
                // haut bordure plage (turquoise)
                return new Color(0, 224, 240);
            case 11:
                // Bleu super clair
                // eau peu profonde (bleu super clair)
                return new Color(123, 192, 238);
            case 12:
                // Bleu clair
                // eau semi profonde (bleu clair)
                return new Color(91, 173, 228);
            case 13:
                // bleu foncé
                // eau profonde
                return new Color(40, 128, 187);
            case 14:
                // TODO Bleu foncé x2
                // eau très profonde
                return new Color(21, 97, 147);
            case 15:
                // bleu foncé x3
                // eau super profonde
                return new Color(5, 64, 103);
            default:
                return Color.BLACK;
        }
    }

    public static Color getStratesColor(int c) {
        if (c < 0 || c > 15) {
            throw new IllegalArgumentException("c doit être compris entre 0 et 15");
        }

        switch (c) {
            case 0:
                // Noir
                return new Color(0, 0, 0);
            case 1:
                // Bleu
                return new Color(0, 0, 255);
            case 2:
                // Bleu vif
                return new Color(0, 0, 139);
            case 3:
                // Rouge
                return new Color(255, 0, 0);
            case 4:
                // Magenta
                return new Color(255, 0, 255);
            case 5:
                // TODO Mauve
                return new Color(212, 115, 212);
            case 6:
                // Rouge vif
                return new Color(139, 0, 0);
            case 7:
                // Violet
                return new Color(128, 0, 128);
            case 8:
                // Magenta vif
                return new Color(139, 0, 139);
            case 9:
                // Vert
                return new Color(0, 128, 0);
            case 10:
                // Turquoise
                return new Color(64, 224, 208);
            case 11:
                // Bleu ciel
                return new Color(135, 206, 235);
            case 12:
                // Jaune
                return new Color(255, 255, 0);
            case 13:
                // Blanc
                return new Color(255, 255, 255);
            case 14:
                // TODO Bleu pastel
                return Color.BLUE;
            case 15:
                // Orange
                return new Color(255, 165, 0);
            default:
                return Color.BLACK;
        }
    }

    public static Color getOmbresColor(int c) {
        if (c < 0 || c > 15) {
            throw new IllegalArgumentException("c doit être compris entre 0 et 15");
        }

        switch (c) {
            case 0:
                // Bleu foncé
                return new Color(50, 57, 175);
            case 1:
                // Bleu plus clair
                return new Color(137, 143, 253);
            case 2:
                // Bleu clair smr
                return new Color(38, 249, 254);
            case 3:
                // Jaune
                return new Color(254, 254, 38);
            case 4:
                // Magenta
                return new Color(255, 0, 255);
            case 5:
                // TODO Mauve
                return new Color(212, 115, 212);
            case 6:
                // Rouge vif
                return new Color(139, 0, 0);
            case 7:
                // Violet
                return new Color(128, 0, 128);
            case 8:
                // Magenta vif
                return new Color(139, 0, 139);
            case 9:
                // Vert
                return new Color(0, 128, 0);
            case 10:
                // Turquoise
                return new Color(64, 224, 208);
            case 11:
                // Bleu ciel
                return new Color(135, 206, 235);
            case 12:
                // Jaune
                return new Color(255, 255, 0);
            case 13:
                // Blanc
                return new Color(255, 255, 255);
            case 14:
                // Gris
                return new Color(218, 218, 210);
            case 15:
                // Blanc
                return new Color(255, 255, 255);
            default:
                return Color.BLACK;
        }
    }
}
