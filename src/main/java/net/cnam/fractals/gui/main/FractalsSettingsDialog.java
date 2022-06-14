package net.cnam.fractals.gui.main;

import javax.swing.*;
import java.awt.*;

public class FractalsSettingsDialog extends JDialog {
    private JTextField textFieldDeviation = new JTextField();
    private JTextField textFieldTaille = new JTextField();
    private JTextField textFieldHauteur = new JTextField();
    private JTextField textFieldGraine = new JTextField();

    public FractalsSettingsDialog(Frame owner) {
        super(owner, "Nouveau...", true);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(owner);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new GridLayout(6, 2, 10, 10));

        contentPane.add(new JLabel("Maille : "));
        JSlider slideMaille = new JSlider();
        slideMaille.setMinimum(0);
        slideMaille.setMaximum(3);
        slideMaille.setPaintTicks(true);
        slideMaille.setPaintLabels(true);
        slideMaille.setMajorTickSpacing(1);
        contentPane.add(slideMaille);

        contentPane.add(new JLabel("Deviation : "));
        contentPane.add(textFieldDeviation);

        contentPane.add(new JLabel("Taille : "));
        contentPane.add(textFieldTaille);

        contentPane.add(new JLabel("Hauteur : "));
        contentPane.add(textFieldHauteur);

        contentPane.add(new JLabel("Graine : "));
        contentPane.add(textFieldGraine);

        contentPane.add(new JButton("Valider"));
        contentPane.add(new JButton("Annuler"));

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
