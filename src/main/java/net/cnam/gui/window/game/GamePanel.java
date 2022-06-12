package net.cnam.gui.window.game;

import net.cnam.Fractals;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Fractals fractals;

    public GamePanel(Fractals fractals) {
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        this.fractals = fractals;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        fractals.game((Graphics2D) g);
    }
}
