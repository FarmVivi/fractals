package net.cnam.fractals.gui.view.filfer;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class FilFerPanel extends JPanel {
    public FilFerPanel(Fractals fractals) {
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        FilFerComponent filFerComponent = new FilFerComponent(fractals);
        this.add(filFerComponent);

        this.setPreferredSize(filFerComponent.getSize());
    }
}
