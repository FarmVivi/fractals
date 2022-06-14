package net.cnam.fractals.utils;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.Map;

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

    // Méthode pour ouvrir un lien dans un navigateur
    public static void openLink(URI url) {
        try {
            Desktop.getDesktop().browse(url);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossible d'ouvrir le lien : " + url, "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Méthode qui retourne un JLabel avec un lien clickable
    public static JLabel createLink(String text, String url) {
        JLabel label = new JLabel(text);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setForeground(Color.BLUE.darker());
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                openLink(URI.create(url));
            }
        });
        return label;
    }
}
