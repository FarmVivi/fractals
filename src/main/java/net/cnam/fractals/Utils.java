package net.cnam.fractals;

import java.awt.*;

public class Utils {
    // Méthode pour créer un dégradé de couleurs entre 2 couleurs
    public static Color[] createGradient(Color color1, Color color2, int nbColors) {
        Color[] colors = new Color[nbColors];
        for (int i = 0; i < nbColors; i++) {
            colors[i] = new Color(color1.getRed() + (color2.getRed() - color1.getRed()) * i / nbColors,
                    color1.getGreen() + (color2.getGreen() - color1.getGreen()) * i / nbColors,
                    color1.getBlue() + (color2.getBlue() - color1.getBlue()) * i / nbColors);
        }
        return colors;
    }
}
