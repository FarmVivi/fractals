package net.cnam.fractals.old;

import net.cnam.fractals.Fractals;
import net.cnam.fractals.old.gui.carte.CarteFrame;
import net.cnam.fractals.old.gui.game.GameFrame;
import net.cnam.fractals.old.gui.menu.MenuFrame;
import net.cnam.fractals.old.gui.surface.NewSurfaceFrame;
import net.cnam.fractals.old.gui.view.filfer.FilFerFrame;
import net.cnam.fractals.old.gui.view.ombres.OmbresFrame;
import net.cnam.fractals.old.gui.view.strates.StratesFrame;

@Deprecated
public class App {
    private final MenuFrame menuFrame;
    private final NewSurfaceFrame newSurfaceFrame;
    private final CarteFrame carteFrame;
    private final StratesFrame stratesFrame;
    private final OmbresFrame ombresFrame;
    private final FilFerFrame filFerFrame;
    private final GameFrame gameFrame;

    @Deprecated
    public App() {
        Fractals defaultFractals = new Fractals(2, 64, 3, 0L, 128);

        this.menuFrame = new MenuFrame(this);
        this.newSurfaceFrame = new NewSurfaceFrame(this, defaultFractals);
        this.carteFrame = new CarteFrame(this, defaultFractals);
        this.stratesFrame = new StratesFrame(this, defaultFractals);
        this.ombresFrame = new OmbresFrame(this, defaultFractals);
        this.filFerFrame = new FilFerFrame(this, defaultFractals);
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
    public StratesFrame getStratesViewFrame() {
        return stratesFrame;
    }

    @Deprecated
    public OmbresFrame getOmbresViewFrame() {
        return ombresFrame;
    }

    @Deprecated
    public FilFerFrame getFilFerViewFrame() {
        return filFerFrame;
    }

    @Deprecated
    public GameFrame getGameFrame() {
        return gameFrame;
    }
}
