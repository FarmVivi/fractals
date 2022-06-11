package net.cnam.gui.window.main;

import net.cnam.App;
import net.cnam.Fractals;
import net.cnam.gui.window.surface.NewSurfacePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Fractals fractals;

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
        // Onglet Fichier
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Fichier");
        JMenuItem newItem = new JMenuItem("Nouveau...");
        newItem.addActionListener(e -> {
            fractals = new Fractals(1, 128, 3, 0L, 1024);
            Container contentPane = this.getContentPane();
            contentPane.removeAll();
            contentPane.add(new NewSurfacePanel(fractals));
            contentPane.repaint();
        });
        fileMenu.add(newItem);
        fileMenu.addSeparator();
        JMenuItem oldItem = new JMenuItem("Ouvrir vieux menu");
        oldItem.addActionListener(e -> {
            App app = new App();
            app.launchMainWindow();
        });
        fileMenu.add(oldItem);
        fileMenu.addSeparator();
        JMenuItem exitItem = new JMenuItem("Quitter");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Onglet Affichage
        JMenu viewMenu = new JMenu("Affichage");
        JMenuItem mapItem = new JMenuItem("Carte");
        mapItem.addActionListener(e -> {

        });
        viewMenu.add(mapItem);
        menuBar.add(viewMenu);

        this.setJMenuBar(menuBar);

        MainPanel panel = new MainPanel();

        // Ajout du panel
        this.add(panel);
    }
}
