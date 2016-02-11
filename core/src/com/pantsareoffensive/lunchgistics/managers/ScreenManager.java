package com.pantsareoffensive.lunchgistics.managers;

import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.screens.AbstractScreen;
import com.pantsareoffensive.lunchgistics.screens.GamePlayScreen;
import com.pantsareoffensive.lunchgistics.screens.LoadingScreen;
import com.pantsareoffensive.lunchgistics.screens.SplashScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.MenuScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.NewGameScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.OptionsScreen;

import java.util.HashMap;

public class ScreenManager {

    private Main game;
    private HashMap<STATE, AbstractScreen> screens;

    public enum STATE {
        SPLASH,
        LOADING,
        MAIN_MENU,
        NEW_GAME,
        OPTIONS,
        GAME
    }

    public ScreenManager(Main game) {
        this.game = game;
        this.screens = new HashMap<STATE, AbstractScreen>();
        for(STATE s: STATE.values()) {
            init(s);
        }

        setScreen(STATE.GAME);

    }
    
    public void init(STATE newScreen) {
        switch (newScreen){
            case SPLASH:
                this.screens.put(STATE.SPLASH, new SplashScreen(game));
                return;

            case LOADING:
                this.screens.put(STATE.LOADING, new LoadingScreen(game));
                return;

            case MAIN_MENU:
                this.screens.put(STATE.MAIN_MENU, new MenuScreen(game));
                return;
            case NEW_GAME:
                this.screens.put(STATE.NEW_GAME, new NewGameScreen(game));
                return;

            case OPTIONS:
                this.screens.put(STATE.OPTIONS, new OptionsScreen(game));
                return;

            case GAME:
                this.screens.put(STATE.GAME, new GamePlayScreen(game));
                return;

            default:
                return;
        }

    }

    public void setScreen(STATE nextScreen) {
        if (!screens.containsKey(nextScreen))
            init(nextScreen);
        game.setScreen(screens.get(nextScreen));
    }


    public void dispose(STATE disposeScreen) {
        if (this.screens.containsKey(disposeScreen)) {
            this.screens.get(disposeScreen).dispose();
            this.screens.remove(disposeScreen);
        }
    }

    public void dispose(){
        for(STATE s: STATE.values()) {
            dispose(s);
        }
    }


    public boolean isScreen(STATE isScreen) {
        return (screens.containsKey(isScreen));
    }

}

