package net.cnam;

public class App {
    private static App INSTANCE;

    public static App getInstance() {
        return INSTANCE;
    }

    public static void setInstance(App instance) {
        App.INSTANCE = instance;
    }

    private Menu_Frame menuFrame;

    public App() {
        this.menuFrame = new Menu_Frame();
        menuFrame.setVisible(true);
    }

    public Menu_Frame getMenuFrame() {
        return menuFrame;
    }
}
