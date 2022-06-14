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

        JPanel panelCredits = new JPanel();

        TitledBorder titledBorder = BorderFactory.createTitledBorder("Crédits");
        titledBorder.setTitleFont( titledBorder.getTitleFont().deriveFont(Font.BOLD));
        panelCredits.setBorder(BorderFactory.createCompoundBorder(
                titledBorder,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        panelCredits.setLayout(new GridBagLayout());

        gbc.ipadx = 10;
        gbc.ipady = 7;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridy = 0;
        gbc.gridx = 0;
        panelCredits.add(new JLabel("VAIZAND Victor"), gbc);
        gbc.gridx = 1;
        panelCredits.add(Utils.createLink("GitHub", "https://github.com/FarmVivi"), gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        panelCredits.add(new JLabel("ROUAULT Alban"), gbc);
        gbc.gridx = 1;
        panelCredits.add(Utils.createLink("GitHub", "https://github.com/albanrouault"), gbc);

        JPanel panelFractals = new JPanel();

        titledBorder = BorderFactory.createTitledBorder("Fractals");
        titledBorder.setTitleFont( titledBorder.getTitleFont().deriveFont(Font.BOLD));
        panelFractals.setBorder(BorderFactory.createCompoundBorder(
                titledBorder,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        gbc.ipady = 2;
        gbc.gridy = 0;
        gbc.gridx = 0;
        panelFractals.add(Utils.createLink("Projet GitHub", "https://github.com/cnam-bfc/NFA006-Fractals"), gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        this.add(panelCredits, gbc);
        gbc.gridy = 1;
        this.add(panelFractals, gbc);
    }
}