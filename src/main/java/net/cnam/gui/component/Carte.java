package net.cnam.gui.component;

import net.cnam.Fractals;

import javax.swing.*;
import java.awt.*;

public class Carte extends JComponent {
    private final Fractals fractals;

    public Carte(Fractals fractals) {
        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.map((Graphics2D) g);
    }
}
