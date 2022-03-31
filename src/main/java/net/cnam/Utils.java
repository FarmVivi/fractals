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
                // Bleu
                return Color.BLUE;
            case 1:
                // Jaune vif
                return new Color(97, 71, 0);
            case 2:
                // Turquoise
                return new Color(29, 73, 69);
            case 3:
                // Rouge vif
                return new Color(84, 12, 20);
            case 4:
                // Blanc brillant
                return new Color(76, 84, 84);
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
        g.drawRect(x, y, 1, 1);
    }
}
