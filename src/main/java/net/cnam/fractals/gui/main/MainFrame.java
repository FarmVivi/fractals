package net.cnam.fractals.gui.main;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.FractalsSettings;
import net.cnam.fractals.gui.ScrollPanel;
import net.cnam.fractals.gui.carte.CartePanel;
import net.cnam.fractals.gui.game.GamePanel;
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
    private final JMenuItem saveItem;
    private final JMenuItem closeItem;
    private final JMenuItem mapItem;
    private final JMenuItem stratesViewItem;
    private final JMenuItem ombresViewItem;
    private final JMenuItem filFerViewItem;
    private final JMenuItem gameItem;

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

        this.saveItem = new JMenuItem("Enregistrer", UIManager.getIcon("FileView.floppyDriveIcon"));
        fileMenu.add(saveItem);

        this.closeItem = new JMenuItem("Fermer");
        closeItem.addActionListener(e -> MainFrame.this.close());
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

        this.mapItem = new JMenuItem("Carte");
        viewMenu.add(mapItem);

        viewMenu.addSeparator();

        this.stratesViewItem = new JMenuItem("Vue en strates");
        viewMenu.add(stratesViewItem);

        this.ombresViewItem = new JMenuItem("Vue en ombres");
        viewMenu.add(ombresViewItem);

        this.filFerViewItem = new JMenuItem("Vue en fil de fer");
        viewMenu.add(filFerViewItem);

        viewMenu.addSeparator();

        this.gameItem = new JMenuItem("Jeu");
        viewMenu.add(gameItem);

        menuBar.add(viewMenu);

        // Onglet Aide
        JMenu helpMenu = new JMenu("Aide");

        JMenuItem aboutItem = new JMenuItem("À propos");
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        // Actions
        // Onglet Fichier
        // Nouveau
        newItem.addActionListener(e -> {
            FractalsSettingsPanel fractalsSettingsPanel = new FractalsSettingsPanel();
            JPanel fractalsSettingsContentPanel = new JPanel();
            fractalsSettingsContentPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            fractalsSettingsContentPanel.add(fractalsSettingsPanel, gbc);
            JButton randomButton = new JButton("Aléatoire");
            randomButton.addActionListener(e1 -> {
                FractalsSettings randomSettings = new FractalsSettings();
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.MAILLE).setValuable(String.valueOf(randomSettings.getMaille()));
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.HAUTEUR).setValuable(String.valueOf(randomSettings.getHauteur()));
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.DEVIATION).setValuable(String.valueOf(randomSettings.getDeviation()));
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.GRAINE).setValuable(String.valueOf(randomSettings.getGraine()));
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.TAILLE).setValuable(String.valueOf(randomSettings.getTaille()));
            });
            if (this.fractals == null) {
                randomButton.doClick();
            } else {
                FractalsSettings randomSettings = this.fractals.getSettings();
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.MAILLE).setValuable(String.valueOf(randomSettings.getMaille()));
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.HAUTEUR).setValuable(String.valueOf(randomSettings.getHauteur()));
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.DEVIATION).setValuable(String.valueOf(randomSettings.getDeviation()));
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.GRAINE).setValuable(String.valueOf(randomSettings.getGraine()));
                fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.TAILLE).setValuable(String.valueOf(randomSettings.getTaille()));
            }
            gbc.gridy = 1;
            fractalsSettingsContentPanel.add(randomButton, gbc);

            int result = JOptionPane.showConfirmDialog(MainFrame.this, fractalsSettingsContentPanel,
                    "Nouvelle fractal", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    Fractals newFractals = new Fractals(new FractalsSettings(
                            Integer.parseInt(fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.MAILLE).getValuable()),
                            Integer.parseInt(fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.HAUTEUR).getValuable()),
                            Integer.parseInt(fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.DEVIATION).getValuable()),
                            Long.parseLong(fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.GRAINE).getValuable()),
                            Integer.parseInt(fractalsSettingsPanel.getValuableComponent(FractalsSettingsPanel.FieldTitle.TAILLE).getValuable())
                    ));
                    MainFrame.this.open(newFractals);
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
                    MainFrame.this.open(new Fractals(new FractalsSettings(file)));
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
                    if (fractals.getSettings().isSaved()) {
                        this.setTitle(TITLE + " - " + fractals.getSettings().getFile().getAbsolutePath());
                    } else {
                        this.setTitle(TITLE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement du fichier\nErreur:\n" + ex, "Erreur lors de l'enregistrement du fichier", JOptionPane.ERROR_MESSAGE);
                }
            }
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

        // Onglet Aide
        // A propos
        aboutItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, new AboutPanel(),
                    "À propos de Fractals", JOptionPane.PLAIN_MESSAGE);
        });

        this.setJMenuBar(menuBar);

        // Ajout du panel
        this.add(scrollPanel);

        close();
    }

    public void open(Fractals fractals) {
        if (this.fractals != null) {
            close();
        }

        this.fractals = fractals;

        if (fractals.getSettings().isSaved()) {
            this.setTitle(TITLE + " - " + fractals.getSettings().getFile().getAbsolutePath());
        } else {
            this.setTitle(TITLE);
        }

        saveItem.setEnabled(true);
        closeItem.setEnabled(true);
        mapItem.setEnabled(true);
        stratesViewItem.setEnabled(true);
        ombresViewItem.setEnabled(true);
        filFerViewItem.setEnabled(true);
        gameItem.setEnabled(true);

        panel.removeAll();
        panel.add(new CartePanel(fractals));
        mapItem.setSelected(true);
        panel.revalidate();
    }

    public void close() {
        this.fractals = null;
        this.setTitle(TITLE);
        saveItem.setEnabled(false);
        closeItem.setEnabled(false);
        mapItem.setEnabled(false);
        stratesViewItem.setEnabled(false);
        ombresViewItem.setEnabled(false);
        filFerViewItem.setEnabled(false);
        gameItem.setEnabled(false);
        panel.removeAll();
        panel.revalidate();
    }
}
