package net.cnam.fractals.gui.carte;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class CartePanel extends JPanel {
    private final Fractals fractals;

    public CartePanel(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.map((Graphics2D) g);
    }
}
