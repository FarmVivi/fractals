package net.cnam.fractals.gui.view.filfer;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class FilFerComponent extends JComponent {
    private final Fractals fractals;

    public FilFerComponent(Fractals fractals) {
        this.setLayout(null);

        this.fractals = fractals;

        this.setSize(fractals.getDimension3D());
    }

    @Override
    public void paint(Graphics g) {
        fractals.viewFilDeFer((Graphics2D) g);

        super.paint(g);
    }
}
