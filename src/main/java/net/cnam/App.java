package net.cnam;

public class App {
    private MainFrame mainFrame;
    private NewSurfaceFrame newSurfaceFrame;

    public App() {
        this.mainFrame = new MainFrame(this);
        this.newSurfaceFrame = new NewSurfaceFrame(this);
    }

    public void launchMainWindow() {
        this.mainFrame.setVisible(true);
    }

    public void launchNewSurfaceWindow() {
        this.newSurfaceFrame.setVisible(true);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public NewSurfaceFrame getCarteFrame() {
        return newSurfaceFrame;
    }
}
