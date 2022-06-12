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

    // Méthode pour générer un entier aléatoire entre min et max
    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
