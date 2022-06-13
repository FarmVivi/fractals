package net.cnam.fractals;

import java.io.*;
import java.util.Random;

public class FractalsSettings {
    // maille (0-3)
    private final int maille;
    // hauteur de base
    private final int hauteur;
    // déviation
    private final int deviation;
    // graine
    private final long graine;
    // taille (128, 64, 32)
    private final int taille;

    public FractalsSettings() {
        this(Utils.randomInt(1, 3),
                Utils.randomInt(64, 128),
                Utils.randomInt(1, 3),
                new Random().nextLong(),
                Utils.randomInt(128, 1024));
    }

    public FractalsSettings(int maille, int hauteur, int deviation, long graine, int taille) {
        this.maille = maille;
        this.hauteur = hauteur;
        this.deviation = deviation;
        this.graine = graine;
        this.taille = taille;

        verifyParameters();
    }

    public FractalsSettings(File saveFile) throws IOException {
        FileInputStream fluxEntree = new FileInputStream(saveFile);
        BufferedInputStream tamponEntree = new BufferedInputStream(fluxEntree);
        DataInputStream entree = new DataInputStream(tamponEntree);

        if (entree.available() != 5) {
            entree.close();
            throw new IllegalArgumentException("Fractals settings file (" + saveFile.getAbsolutePath() + ") is corrupted");
        }

        this.maille = entree.readInt();
        this.hauteur = entree.readInt();
        this.deviation = entree.readInt();
        this.graine = entree.readLong();
        this.taille = entree.readInt();

        entree.close();

        verifyParameters();
    }

    private void verifyParameters() {
        if (maille < 0 || maille > 3) {
            throw new IllegalArgumentException("maille must be between 0 and 3");
        }
        if (hauteur <= 0) {
            throw new IllegalArgumentException("hauteur must be greater than 0");
        }
        if (deviation < 0) {
            throw new IllegalArgumentException("deviation must be positive");
        }
        if (taille <= 0) {
            throw new IllegalArgumentException("taille must be greater than 0");
        }
    }

    public void save(File saveFile) throws IOException {
        FileOutputStream fluxSortie = new FileOutputStream(saveFile);
        BufferedOutputStream tamponSortie = new BufferedOutputStream(fluxSortie);
        DataOutputStream sortie = new DataOutputStream(tamponSortie);

        sortie.writeInt(maille);
        sortie.writeInt(hauteur);
        sortie.writeInt(deviation);
        sortie.writeLong(graine);
        sortie.writeInt(taille);

        sortie.close();
    }

    public int getMaille() {
        return maille;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getDeviation() {
        return deviation;
    }

    public long getGraine() {
        return graine;
    }

    public int getTaille() {
        return taille;
    }
}
