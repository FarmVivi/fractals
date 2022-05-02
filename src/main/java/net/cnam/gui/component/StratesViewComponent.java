package net.cnam.gui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import net.cnam.Utils;

public class StratesViewComponent extends JComponent {

    private int surface[][];
    private int hauteur;
    private int c [];

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int n = hauteur / 16;

        // Lignes 980 à 1140
        
        int nm = n*4;
        
        for (int i = 0 ; i <= 80 ; i++)
        {
            int h = surface[0][i] + i;
            if (h < nm + i) h = nm + i;
            c[80-i] = h-2;
            h = surface[i][0] + i;
            if (h < nm + i) h = nm + i;
            c[80+i]= h-2;
        }
        
        for (int y = 0 ; y <= 128 ; y++)
        {
            for (int x = 0 ; x <= 127 ; x++)
            {
                int nmx = nm + x + y;
                int a = 80 - y + x;
                if (a < 0 ||a > 319) continue;
                int h = (surface[x][y] + x + y);
                int c2 = surface[x][y]/n; // attention c2 remplace c dans le texte
                if (c2 > 15) c2=15;
                if (h < nmx) h = nmx;
                if (h <= c[a]) Utils.plot(g2d, a*4, c[a], 0);
                int cursorX = 0;
                int cursorY = 0;
                if (h>c[a]) 
                {
                    cursorX = a*7;
                    cursorY = c[a] +2;
                }
                Utils.drawLine(g2d, cursorX, cursorY, a*4, h, c2);
                c[a] = h;
                
            }
        }
        
    }

    public void setValues(int[][] surface, int hauteur, int c []) {
        this.surface = surface;
        this.hauteur = hauteur;
        this.c = c;

        this.setSize(surface.length, surface[0].length);
        this.repaint();
    }
    
}
