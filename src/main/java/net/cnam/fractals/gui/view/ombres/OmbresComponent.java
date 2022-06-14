package net.cnam.fractals.gui.view.ombres;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class OmbresComponent extends JComponent {
    private final Fractals fractals;

    public OmbresComponent(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;

        this.setSize(fractals.getDimension3D());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        fractals.viewOmbres(g2d);
    }
}
