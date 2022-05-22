package net.cnam.gui.window.view.strates;

import java.awt.Graphics;

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

        // TODO
    }
}
