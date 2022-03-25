package net.cnam;

import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Carte_Frame ex = new Carte_Frame();
                ex.setVisible(true);
            }
        });
    }
}
