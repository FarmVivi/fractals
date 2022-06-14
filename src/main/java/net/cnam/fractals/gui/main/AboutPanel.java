package net.cnam.fractals.gui.main;

import net.cnam.fractals.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class AboutPanel extends JPanel {
    public AboutPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;


        this.add(new JLabel("Crédits:"), gbc);
        gbc.gridy = 1;
        this.add(Utils.createLink("Rouault Alban", "https://github.com/albanrouault"), gbc);
        gbc.gridy = 2;
        this.add(Utils.createLink("Vaizand Victor", "https://github.com/FarmVivi"), gbc);
        gbc.gridy = 3;
        this.add(Utils.createLink("Projet GitHub", "https://github.com/cnam-bfc/NFA006-Fractals"), gbc);
    }
}
