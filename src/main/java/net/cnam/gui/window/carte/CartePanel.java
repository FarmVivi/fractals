package net.cnam.gui.window.carte;

import net.cnam.Fractals;

import javax.swing.*;
import java.awt.*;

public class CartePanel extends JScrollPane {
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
