package net.cnam.fractals.gui.main;

import javax.swing.*;
import javax.swing.text.Document;

public class ValuableJTextField extends JTextField implements ValuableComponent {
    public ValuableJTextField() {
        super();
    }

    public ValuableJTextField(String text) {
        super(text);
    }

    public ValuableJTextField(int columns) {
        super(columns);
    }

    public ValuableJTextField(String text, int columns) {
        super(text, columns);
    }

    public ValuableJTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
    }

    @Override
    public String getValuable() {
        return super.getText();
    }

    @Override
    public void setValuable(String value) {
        super.setText(value);
    }
}
