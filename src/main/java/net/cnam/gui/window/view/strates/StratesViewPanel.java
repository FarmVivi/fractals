package net.cnam.gui.window.view.strates;

import net.cnam.Fractals;

import javax.swing.*;
import java.awt.*;

public class StratesViewPanel extends JPanel {
    private final Fractals fractals;

    public StratesViewPanel(Fractals fractals) {
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.viewStrates((Graphics2D) g);
    }
}
