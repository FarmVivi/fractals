package net.cnam.fractals.gui.main;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        this.setLayout(new GridBagLayout());
    }

    @Override
    public Component add(Component comp) {
        if (comp.getBackground() != null) {
            this.setBackground(comp.getBackground());
        }
        return super.add(comp);
    }

    @Override
    public void removeAll() {
        this.setBackground(null);
        super.removeAll();
    }
}
