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
        MAINMENU,
        NEWGAME,
        OPTIONS,
        GAME
    }

    public ScreenManager(Main game) {
        this.game = game;
        this.screens = new HashMap<STATE, AbstractScreen>();

        setScreen(STATE.SPLASH);
    }



    public void init(STATE newScreen) {
        switch (newScreen){
            case SPLASH:
                this.screens.put(STATE.SPLASH, new SplashScreen(game));
                return;

            case LOADING:
                this.screens.put(STATE.LOADING, new LoadingScreen(game));
                return;

            case MAINMENU:
                this.screens.put(STATE.MAINMENU, new MenuScreen(game));
                return;
            case NEWGAME:
                this.screens.put(STATE.NEWGAME, new NewGameScreen(game));
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

