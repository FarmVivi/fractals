package net.cnam.gui.window.view.strates;

import javax.swing.JPanel;

import net.cnam.gui.component.StratesViewComponent;

public class StratesViewPanel extends JPanel {

    private final StratesViewComponent stratesViewComponent;

    public StratesViewPanel() {
        this.setLayout(null);

        stratesViewComponent = new StratesViewComponent();
        stratesViewComponent.setLocation(0, 0);
        this.add(stratesViewComponent);
    }

    public StratesViewComponent getStratesViewComponent() {
        return stratesViewComponent;
    }
}
