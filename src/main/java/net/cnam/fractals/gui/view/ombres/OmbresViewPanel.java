package net.cnam.fractals.gui.view.ombres;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

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
