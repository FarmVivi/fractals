package net.cnam;

public class App {
    private Main_Frame mainFrame;
    private Carte_Frame carteFrame;

    public App() {
        this.mainFrame = new Main_Frame(this);
        this.carteFrame = new Carte_Frame(this);
    }

    public void launchMainWindow() {
        this.mainFrame.setVisible(true);
    }

    public void launchCarteWindow() {
        this.carteFrame.setVisible(true);
    }

    public Main_Frame getMainFrame() {
        return mainFrame;
    }

    public Carte_Frame getCarteFrame() {
        return carteFrame;
    }
}
