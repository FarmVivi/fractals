package net.cnam.fractals.gui.game;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.view.strates.StratesComponent;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Fractals fractals;

    public GamePanel(Fractals fractals) {
        this.fractals = fractals;

        this.setLayout(null);
        this.setBackground(Color.BLACK);

        StratesComponent stratesComponent = new StratesComponent(fractals);
        this.add(stratesComponent);

        this.setPreferredSize(stratesComponent.getSize());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.game((Graphics2D) g);
    }
}
