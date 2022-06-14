package net.cnam.fractals.gui.main;

import javax.swing.*;
import java.awt.*;

public class FractalsSettingsDialog extends JDialog {
    private JTextField textFieldMaille = new JTextField();
    private JTextField textFieldDeviation = new JTextField();
    private JTextField textFieldTaille = new JTextField();

    public FractalsSettingsDialog(Frame owner) {
        super(owner, "Nouveau...", true);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(owner);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new GridLayout(3, 2, 10, 10));

        contentPane.add(new JLabel("Maille : "));
        contentPane.add(textFieldMaille);

        contentPane.add(new JLabel("Deviation : "));
        contentPane.add(textFieldDeviation);

        contentPane.add(new JLabel("Taille : "));
        contentPane.add(textFieldTaille);

        this.pack();
    }
}

   /*panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

    JPanel panelMaille = new JPanel();
    JLabel labelMaille = new JLabel("Maille : ");
    JTextField textFieldMaille = new JTextField("Maille comprise entre 0 et 3", 50);
            panelMaille.add(labelMaille);
            panelMaille.add(textFieldMaille);
            panel.add(panelMaille);

    JPanel panelDeviation = new JPanel();
    JLabel labelDeviation = new JLabel("Deviation : ");
    JTextField textFieldDeviation = new JTextField("Deviation : positive", 50);
            panelDeviation.add(labelDeviation);
            panelDeviation.add(textFieldDeviation);
            panel.add(panelDeviation);

    JPanel panelTaille = new JPanel();
    JLabel labelTaille = new JLabel("Taille : ");
    JTextField textFieldTaille = new JTextField("Taille : positive", 50);
            panelTaille.add(labelTaille);
            panelTaille.add(textFieldTaille);
            panel.add(panelTaille);*/
