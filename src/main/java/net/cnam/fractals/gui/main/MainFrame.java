package net.cnam.fractals.gui.main;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.gui.ScrollPanel;
import net.cnam.fractals.gui.carte.CartePanel;
import net.cnam.fractals.gui.game.GamePanel;
import net.cnam.fractals.gui.surface.NewSurfacePanel;
import net.cnam.fractals.gui.view.filfer.FilFerPanel;
import net.cnam.fractals.gui.view.ombres.OmbresPanel;
import net.cnam.fractals.gui.view.strates.StratesPanel;
import net.cnam.fractals.old.App;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final String TITLE = "Fractals";

    private final MainPanel panel;
    private Fractals fractals;

    public MainFrame() {
        this.panel = new MainPanel();
        ScrollPanel scrollPanel = new ScrollPanel(panel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets bounds = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        int width = (int) (screenSize.getWidth() - bounds.left - bounds.right);
        int height = (int) (screenSize.getHeight() - bounds.top - bounds.bottom);
        // Caractéristiques de la fenêtre
        this.setTitle(TITLE);
        this.setSize(width, height);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu
        // Onglet Fichier
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Fichier");

        JMenuItem newItem = new JMenuItem("Nouveau...", UIManager.getIcon("FileView.fileIcon"));
        newItem.addActionListener(e -> {
            fractals = new Fractals();
            panel.removeAll();
            panel.add(new NewSurfacePanel(fractals));
            panel.revalidate();
        });
        fileMenu.add(newItem);

        JMenuItem openItem = new JMenuItem("Ouvrir...", UIManager.getIcon("FileView.directoryIcon"));
        openItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Ouvrir");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Fractals", "fractals"));
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Fonctionnalité bientôt disponible", "En développement...", JOptionPane.INFORMATION_MESSAGE);
                /* fractals = new Fractals(1, 128, 3, 0L, 1024);
                fractals.load(fileChooser.getSelectedFile());
                panel.removeAll();
                panel.add(new NewSurfacePanel(fractals));
                panel.revalidate(); */
            }
        });
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Enregistrer", UIManager.getIcon("FileView.floppyDriveIcon"));
        saveItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Enregistrer");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Fractals", "fractals"));
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Fonctionnalité bientôt disponible", "En développement...", JOptionPane.INFORMATION_MESSAGE);
                // fractals.save(fileChooser.getSelectedFile());
            }
        });
        fileMenu.add(saveItem);

        JMenuItem closeItem = new JMenuItem("Fermer");
        closeItem.addActionListener(e -> {
            this.fractals = null;
            this.setTitle(TITLE);
            panel.removeAll();
            panel.revalidate();
        });
        fileMenu.add(closeItem);

        fileMenu.addSeparator();

        JMenuItem oldItem = new JMenuItem("Ouvrir vieux menu");
        oldItem.addActionListener(e -> {
            App app = new App();
            app.getMenuFrame().setVisible(true);
        });
        fileMenu.add(oldItem);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Quitter");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        // Onglet Affichage
        JMenu viewMenu = new JMenu("Affichage");

        JMenuItem newSurfaceItem = new JMenuItem("Nouvelle surface");
        newSurfaceItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new NewSurfacePanel(fractals));
            panel.revalidate();
        });
        viewMenu.add(newSurfaceItem);

        viewMenu.addSeparator();

        JMenuItem mapItem = new JMenuItem("Carte");
        mapItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new CartePanel(fractals));
            panel.revalidate();
        });
        viewMenu.add(mapItem);

        viewMenu.addSeparator();

        JMenuItem stratesViewItem = new JMenuItem("Vue en strates");
        stratesViewItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new StratesPanel(fractals));
            panel.revalidate();
        });
        viewMenu.add(stratesViewItem);

        JMenuItem ombresViewItem = new JMenuItem("Vue en ombres");
        ombresViewItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new OmbresPanel(fractals));
            panel.revalidate();
        });
        viewMenu.add(ombresViewItem);

        JMenuItem filFerViewItem = new JMenuItem("Vue en fil de fer");
        filFerViewItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new FilFerPanel(fractals));
            panel.revalidate();
        });
        viewMenu.add(filFerViewItem);

        viewMenu.addSeparator();

        JMenuItem gameItem = new JMenuItem("Jeu");
        gameItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new GamePanel(fractals));
            panel.revalidate();
        });
        viewMenu.add(gameItem);

        menuBar.add(viewMenu);

        this.setJMenuBar(menuBar);

        // Ajout du panel
        this.add(scrollPanel);
    }

    public void setFractals(Fractals fractals) {
        this.fractals = fractals;
    }
}
