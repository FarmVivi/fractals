package net.cnam;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Panel extends JPanel {
    private JButton newSurfaceButton;
    private JButton carteButton;
    private JButton stratesViewButton;
    private JButton ombresViewButton;
    private JButton filFerViewButton;
    private JButton gameButton;

    public Main_Panel(App app) {
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
        this.add(carteButton);

        // Bouton "Vue en strates"
        this.stratesViewButton = new JButton("Vue en strates");
        this.add(stratesViewButton);

        // Bouton "Vue en ombres"
        this.ombresViewButton = new JButton("Vue en ombres");
        this.add(ombresViewButton);

        // Bouton "Vue en fils de fer"
        this.filFerViewButton = new JButton("Vue en fil de fer");
        this.add(filFerViewButton);

        // Bouton "Le jeu"
        this.gameButton = new JButton("Le jeu");
        this.add(gameButton);
    }
}
