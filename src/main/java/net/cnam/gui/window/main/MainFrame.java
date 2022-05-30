package net.cnam.gui.window.main;

import net.cnam.App;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newItem;
    private JMenuItem oldItem;
    private JMenuItem exitItem;

    public MainFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets bounds = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        int width = (int) (screenSize.getWidth() - bounds.left - bounds.right);
        int height = (int) (screenSize.getHeight() - bounds.top - bounds.bottom);
        // Caractéristiques de la fenêtre
        this.setTitle("Fractals");
        this.setSize(width, height);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu
        menuBar = new JMenuBar();
        fileMenu = new JMenu("Fichier");
        newItem = new JMenuItem("Nouveau...");
        fileMenu.add(newItem);
        fileMenu.addSeparator();
        oldItem = new JMenuItem("Ouvrir vieux menu");
        oldItem.addActionListener(e -> {
            App app = new App();
            app.launchMainWindow();
        });
        fileMenu.add(oldItem);
        fileMenu.addSeparator();
        exitItem = new JMenuItem("Quitter");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

        MainPanel panel = new MainPanel();

        // Ajout du panel
        this.add(panel);
    }
}
