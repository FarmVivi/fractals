package net.cnam.window.menu;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.cnam.App;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
    private JButton newSurfaceButton;
    private JButton carteButton;
    private JButton stratesViewButton;
    private JButton ombresViewButton;
    private JButton filFerViewButton;
    private JButton gameButton;

    public MenuPanel(App app) {
        // Bouton "Nouvelle surface"
        this.newSurfaceButton = new JButton("Nouvelle surface");
        this.newSurfaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.launchNewSurfaceWindow();
            }
        });
        this.add(newSurfaceButton);

        // Bouton "Carte"
        this.carteButton = new JButton("Carte");
        this.carteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.launchCarteWindow();
            }
        });
        this.add(carteButton);

        // Bouton "Vue en strates"
        this.stratesViewButton = new JButton("Vue en strates");
        this.stratesViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.launchStratesViewWindow();
            }
        });
        this.add(stratesViewButton);

        // Bouton "Vue en ombres"
        this.ombresViewButton = new JButton("Vue en ombres");
        this.ombresViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.launchOmbresViewWindow();
            }
        });
        this.add(ombresViewButton);

        // Bouton "Vue en fils de fer"
        this.filFerViewButton = new JButton("Vue en fil de fer");
        this.filFerViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.launchFilFerViewWindow();
            }
        });
        this.add(filFerViewButton);

        // Bouton "Le jeu"
        this.gameButton = new JButton("Le jeu");
        this.gameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.launchGameWindow();
            }
        });
        this.add(gameButton);

        // TODO REMOVE THIS CODE
        JButton test1Button = new JButton("Test1");
        test1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.getNewSurfaceFrame().repaint();
            }
        });
        this.add(test1Button);

        // TODO REMOVE THIS CODE
        JButton test2Button = new JButton("Test2");
        test2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.getCarteFrame().repaint();
            }
        });
        this.add(test2Button);
    }
}
