package net.cnam.fractals.gui.view.strates;

import net.cnam.fractals.Fractals;

import javax.swing.*;
import java.awt.*;

public class StratesPanel extends JPanel {
    public StratesPanel(Fractals fractals) {
        this.setLayout(null);

        StratesComponent stratesComponent = new StratesComponent(fractals);
        this.add(stratesComponent);

        this.setPreferredSize(stratesComponent.getSize());
        this.setBackground(Color.BLACK);
    }
}
