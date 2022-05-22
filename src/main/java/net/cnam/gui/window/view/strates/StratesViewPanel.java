package net.cnam.gui.window.view.strates;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import net.cnam.Fractals;

public class StratesViewPanel extends JPanel {
    private final Fractals fractals;

    public StratesViewPanel(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.viewStrates((Graphics2D) g);
    }
}
