package net.cnam;

import java.awt.Color;
import java.awt.Graphics2D;

public class Utils {
    public static Color getColor(int c) {
        if (c < 0 || c > 15)
            throw new IllegalArgumentException("c doit être compris entre 0 et 15");

        // TODO Faire un switch avec les bonnes couleurs
        switch (c) {
            case 0:
                return Color.BLACK;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.CYAN;
            case 3:
                return Color.DARK_GRAY;
            case 4:
                return Color.GRAY;
            case 5:
                return Color.GREEN;
            case 6:
                return Color.LIGHT_GRAY;
            case 7:
                return Color.MAGENTA;
            case 8:
                return Color.ORANGE;
            case 9:
                return Color.PINK;
            case 10:
                return Color.RED;
            case 11:
                return Color.WHITE;
            case 12:
                return Color.YELLOW;
            case 13:
                return Color.BLUE;
            case 14:
                return Color.CYAN;
            case 15:
                return Color.WHITE;
            default:
                return Color.BLACK;
        }
    }

    public static void plot(Graphics2D g, int x, int y, int c) {
        Color color = getColor(c);
        g.setColor(color);
        g.drawLine(x, y, x, y);
    }
}
