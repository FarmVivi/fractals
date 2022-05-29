package net.cnam;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.launchMainWindow();
        });
    }
}
