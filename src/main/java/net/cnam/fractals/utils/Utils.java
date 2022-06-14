package net.cnam.fractals.utils;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import java.awt.*;
import java.awt.image.BufferedImage;

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

    public static BufferedImage loadImage(String svgFileURI, float width, float height) throws TranscoderException {
        BufferedImageTranscoder imageTranscoder = new BufferedImageTranscoder();

        imageTranscoder.addTranscodingHint(PNGTranscoder.KEY_WIDTH, width);
        imageTranscoder.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, height);

        TranscoderInput input = new TranscoderInput(svgFileURI);
        imageTranscoder.transcode(input, null);

        return imageTranscoder.getBufferedImage();
    }
}
