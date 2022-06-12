package net.cnam;

import net.cnam.gui.window.carte.CarteFrame;
import net.cnam.gui.window.game.GameFrame;
import net.cnam.gui.window.menu.MenuFrame;
import net.cnam.gui.window.surface.NewSurfaceFrame;
import net.cnam.gui.window.view.filfer.FilFerViewFrame;
import net.cnam.gui.window.view.ombres.OmbresViewFrame;
import net.cnam.gui.window.view.strates.StratesViewFrame;

@Deprecated
public class App {
    private final MenuFrame menuFrame;
    private final NewSurfaceFrame newSurfaceFrame;
    private final CarteFrame carteFrame;
    private final StratesViewFrame stratesViewFrame;
    private final OmbresViewFrame ombresViewFrame;
    private final FilFerViewFrame filFerViewFrame;
    private final GameFrame gameFrame;

    @Deprecated
    public App() {
        Fractals defaultFractals = new Fractals(2, 64, 3, 0L, 128);

        this.menuFrame = new MenuFrame(this);
        this.newSurfaceFrame = new NewSurfaceFrame(this, defaultFractals);
        this.carteFrame = new CarteFrame(this, defaultFractals);
        this.stratesViewFrame = new StratesViewFrame(this, defaultFractals);
        this.ombresViewFrame = new OmbresViewFrame(this, defaultFractals);
        this.filFerViewFrame = new FilFerViewFrame(this, defaultFractals);
        this.gameFrame = new GameFrame(this, defaultFractals);
    }

    @Deprecated
    public MenuFrame getMenuFrame() {
        return menuFrame;
    }

    @Deprecated
    public NewSurfaceFrame getNewSurfaceFrame() {
        return newSurfaceFrame;
    }

    @Deprecated
    public CarteFrame getCarteFrame() {
        return carteFrame;
    }

    @Deprecated
    public StratesViewFrame getStratesViewFrame() {
        return stratesViewFrame;
    }

    @Deprecated
    public OmbresViewFrame getOmbresViewFrame() {
        return ombresViewFrame;
    }

    @Deprecated
    public FilFerViewFrame getFilFerViewFrame() {
        return filFerViewFrame;
    }

    @Deprecated
    public GameFrame getGameFrame() {
        return gameFrame;
    }
}
