package net.cnam.fractals.gui.view.ombres;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class OmbresPanel extends JPanel {
    public OmbresPanel(Fractals fractals) {
        this.setLayout(null);

        OmbresComponent ombresComponent = new OmbresComponent(fractals);
        this.add(ombresComponent);

        this.setPreferredSize(ombresComponent.getSize());
    }
}
