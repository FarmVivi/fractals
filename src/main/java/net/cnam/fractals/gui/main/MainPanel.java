package net.cnam.fractals.gui.main;

import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

public class MainPanel extends JPanel {
    private final JSVGCanvas svgCanvas;

    public MainPanel() {
        this.setLayout(new GridBagLayout());

        this.svgCanvas = new JSVGCanvas();
        try {
            svgCanvas.setURI(MainPanel.class.getResource("/assets/svg/logo.svg").toURI().toString());
            svgCanvas.setBackground(null);
            super.add(svgCanvas);
        } catch (URISyntaxException ignored) {
        }
    }

    @Override
    public Component add(Component comp) {
        super.remove(svgCanvas);
        return super.add(comp);
    }

    @Override
    public void removeAll() {
        super.removeAll();
        super.add(svgCanvas);
    }
}
