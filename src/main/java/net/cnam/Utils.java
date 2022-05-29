package net.cnam;

import java.awt.Color;

public class Utils {
    public static Color[] tryDegradeSaMere(Color colorUne, Color colorDeux, int nbDegra) {
        int rMax, rMin, gMax, gMin, bMax, bMin;
        if (colorUne.getRed() > colorDeux.getRed()) {
            rMax = colorUne.getRed();
            rMin = colorDeux.getRed();
        } else {
            rMin = colorUne.getRed();
            rMax = colorDeux.getRed();
        }

        if (colorUne.getGreen() > colorDeux.getGreen()) {
            gMax = colorUne.getGreen();
            gMin = colorDeux.getGreen();
        } else {
            gMin = colorUne.getGreen();
            gMax = colorDeux.getGreen();
        }

        if (colorUne.getBlue() > colorDeux.getBlue()) {
            bMax = colorUne.getBlue();
            bMin = colorDeux.getBlue();
        } else {
            bMin = colorUne.getBlue();
            bMax = colorDeux.getBlue();
        }

        float pasRed, pasGreen, pasBlue;
        pasRed = ((rMax - rMin) / nbDegra);
        pasGreen = ((gMax - gMin) / nbDegra);
        pasBlue = ((bMax - bMin) / nbDegra);

        Color[] result = new Color[nbDegra];
        for (int i = 0; i < nbDegra; i++) {
            result[i] = new Color(rMax - pasRed * i, gMax - pasGreen * i, bMax - pasBlue * i);
        }

        return result;
    }

    public static Color getSurfaceColor(int c) {
        if (c < 0 || c > 15) {
            throw new IllegalArgumentException("c doit être compris entre 0 et 15");
        }

        return switch (c) {
            case 15 ->
                // Blanc
                // sommet montagne
                    new Color(255, 255, 255);
            case 14 ->
                // Blanc
                // haut de montagne (blanc)
                    new Color(255, 255, 255);
            case 13 ->
                // gris très clair
                // presque haut de montagne (gris très clair)
                    new Color(243, 244, 244);
            case 12 ->
                // gris moins clair
                // flanc de montagne (gris moins clair)
                    new Color(218, 221, 221);
            case 11 ->
                // gris foncé
                // flanc de montagne (gris foncé)
                    new Color(149, 151, 151);
            case 10 ->
                // vert très foncé
                // haut de pleine / début montagne (vert très foncé)
                    new Color(56, 82, 64);
            case 9 ->
                // vert foncé
                // haut de pleine (vert foncé)
                    new Color(64, 119, 81);
            case 8 ->
                // Vert
                // pleine (vert)
                    new Color(43, 153, 77);
            case 7 ->
                // vert clair
                // pleine basse (vert clair)
                    new Color(11, 194, 66);
            case 6 ->
                // jaune
                // plage (jaune)
                    new Color(218, 211, 4);
            case 5 ->
                // Turquoise
                // haut bordure plage (turquoise)
                    new Color(0, 224, 240);
            case 4 ->
                // Bleu super clair
                // eau peu profonde (bleu super clair)
                    new Color(123, 192, 238);
            case 3 ->
                // Bleu clair
                // eau semi profonde (bleu clair)
                    new Color(91, 173, 228);
            case 2 ->
                // bleu foncé
                // eau profonde
                    new Color(40, 128, 187);
            case 1 ->
                // TODO Bleu foncé x2
                // eau très profonde
                    new Color(21, 97, 147);
            case 0 ->
                // bleu foncé x3
                // eau super profonde
                    new Color(5, 64, 103);
            default -> Color.BLACK;
        };
    }

    public static Color getStratesColor(int c) {
        if (c < 0 || c > 15) {
            throw new IllegalArgumentException("c doit être compris entre 0 et 15");
        }

        return switch (c) {
            case 0 ->
                // Noir
                    new Color(0, 0, 0);
            case 1 ->
                // Bleu
                    new Color(0, 0, 255);
            case 2 ->
                // Bleu vif
                    new Color(0, 0, 139);
            case 3 ->
                // Rouge
                    new Color(255, 0, 0);
            case 4 ->
                // Magenta
                    new Color(255, 0, 255);
            case 5 ->
                // TODO Mauve
                    new Color(212, 115, 212);
            case 6 ->
                // Rouge vif
                    new Color(139, 0, 0);
            case 7 ->
                // Violet
                    new Color(128, 0, 128);
            case 8 ->
                // Magenta vif
                    new Color(139, 0, 139);
            case 9 ->
                // Vert
                    new Color(0, 128, 0);
            case 10 ->
                // Turquoise
                    new Color(64, 224, 208);
            case 11 ->
                // Bleu ciel
                    new Color(135, 206, 235);
            case 12 ->
                // Jaune
                    new Color(255, 255, 0);
            case 13 ->
                // Blanc
                    new Color(255, 255, 255);
            case 14 ->
                // TODO Bleu pastel
                    Color.BLUE;
            case 15 ->
                // Orange
                    new Color(255, 165, 0);
            default -> Color.BLACK;
        };
    }

    public static Color getOmbresColor(int c) {
        if (c < 0 || c > 15) {
            throw new IllegalArgumentException("c doit être compris entre 0 et 15");
        }

        return switch (c) {
            case 0 ->
                // Bleu foncé
                    new Color(50, 57, 175);
            case 1 ->
                // Bleu plus clair
                    new Color(137, 143, 253);
            case 2 ->
                // Bleu clair smr
                    new Color(38, 249, 254);
            case 3 ->
                // Jaune
                    new Color(254, 254, 38);
            case 4 ->
                // Magenta
                    new Color(255, 0, 255);
            case 5 ->
                // TODO Mauve
                    new Color(212, 115, 212);
            case 6 ->
                // Rouge vif
                    new Color(139, 0, 0);
            case 7 ->
                // Violet
                    new Color(128, 0, 128);
            case 8 ->
                // Magenta vif
                    new Color(139, 0, 139);
            case 9 ->
                // Vert
                    new Color(0, 128, 0);
            case 10 ->
                // Turquoise
                    new Color(64, 224, 208);
            case 11 ->
                // Bleu ciel
                    new Color(135, 206, 235);
            case 12 ->
                // Jaune
                    new Color(255, 255, 0);
            case 13 ->
                // Blanc
                    new Color(255, 255, 255);
            case 14 ->
                // Gris
                    new Color(218, 218, 210);
            case 15 ->
                // Blanc
                    new Color(255, 255, 255);
            default -> Color.BLACK;
        };
    }
}
