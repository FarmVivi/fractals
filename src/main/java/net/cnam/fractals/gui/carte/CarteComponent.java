package net.cnam.fractals.gui.carte;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class CarteComponent extends JComponent {
    private final Fractals fractals;

    public CarteComponent(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;

        this.setSize(fractals.getDimension2D());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        fractals.map(g2d);
        g2d.dispose();
    }
}
