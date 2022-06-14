package net.cnam.fractals.gui.main;

import net.cnam.fractals.utils.Utils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AboutPanel extends JPanel {
    public AboutPanel() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel troudeballe = new JPanel();

        TitledBorder titledBorder = BorderFactory.createTitledBorder("Crédits");
        titledBorder.setTitleFont( titledBorder.getTitleFont().deriveFont(Font.BOLD));
        troudeballe.setBorder(BorderFactory.createCompoundBorder(
                titledBorder,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        troudeballe.setLayout(new GridBagLayout());

        gbc.ipadx = 10;
        gbc.ipady = 7;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridy = 0;
        gbc.gridx = 0;
        troudeballe.add(new JLabel("VAIZAND Victor"), gbc);
        gbc.gridx = 1;
        troudeballe.add(Utils.createLink("GitHub", "https://github.com/FarmVivi"), gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        troudeballe.add(new JLabel("ROUAULT Alban"), gbc);
        gbc.gridx = 1;
        troudeballe.add(Utils.createLink("GitHub", "https://github.com/albanrouault"), gbc);

        JPanel troudeballeV2 = new JPanel();

        titledBorder = BorderFactory.createTitledBorder("Fractals");
        titledBorder.setTitleFont( titledBorder.getTitleFont().deriveFont(Font.BOLD));
        troudeballeV2.setBorder(BorderFactory.createCompoundBorder(
                titledBorder,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        gbc.ipady = 2;
        gbc.gridy = 0;
        gbc.gridx = 0;
        troudeballeV2.add(Utils.createLink("Projet GitHub", "https://github.com/cnam-bfc/NFA006-Fractals"), gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        this.add(troudeballe, gbc);
        gbc.gridy = 1;
        this.add(troudeballeV2, gbc);
    }
}