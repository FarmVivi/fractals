package net.cnam;

public class App {
    private Main_Frame mainFrame;
    private NewSurface_Frame newSurfaceFrame;

    public App() {
        this.mainFrame = new Main_Frame(this);
        this.newSurfaceFrame = new NewSurface_Frame(this);
    }

    public void launchMainWindow() {
        this.mainFrame.setVisible(true);
    }

    public void launchNewSurfaceWindow() {
        this.newSurfaceFrame.setVisible(true);
    }

    public Main_Frame getMainFrame() {
        return mainFrame;
    }

    public NewSurface_Frame getCarteFrame() {
        return newSurfaceFrame;
    }
}
