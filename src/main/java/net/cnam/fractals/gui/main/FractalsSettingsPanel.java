package net.cnam.fractals.gui.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class FractalsSettingsPanel extends JPanel {
    enum FieldTitle {
        MAILLE("Maille", 0, 3),
        HAUTEUR("Hauteur"),
        DEVIATION("Deviation"),
        GRAINE("Graine"),
        TAILLE("Taille");

        private final String title;
        private final boolean slider;
        private final boolean onlyNumbers;
        private final int minimumValue;
        private final int maximumValue;

        FieldTitle(String title) {
            this.title = title;
            this.slider = false;
            this.onlyNumbers = true;
            this.minimumValue = 0;
            this.maximumValue = 0;
        }

        FieldTitle(String title, int minimumValue, int maximumValue) {
            this.title = title;
            this.slider = true;
            this.onlyNumbers = false;
            this.minimumValue = minimumValue;
            this.maximumValue = maximumValue;
        }

        public String getTitle() {
            return title;
        }

        public int getMinimumValue() {
            return minimumValue;
        }

        public int getMaximumValue() {
            return maximumValue;
        }

        public boolean isSlider() {
            return slider;
        }

        public boolean isOnlyNumbers() {
            return onlyNumbers;
        }
    }

    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);

    private final Map<FieldTitle, ValuableComponent> fieldMap = new HashMap<>();

    public FractalsSettingsPanel() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Paramétrage des fractals"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        GridBagConstraints gbc;
        for (int i = 0; i < FieldTitle.values().length; i++) {
            FieldTitle fieldTitle = FieldTitle.values()[i];
            gbc = createGbc(0, i);
            add(new JLabel(fieldTitle.getTitle() + " :", JLabel.LEFT), gbc);
            gbc = createGbc(1, i);
            ValuableComponent valuable;
            if (!fieldTitle.isSlider()) {
                ValuableJTextField valuableJTextField = new ValuableJTextField(10);

                if (fieldTitle.isOnlyNumbers()) {
                    valuableJTextField.addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            char c = e.getKeyChar();
                            if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                                e.consume();
                            }
                        }
                    });
                }

                valuable = valuableJTextField;
            } else {
                ValuableJSlider valuableJSlider = new ValuableJSlider();
                valuableJSlider.setMinimum(fieldTitle.getMinimumValue());
                valuableJSlider.setMaximum(fieldTitle.getMaximumValue());
                valuableJSlider.setPaintTicks(true);
                valuableJSlider.setPaintLabels(true);
                valuableJSlider.setMajorTickSpacing(1);

                valuable = valuableJSlider;
            }
            add((Component) valuable, gbc);

            fieldMap.put(fieldTitle, valuable);
        }
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        gbc.fill = (x == 0) ? GridBagConstraints.BOTH
                : GridBagConstraints.HORIZONTAL;

        gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
        gbc.weightx = (x == 0) ? 0.1 : 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }

    public String getFieldText(FieldTitle fieldTitle) {
        return fieldMap.get(fieldTitle).getValuable();
    }
}