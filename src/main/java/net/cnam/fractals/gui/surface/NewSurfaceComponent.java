package net.cnam.fractals.gui.surface;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class NewSurfaceComponent extends JComponent {
    private final Fractals fractals;

    public NewSurfaceComponent(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;

        this.setSize(fractals.getDimension2D());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.newSurface((Graphics2D) g);
    }
}
