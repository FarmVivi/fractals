package net.cnam.gui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

import net.cnam.App;
import net.cnam.Utils;

public class FilFerViewComponent extends JComponent {

    private final App app;

    private int surface[][];
    private int hauteur;

    public FilFerViewComponent(App app, int surface[][], int hauteur) {
        this.app = app;

        this.surface = surface;
        this.hauteur = hauteur;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Lignes 850 à 970
        int o = 160;
        int k = 0;
        int originX = 0;
        int originY = 40;
        Utils.drawLine(g2d, originX, originY, 320, 0, 1, 1, 14);
        Utils.drawLine(g2d, originX, originY, 640, 40, 1, 1, 14);
        int[] c = new int[320];

        int h = hauteur;
        int fh = hauteur;

        for (int y = 0; y <= 128; y += 2) {
            originX = o * 4 - 320;
            originY = c[0 + k];
            k = 0;
            o = 160 - y;
            if (o < 0)
                k = -o;

            int saveX = 0;

            for (int x = y; x <= 128; x += 2) {
                int t = surface[x][y] + y + x;
                h = Math.max(c[x + o], t);
                c[x + o] = h;

                Utils.drawLine(g2d, originX, originY, (o + x) * 4 - 320, h, 1, 1, 14);
                saveX = x;
            }

            Utils.drawLine(g2d, originX, originY, (o + saveX) * 4 - 322, fh, 1, 1, 14);
            fh = h;
        }

        StratesViewComponent stratesViewComponent = this.app.getStratesViewFrame().getStratesViewPanel()
                .getStratesViewComponent();
        stratesViewComponent.setValues(surface, hauteur, c);
    }

    public void setValues(int[][] surface, int hauteur) {
        this.surface = surface;
        this.hauteur = hauteur;

        this.setSize(surface.length, surface[0].length);
        this.repaint();
    }
}
