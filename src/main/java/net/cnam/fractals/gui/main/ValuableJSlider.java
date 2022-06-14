package net.cnam.fractals.gui.main;

import javax.swing.*;

public class ValuableJSlider extends JSlider implements ValuableComponent {
    public ValuableJSlider() {
        super();
    }

    public ValuableJSlider(int orientation) {
        super(orientation);
    }

    public ValuableJSlider(int min, int max) {
        super(min, max);
    }

    public ValuableJSlider(int min, int max, int value) {
        super(min, max, value);
    }

    public ValuableJSlider(int orientation, int min, int max, int value) {
        super(orientation, min, max, value);
    }

    public ValuableJSlider(BoundedRangeModel brm) {
        super(brm);
    }

    @Override
    public String getValuable() {
        return "" + super.getValue();
    }

    @Override
    public void setValuable(String value) {
        super.setValue(Integer.parseInt(value));
    }
}
