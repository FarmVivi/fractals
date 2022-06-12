package net.cnam.fractals.gui.carte;

import net.cnam.fractals.Fractals;

import javax.swing.*;

public class CartePanel extends JPanel {
    public CartePanel(Fractals fractals) {
        this.setLayout(null);

        CarteComponent carteComponent = new CarteComponent(fractals);
        this.add(carteComponent);

        this.setPreferredSize(carteComponent.getSize());
    }
}
