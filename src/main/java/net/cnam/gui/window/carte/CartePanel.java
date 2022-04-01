package net.cnam.gui.window.carte;

import javax.swing.JPanel;

import net.cnam.gui.component.CarteFractalComponent;

public class CartePanel extends JPanel {
    private CarteFractalComponent carteFractal;

    public CartePanel() {
        this.setLayout(null);

        carteFractal = new CarteFractalComponent(new int[0][0], 0);
        carteFractal.setLocation(0, 0);
        this.add(carteFractal);
    }

    public CarteFractalComponent getCarteFractal() {
        return carteFractal;
    }
}