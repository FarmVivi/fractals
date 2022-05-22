package net.cnam.gui.window.surface;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import net.cnam.Fractals;

public class NewSurfacePanel extends JPanel {
    private Fractals fractals;

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
