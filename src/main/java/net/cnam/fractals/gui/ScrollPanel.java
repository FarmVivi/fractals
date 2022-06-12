package net.cnam.fractals.gui;

import javax.swing.*;
import java.awt.*;

public class ScrollPanel extends JScrollPane {
    public ScrollPanel(Component view) {
        super(view);

        this.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setLayout(new ScrollPaneLayout());
    }
}
