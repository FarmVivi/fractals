package net.cnam.fractals.gui.game;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.view.strates.StratesComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private final JFrame mainFrame;
    private final Fractals fractals;
    private final StratesComponent stratesComponent;

    public GamePanel(JFrame mainFrame, Fractals fractals) {
        this.mainFrame = mainFrame;
        this.fractals = fractals;

        fractals.initGame();

        this.setLayout(null);

        this.stratesComponent = new StratesComponent(fractals);

        this.setPreferredSize(stratesComponent.getSize());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        stratesComponent.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        fractals.game(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'z')
            fractals.moveGame(mainFrame, this, 0);
        else if (e.getKeyChar() == 's')
            fractals.moveGame(mainFrame, this, 1);
        else if (e.getKeyChar() == 'q')
            fractals.moveGame(mainFrame, this, 3);
        else if (e.getKeyChar() == 'd')
            fractals.moveGame(mainFrame, this, 2);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
