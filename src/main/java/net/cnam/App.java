package net.cnam;

import net.cnam.window.carte.CarteFrame;
import net.cnam.window.game.GameFrame;
import net.cnam.window.menu.MenuFrame;
import net.cnam.window.surface.NewSurfaceFrame;
import net.cnam.window.view.filfer.FilFerViewFrame;
import net.cnam.window.view.ombres.OmbresViewFrame;
import net.cnam.window.view.strates.StratesViewFrame;

public class App {
    private MenuFrame mainFrame;
    private NewSurfaceFrame newSurfaceFrame;
    private CarteFrame carteFrame;
    private StratesViewFrame stratesViewFrame;
    private OmbresViewFrame ombresViewFrame;
    private FilFerViewFrame filFerViewFrame;
    private GameFrame gameFrame;

    public App() {
        this.mainFrame = new MenuFrame(this);
        this.newSurfaceFrame = new NewSurfaceFrame(this);
        this.carteFrame = new CarteFrame(this);
        this.stratesViewFrame = new StratesViewFrame(this);
        this.ombresViewFrame = new OmbresViewFrame(this);
        this.filFerViewFrame = new FilFerViewFrame(this);
        this.gameFrame = new GameFrame(this);
    }

    public void launchMainWindow() {
        this.mainFrame.setVisible(true);
    }

    public MenuFrame getMainFrame() {
        return mainFrame;
    }

    public NewSurfaceFrame getNewSurfaceFrame() {
        return newSurfaceFrame;
    }

    public void launchNewSurfaceWindow() {
        this.newSurfaceFrame.setVisible(true);
    }

    public CarteFrame getCarteFrame() {
        return carteFrame;
    }

    public void launchCarteWindow() {
        this.carteFrame.setVisible(true);
    }

    public StratesViewFrame getStratesViewFrame() {
        return stratesViewFrame;
    }

    public void launchStratesViewWindow() {
        this.stratesViewFrame.setVisible(true);
    }

    public OmbresViewFrame getOmbresViewFrame() {
        return ombresViewFrame;
    }

    public void launchOmbresViewWindow() {
        this.ombresViewFrame.setVisible(true);
    }

    public FilFerViewFrame getFilFerViewFrame() {
        return filFerViewFrame;
    }

    public void launchFilFerViewWindow() {
        this.filFerViewFrame.setVisible(true);
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void launchGameWindow() {
        this.gameFrame.setVisible(true);
    }
}
