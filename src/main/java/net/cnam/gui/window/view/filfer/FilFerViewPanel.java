package net.cnam.gui.window.view.filfer;

import java.awt.Graphics;

import javax.swing.JPanel;

import net.cnam.Fractals;

public class FilFerViewPanel extends JPanel {
    private final Fractals fractals;

    public FilFerViewPanel(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // TODO
    }
}
