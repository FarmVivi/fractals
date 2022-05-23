package net.cnam.gui.window.view.ombres;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import net.cnam.Fractals;

public class OmbresViewPanel extends JPanel {
    private final Fractals fractals;

    public OmbresViewPanel(Fractals fractals) {
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.viewOmbres((Graphics2D) g);
    }
}
