package net.cnam.gui.window.view.ombres;

import java.awt.Graphics;

import javax.swing.JPanel;

import net.cnam.Fractals;

public class OmbresViewPanel extends JPanel {
    private final Fractals fractals;

    public OmbresViewPanel(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // TODO
    }
}
