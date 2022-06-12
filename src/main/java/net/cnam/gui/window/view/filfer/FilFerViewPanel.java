package net.cnam.gui.window.view.filfer;

import net.cnam.Fractals;

import javax.swing.*;
import java.awt.*;

public class FilFerViewPanel extends JPanel {
    private final Fractals fractals;

    public FilFerViewPanel(Fractals fractals) {
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.viewFilDeFer((Graphics2D) g);
    }
}
