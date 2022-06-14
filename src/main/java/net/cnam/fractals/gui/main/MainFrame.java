package net.cnam.fractals.gui.main;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.FractalsSettings;
import net.cnam.fractals.gui.ScrollPanel;
import net.cnam.fractals.gui.carte.CartePanel;
import net.cnam.fractals.gui.game.GamePanel;
import net.cnam.fractals.gui.surface.NewSurfacePanel;
import net.cnam.fractals.gui.view.filfer.FilFerPanel;
import net.cnam.fractals.gui.view.ombres.OmbresPanel;
import net.cnam.fractals.gui.view.strates.StratesPanel;
import net.cnam.fractals.old.App;
import net.cnam.fractals.utils.Utils;
import org.apache.batik.transcoder.TranscoderException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
        try {
            String iconSVGURI = MainFrame.class.getResource("/assets/svg/logo.svg").toURI().toString();
            List<Image> logos = new ArrayList<>();
            logos.add(Utils.loadImage(iconSVGURI, 16, 16));
            logos.add(Utils.loadImage(iconSVGURI, 32, 32));
            logos.add(Utils.loadImage(iconSVGURI, 64, 64));
            logos.add(Utils.loadImage(iconSVGURI, 128, 128));
            this.setIconImages(logos);
        } catch (URISyntaxException | TranscoderException ex) {
            ex.printStackTrace();
        }

        // Menu
        // Onglet Fichier
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Fichier");

        JMenuItem newItem = new JMenuItem("Nouveau...", UIManager.getIcon("FileView.fileIcon"));
        fileMenu.add(newItem);

        JMenuItem openItem = new JMenuItem("Ouvrir...", UIManager.getIcon("FileView.directoryIcon"));
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Enregistrer", UIManager.getIcon("FileView.floppyDriveIcon"));
        fileMenu.add(saveItem);

        JMenuItem closeItem = new JMenuItem("Fermer");
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

        JMenuItem mapItem = new JMenuItem("Carte");
        viewMenu.add(mapItem);

        viewMenu.addSeparator();

        JMenuItem stratesViewItem = new JMenuItem("Vue en strates");
        viewMenu.add(stratesViewItem);

        JMenuItem ombresViewItem = new JMenuItem("Vue en ombres");
        viewMenu.add(ombresViewItem);

        JMenuItem filFerViewItem = new JMenuItem("Vue en fil de fer");
        viewMenu.add(filFerViewItem);

        viewMenu.addSeparator();

        JMenuItem gameItem = new JMenuItem("Jeu");
        viewMenu.add(gameItem);

        menuBar.add(viewMenu);

        // Actions
        // Onglet Fichier
        // Nouveau
        newItem.addActionListener(e -> {
            FractalsSettingsPanel fractalsSettingsPanel = new FractalsSettingsPanel();

            int result = JOptionPane.showConfirmDialog(MainFrame.this, fractalsSettingsPanel,
                    "Nouvelle fractal", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    fractals = new Fractals(new FractalsSettings(
                            Integer.parseInt(fractalsSettingsPanel.getFieldText(FractalsSettingsPanel.FieldTitle.MAILLE)),
                            Integer.parseInt(fractalsSettingsPanel.getFieldText(FractalsSettingsPanel.FieldTitle.HAUTEUR)),
                            Integer.parseInt(fractalsSettingsPanel.getFieldText(FractalsSettingsPanel.FieldTitle.DEVIATION)),
                            Long.parseLong(fractalsSettingsPanel.getFieldText(FractalsSettingsPanel.FieldTitle.GRAINE)),
                            Integer.parseInt(fractalsSettingsPanel.getFieldText(FractalsSettingsPanel.FieldTitle.TAILLE))
                    ));
                    panel.removeAll();
                    panel.add(new CartePanel(fractals));
                    panel.revalidate();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(),
                            "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ouvrir
        openItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Ouvrir");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Fractals", "fractals"));
            int returnValue = fileChooser.showOpenDialog(MainFrame.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                FileFilter fileFilter = fileChooser.getFileFilter();
                if (fileFilter instanceof FileNameExtensionFilter && !fileFilter.accept(file)) {
                    // if the filter doesn't accept the filename, that must be because it doesn't have the correct extension
                    // so change the extension to the first extension offered by the filter.
                    FileNameExtensionFilter fileNameExtensionFilter = (FileNameExtensionFilter) fileFilter;
                    String extension = fileNameExtensionFilter.getExtensions()[0];

                    String newName = file.getName() + "." + extension;
                    file = new File(file.getParent(), newName);

                }

                try {
                    fractals = new Fractals(new FractalsSettings(fileChooser.getSelectedFile()));
                    panel.removeAll();
                    panel.add(new NewSurfacePanel(fractals));
                    panel.revalidate();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de l'ouverture du fichier\nErreur:\n" + ex, "Erreur lors de l'ouverture du fichier", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Enregistrer
        saveItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Enregistrer");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Fractals", "fractals"));
            int returnValue = fileChooser.showSaveDialog(MainFrame.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                FileFilter fileFilter = fileChooser.getFileFilter();
                if (fileFilter instanceof FileNameExtensionFilter && !fileFilter.accept(file)) {
                    // if the filter doesn't accept the filename, that must be because it doesn't have the correct extension
                    // so change the extension to the first extension offered by the filter.
                    FileNameExtensionFilter fileNameExtensionFilter = (FileNameExtensionFilter) fileFilter;
                    String extension = fileNameExtensionFilter.getExtensions()[0];

                    String newName = file.getName() + "." + extension;
                    file = new File(file.getParent(), newName);
                }

                try {
                    fractals.getSettings().save(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement du fichier\nErreur:\n" + ex, "Erreur lors de l'enregistrement du fichier", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Fermer
        closeItem.addActionListener(e -> {
            this.fractals = null;
            this.setTitle(TITLE);
            panel.removeAll();
            panel.revalidate();
        });

        // Onglet Affichage
        // Carte
        mapItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new CartePanel(fractals));
            panel.revalidate();
        });

        // Vue en strates
        stratesViewItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new StratesPanel(fractals));
            panel.revalidate();
        });

        // Vue en ombres
        ombresViewItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new OmbresPanel(fractals));
            panel.revalidate();
        });

        // Vue en fil de fer
        filFerViewItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new FilFerPanel(fractals));
            panel.revalidate();
        });

        // Jeu
        gameItem.addActionListener(e -> {
            panel.removeAll();
            panel.add(new GamePanel(fractals));
            panel.revalidate();
        });

        this.setJMenuBar(menuBar);

        // Ajout du panel
        this.add(scrollPanel);
    }

    public void setFractals(Fractals fractals) {
        this.fractals = fractals;
    }
}
