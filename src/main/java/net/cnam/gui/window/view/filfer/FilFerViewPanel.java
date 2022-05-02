package net.cnam.gui.window.view.filfer;

import javax.swing.JPanel;

import net.cnam.gui.component.FilFerViewComponent;

public class FilFerViewPanel extends JPanel {

    private final FilFerViewComponent filFerViewComponent;

    public FilFerViewPanel() {
        this.setLayout(null);

        filFerViewComponent = new FilFerViewComponent(new int[0][0], 0);
        filFerViewComponent.setLocation(0, 0);
        this.add(filFerViewComponent);
    }

    public FilFerViewComponent getFilFerViewComponent() {
        return filFerViewComponent;
    }
}
