package net.cnam;

import java.util.Random;

import net.cnam.gui.window.carte.CarteFrame;
import net.cnam.gui.window.game.GameFrame;
import net.cnam.gui.window.menu.MenuFrame;
import net.cnam.gui.window.surface.NewSurfaceFrame;
import net.cnam.gui.window.view.filfer.FilFerViewFrame;
import net.cnam.gui.window.view.ombres.OmbresViewFrame;
import net.cnam.gui.window.view.strates.StratesViewFrame;

public class App {
    private final MenuFrame mainFrame;
    private final NewSurfaceFrame newSurfaceFrame;
    private final CarteFrame carteFrame;
    private final StratesViewFrame stratesViewFrame;
    private final OmbresViewFrame ombresViewFrame;
    private final FilFerViewFrame filFerViewFrame;
    private final GameFrame gameFrame;

    public App() {
        Fractals fractals = new Fractals(2, 64, 3, 0L, 1024);

        this.mainFrame = new MenuFrame(this);
        this.newSurfaceFrame = new NewSurfaceFrame(this, fractals);
        this.carteFrame = new CarteFrame(this, fractals);
        this.stratesViewFrame = new StratesViewFrame(this, fractals);
        this.ombresViewFrame = new OmbresViewFrame(this, fractals);
        this.filFerViewFrame = new FilFerViewFrame(this, fractals);
        this.gameFrame = new GameFrame(this, fractals);
    }

    public void launchMainWindow() {
        this.mainFrame.setVisible(true);
    }

    public MenuFrame getMainFrame() {
        return mainFrame;
    }

    public void launchNewSurfaceWindow() {
        this.newSurfaceFrame.setVisible(true);
    }

    public void launchCarteWindow() {
        this.carteFrame.setVisible(true);
    }

    public void launchStratesViewWindow() {
        this.stratesViewFrame.setVisible(true);
    }

    public void launchOmbresViewWindow() {
        this.ombresViewFrame.setVisible(true);
    }

    public void launchFilFerViewWindow() {
        this.filFerViewFrame.setVisible(true);
    }

    public void launchGameWindow() {
        this.gameFrame.setVisible(true);
    }
}
