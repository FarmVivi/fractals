package net.cnam.fractals.gui.surface;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class NewSurfacePanel extends JPanel {
    public NewSurfacePanel(Fractals fractals) {
        this.setLayout(null);

        NewSurfaceComponent newSurfaceComponent = new NewSurfaceComponent(fractals);
        this.add(newSurfaceComponent);

        this.setPreferredSize(newSurfaceComponent.getSize());
    }
}
