package net.cnam.fractals.gui.surface;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class NewSurfacePanel extends JPanel {
    private final Fractals fractals;

    public NewSurfacePanel(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.newSurface((Graphics2D) g);
    }
}
